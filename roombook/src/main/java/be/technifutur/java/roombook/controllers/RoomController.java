package be.technifutur.java.roombook.controllers;

import be.technifutur.java.roombook.dtos.RoomDTO;
import be.technifutur.java.roombook.services.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @GetMapping("/all")
    List<RoomDTO> getAllRoom(){
        return roomService.getAllRoom();
    }
}
