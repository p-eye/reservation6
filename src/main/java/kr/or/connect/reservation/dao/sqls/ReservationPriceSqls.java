package kr.or.connect.reservation.dao.sqls;

public class ReservationPriceSqls {
	
	public static final String SELECT_RESERVATION_PRICE_LIST = 
			"SELECT rip.id AS reservation_info_price_id, "
			+ "rip.reservation_info_id, "
			+ "rip.product_price_id, "
			+ "rip.count "
			+ "FROM reservation_info_price rip "
			+ "WHERE rip.reservation_info_id = :reservationInfoId";

	public static final String SELECT_RESERVATION_TOTAL_PRICE = 
			"SELECT sum(rip.count * pp.price) "
			+ "FROM reservation_info_price rip "
			+ "INNER JOIN product_price pp "
			+ "ON pp.id = rip.product_price_id "
			+ "WHERE rip.reservation_info_id = :reservationInfoId "
			+ "GROUP BY rip.reservation_info_id";
}
