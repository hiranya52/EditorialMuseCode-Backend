package repository;

import model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

    // Find user by email (MOST IMPORTANT for JWT + OAuth2)
    Optional<User> findByEmail(String email);

    // Check if user exists (useful for registration)
    boolean existsByEmail(String email);

}
