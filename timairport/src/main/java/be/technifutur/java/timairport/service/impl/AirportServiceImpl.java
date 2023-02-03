package be.technifutur.java.timairport.service.impl;

import be.technifutur.java.timairport.mapper.AirportMapper;
import be.technifutur.java.timairport.model.dto.AirportDTO;
import be.technifutur.java.timairport.repository.AirportRepository;
import be.technifutur.java.timairport.service.AirportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository   airportRepository;
    private final AirportMapper       airportMapper;

    public AirportServiceImpl(AirportRepository airportRepository, AirportMapper airportMapper) {
        this.airportRepository = airportRepository;
        this.airportMapper = airportMapper;
    }

    @Override
    public List<AirportDTO> getAll() {
        return airportRepository.findAll().stream()
                .map(airportMapper::toDto)
                .toList();
    }
}
