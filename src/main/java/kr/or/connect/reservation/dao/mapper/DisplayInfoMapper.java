package kr.or.connect.reservation.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.or.connect.reservation.dto.DisplayInfo;

public class DisplayInfoMapper implements RowMapper<DisplayInfo> {

	@Override
	public DisplayInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

		DisplayInfo displayInfo = new DisplayInfo();
		
		displayInfo.setProductId(rs.getInt(1));
		displayInfo.setCategoryId(rs.getInt(2));
		displayInfo.setDisplayInfoId(rs.getInt(3));
		displayInfo.setCategoryName(rs.getString(4));
		displayInfo.setProductDescription(rs.getString(5));
		displayInfo.setProductContent(rs.getString(6));
		displayInfo.setProductEvent(rs.getString(7));
		displayInfo.setOpeningHours(rs.getString(8));
		displayInfo.setPlaceName(rs.getString(9));
		displayInfo.setPlaceLot(rs.getString(10));
		displayInfo.setPlaceStreet(rs.getString(11));
		displayInfo.setTelephone(rs.getString(12));
		displayInfo.setHomepage(rs.getString(13));
		displayInfo.setEmail(rs.getString(14));
		displayInfo.setCreateDate(rs.getString(15));
		displayInfo.setModifyDate(rs.getString(16));

		return displayInfo;
	}

}
