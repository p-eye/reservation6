package kr.or.connect.reservation.dao.sqls;

public class CategorySqls {
	public static final String SELECT_CATEGORIES = 
			"SELECT c.id, " 
			+ "c.name, " 
			+ "count(di.id) AS count "
			+ "FROM display_info di "
			+ "INNER JOIN product p " 
			+ "ON di.product_id = p.id " 
			+ "INNER JOIN category c "
			+ "ON c.id = p.category_id " 
			+ "GROUP BY c.id";
}
