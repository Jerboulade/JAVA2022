package be.technifutur.java.roombook.repositories;

import be.technifutur.java.roombook.models.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {
    Optional<Room> findByNumber(Integer roomNumber);
}
