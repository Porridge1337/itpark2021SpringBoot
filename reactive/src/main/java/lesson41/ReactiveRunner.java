package lesson41;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

//@EnableMongock
@EnableReactiveMongoRepositories
@SpringBootApplication
public class ReactiveRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ReactiveRunner.class, args);
    }

}
