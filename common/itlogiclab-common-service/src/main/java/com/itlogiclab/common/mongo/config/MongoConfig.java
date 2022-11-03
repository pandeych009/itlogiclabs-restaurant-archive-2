package com.itlogiclab.common.mongo.config;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.NoOpDbRefResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientSettings.Builder;
import com.mongodb.MongoCredential;
import com.mongodb.ReadConcern;
import com.mongodb.ReadConcernLevel;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig {
	private static Logger logger = LogManager.getLogger(MongoConfig.class);
	
	@Value("${mongo.host.names:localhost}")
	private String hostNames;
	
	@Value("${mongo.readconcern:primary}")
	private String mongoReadConcern;
	
	@Value("${mongo.username}")
	private String userName;
	
	@Value("${mongo.database:shoppingKart}")
	private String mongoDatabase;
	
	
	@Value("${mongo.password}")
	private String password;
	
	@Value("${mongo.writeconcern:MAJORITY}")
	private String mongoWriteConcern;
	
	
	@Bean("mongoDBFactory")
	public MongoDatabaseFactory databaseFactory() {
		
		logger.debug("mongoConfig: config: "+hostNames);
		String hostName[] = hostNames.split(";");
		List<ServerAddress> addressList = Arrays.stream(hostName).map(hostNameAndPort-> new ServerAddress(hostNameAndPort.split(":")[0], Integer.parseInt(hostNameAndPort.split(":")[1]))).collect(Collectors.toList());
		Builder mongoClientSettingBuilder = MongoClientSettings.builder();
		mongoClientSettingBuilder.credential(MongoCredential.createCredential(userName, mongoDatabase, password.toCharArray()));
		logger.debug("mongoConfig: config: userName: "+userName+", database: "+mongoDatabase);
		mongoClientSettingBuilder.readConcern(new ReadConcern(ReadConcernLevel.fromString(mongoReadConcern)));
		
		mongoClientSettingBuilder.writeConcern(WriteConcern.valueOf(mongoWriteConcern).withWTimeout(5, TimeUnit.SECONDS).withJournal(true));
		
		mongoClientSettingBuilder.applyToClusterSettings(setting -> setting.hosts(addressList));
		MongoClient client = MongoClients.create(mongoClientSettingBuilder.build());
		MongoDatabaseFactory factory = new SimpleMongoClientDatabaseFactory(client, mongoDatabase);
		
		
		return factory;
	}
	
	@Bean("mongoTemplate")
	public MongoTemplate mongoTemplate(MongoDatabaseFactory factory) {
		MappingMongoConverter convertor = new MappingMongoConverter(NoOpDbRefResolver.INSTANCE, new MongoMappingContext());
		convertor.setTypeMapper(new DefaultMongoTypeMapper());
		MongoTemplate template = new MongoTemplate(factory, convertor);
		return template;
		
	}

}
