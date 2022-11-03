package com.itlogiclab.delivery;

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
public class ItlogicLabsDeliveryApplication implements CommandLineRunner{

	private static Logger logger = LogManager.getLogger(ItlogicLabsDeliveryApplication.class);
	
	@Autowired
	private ConfigurableApplicationContext appContextAutoWired; 
	
	public static void main(String[] args) {
		SpringApplication.run(ItlogicLabsDeliveryApplication.class, args);
		logger.debug("ItlogicLabsDeliveryApplication: Context loaded; application ready for use");
	}

	@Override
	public void run(String... run) throws Exception{
		String[] beansLoaded = appContextAutoWired.getBeanDefinitionNames();
		final AtomicInteger count = new AtomicInteger();
		String beans = Arrays.stream(beansLoaded).map(input -> count.getAndIncrement()+" - "+input).collect(Collectors.joining("\n"));
		//logger.debug("ItlogicLabsDeliveryApplication: Loaded Beans: "+beans);
	}
}
