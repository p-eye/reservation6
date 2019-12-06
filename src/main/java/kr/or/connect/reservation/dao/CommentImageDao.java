package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.CommentImageSqls.SELECT_COMMENT_IMAGE_LIST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dao.mapper.CommentImageMapper;
import kr.or.connect.reservation.dto.CommentImage;

@Repository
public class CommentImageDao {

	private NamedParameterJdbcTemplate jdbc;

	public CommentImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<CommentImage> getCommentImageList(int reservationInfoId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("reservationInfoId", reservationInfoId);

		return jdbc.query(SELECT_COMMENT_IMAGE_LIST, params, new CommentImageMapper());
	}

}
