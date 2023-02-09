package be.technifutur.java.technisandwich.controller;

import be.technifutur.java.technisandwich.model.dto.UserDTO;
import be.technifutur.java.technisandwich.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserDTO> getAll(){
        return userService.getAll();
    }
}
