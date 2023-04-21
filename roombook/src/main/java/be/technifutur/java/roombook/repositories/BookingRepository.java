package be.technifutur.java.roombook.repositories;

import be.technifutur.java.roombook.models.entity.Booking;
import be.technifutur.java.roombook.models.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public interface BookingRepository extends JpaRepository<Booking, UUID> {
    @Transactional
    @Modifying
    @Query("update Booking b set b.status = ?1 where b.id = ?2")
    void updateStatusById(BookingStatus status, UUID bookingId);

}
