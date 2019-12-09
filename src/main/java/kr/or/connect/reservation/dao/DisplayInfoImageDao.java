package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.DisplayInfoImageSqls.*;

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

		return jdbc.queryForObject(SELECT_DISPLAY_INFO_IMAGE, params, new DisplayInfoImageMapper());

	}

}
