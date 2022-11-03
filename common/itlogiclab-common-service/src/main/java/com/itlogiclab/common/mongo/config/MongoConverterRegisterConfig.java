package com.itlogiclab.common.mongo.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.convert.NoOpDbRefResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

public class MongoConverterRegisterConfig extends MongoConfig {
	
	private static Logger logger = LogManager.getLogger(MongoConverterRegisterConfig.class);
	
	private List<Converter<?, ?>> converterList = null;

	/**
	 * @return the converterList
	 */
	public List<Converter<?, ?>> getConverterList() {
		return converterList;
	}

	/**
	 * @param converterList the converterList to set
	 */
	@Bean
	public void addConverter(Converter<?, ?> converter) {
		if(Objects.isNull(converterList))
			converterList = new ArrayList<Converter<?,?>>();
		converterList.add(converter);
	}
	
	@Override
	public MongoTemplate mongoTemplate(MongoDatabaseFactory factory) {
		logger.debug("MongoConverterRegisterConfig: executing: ");
		
		
		if(Objects.isNull(converterList)) {
			return super.mongoTemplate(factory);
		}
		MappingMongoConverter mappingConverter = new MappingMongoConverter(NoOpDbRefResolver.INSTANCE, new MongoMappingContext());
		mappingConverter.setTypeMapper(new DefaultMongoTypeMapper());
		mappingConverter.setCustomConversions(new MongoCustomConversions(converterList));
		mappingConverter.afterPropertiesSet();
		
		MongoTemplate template = new MongoTemplate(factory, mappingConverter);
		
		return template;
	}
}
