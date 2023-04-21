package be.technifutur.java.roombook.services.impl;

import be.technifutur.java.roombook.dtos.UserDTO;
import be.technifutur.java.roombook.mappers.UserMapper;
import be.technifutur.java.roombook.repositories.UserRepository;
import be.technifutur.java.roombook.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.findAll().stream()
                .map(userMapper::toDTO)
                .toList();
    }
}
