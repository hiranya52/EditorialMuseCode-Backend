package edu.icet.repository;

import edu.icet.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<edu.icet.model.entity.User> findByUsername(String username);


}