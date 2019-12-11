package kr.or.connect.reservation.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.or.connect.reservation.dto.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

		Product product = new Product();
		product.setDisplayInfoId(rs.getInt(1));
		product.setProductId(rs.getInt(2));
		product.setProductDescription(rs.getString(3));
		product.setPlaceName(rs.getString(4));
		product.setProductContent(rs.getString(5));
		product.setProductImageUrl(rs.getString(6));

		return product;
	}

}
