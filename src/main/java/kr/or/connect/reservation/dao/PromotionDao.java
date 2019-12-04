package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.PromotionSqls.*;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dao.mapper.PromotionMapper;
import kr.or.connect.reservation.dto.Promotion;

@Repository
public class PromotionDao {

	private NamedParameterJdbcTemplate jdbc;

	public PromotionDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Promotion> getPromotionList() {
		return jdbc.query(SELECT_PROMOTIONS, Collections.emptyMap(), new PromotionMapper());
	}
}
