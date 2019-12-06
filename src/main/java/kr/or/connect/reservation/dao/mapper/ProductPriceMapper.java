package kr.or.connect.reservation.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.or.connect.reservation.dto.ProductPrice;

public class ProductPriceMapper implements RowMapper<ProductPrice> {

	@Override
	public ProductPrice mapRow(ResultSet rs, int rowNum) throws SQLException {

		ProductPrice productPrice = new ProductPrice();

		productPrice.setProductPriceId(rs.getInt(1));
		productPrice.setProductId(rs.getInt(2));
		productPrice.setPriceTypeName(rs.getString(3));
		productPrice.setPrice(rs.getInt(4));
		productPrice.setDiscountRate(rs.getDouble(5));
		productPrice.setCreateDate(rs.getString(6));
		productPrice.setModifyDate(rs.getString(7));

		return productPrice;
	}

}
