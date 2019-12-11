package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.sqls.FileSqls.*;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.FileInfo;

@Repository
public class FileDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<FileInfo> rowMapper = BeanPropertyRowMapper.newInstance(FileInfo.class);
	private SimpleJdbcInsert insertAction;

	public FileDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("file_info").usingGeneratedKeyColumns("id");
	}

	public int insertFileInfo(FileInfo fileInfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(fileInfo);
		return insertAction.executeAndReturnKey(params).intValue();
	}

	public FileInfo getFileInfo(int fileId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("fileId", fileId);
			return jdbc.queryForObject(SELECT_FILE_INFO, params, rowMapper);

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public FileInfo getFileInfoByProductId(int productId) {
		try {
			Map<String, Integer> params = new HashMap<>();
			params.put("productId", productId);
			return jdbc.queryForObject(SELECT_FILE_INFO_BY_PRODUCT_ID, params, rowMapper);

		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
