package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.ReservationResponseDaoSqls.SELECT_RESERVATION;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.response.ReservationResponse;

@Repository
public class ReservationResponseDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationResponse> rowMapper = BeanPropertyRowMapper.newInstance(ReservationResponse.class);

	public ReservationResponseDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);

	}

	public ReservationResponse getReservationResponse(int reservationInfoId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("reservationInfoId", reservationInfoId);
			return jdbc.queryForObject(SELECT_RESERVATION, params, rowMapper);
			
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
