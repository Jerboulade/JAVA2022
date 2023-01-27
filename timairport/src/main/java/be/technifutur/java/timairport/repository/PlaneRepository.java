package be.technifutur.java.timairport.repository;

import be.technifutur.java.timairport.model.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlaneRepository extends JpaRepository<Plane, UUID> {
}
