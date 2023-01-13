package be.technifutur.jcarere.mvc.controllers;

import be.technifutur.jcarere.mvc.models.Hotel;
import be.technifutur.jcarere.mvc.models.Room;
import be.technifutur.jcarere.mvc.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller // mon controller est un Bean (condition 1)
public class RoomController {

    // On instancie pas le controller, on va faire de l'injection de dépendance:
    // 3 conditions pour l'injection:
    // 1 - je peux injecter une dépendance pour créer un Bean.
    // 2 - il existe un Bean qui correspond au type de la dépendance souhaitée
    // 3 - la dépendance est déclarée
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService; // (condition 3)
    }

    //GET -> /room/all -> voir toutes les chambres
    @GetMapping("/room/all")
    public String allRooms(Model model){
        List<Room> rooms = roomService.getAll();

        model.addAttribute("rooms", rooms);
        return "room/all";
    }

    //GET -> /room/1 -> voir chambre numero un tel
    @GetMapping("/room/{roomNumber}")
    public String oneRoom(Model model, @PathVariable int roomNumber){
        Room room = roomService.getOne(roomNumber);
        model.addAttribute("room", room);
        model.addAttribute("hotel", room.getHotel());
        return "room/one";
    }



}
