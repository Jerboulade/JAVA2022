package be.technifutur.java.roombook.models.form;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BookingCreateForm {

    private UUID userId;
    private Integer roomNumber;
    private LocalDateTime date;
    private LocalDateTime start;
    private LocalDateTime end;
}
