package kr.or.connect.reservation.dao.sqls;

public class PromotionSqls {
	public static final String SELECT_PROMOTIONS = 
			"SELECT p.id, "
			+"p.product_id, "
			+"fi.save_file_name "
			+"FROM promotion p "
			+"INNER JOIN product_image pi "
			+"ON p.product_id = pi.product_id "
			+"INNER JOIN file_info fi "
			+"ON fi.id = pi.file_id "
			+"WHERE pi.type = 'th'";
}
