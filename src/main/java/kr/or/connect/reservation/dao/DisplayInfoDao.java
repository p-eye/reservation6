package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.DisplayInfoSqls.*;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dao.mapper.DisplayInfoMapper;
import kr.or.connect.reservation.dto.DisplayInfo;

@Repository
public class DisplayInfoDao {

	private NamedParameterJdbcTemplate jdbc;

	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}


	public DisplayInfo getDisplayInfo(int displayInfoId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("displayInfoId", displayInfoId);
			return jdbc.queryForObject(SELECT_DISPLAY_INFO, params, new DisplayInfoMapper());

		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	/* 테스트 1
	public DisplayInfo getDisplayInfo(int displayInfoId) throws EmptyResultDataAccessException {
			Map<String, Integer> params = new HashMap<>();
			params.put("displayInfoId", displayInfoId);
			return jdbc.queryForObject(SELECT_DISPLAY_INFO, params, new DisplayInfoMapper());
	}
	*/

	
	/* 테스트 2
	public DisplayInfo getDisplayInfo(int displayInfoId) {
			Map<String, Integer> params = new HashMap<>();
			params.put("displayInfoId", displayInfoId);
			return jdbc.queryForObject(SELECT_DISPLAY_INFO, params, new DisplayInfoMapper());
	}
	*/

}
