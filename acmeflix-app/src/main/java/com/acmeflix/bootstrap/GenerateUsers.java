package com.acmeflix.bootstrap;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.domain.User;
import com.acmeflix.service.ProfileService;
import com.acmeflix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Profile("my-dev")
@RequiredArgsConstructor
@Order(1) // Before doing anything else we must create the users
public class GenerateUsers extends AbstractLogComponent implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Generating users");

        var users = userService.createAll(
                User.builder().email("akiskostakis@gmail.com")
                        .firstName("Akis")
                        .lastName("Kostakis")
                        .password("mypass")
                        .build(),
                User.builder().email("johndoe@gmail.com")
                        .firstName("John")
                        .lastName("Doe")
                        .password("mypass")
                        .build(),
                User.builder().email("giannispetrakis@gmail.com")
                        .firstName("Giannis")
                        .lastName("Petrakis")
                        .password("mypass")
                        .build(),
                User.builder().email("nikospapadakis@gmail.com")
                        .firstName("Nikos")
                        .lastName("Papadakis")
                        .password("mypass")
                        .build()
        );
    }
}
