package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.ProductImageSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dao.mapper.ProductImageMapper;
import kr.or.connect.reservation.dto.ProductImage;

@Repository
public class ProductImageDao {

	private NamedParameterJdbcTemplate jdbc;

	public ProductImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<ProductImage> getProductImageList(int displayInfoId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		return jdbc.query(SELECT_PRODUCT_IMAGE_LIST, params, new ProductImageMapper());

	}

}
