package be.technifutur.java.timairport.repository;

import be.technifutur.java.timairport.model.entity.Pilot;
import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PilotRepository extends JpaRepository<Pilot, UUID> {
    public List<Pilot> findByFirstNameStartingWith(String start);

    @Query("SELECT p FROM Pilot WHERE p.firstName = p.lastName")
    public List<Pilot> findPilotWithSameName();

}
