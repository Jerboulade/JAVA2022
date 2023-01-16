package be.technifutur.jcarere.mvc.controllers;

import be.technifutur.jcarere.mvc.models.Hotel;
import be.technifutur.jcarere.mvc.models.Room;
import be.technifutur.jcarere.mvc.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller // mon controller est un Bean (condition 1)
@RequestMapping("/room")//sous-tend GetMapping
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
    @GetMapping("/all")
    public String allRooms(Model model){
        List<Room> rooms = roomService.getAll();

        model.addAttribute("rooms", rooms);
        return "room/all";
    }

    //GET -> /room/1 -> voir chambre numero un tel
    @GetMapping("/{id}")
    public String oneRoom(Model model, @PathVariable String id){
        Room room = roomService.getOneById(id);
        model.addAttribute("room", room);
        return "room/one";
    }

    @GetMapping("/add")
    public String insertForm(Model model){

        model.addAttribute("room", new Room());

        return "room/create";
    }

    @PostMapping("/add")
    public String processInsert(Room form){
        roomService.insert(form);
        return "redirect:all";
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model,@PathVariable String id){
        Room toUpdate = roomService.getOneById(id);
        model.addAttribute("room", toUpdate);
        return "room/udate";
    }

    @PostMapping("/update/{id}")
    public String processUpdate(Room room, @PathVariable String id){
        roomService.update(id, room);
        return "redirect:/room/all";
    }
}
