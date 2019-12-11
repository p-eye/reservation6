package kr.or.connect.reservation.dao.sqls;

public class ProductSqls {
	
	public static final String SELECT_PRODUCTS_ALL = 
			"SELECT di.id, "
			+ "di.product_id, "
			+ "p.description, "
			+ "di.place_name, "
			+ "p.content, "
			+ "fi.save_file_name "
			+ "from display_info di "
			+ "INNER JOIN product p "
			+ "ON di.product_id = p.id "
			+ "INNER JOIN product_image pi "
			+ "ON p.id = pi.product_id "
			+ "INNER JOIN file_info fi "
			+ "ON fi.id = pi.file_id "
			+ "WHERE pi.type = 'th' "
			+ "limit :start, :limit";
	
	public static final String SELECT_PRODUCTS_BY_CATEGORY = 
			"SELECT di.id, "
			+ "di.product_id, "
			+ "p.description, "
			+ "di.place_name, "
			+ "p.content, "
			+ "fi.save_file_name "
			+ "from display_info di "
			+ "INNER JOIN product p "
			+ "ON di.product_id = p.id "
			+ "INNER JOIN product_image pi "
			+ "ON p.id = pi.product_id "
			+ "INNER JOIN file_info fi "
			+ "ON fi.id = pi.file_id "
			+ "WHERE pi.type = 'th' "
			+ "AND p.category_id = :categoryId "
			+ "limit :start, :limit";
}
