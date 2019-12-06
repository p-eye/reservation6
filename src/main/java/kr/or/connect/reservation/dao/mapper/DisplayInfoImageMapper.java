package kr.or.connect.reservation.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.or.connect.reservation.dto.DisplayInfoImage;

public class DisplayInfoImageMapper implements RowMapper<DisplayInfoImage> {

	@Override
	public DisplayInfoImage mapRow(ResultSet rs, int rowNum) throws SQLException {

		DisplayInfoImage displayInfoImage = new DisplayInfoImage();

		displayInfoImage.setDisplayInfoImageId(rs.getInt(1));
		displayInfoImage.setDisplayInfoId(rs.getInt(2));
		displayInfoImage.setFileId(rs.getInt(3));
		displayInfoImage.setFileName(rs.getString(4));
		displayInfoImage.setSaveFileName(rs.getString(5));
		displayInfoImage.setContentType(rs.getString(6));
		displayInfoImage.setDeleteFlag(rs.getBoolean(7));
		displayInfoImage.setCreateDate(rs.getString(8));
		displayInfoImage.setModifyDate(rs.getString(9));

		return displayInfoImage;
	}

}
