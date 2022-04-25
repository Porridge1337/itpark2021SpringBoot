package lesson43.repository;

import lesson43.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.Optional;


@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join fetch u.role where u.login = :login")
    Optional<User> findByLogin(String login);

}
