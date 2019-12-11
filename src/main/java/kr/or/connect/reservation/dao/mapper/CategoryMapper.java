package kr.or.connect.reservation.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.or.connect.reservation.dto.Category;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {

		Category category = new Category();
		
		category.setCategoryId(rs.getInt(1));
		category.setCategoryName(rs.getString(2));
		category.setDisplayInfoCount(rs.getInt(3));

		return category;
	}

}
