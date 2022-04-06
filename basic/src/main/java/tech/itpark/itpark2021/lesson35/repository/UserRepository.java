package tech.itpark.itpark2021.lesson35.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.itpark.itpark2021.lesson35.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join fetch u.role where u.login = :login")
    Optional<User> findByLogin(String login);

}
