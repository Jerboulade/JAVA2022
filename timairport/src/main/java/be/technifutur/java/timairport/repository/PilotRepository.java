package be.technifutur.java.timairport.repository;

import be.technifutur.java.timairport.model.entity.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface PilotRepository extends JpaRepository<Pilot, UUID> {
    List<Pilot> findByFirstNameStartingWith(String start);

    @Query("SELECT p FROM Pilot p WHERE p.firstName = p.lastName")
    List<Pilot> findPilotWithSameName();

}
