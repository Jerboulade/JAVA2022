package be.technifutur.java.roombook.controllers;


import be.technifutur.java.roombook.dtos.BookingDTO;
import be.technifutur.java.roombook.dtos.UserDTO;
import be.technifutur.java.roombook.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    List<UserDTO> getAllUser(){
        return userService.getAllUser();
    }
}
