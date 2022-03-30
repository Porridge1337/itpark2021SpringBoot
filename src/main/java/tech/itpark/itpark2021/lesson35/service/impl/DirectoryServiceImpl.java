package tech.itpark.itpark2021.lesson35.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.itpark.itpark2021.lesson35.dto.DirectoryDto;
import tech.itpark.itpark2021.lesson35.dto.DirectoryPageDto;
import tech.itpark.itpark2021.lesson35.mapper.DirectoryMapper;
import tech.itpark.itpark2021.lesson35.model.Directory;
import tech.itpark.itpark2021.lesson35.repository.DirectoryRepository;
import tech.itpark.itpark2021.lesson35.service.DirectoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DirectoryServiceImpl implements DirectoryService {

    private final DirectoryRepository repository;
    private final DirectoryMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public List<DirectoryDto> findAllDirectory() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public DirectoryPageDto getPage(Pageable pageable) {
        Page<Directory> currentPage = repository.findAll(pageable);
        return new DirectoryPageDto(mapper.toDtos(currentPage.getContent()),
                currentPage.getNumber(),
                currentPage.getTotalPages(),
                currentPage.hasNext(),
                currentPage.hasPrevious());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DirectoryDto> getById(Long id) {
        return mapper.toOptionalDto(repository.findById(id));
    }

    @Override
    @Transactional
    public DirectoryDto save(@Valid DirectoryDto directory) {
        return mapper.toDto(repository.save(mapper.toEntity(directory)));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
