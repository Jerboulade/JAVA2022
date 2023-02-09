package be.technifutur.java.technisandwich.service.impl;

import be.technifutur.java.technisandwich.mapper.UserMapper;
import be.technifutur.java.technisandwich.model.dto.UserDTO;
import be.technifutur.java.technisandwich.model.entity.User;
import be.technifutur.java.technisandwich.repository.UserRepository;
import be.technifutur.java.technisandwich.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository    userRepository;
    private final UserMapper        userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .toList();
    }
}
