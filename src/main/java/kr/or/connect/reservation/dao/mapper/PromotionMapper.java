package kr.or.connect.reservation.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.or.connect.reservation.dto.Promotion;

public class PromotionMapper implements RowMapper<Promotion> {

	@Override
	public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException {

		Promotion promotion = new Promotion();
		promotion.setId(rs.getInt(1));
		promotion.setProductId(rs.getInt(2));
		promotion.setProductImageUrl(rs.getString(3));

		return promotion;
	}

}
