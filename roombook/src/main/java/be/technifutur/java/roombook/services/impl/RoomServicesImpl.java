package be.technifutur.java.roombook.services.impl;

import be.technifutur.java.roombook.dtos.RoomDTO;
import be.technifutur.java.roombook.mappers.RoomMapper;
import be.technifutur.java.roombook.repositories.RoomRepository;
import be.technifutur.java.roombook.services.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServicesImpl implements RoomService {

    private final RoomRepository    roomRepository;
    private final RoomMapper        roomMapper;

    public RoomServicesImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Override
    public List<RoomDTO> getAllRoom() {

        return roomRepository.findAll().stream()
                .map(roomMapper::toDTO)
                .toList();

    }
}
