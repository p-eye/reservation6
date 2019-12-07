package kr.or.connect.reservation.dao.sqls;

public class ReservationPriceSqls {
	
	public static final String SELECT_RESERVATION_PRICE_LIST = 
			"SELECT rip.id AS reservation_info_price_id, "
			+"rip.reservation_info_id, "
			+"rip.product_price_id, "
			+"rip.count "
			+"FROM reservation_info_price rip "
			+"WHERE rip.reservation_info_id = :reservationInfoId";

}
