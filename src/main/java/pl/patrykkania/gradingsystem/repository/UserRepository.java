package pl.patrykkania.gradingsystem.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.patrykkania.gradingsystem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}