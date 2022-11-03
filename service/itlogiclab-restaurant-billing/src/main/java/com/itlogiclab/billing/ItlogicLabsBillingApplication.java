package com.itlogiclab.billing;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ItlogicLabsBillingApplication implements CommandLineRunner{
	private static Logger logger = LogManager.getLogger(ItlogicLabsBillingApplication.class);
	
	@Autowired
	private ConfigurableApplicationContext appContextAutoWired; 
	
	public static void main(String[] args) {
		SpringApplication.run(ItlogicLabsBillingApplication.class, args);
		logger.info("Application started successfully: ");
	}


	@Override
	public void run(String... args) throws Exception {
		String[] beansLoaded = appContextAutoWired.getBeanDefinitionNames();
		final AtomicInteger count = new AtomicInteger();
		String beans = Arrays.stream(beansLoaded).map(input -> count.getAndIncrement()+" - "+input).collect(Collectors.joining("\n"));
		logger.trace("ItlogicLabsDeliveryApplication: Loaded Beans: "+beans);
		
	}	
	
//	public TomcatServletWebServerFactory getTomcatFactory() {
//		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//			
//			@Override
//			public TomcatWebServer getTomcatWebServer(org.apache.catalina.startup.Tomcat tomcat) {
//				tomcat.enableNaming();
//				return super.getTomcatWebServer(tomcat);
//			}
//			
//			@Override
//	        protected void postProcessContext(Context context) {
//				ContextResource resource = new ContextResource();
//	            resource.setName("jdbc/myJndiResource");
//	            resource.setType(DataSource.class.getName());
//	            resource.setProperty("driverClassName", "DRIVER_NAME");
//
//	            resource.setProperty("url", "jdbc:postgresql://hostname:port/dbname");
//	            resource.setProperty("username", "username");
//	            resource.setProperty("password", "password");
//	            context.getNamingResources().addResource(resource);  
//	        }
//	    };
//	    return tomcat;
//	}
	
}
