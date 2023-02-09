package be.technifutur.java.technisandwich.repository;

import be.technifutur.java.technisandwich.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
