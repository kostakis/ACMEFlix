package com.acmeflix.Configuration;

import com.acmeflix.base.AbstractLogComponent;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
public class DbControllerBackUp extends AbstractLogComponent {


    //@Scheduled(cron = "0 0 0/24 * * ?") //Every 24 hours
    @Scheduled(cron = "0 0/1 * * * ?") //Every min for example
    public void backup() throws IOException {
        Date date = new Date();
        logger.trace("Starting backup of DB: {}", date);

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String backupDateStr = format.format(date);

        String rootPath = new File("").getAbsolutePath() + File.separator + "logs/";
        String fileName = "DB_BACK_UP_" + backupDateStr;

        String tables = "USERS"; //Make sure to include all the tables

        File file = new File(rootPath + fileName);

        file.createNewFile();
    }
}
