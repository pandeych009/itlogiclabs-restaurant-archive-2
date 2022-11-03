package com.itlogiclab.billing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ItlogicLabBillingApplication implements CommandLineRunner{
	private static Logger logger = LogManager.getLogger(ItlogicLabBillingApplication.class);
	
	@Autowired
	private ConfigurableApplicationContext appContextAutoWired; 
	
	public static void main(String[] args) {
		SpringApplication.run(ItlogicLabBillingApplication.class, args);
		logger.info("Application started successfully: ");
	}


	@Override
	public void run(String... args) throws Exception {
		
	}	
}
