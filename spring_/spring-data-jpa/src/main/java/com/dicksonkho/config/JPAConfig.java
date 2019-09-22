package com.dicksonkho.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.dicksonkho.jpa.repository")
@EnableTransactionManagement
public class JPAConfig {
// Override configuration by Java Bean here if there is any
}
