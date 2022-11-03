package com.itlogiclab.order;

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
public class ItLogiclabsOrderApplication  implements CommandLineRunner{
	private static Logger logger = LogManager.getLogger(ItLogiclabsOrderApplication.class);
	
	@Autowired
	private ConfigurableApplicationContext appContextAutoWired; 
	
	public static void main(String[] args) {
		SpringApplication.run(ItLogiclabsOrderApplication.class, args);
		logger.debug("ItLogiclabsOrderApplication: Context loaded; application ready for use");
	}

	@Override
	public void run(String... run) throws Exception{
		String[] beansLoaded = appContextAutoWired.getBeanDefinitionNames();
		final AtomicInteger count = new AtomicInteger();
		String beans = Arrays.stream(beansLoaded).map(input -> count.getAndIncrement()+" - "+input).collect(Collectors.joining("\n"));
		//logger.debug("ItLogiclabsOrderApplication: Loaded Beans: "+beans);
	}

	
	
	
}
