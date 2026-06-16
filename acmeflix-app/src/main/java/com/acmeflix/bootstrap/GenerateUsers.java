package com.acmeflix.bootstrap;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.domain.User;
import com.acmeflix.service.ProfileService;
import com.acmeflix.service.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Profile("my-dev")

@Order(1)
public class GenerateUsers extends AbstractLogComponent implements CommandLineRunner {

    private final UserService userService;
    private final ProfileService profileService;

    public GenerateUsers(UserService userService, ProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Generating users");

        var users = userService.createAll(
                new User("akiskostakis@gmail.com", "Akis", "Kostakis", "mypass"),
                new User("johndoe@gmail.com", "John", "Doe", "mypass"),
                new User("giannispetrakis@gmail.com", "Giannis", "Petrakis", "mypass"),
                new User("nikospapadakis@gmail.com", "Nikos", "Papadakis", "mypass")
        );
    }
}
