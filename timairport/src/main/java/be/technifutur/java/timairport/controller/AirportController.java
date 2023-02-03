package be.technifutur.java.timairport.controller;

import be.technifutur.java.timairport.model.dto.AirportDTO;
import be.technifutur.java.timairport.service.AirportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/all")
    List<AirportDTO> getAll(){
        return airportService.getAll();
    }
}
