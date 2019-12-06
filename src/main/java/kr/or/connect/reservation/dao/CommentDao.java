package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.CommentSqls.SELECT_COMMENT_LIST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dao.mapper.CommentMapper;
import kr.or.connect.reservation.dto.Comment;

@Repository
public class CommentDao {

	private NamedParameterJdbcTemplate jdbc;

	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Comment> getCommentList(int productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);

		return jdbc.query(SELECT_COMMENT_LIST, params, new CommentMapper());

	}
}
