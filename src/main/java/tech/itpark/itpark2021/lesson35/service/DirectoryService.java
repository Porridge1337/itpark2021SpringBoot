package tech.itpark.itpark2021.lesson35.service;

import org.springframework.data.domain.Pageable;
import tech.itpark.itpark2021.lesson35.dto.DirectoryDto;
import tech.itpark.itpark2021.lesson35.dto.DirectoryPageDto;

import java.util.List;
import java.util.Optional;

public interface DirectoryService {
    List<DirectoryDto> findAllDirectory();

    DirectoryPageDto getPage(Pageable pageable);

    Optional<DirectoryDto> getById(Long id);

    DirectoryDto save(DirectoryDto directory);

    void deleteById(Long id);

}
