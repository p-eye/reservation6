package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

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
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("file_info")
				.usingGeneratedKeyColumns("id");
	}

	public int insertFileInfo(FileInfo fileInfo) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(fileInfo);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	public FileInfo getFileInfo(int fileId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("fileId", fileId);
		String sql = "SELECT * FROM file_info WHERE id = :fileId";
		return jdbc.queryForObject(sql, params, rowMapper);
	}
	
	public FileInfo getFileInfoByProductId(int productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		String sql = 
		"SELECT * "
		+"FROM file_info fi "
		+"INNER JOIN product_image pi "
		+"ON pi.file_id = fi.id "
		+"WHERE pi.type = 'th' "
		+"AND pi.product_id = :productId";
		return jdbc.queryForObject(sql, params, rowMapper);
	}
	
	
}
