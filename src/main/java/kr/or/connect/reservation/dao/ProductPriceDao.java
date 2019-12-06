package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.ProductPriceSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dao.mapper.ProductPriceMapper;
import kr.or.connect.reservation.dto.ProductPrice;

@Repository
public class ProductPriceDao {

	private NamedParameterJdbcTemplate jdbc;

	public ProductPriceDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<ProductPrice> getProductPriceList(int productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);

		return jdbc.query(SELECT_PRODUCT_PRICE_LIST, params, new ProductPriceMapper());

	}

}
