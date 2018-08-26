package com.mjh.logparser;

import java.sql.Date;
import java.util.List;

public interface LogDAO {
	public void insertRows(List<Object[]> rows);
	public void findByStartDateDurationThreshold(Date startDate, String duration, int threshold);
}
