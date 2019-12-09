package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.CommentTable;
import kr.or.connect.reservation.dto.ReservationInfo;

@Repository
public class MatchingDao {

	private NamedParameterJdbcTemplate jdbc;

	public MatchingDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public CommentTable matchComment(int reservationInfoId, int productId) {
		try {

			Map<String, Integer> params = new HashMap<>();
			params.put("reservationInfoId", reservationInfoId);
			params.put("productId", productId);

			String sql = "SELECT * FROM " + "reservation_user_comment "
					+ "WHERE reservation_info_id = :reservationInfoId " + "AND product_id = :productId";

			return jdbc.queryForObject(sql, params, BeanPropertyRowMapper.newInstance(CommentTable.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public ReservationInfo matchReservationInfo(int reservationInfoId, int productId) {

		try {

			Map<String, Integer> params = new HashMap<>();
			params.put("reservationInfoId", reservationInfoId);
			params.put("productId", productId);

			String sql = "SELECT ri.id AS reservation_info_id, " + "ri.product_id, " + "ri.display_info_id, "
					+ "ri.reservation_name, " + "ri.reservation_tel, " + "ri.reservation_email, "
					+ "ri.reservation_date, " + "ri.cancel_flag, " + "ri.create_date, " + "ri.modify_date "
					+ "FROM reservation_info ri " + "WHERE ri.id = :reservationInfoId "
					+ "AND ri.product_id = :productId";

			return jdbc.queryForObject(sql, params, BeanPropertyRowMapper.newInstance(ReservationInfo.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public ReservationInfo matchReservationInfo(int reservationInfoId, String reservationEmail) {

		try {
			Map<String, Object> params = new HashMap<>();
			params.put("reservationInfoId", reservationInfoId);
			params.put("reservationEmail", reservationEmail);

			String sql = "SELECT ri.id AS reservation_info_id, " + "ri.product_id, " + "ri.display_info_id, "
					+ "ri.reservation_name, " + "ri.reservation_tel, " + "ri.reservation_email, "
					+ "ri.reservation_date, " + "ri.cancel_flag, " + "ri.create_date, " + "ri.modify_date "
					+ "FROM reservation_info ri " + "WHERE ri.id = :reservationInfoId "
					+ "AND ri.reservation_email = :reservationEmail";
			return jdbc.queryForObject(sql, params, BeanPropertyRowMapper.newInstance(ReservationInfo.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}
}
