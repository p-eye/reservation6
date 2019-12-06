package kr.or.connect.reservation.dao.sqls;

public class CommentImageSqls {
	public static final String SELECT_COMMENT_IMAGE_LIST = 
			"SELECT ruci.id, "
			+"ruci.reservation_info_id, "
			+"ruc.id , "
			+"ruci.file_id, "
			+"fi.file_name, "
			+"fi.save_file_name, "
			+"fi.content_type, "
			+"fi.delete_flag, "
			+"fi.create_date, "
			+"fi.modify_date "
			+"FROM reservation_user_comment_image ruci "
			+"INNER JOIN file_info fi "
			+"ON fi.id = ruci.file_id "
			+"INNER JOIN reservation_user_comment ruc "
			+"ON ruc.id = ruci.reservation_user_comment_id "
			+"WHERE ruc.reservation_info_id = :reservationInfoId";

}
