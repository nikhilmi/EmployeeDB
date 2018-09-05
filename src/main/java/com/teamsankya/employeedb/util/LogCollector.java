package com.teamsankya.employeedb.util;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.log4j.Logger;

public class LogCollector {

	final static Logger logger= Logger.getLogger(LogCollector.class);
	
	public static void main(String[] args) {
	
		logger.info("program started");
		try {
			logger.info("giving file path");
			String path= "E:\\ll\\log.txt";
			FileReader reader= new FileReader(path);
			BufferedReader in= new BufferedReader(reader);
			String line=null;
			while((line= in.readLine()) != null) {
				System.out.println(line);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		
	}

