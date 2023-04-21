package be.technifutur.java.roombook.controllers;

import be.technifutur.java.roombook.dtos.BookingDTO;
import be.technifutur.java.roombook.models.enums.BookingStatus;
import be.technifutur.java.roombook.models.form.BookingCreateForm;
import be.technifutur.java.roombook.services.BookingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @GetMapping("/all")
    List<BookingDTO> getAllBooking(){
        return bookingService.getAllBooking();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    void createBooking(@RequestBody @Valid BookingCreateForm form){
        bookingService.createBooking(form);
    }

    @PatchMapping("/{id}/accept")
    void acceptBooking(@PathVariable String id){
        bookingService.updateBookingStatus(BookingStatus.ACCEPTED, UUID.fromString(id));
    }

    @PatchMapping("/{id}/refuse")
    void refuseBooking(@PathVariable String id){
        bookingService.updateBookingStatus(BookingStatus.REFUSED, UUID.fromString(id));
    }

}
