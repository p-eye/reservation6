package kr.or.connect.reservation.dao.sqls;

public class ReservationResponseDaoSqls {

	public static final String SELECT_RESERVATION =
			 "SELECT ri.id AS reservation_info_id, "
			 + "ri.display_info_id, "
			 + "ri.product_id, "
			 + "ri.reservation_email, "
			 + "ri.reservation_name, "
			 + "ri.reservation_tel, "
			 + "ri.reservation_date, "
			 + "ri.cancel_flag, "
			 + "ri.create_date, "
			 + "ri.modify_date "
			 + "FROM reservation_info ri "
			 + "WHERE ri.id = :reservationInfoId";
}
