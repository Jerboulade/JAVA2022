package be.technifutur.jcarere.mvc.controllers;

import be.technifutur.jcarere.mvc.models.Hotel;
import be.technifutur.jcarere.mvc.services.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
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
        return "hotel/one";
    }
}
