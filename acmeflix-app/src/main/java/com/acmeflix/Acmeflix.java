package com.acmeflix;

import com.acmeflix.repository.UserRepository;
import com.acmeflix.service.UserService;
import com.acmeflix.service.UserServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Acmeflix {
    private static final Logger logger = LoggerFactory.getLogger(Acmeflix.class);

    public static void main(String[] args) {
        SpringApplication.run(Acmeflix.class);
        logger.info("Acmeflix app started");
    }
}