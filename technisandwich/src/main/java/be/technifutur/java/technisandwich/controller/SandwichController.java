package be.technifutur.java.technisandwich.controller;

import be.technifutur.java.technisandwich.model.dto.SandwichDTO;
import be.technifutur.java.technisandwich.service.SandwichService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sandwich")
public class SandwichController {

    private final SandwichService sandwichService;

    public SandwichController(SandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }

    @GetMapping("/all")
    public List<SandwichDTO> getAll(){
        return sandwichService.getAll();
    }

}
