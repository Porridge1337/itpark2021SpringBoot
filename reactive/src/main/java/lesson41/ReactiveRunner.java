package lesson41;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
@SpringBootApplication
//@EnableMongock
public class ReactiveRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveRunner.class, args);
    }

}
