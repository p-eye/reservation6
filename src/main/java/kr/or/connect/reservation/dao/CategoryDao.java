package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.CategorySqls.SELECT_CATEGORIES;

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
		return jdbc.query(SELECT_CATEGORIES, Collections.emptyMap(), new CategoryMapper());
	}
}
