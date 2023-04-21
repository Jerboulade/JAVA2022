package be.technifutur.java.roombook.services.impl;

import be.technifutur.java.roombook.dtos.BookingDTO;
import be.technifutur.java.roombook.mappers.BookingMapper;
import be.technifutur.java.roombook.models.enums.BookingStatus;
import be.technifutur.java.roombook.models.form.BookingCreateForm;
import be.technifutur.java.roombook.repositories.BookingRepository;
import be.technifutur.java.roombook.services.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper     bookingMapper;

    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    private boolean bookingIsValid(BookingCreateForm form) {
        // to do ???
        return true;
    }
    @Override
    public void createBooking(BookingCreateForm form) {
        if (!bookingIsValid(form))
            return ;
        bookingRepository.save(bookingMapper.bookingFormToEntity(form));
    }
    @Override
    public void updateBookingStatus(BookingStatus status, UUID bookingId) {
        if (bookingRepository.findById(bookingId).orElseThrow().getStatus().equals(BookingStatus.PENDING))
            bookingRepository.updateStatusById(status, bookingId);

    }

    @Override
    public List<BookingDTO> getAllBooking() {
        return bookingRepository.findAll().stream()
                .map(bookingMapper::toDTO)
                .toList();
    }

}
