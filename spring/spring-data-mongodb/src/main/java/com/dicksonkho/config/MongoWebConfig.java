package com.dicksonkho.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Dickson Kho May 9, 2015
 */
@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@EnableMongoRepositories({"com.dicksonkho.repositories"})
@ComponentScan(basePackages = {"com.dicksonkho.controller"})
public class MongoWebConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "shopdb";
    }

    @Bean
    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("localhost");
    }
}
