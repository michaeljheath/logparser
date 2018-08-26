package com.mjh.logparser;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogParser implements CommandLineRunner {

	@Option(name="--logFile",usage="log file")
	private String logFile;
	
    @Option(name="--startDate",usage="start date")
    private String startDate;

    @Option(name="--duration",usage="duration")
    private String duration;

    @Option(name="--threshold",usage="threshold")      
    private String threshold;
    
	@Autowired
	LogService logService;
	
	public static void main(String[] args) {
		SpringApplication.run(LogParser.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
        CmdLineParser parser = new CmdLineParser(this);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    	try{
            parser.parseArgument(args);

            logService.importFileToMySQL(logFile);
            
            startDate = startDate.replace(".", " ");
            Date formattedDate = formatter.parse(startDate);

    		// TODO Auto-generated method stub
    		//logService.getNumberOfRequestsForIP(formattedDate, duration, Integer.parseInt(threshold));
    		
    	}
    	catch(Exception e){
    		System.out.println("Error: " + e.getMessage());
    		return;
    	}
        

	}
}
