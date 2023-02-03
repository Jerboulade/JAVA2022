package be.technifutur.java.timairport.service;

import be.technifutur.java.timairport.model.dto.AirportDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AirportService{
    List<AirportDTO> getAll();
}
