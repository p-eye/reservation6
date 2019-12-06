package kr.or.connect.reservation.dao.sqls;

public class ProductPriceSqls {
	
	public static final String SELECT_PRODUCT_PRICE_LIST = 
			"SELECT pp.id, "
			+"pp.product_id, "
			+"pp.price_type_name, "
			+"pp.price, "
			+"pp.discount_rate, "
			+"pp.create_date, "
			+"pp.modify_date "
			+"FROM product_price pp "
			+"INNER JOIN display_info di "
			+"ON di.product_id = pp.product_id "
			+"WHERE di.id = :displayInfoId "
			+"ORDER BY pp.id DESC";
}
