package tech.itpark.itpark2021.lesson35.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.itpark.itpark2021.lesson35.model.Directory;

public interface DirectoryRepository extends JpaRepository<Directory, Long> {

}
