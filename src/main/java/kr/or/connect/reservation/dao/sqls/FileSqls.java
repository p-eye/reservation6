package kr.or.connect.reservation.dao.sqls;

public class FileSqls {
	public static final String SELECT_FILE_INFO = 
			"SELECT * "
			+ "FROM file_info "
			+ "WHERE id = :fileId";
	
	public static final String SELECT_FILE_INFO_BY_PRODUCT_ID = 
			"SELECT * "
			+"FROM file_info fi "
			+"INNER JOIN product_image pi "
			+"ON pi.file_id = fi.id "
			+"WHERE pi.type = 'th' "
			+"AND pi.product_id = :productId";
}
