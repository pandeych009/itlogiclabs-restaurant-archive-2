package com.itlogiclab.payment;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class itlogiclabPaymentApplication implements CommandLineRunner{
private static Logger logger = LogManager.getLogger(itlogiclabPaymentApplication.class);
	
	@Autowired
	private ConfigurableApplicationContext appContextAutoWired; 
	
	public static void main(String[] args) {
		SpringApplication.run(itlogiclabPaymentApplication.class, args);
		logger.info("Application started successfully: ");
	}


	@Override
	public void run(String... args) throws Exception {
		String[] beansLoaded = appContextAutoWired.getBeanDefinitionNames();
		final AtomicInteger count = new AtomicInteger();
		String beans = Arrays.stream(beansLoaded).map(input -> count.getAndIncrement()+" - "+input).collect(Collectors.joining("\n"));
		logger.trace("itlogiclabPaymentApplication: Loaded Beans: "+beans);
		
	}	
}
