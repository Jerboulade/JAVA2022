package be.technifutur.java.timairport.controller;

import be.technifutur.java.timairport.model.dto.PlaneDTO;
import be.technifutur.java.timairport.model.form.PlaneInsertForm;
import be.technifutur.java.timairport.service.PlaneService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/plane")
public class PlaneController {

    private final PlaneService planeService;

    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @PostMapping("/add")
    public void create(@RequestBody @Valid PlaneInsertForm form){
        planeService.create(form);
    }

    @GetMapping("/{id}")
    public PlaneDTO getOne(@PathVariable UUID id){
        return planeService.getOne(id);
    }
}