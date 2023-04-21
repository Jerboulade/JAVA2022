package be.technifutur.java.roombook.services;

import be.technifutur.java.roombook.dtos.BookingDTO;
import be.technifutur.java.roombook.dtos.UserDTO;
import be.technifutur.java.roombook.models.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDTO> getAllUser();
}
