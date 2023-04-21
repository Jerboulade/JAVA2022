package be.technifutur.java.roombook.repositories;

import be.technifutur.java.roombook.models.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MaterialRepository extends JpaRepository<Material, UUID> {
}
