package be.technifutur.java.timairport.service;

import be.technifutur.java.timairport.model.dto.CompanyDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> getAll();
}
