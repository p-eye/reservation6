package kr.or.connect.reservation.dao.sqls;

public class CommentSqls {
	public static final String SELECT_COMMENT_LIST = 
			"SELECT ruc.id, "
			+ "ri.product_id, "
			+ "ruc.reservation_info_id, "
			+ "ruc.score, "
			+ "ruc.comment, "
			+ "ri.reservation_name, "
			+ "ri.reservation_tel, "
			+ "ri.reservation_email, "
			+ "ri.reservation_date, "
			+ "ruc.create_date, "
			+ "ruc.modify_date "
			+ "FROM reservation_user_comment ruc "
			+ "INNER JOIN reservation_info ri "
			+ "ON ri.id = ruc.reservation_info_id "
			+ "WHERE ri.product_id = :productId "
			+ "ORDER BY ruc.id DESC";
	
	public static final String CALC_AVERAGE_SCORE = 
			"SELECT AVG(ruc.score) " 
			+ "FROM reservation_user_comment ruc "
			+ "INNER JOIN reservation_info ri ON ri.id =  ruc.reservation_info_id "
			+ "WHERE ri.product_id = :productId " 
			+ "ORDER BY ri.id DESC";
	
	public static final String SELECT_COMMENT_RESPONSE = 
			"SELECT ruc.id AS comment_id, " 
			+ "ruc.product_id, " 
			+ "ruc.reservation_info_id, "
			+ "ruc.score, " 
			+ "ruc.comment, " 
			+ "ruc.create_date, " 
			+ "ruc.modify_date "
			+ "FROM reservation_user_comment ruc " 
			+ "WHERE ruc.id = :commentId";
}
