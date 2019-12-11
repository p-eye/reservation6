package kr.or.connect.reservation.dao.sqls;

public class ProductImageSqls {
	
	public static final String SELECT_PRODUCT_IMAGE_LIST = 
			"SELECT pi.product_id, "
			+ "pi.id, "
			+ "pi.type, "
			+ "pi.file_id, "
			+ "fi.file_name, "
			+ "fi.save_file_name, "
			+ "fi.content_type, "
			+ "fi.delete_flag, "
			+ "fi.create_date, "
			+ "fi.modify_date "
			+ "FROM product_image pi "
			+ "INNER JOIN file_info fi "
	 		+ "ON fi.id = pi.file_id "
			+ "WHERE pi.type NOT IN ('th') "
			+ "AND pi.product_id = :productId "
			+ "LIMIT 2";

}
