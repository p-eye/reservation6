package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.MatchingSqls.*;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Comment;
import kr.or.connect.reservation.dto.ReservationInfo;

@Repository
public class MatchingDao {

	private NamedParameterJdbcTemplate jdbc;

	public MatchingDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public Comment matchComment(int reservationInfoId, int productId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("reservationInfoId", reservationInfoId);
			params.put("productId", productId);
			return jdbc.queryForObject(MATCH_COMMENT, params, BeanPropertyRowMapper.newInstance(Comment.class));

		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public ReservationInfo matchReservationInfo(int reservationInfoId, int productId) {

		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("reservationInfoId", reservationInfoId);
			params.put("productId", productId);
			return jdbc.queryForObject(MATCH_RESERVATION_INFO_BY_PRODUCT_ID, params,
					BeanPropertyRowMapper.newInstance(ReservationInfo.class));

		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public ReservationInfo matchReservationInfo(int reservationInfoId, String reservationEmail) {

		try {
			Map<String, Object> params = new HashMap<>();
			params.put("reservationInfoId", reservationInfoId);
			params.put("reservationEmail", reservationEmail);
			return jdbc.queryForObject(MATCH_RESERVATION_INFO_BY_EMAIL, params,
					BeanPropertyRowMapper.newInstance(ReservationInfo.class));

		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}
}
