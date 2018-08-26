package com.mjh.logparser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class LogService {


	public void importFileToMySQL(String fileName){
		List<String> lines = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			
			lines = stream.collect(Collectors.toList());
			System.out.println("File lines: " + lines.size());
			
			//insertRows(lines);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void insertRows(List<Object[]> lines){
		LogDAO logDAO = new LogDAOImpl();
		logDAO.insertRows(lines);
	}
}
