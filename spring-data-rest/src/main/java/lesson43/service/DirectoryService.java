package lesson43.service;

import lesson43.model.Directory;

import java.util.List;
import java.util.Optional;

public interface DirectoryService {
    List<Directory> findAllDirectory();

    Optional<Directory> getById(Long id);

    Directory save(Directory directory);

    void deleteById(Long id);

}
