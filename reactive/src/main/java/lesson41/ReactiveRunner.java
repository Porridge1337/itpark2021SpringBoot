package lesson41;

import lesson41.model.Directory;
import lesson41.service.DirectoryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class ReactiveRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ReactiveRunner.class, args);
        DirectoryService service = run.getBean(DirectoryService.class);
        service.save(new Directory("01", "Республика адыгея"));
    }

}
