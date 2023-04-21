package be.technifutur.java.roombook.dtos;

import be.technifutur.java.roombook.models.enums.BookingStatus;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class BookingDTO {
    private UUID id;
    private LocalDateTime date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BookingStatus status = BookingStatus.PENDING;
}
