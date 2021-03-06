package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.CommentSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dao.mapper.CommentMapper;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.param.CommentParam;
import kr.or.connect.reservation.dto.response.CommentResponse;

@Repository
public class CommentDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;

	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_user_comment")
				.usingGeneratedKeyColumns("id");
	}

	public List<Comment> getCommentList(int productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		return jdbc.query(SELECT_COMMENT_LIST, params, new CommentMapper());
	}

	public double getCommentAverageScore(int productId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("productId", productId);
			return jdbc.queryForObject(CALC_AVERAGE_SCORE, params, Double.class);

		} catch (NullPointerException e) {
			return 0;
		}
	}

	public CommentResponse getCommentResponse(int commentId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("commentId", commentId);
			return jdbc.queryForObject(SELECT_COMMENT_RESPONSE, params,
					BeanPropertyRowMapper.newInstance(CommentResponse.class));

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public int insertComment(CommentParam commentParam) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(commentParam);
		return insertAction.executeAndReturnKey(params).intValue();
	}

}
