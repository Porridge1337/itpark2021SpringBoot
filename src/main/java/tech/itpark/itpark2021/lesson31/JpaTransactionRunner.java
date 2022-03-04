package tech.itpark.itpark2021.lesson31;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import tech.itpark.itpark2021.lesson31.service.TownDirectoryDao;


@SpringBootApplication
public class JpaTransactionRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(JpaTransactionRunner.class, args);
        TownDirectoryDao jpa = run.getBean(TownDirectoryDao.class);
        jpa.updateCityName("Karagand", 3);
        jpa.updatePopulation(501095, 3);
        jpa.updateCityCode(7212, 3);

    }
}
