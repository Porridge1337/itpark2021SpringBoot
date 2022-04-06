package tech.itpark.itpark2021.lesson35.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.itpark.itpark2021.lesson35.model.Role;

import java.util.List;

public interface RoleReposotory extends JpaRepository<Role, Long> {

    List<Role> findByName(String roleName);
}
