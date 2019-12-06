package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dao.mapper.DisplayInfoImageMapper;
import kr.or.connect.reservation.dto.DisplayInfoImage;

@Repository
public class DisplayInfoImageDao {

	private NamedParameterJdbcTemplate jdbc;

	public DisplayInfoImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public DisplayInfoImage getDisplayInfoImage(int displayInfoId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		String sql = "SELECT dii.id, "
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
		
		return jdbc.queryForObject(sql, params, new DisplayInfoImageMapper());

	}


}
