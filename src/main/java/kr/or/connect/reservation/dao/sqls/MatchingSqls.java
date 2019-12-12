package kr.or.connect.reservation.dao.sqls;

public class MatchingSqls {
	public static final String MATCH_COMMENT = 
			"SELECT id AS comment_id, "
			+ "product_id, "
			+ "reservation_info_id, "
			+ "comment "
			+ " FROM " + "reservation_user_comment "
			+ "WHERE reservation_info_id = :reservationInfoId " 
			+ "AND product_id = :productId";
	
	public static final String MATCH_RESERVATION_INFO_BY_PRODUCT_ID =
			"SELECT ri.id AS reservation_info_id, " 
			+ "ri.product_id, " 
			+ "ri.display_info_id, "
			+ "ri.reservation_name, " 
			+ "ri.reservation_tel, " 
			+ "ri.reservation_email, "
			+ "ri.reservation_date, " 
			+ "ri.cancel_flag, " 
			+ "ri.create_date, " 
			+ "ri.modify_date "
			+ "FROM reservation_info ri " 
			+ "WHERE ri.id = :reservationInfoId "
			+ "AND ri.product_id = :productId";
	
	
	public static final String MATCH_RESERVATION_INFO_BY_EMAIL =
			"SELECT ri.id AS reservation_info_id, " 
			+ "ri.product_id, " 
			+ "ri.display_info_id, "
			+ "ri.reservation_name, " 
			+ "ri.reservation_tel, " 
			+ "ri.reservation_email, "
			+ "ri.reservation_date, " 
			+ "ri.cancel_flag, " 
			+ "ri.create_date, " 
			+ "ri.modify_date "
			+ "FROM reservation_info ri " 
			+ "WHERE ri.id = :reservationInfoId "
			+ "AND ri.reservation_email = :reservationEmail";
}
