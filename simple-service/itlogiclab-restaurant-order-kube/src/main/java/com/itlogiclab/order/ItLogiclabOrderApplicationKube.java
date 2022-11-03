package com.itlogiclab.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ItLogiclabOrderApplicationKube  implements CommandLineRunner{
	private static Logger logger = LogManager.getLogger(ItLogiclabOrderApplicationKube.class);
	
	@Autowired
	private ConfigurableApplicationContext appContextAutoWired; 
	
	public static void main(String[] args) {
		SpringApplication.run(ItLogiclabOrderApplicationKube.class, args);
		logger.debug("ItLogiclabOrderApplicationKube: Context loaded; application ready for use");
	}

	@Override
	public void run(String... run) throws Exception{
		String[] beansLoaded = appContextAutoWired.getBeanDefinitionNames();
		//final AtomicInteger count = new AtomicInteger();
		// beans = Arrays.stream(beansLoaded).map(input -> count.getAndIncrement()+" - "+input).collect(Collectors.joining("\n"));
		//logger.debug("itlogiclabOrderApplicationKube: Loaded Beans: "+beans);
	}

	
	
	
}
