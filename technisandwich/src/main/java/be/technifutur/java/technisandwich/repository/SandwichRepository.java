package be.technifutur.java.technisandwich.repository;

import be.technifutur.java.technisandwich.model.entity.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface SandwichRepository extends JpaRepository<Sandwich, UUID> {
}
