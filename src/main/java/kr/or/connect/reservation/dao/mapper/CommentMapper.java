package kr.or.connect.reservation.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.or.connect.reservation.dto.Comment;

public class CommentMapper implements RowMapper<Comment> {

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {

		Comment comment = new Comment();

		comment.setCommentId(rs.getInt(1));
		comment.setProductId(rs.getInt(2));
		comment.setReservationInfoId(rs.getInt(3));
		comment.setScore(rs.getInt(4));
		comment.setComment(rs.getString(5));
		comment.setReservationName(rs.getString(6));
		comment.setReservationTelephone(rs.getString(7));
		comment.setReservationEmail(rs.getString(8));
		comment.setReservationDate(rs.getString(9));
		comment.setCreateDate(rs.getString(10));
		comment.setCreateDate(rs.getString(11));

		return comment;

	}

}
