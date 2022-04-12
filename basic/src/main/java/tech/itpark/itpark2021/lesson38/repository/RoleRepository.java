package tech.itpark.itpark2021.lesson38.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.itpark.itpark2021.lesson38.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String roleName);
}
