package lesson41.repository;

import lesson41.model.Directory;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DirectoryRepository extends ReactiveMongoRepository<Directory, String> {
}
