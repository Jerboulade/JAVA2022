package be.technifutur.java.timairport.repository;

import be.technifutur.java.timairport.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    /*
    @Query("""
            SELECT user
            FROM User user
            WHERE user.username = :username
            """)
    */
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
