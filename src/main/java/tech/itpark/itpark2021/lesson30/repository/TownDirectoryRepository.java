package tech.itpark.itpark2021.lesson30.repository;

import org.springframework.data.repository.CrudRepository;
import tech.itpark.itpark2021.lesson30.model.TownDirectory;

public interface TownDirectoryRepository extends CrudRepository<TownDirectory, Long> {
    TownDirectory findByCityName(String cityName);

    boolean existsByCityName(String cityName);
}
