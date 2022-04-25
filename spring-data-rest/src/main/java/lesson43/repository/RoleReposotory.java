package lesson43.repository;

import lesson43.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;


@RepositoryRestResource(path = "role")
public interface RoleReposotory extends JpaRepository<Role, Long> {

    List<Role> findByName(String roleName);
}
