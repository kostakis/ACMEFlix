package com.acmeflix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories
@SpringBootApplication
public class Acmeflix {
    private static final Logger logger = LoggerFactory.getLogger(Acmeflix.class);

    public static void main(String[] args) {
        SpringApplication.run(Acmeflix.class);
        logger.info("Acmeflix app started");
    }
}