package be.technifutur.java.technisandwich.controller;

import be.technifutur.java.technisandwich.model.dto.SandwichDTO;
import be.technifutur.java.technisandwich.model.entity.Sandwich;
import be.technifutur.java.technisandwich.model.form.insert.SandwichInsertForm;
import be.technifutur.java.technisandwich.model.form.update.SandwichUpdateForm;
import be.technifutur.java.technisandwich.service.SandwichService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sandwich")
public class SandwichController {

    private final SandwichService sandwichService;

    public SandwichController(SandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }

    @GetMapping("/all")
    public List<SandwichDTO>    getAll(){
        return sandwichService.getAll();
    }

    @GetMapping("/one")
    public SandwichDTO          getOneByName(@RequestParam String name){
        return sandwichService.getOneByName(name);
    }

    @GetMapping("/one/{id}")
    public SandwichDTO          getOneById(@PathVariable Long id){
        return sandwichService.getOneById(id);
    }

    @PostMapping("/add")
    public Long                 createSandwich(@RequestBody @Valid SandwichInsertForm form) {
        return sandwichService.createSandwich(form);
    }

    @PatchMapping("/update/{id}")
    public void                 updateSandwich(@RequestBody @Valid SandwichUpdateForm form,
                                               @PathVariable Long id){
        sandwichService.updateSandwich(id, form);
    }

    @DeleteMapping("/delete")
    public void                 deleteSandwich(@RequestBody String name){
        sandwichService.deleteSandwich(name);
    }

}
