package lesson43.repository;

import lesson43.model.Directory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "directory")
public interface DirectoryRepository extends JpaRepository<Directory, Long> {

}
