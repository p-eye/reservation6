package kr.or.connect.reservation.dao.sqls;

public class DisplayInfoSqls {
	public static final String SELECT_DISPLAY_INFO = 
			"SELECT di.product_id, "
			+"c.id, "
			+"di.id, "
			+"c.name, "
			+"p.description, "
			+"p.content, "
			+"p.event, "
			+"di.opening_hours, "
			+"di.place_name, "
			+"di.place_lot, "
			+"di.place_street, "
			+"di.tel, "
			+"di.homepage, "
			+"di.email, "
			+"di.create_date, "
			+"di.modify_date "
			+"FROM display_info di "
			+"INNER JOIN product p "
			+"ON p.id = di.product_id "
			+"INNER JOIN category c "
			+"ON c.id = p.category_id "
			+"WHERE di.id = :displayInfoId";
}
