package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.CommentSqls.CALC_AVERAGE_SCORE;
import static kr.or.connect.reservation.dao.sqls.CommentSqls.SELECT_COMMENT_LIST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dao.mapper.CommentMapper;
import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.CommentTable;

@Repository
public class CommentDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<CommentTable> rowMapper = BeanPropertyRowMapper.newInstance(CommentTable.class);

	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Comment> getCommentList(int productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);

		return jdbc.query(SELECT_COMMENT_LIST, params, new CommentMapper());

	}

	public double getCommentAverageScore(int productId) {

		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		try {
			return jdbc.queryForObject(CALC_AVERAGE_SCORE, params, Double.class);

		} catch (Exception e) {
			return 0;
		}

	}

	public CommentTable matchComment(int reservationInfoId, int productId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("reservationInfoId", reservationInfoId);
			params.put("productId", productId);		

			String sql = "SELECT * FROM " 
			+ "reservation_user_comment " 
					+ "WHERE reservation_info_id = :reservationInfoId "
					+ "AND product_id = :productId";
			return jdbc.queryForObject(sql, params, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}
}
