package be.technifutur.jcarere.mvc.controllers;

import be.technifutur.jcarere.mvc.models.Hotel;
import be.technifutur.jcarere.mvc.services.HotelService;
import be.technifutur.jcarere.mvc.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HotelController {

    private final HotelService hotelService;
    private final RoomService roomService;

    public HotelController(HotelService hotelService, RoomService roomService) {
        this.hotelService = hotelService;
        this.roomService = roomService;
    }

    @GetMapping("/hotel/all")
    public String allHotel(Model model){
        List<Hotel> list = hotelService.getAll();
        model.addAttribute("hotels", list);
        return "hotel/all";
    }

    @GetMapping("hotel/{name}")
    public String oneHotel(Model model, @PathVariable String name){
        model.addAttribute("hotel", hotelService.getHotelByName(name));
        model.addAttribute("rooms", roomService.getRoomsByHotelName(name));
        return "hotel/one";
    }
}
