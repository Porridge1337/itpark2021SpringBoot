package lesson41.service;

import lesson41.dto.DirectoryDto;
import lesson41.model.Directory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface DirectoryService {

    Flux<Directory> findAll();

    Mono<Directory> findByRegionId(String regionId);

    void save(Directory directory);

    void delete(String regionId);

}
