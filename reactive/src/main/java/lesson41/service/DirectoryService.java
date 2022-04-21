package lesson41.service;

import lesson41.model.Directory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DirectoryService {

    Flux<Directory> findAll();

    Mono<Directory> findByRegionId(String regionId);

    Mono<String> save(Directory directory);

    void delete(String regionId);

}
