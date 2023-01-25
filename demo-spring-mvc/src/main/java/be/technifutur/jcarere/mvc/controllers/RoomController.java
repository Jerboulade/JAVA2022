package be.technifutur.jcarere.mvc.controllers;

import be.technifutur.jcarere.mvc.models.Room;
import be.technifutur.jcarere.mvc.models.form.RoomForm;
import be.technifutur.jcarere.mvc.services.HotelService;
import be.technifutur.jcarere.mvc.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@Controller // mon controller est un Bean (condition 1)
@RequestMapping("/room")//sous-tend GetMapping
public class RoomController {

    // On instancie pas le controller, on va faire de l'injection de dépendance:
    // 3 conditions pour l'injection:
    // 1 - je peux injecter une dépendance pour créer un Bean.
    // 2 - il existe un Bean qui correspond au type de la dépendance souhaitée
    // 3 - la dépendance est déclarée
    private final RoomService roomService;
    private final HotelService hotelService;


    public RoomController(RoomService roomService, HotelService hotelService) {
        this.roomService = roomService; // (condition 3)
        this.hotelService = hotelService;
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
        Stream stream;

        model.addAttribute("room", new RoomForm());
        //model.addAttribute("hotels", hotelService.getAll().stream().map(Hotel::getName).toList());
        model.addAttribute("hotels", hotelService.getAll());
        return "room/create";
    }

    @PostMapping("/add")
    public String processInsert(RoomForm form){
        roomService.insert(form);
        return "redirect:all";
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model,@PathVariable String id){
        Room toUpdate = roomService.getOneById(id);
        RoomForm form = new RoomForm();
        form.setRoomSize(toUpdate.getRoomSize());
        form.setRoomNumber(toUpdate.getRoomNumber());
        form.setNbSimpleBed(toUpdate.getNbSimpleBed());
        form.setNbDoubleBed(toUpdate.getNbDoubleBed());
        model.addAttribute("form",form);
        model.addAttribute("room_id", toUpdate.getId());
        return "room/update";
    }

    @PostMapping("/update/{id}")
    public String processUpdate(RoomForm form, @PathVariable String id){
        roomService.update(id, form);
        return "redirect:/room/all";
    }

}
