package be.technifutur.java.timairport.service.impl;

import be.technifutur.java.timairport.mapper.CompanyMapper;
import be.technifutur.java.timairport.model.dto.CompanyDTO;
import be.technifutur.java.timairport.repository.CompanyRepository;
import be.technifutur.java.timairport.repository.PilotRepository;
import be.technifutur.java.timairport.repository.PlaneRepository;
import be.technifutur.java.timairport.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final PlaneRepository   planeRepository;
    private final PilotRepository   pilotRepository;
    private final CompanyMapper     companyMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, PlaneRepository planeRepository, PilotRepository pilotRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.planeRepository = planeRepository;
        this.pilotRepository = pilotRepository;
        this.companyMapper = companyMapper;
    }

    @Override
    public List<CompanyDTO> getAll() {
        return companyRepository.findAll().stream()
                .map(companyMapper::toDto)
                .toList();
    }
}
