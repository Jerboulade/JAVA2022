package be.technifutur.java.roombook.services;

import be.technifutur.java.roombook.dtos.BookingDTO;
import be.technifutur.java.roombook.models.enums.BookingStatus;
import be.technifutur.java.roombook.models.form.BookingCreateForm;

import java.util.List;
import java.util.UUID;

public interface BookingService {
    void createBooking(BookingCreateForm form);

    void updateBookingStatus(BookingStatus status, UUID bookingId);

    List<BookingDTO> getAllBooking();
}

