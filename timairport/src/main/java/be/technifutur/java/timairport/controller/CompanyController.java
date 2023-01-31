package be.technifutur.java.timairport.controller;

import be.technifutur.java.timairport.model.dto.CompanyDTO;
import be.technifutur.java.timairport.service.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/all")
    List<CompanyDTO> getAll(){
        return companyService.getAll();
    }
}
