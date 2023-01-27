package be.technifutur.java.timairport.repository;

import be.technifutur.java.timairport.model.entity.TypePlane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TypePlaneRepository extends JpaRepository<TypePlane, UUID> {
}
