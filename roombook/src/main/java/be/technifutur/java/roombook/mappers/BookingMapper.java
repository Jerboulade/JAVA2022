package be.technifutur.java.roombook.mappers;

import be.technifutur.java.roombook.dtos.BookingDTO;
import be.technifutur.java.roombook.dtos.RoomDTO;
import be.technifutur.java.roombook.models.entity.Booking;
import be.technifutur.java.roombook.models.entity.Room;
import be.technifutur.java.roombook.models.form.BookingCreateForm;
import be.technifutur.java.roombook.repositories.RoomRepository;
import be.technifutur.java.roombook.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class BookingMapper {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public BookingMapper(UserRepository userRepository, RoomRepository roomRepository) {
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }


    public Booking bookingFormToEntity(BookingCreateForm form){
        Booking booking = new Booking();
        booking.setDate(form.getDate());
        booking.setStartTime(form.getStart());
        booking.setEndTime(form.getEnd());
        booking.setUser(userRepository.findById(form.getUserId()).orElseThrow()); // add UserNotFindException
        booking.setRoom(roomRepository.findByNumber(form.getRoomNumber()).orElseThrow()); // add RoomNotFoundException
        return booking;
    }

    public BookingDTO toDTO(Booking entity){
        return BookingDTO.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .endTime(entity.getEndTime())
                .startTime(entity.getStartTime())
                .status(entity.getStatus())
                .build();
    }

}
