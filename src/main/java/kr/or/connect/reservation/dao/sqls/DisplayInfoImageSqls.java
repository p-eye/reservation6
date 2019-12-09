package kr.or.connect.reservation.dao.sqls;

public class DisplayInfoImageSqls {
	public static final String SELECT_DISPLAY_INFO_IMAGE = 
			"SELECT dii.id, "
			+"dii.display_info_id,  "
			+"dii.file_id, "
			+"fi.file_name, "
			+"fi.save_file_name, "
			+"fi.content_type, "
			+"fi.delete_flag, "
			+"fi.create_date, "
			+"fi.modify_date "
			+"FROM display_info_image dii "
			+"INNER JOIN file_info fi "
			+"ON fi.id = dii.file_id "
			+"WHERE dii.display_info_id = :displayInfoId";
}
