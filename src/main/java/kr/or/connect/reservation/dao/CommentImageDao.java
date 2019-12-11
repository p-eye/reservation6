package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.CommentImageSqls.*;

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

import kr.or.connect.reservation.dao.mapper.CommentImageMapper;
import kr.or.connect.reservation.dto.CommentImage;

@Repository
public class CommentImageDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;

	public CommentImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_user_comment_image")
				.usingGeneratedKeyColumns("id");
	}

	public List<CommentImage> getCommentImageList(int reservationInfoId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("reservationInfoId", reservationInfoId);

		return jdbc.query(SELECT_COMMENT_IMAGE_LIST, params, new CommentImageMapper());
	}

	public CommentImage getCommentImage(int commentId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("commentId", commentId);
			return jdbc.queryForObject(SELECT_COMMENT_IMAGE, params,
					BeanPropertyRowMapper.newInstance(CommentImage.class));

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void insertCommentImage(CommentImage commentImage) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(commentImage);
		insertAction.execute(params);
	}

}
