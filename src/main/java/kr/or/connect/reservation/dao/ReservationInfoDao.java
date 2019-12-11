package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.ReservationInfoSqls.CANCEL_RESERVATION;
import static kr.or.connect.reservation.dao.sqls.ReservationInfoSqls.SELECT_RESERVATION_INFO_LIST;
import static kr.or.connect.reservation.dao.sqls.ReservationPriceSqls.SELECT_RESERVATION_TOTAL_PRICE;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.ReservationInfo;
import kr.or.connect.reservation.dto.param.ReservationParam;

@Repository
public class ReservationInfoDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationInfo> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfo.class);
	private SimpleJdbcInsert insertAction;

	public ReservationInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("reservation_info")
				.usingGeneratedKeyColumns("id");
	}

	public List<ReservationInfo> getReservationInfoList(String reservationEmail) {
		Map<String, String> params = new HashMap<>();
		params.put("reservationEmail", reservationEmail);

		return jdbc.query(SELECT_RESERVATION_INFO_LIST, params, rowMapper);
	}

	public int getReservationTotalPrice(int reservationInfoId) {

		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("reservationInfoId", reservationInfoId);
			return jdbc.queryForObject(SELECT_RESERVATION_TOTAL_PRICE, params, Integer.class);

		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}

	public int insertReservationInfo(ReservationParam reservationParam) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationParam);
		return insertAction.executeAndReturnKey(params).intValue();
	}

	public int cancelReservationInfo(int reservationInfoId) {
		try {
			SqlParameterSource params = new MapSqlParameterSource().addValue("reservationInfoId", reservationInfoId)
					.addValue("modifyDate", new Date());
			return jdbc.update(CANCEL_RESERVATION, params);

		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}

	public ReservationInfo getReservationInfo(int reservationInfoId) {

		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("reservationInfoId", reservationInfoId);
			String sql = "SELECT id AS reservation_info_id, reservation_email FROM reservation_info WHERE id = :reservationInfoId ";
			return jdbc.queryForObject(sql, params, rowMapper);
			
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
