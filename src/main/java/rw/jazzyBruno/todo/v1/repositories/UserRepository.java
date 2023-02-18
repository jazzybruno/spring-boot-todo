package rw.jazzyBruno.todo.v1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.jazzyBruno.todo.v1.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
}
