package be.technifutur.java.timairport.repository;

import be.technifutur.java.timairport.model.entity.Flight;
import be.technifutur.java.timairport.model.form.FlightUpdateScheduleForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {
    @Modifying
    @Transactional
    @Query("UPDATE Flight f SET f.cancelled = true WHERE f.id = :id")
    void cancelFlight(UUID id);



    @Modifying
    @Transactional
    @Query("""
            UPDATE Flight f
            SET f.departureTime = ?2, f.arrivalTime = ?3
            WHERE f.id = ?1
            """)
    void updateSchedule(UUID id, LocalDateTime departureTime, LocalDateTime arrivalTime);

}
