package tech.itpark.itpark2021.lesson39.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.itpark.itpark2021.lesson39.model.TownDirectory;


import java.util.Optional;

public interface TownDirectoryRepository extends JpaRepository<TownDirectory, Long> {

    Optional<TownDirectory> findByCityName(String city);
}
