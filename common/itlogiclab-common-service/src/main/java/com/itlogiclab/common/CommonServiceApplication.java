package com.itlogiclab.common;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;

public class CommonServiceApplication implements ApplicationRunner, CommandLineRunner {

	private static Logger logger = LogManager.getLogger(CommonServiceApplication.class);
	
	@Autowired
	private Environment environment;
	
	public static void main(String[] args) {
		logger.info("Application started in the main method");
		SpringApplication.run(CommonServiceApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("CommonServiceApplication: start the run method");
		String sourceArgs = Arrays.toString(args);
		logger.info("Application started with the application runner: "+sourceArgs);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		String sourceArgs = Arrays.toString(args.getSourceArgs());
		logger.info("Application started with the command-line-runner: "+sourceArgs);
		
		

	}

}
