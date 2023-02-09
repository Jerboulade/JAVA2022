package be.technifutur.java.technisandwich.service;

import be.technifutur.java.technisandwich.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
}
