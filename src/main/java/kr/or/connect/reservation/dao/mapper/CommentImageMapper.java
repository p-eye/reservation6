package kr.or.connect.reservation.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.or.connect.reservation.dto.CommentImage;

public class CommentImageMapper implements RowMapper<CommentImage> {

	@Override
	public CommentImage mapRow(ResultSet rs, int rowNum) throws SQLException {

		CommentImage commentImage = new CommentImage();

		commentImage.setImageId(rs.getInt(1));
		commentImage.setReservationInfoId(rs.getInt(2));
		commentImage.setReservationUserCommentId(rs.getInt(3));
		commentImage.setFileId(rs.getInt(4));
		commentImage.setFileName(rs.getString(5));
		commentImage.setSaveFileName(rs.getString(6));
		commentImage.setContentType(rs.getString(7));
		commentImage.setDeleteFlag(rs.getBoolean(8));
		commentImage.setCreateDate(rs.getString(9));
		commentImage.setModifyDate(rs.getString(10));
		
		return commentImage;

	}

}
