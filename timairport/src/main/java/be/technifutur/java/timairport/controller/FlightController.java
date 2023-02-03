package be.technifutur.java.timairport.controller;

import be.technifutur.java.timairport.model.dto.FlightDTO;
import be.technifutur.java.timairport.model.form.FlightInsertForm;
import be.technifutur.java.timairport.model.form.FlightUpdateScheduleForm;
import be.technifutur.java.timairport.model.form.PlaneInsertForm;
import be.technifutur.java.timairport.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/all")
    public List<FlightDTO> getAll(){
        return flightService.getAll();
    }

    @PostMapping("/add")
    public void create(@RequestBody @Valid FlightInsertForm form){
        flightService.create(form);
        System.out.printf("flight created : \n%s\n", form.toString());
    }

    @PatchMapping("/update/cancel")
    public void cancel(@RequestParam UUID id){
        flightService.cancelFlight(id);
    }

    @PatchMapping("/update/schedule")
    public void updateSchedule(@RequestBody @Valid FlightUpdateScheduleForm form){
        flightService.updateSchedule(form);
    }

}
