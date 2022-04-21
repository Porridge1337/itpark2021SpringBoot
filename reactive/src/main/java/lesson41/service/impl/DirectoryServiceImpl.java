package lesson41.service.impl;

import lesson41.model.Directory;
import lesson41.repository.DirectoryRepository;
import lesson41.service.DirectoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DirectoryServiceImpl implements DirectoryService {

    private final DirectoryRepository repository;

    @Override
    @Transactional(readOnly = true)
    public Flux<Directory> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<Directory> findByRegionId(String regionId) {
        return repository.findById(regionId);
    }

    @Override
    @Transactional
    public Mono<String> save(Directory directory) {
        return repository.save(directory).map(dir -> "redirect:/directory");
    }

    @Override
    @Transactional
    public void delete(String regionId) {
        repository.deleteById(regionId);
    }
}
