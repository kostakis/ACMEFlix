package com.acmeflix.bootstrap;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.domain.User;
import com.acmeflix.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("my-dev")
@RequiredArgsConstructor
//Made this simple class to make sure domain/services/repository work as expected
//The rest of the generated data will be created at the import.sql
public class GenerateUsers extends AbstractLogComponent implements CommandLineRunner {

    private final UserService userService;


    @Override
    public void run(String... args) throws Exception {
        logger.info("Run from GenerateUsers");

       var users = userService.createAll(
               User.builder().email("akiskostakis@gmail.com")
                       .firstName("Akis")
                       .lastName("Kostakis")
                       .password("mypass")
                       .build(),
               User.builder().email("katerinalaskaratou@gmail.com")
                       .firstName("Katerina")
                       .lastName("Laskaratou")
                       .password("mypass")
                       .build(),
               User.builder().email("dimitrisaggelopoulos@gmail.com")
                       .firstName("Dimitris")
                       .lastName("Aggelopoulos")
                       .password("mypass")
                       .build(),
               User.builder().email("gianniskarabinas@gmail.com")
                       .firstName("Giannis")
                       .lastName("Karabinas")
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

       logger.info("Created Users {}", users);
    }
}
