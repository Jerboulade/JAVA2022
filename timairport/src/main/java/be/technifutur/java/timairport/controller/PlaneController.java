package be.technifutur.java.timairport.controller;

import be.technifutur.java.timairport.model.dto.PlaneDTO;
import be.technifutur.java.timairport.model.form.PlaneInsertForm;
import be.technifutur.java.timairport.service.PlaneService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        System.out.println(form.getCallSign());
        System.out.println(form.getRegistrationDate());
        System.out.println(form.getCompanyId());
        System.out.println(form.getTypeId());
        planeService.create(form);
    }

    @GetMapping("/{id}")
    public PlaneDTO getOne(@PathVariable UUID id){
        return planeService.getOne(id);
    }

    @GetMapping("/all")
    public List<PlaneDTO> getAll(){
        System.out.println(planeService.getALL().stream().findAny().orElseThrow().getRegistrationDate());
        return planeService.getALL();
    }

    @PatchMapping("/update/maintenance")
    public void updateMaintenance(@RequestParam UUID id, @RequestParam boolean maintenance){
        planeService.updateMaintenance(id, maintenance);
    }

    @PatchMapping("/update/company")
    public void updateCompany(@RequestParam UUID idPlane, @RequestParam UUID idCompany){
        planeService.updateCompany(idPlane, idCompany);
    }

    @PatchMapping("/update/both")
    public void updateBoth(@RequestParam UUID idPlane, @RequestParam Map<String, String> params){
        Map<String,Object> mapValues = new HashMap<>();
        if (params.containsKey("companyId"))
            mapValues.put("companyId", UUID.fromString(params.get("companyId")));
        if (params.containsKey("inMaintenance"))
            mapValues.put("inMaintenance", Boolean.parseBoolean(params.get("inMaintenance")));
        planeService.updateBoth(idPlane, mapValues);
    }
}
