package com.acmeflix.bootstrap;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.domain.User;
import com.acmeflix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("my-dev")
@RequiredArgsConstructor
public class GenerateUsers extends AbstractLogComponent implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Run from GenerateUsers");

       List<User> users = userService.createAll(
               User.builder().email("akiskostakis@gmail.com")
                       .firstName("Akis")
                       .lastName("Kostakis")
                       .password("mypass")
                       .build()
       );
    }
}
