package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dao.mapper.CategoryMapper;
import kr.or.connect.reservation.dto.Category;

@Repository
public class CategoryDao {

	private NamedParameterJdbcTemplate jdbc;

	public CategoryDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Category> getCategoryList() {
		String sql = "SELECT c.id, "
				+"c.name, "
				+"count(di.id) AS count "
				+"FROM display_info di "
				+"INNER JOIN product p "
				+"ON di.product_id = p.id "
				+"INNER JOIN category c "
				+"ON c.id = p.category_id "
				+"GROUP BY c.id";
		
		return jdbc.query(sql, Collections.emptyMap(), new CategoryMapper());
	}
}
