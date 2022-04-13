package tech.itpark.itpark2021.lesson39.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.itpark.itpark2021.lesson39.dto.TownDirectoryDto;
import tech.itpark.itpark2021.lesson39.mapper.TownDirectoryMapper;
import tech.itpark.itpark2021.lesson39.repository.TownDirectoryRepository;
import tech.itpark.itpark2021.lesson39.service.TownDirectoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TownDirectoryServiceImpl implements TownDirectoryService {

    private final TownDirectoryRepository repository;
    private final TownDirectoryMapper mapper;

    @Override
    public Optional<TownDirectoryDto> findByCityName(String name) {
        return mapper.toOptionalDto(repository.findByCityName(name));
    }

    @Override
    public List<TownDirectoryDto> findAllTowns() {
        return mapper.toDtos(repository.findAll());
    }
}
