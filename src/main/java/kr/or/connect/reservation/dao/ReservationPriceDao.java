package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.ReservationPriceSqls.SELECT_RESERVATION_PRICE_LIST;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationPrice;

@Repository
public class ReservationPriceDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationPrice> rowMapper = BeanPropertyRowMapper.newInstance(ReservationPrice.class);
	private SimpleJdbcInsert insertAction;

	public ReservationPriceDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_info_price")
				.usingGeneratedKeyColumns("id");
	}

	public List<ReservationPrice> getReservationPriceList(int reservationInfoId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("reservationInfoId", reservationInfoId);
			return jdbc.query(SELECT_RESERVATION_PRICE_LIST, params, rowMapper);
			
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public void insertReservationPrice(ReservationPrice reservationPrice) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationPrice);
		insertAction.execute(params);
	}

}
