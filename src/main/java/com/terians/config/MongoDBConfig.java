package com.terians.config;/*package com.terians.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

 *//**
 * Created by stromero on 2/5/2015.
 */
/*
@Configuration
@EnableTransactionManagement
@EnableMongoRepositories("com.terians.mongodb.repository")
static class MongoDBConfig extends AbstractMongoConfiguration {

 @Override
 protected String getDatabaseName() {
     return "terians";
 }

 @Override
 static Mongo mongo() throws Exception {
     return new MongoClient("127.0.0.1", 27017);
 }

 @Override
 protected String getMappingBasePackage() {
     return "com.terians.mongodb.model";
 }
}*/
