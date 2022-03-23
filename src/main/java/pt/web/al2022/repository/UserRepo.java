package pt.web.al2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pt.web.al2022.model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
