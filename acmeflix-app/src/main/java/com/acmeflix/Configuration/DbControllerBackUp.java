package com.acmeflix.Configuration;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
public class DbControllerBackUp extends AbstractLogComponent {

    @Autowired
    UserRepository userRepository;

    //@Scheduled(cron = "0 0 0/24 * * ?") //Every 24 hours
    //@Scheduled(cron = "0 0/1 * * * ?") //Every min for example
    @Scheduled(cron = "0/20 * * * * ?") //Every 20sec for example
    public void backupUsers() {
        Date date = new Date();
        logger.trace("Starting backup of DB: {}", date);

        //TODO if we have time
    }
}
