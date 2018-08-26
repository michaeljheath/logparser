package com.mjh.logparser;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class LogDAOImpl implements LogDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
	@Override
	public void insertRows(List<Object[]> rows) {
		jdbcTemplate.batchUpdate("insert into LOGS (DATE,IP_ADDRESS,REQUEST,STATUS,USER_AGENT) values(?,?,?,?,?,?)" , rows);
	}

	@Override
	public void findByStartDateDurationThreshold(Date startDate, String duration, int threshold) {
		RowMapper<LogEntry> rowMapper = new BeanPropertyRowMapper<LogEntry>(LogEntry.class);

		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from logs");
		rows.forEach( row -> System.out.println(row.toString()));
	}

}
