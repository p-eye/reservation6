package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dao.mapper.ProductMapper;
import kr.or.connect.reservation.dto.Product;

@Repository
public class ProductDao {

	private NamedParameterJdbcTemplate jdbc;

	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Product> getProductListByCategoryId(int categoryId, int start, int limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		
		String sql ="SELECT di.id, "
				+"di.product_id, "
				+"p.description, "
				+"di.place_name, "
				+"p.content, "
				+"fi.save_file_name "
				+"from display_info di "
				+"INNER JOIN product p "
				+"ON di.product_id = p.id "
				+"INNER JOIN product_image pi "
				+"ON p.id = pi.product_id "
				+"INNER JOIN file_info fi "
				+"ON fi.id = pi.file_id "
				+"WHERE pi.type = 'th' "
				+"AND p.category_id = :categoryId "
				+"limit :start, :limit";
		
		return jdbc.query(sql, params, new ProductMapper());
	}
}
