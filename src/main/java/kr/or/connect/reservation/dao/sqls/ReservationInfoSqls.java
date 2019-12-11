package kr.or.connect.reservation.dao.sqls;

public class ReservationInfoSqls {
	
	public static final String SELECT_RESERVATION_INFO_LIST = 
			"SELECT ri.id AS reservation_info_id, "
			+ "ri.product_id, "
			+ "ri.display_info_id, "
			+ "ri.reservation_name, "
	 		+ "ri.reservation_tel, "
			+ "ri.reservation_email, "
			+ "ri.cancel_flag AS cancel_yn, "
			+ "ri.reservation_date, "
			+ "ri.create_date, "
			+ "ri.modify_date "
			+ "FROM reservation_info ri "
			+ "WHERE ri.reservation_email = :reservationEmail";

	public static final String CANCEL_RESERVATION = 
			"UPDATE reservation_info ri " 
			+ "SET ri.cancel_flag = 1, "
			+ "ri.modify_date = :modifyDate "
			+ "WHERE ri.id = :reservationInfoId";
	
}
