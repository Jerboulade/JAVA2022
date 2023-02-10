package be.technifutur.java.technisandwich.service.impl;

import be.technifutur.java.technisandwich.mapper.UserInfoMapper;
import be.technifutur.java.technisandwich.model.dto.UserDTO;
import be.technifutur.java.technisandwich.repository.UserRepository;
import be.technifutur.java.technisandwich.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository    userRepository;
    private final UserInfoMapper userInfoMapper;

    public UserServiceImpl(UserRepository userRepository, UserInfoMapper userInfoMapper) {
        this.userRepository = userRepository;
        this.userInfoMapper = userInfoMapper;
    }


    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(userInfoMapper::toDTO)
                .toList();
    }


}
