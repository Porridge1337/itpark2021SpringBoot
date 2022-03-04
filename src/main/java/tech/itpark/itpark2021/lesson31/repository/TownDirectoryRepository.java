package tech.itpark.itpark2021.lesson31.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tech.itpark.itpark2021.lesson31.model.TownDirectory;

public interface TownDirectoryRepository extends CrudRepository<TownDirectory, Long> {
    TownDirectory findByCityName(String cityName);

    boolean existsByCityName(String cityName);

    @Modifying
    @Query("update TownDirectory r set r.cityName = :name " +
            "where r.id = :id")
    void updateCityName(String name, long id);

    @Modifying
    @Query("update TownDirectory r set r.cityCode = :code " +
            "where r.id = :id")
    void updateCityCode(int code, long id);

    @Modifying
    @Query("update TownDirectory r set r.population = :population " +
            "where r.id = :id")
    void updatePopulation(long population, long id);
}
