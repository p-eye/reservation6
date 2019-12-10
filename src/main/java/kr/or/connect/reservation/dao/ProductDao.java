package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.ProductSqls.SELECT_PRODUCTS_ALL;
import static kr.or.connect.reservation.dao.sqls.ProductSqls.SELECT_PRODUCTS_BY_CATEGORY;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dao.mapper.ProductMapper;
import kr.or.connect.reservation.dto.Product;
import kr.or.connect.reservation.dto.ProductTable;

@Repository
public class ProductDao {

	private NamedParameterJdbcTemplate jdbc;

	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Product> getProductListAll(int start, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);

		return jdbc.query(SELECT_PRODUCTS_ALL, params, new ProductMapper());

	}

	public List<Product> getProductListByCategory(int categoryId, int start, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);

		return jdbc.query(SELECT_PRODUCTS_BY_CATEGORY, params, new ProductMapper());
	}

	public ProductTable getProduct(int productId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("productId", productId);
			String sql = "SELECT * FROM product WHERE id = :productId";

			return jdbc.queryForObject(sql, params, BeanPropertyRowMapper.newInstance(ProductTable.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

}
