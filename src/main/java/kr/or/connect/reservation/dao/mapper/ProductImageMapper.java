package kr.or.connect.reservation.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.or.connect.reservation.dto.ProductImage;

public class ProductImageMapper implements RowMapper<ProductImage> {

	@Override
	public ProductImage mapRow(ResultSet rs, int rowNum) throws SQLException {

		ProductImage productImage = new ProductImage();

		productImage.setProductId(rs.getInt(1));
		productImage.setProductImageId(rs.getInt(2));
		productImage.setType(rs.getString(3));
		productImage.setFileInfoId(rs.getInt(4));
		productImage.setFileName(rs.getString(5));
		productImage.setSaveFileName(rs.getString(6));
		productImage.setContentType(rs.getString(7));
		productImage.setDeleteFlag(rs.getBoolean(8));
		productImage.setCreateDate(rs.getString(9));
		productImage.setModifyDate(rs.getString(10));

		return productImage;

	}

}
