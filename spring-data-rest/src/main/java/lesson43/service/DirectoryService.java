package lesson43.service;

import lesson43.dto.DirectoryPageDto;
import lesson43.model.Directory;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface DirectoryService {
    List<Directory> findAllDirectory();

    DirectoryPageDto getPage(Pageable pageable);

    Optional<Directory> getById(Long id);

    Directory save(Directory directory);

    void deleteById(Long id);

}
