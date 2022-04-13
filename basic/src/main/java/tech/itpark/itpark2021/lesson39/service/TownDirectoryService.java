package tech.itpark.itpark2021.lesson39.service;

import tech.itpark.itpark2021.lesson39.dto.TownDirectoryDto;

import java.util.List;
import java.util.Optional;

public interface TownDirectoryService {

    Optional<TownDirectoryDto> findByCityName(String name);

    List<TownDirectoryDto> findAllTowns();

}
