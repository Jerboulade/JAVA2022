package be.technifutur.java.timairport.service;

import be.technifutur.java.timairport.exception.RessourceNotFoundException;
import be.technifutur.java.timairport.mapper.PlaneMapper;
import be.technifutur.java.timairport.model.dto.PlaneDTO;
import be.technifutur.java.timairport.model.entity.Company;
import be.technifutur.java.timairport.model.entity.Plane;
import be.technifutur.java.timairport.model.entity.TypePlane;
import be.technifutur.java.timairport.model.form.PlaneInsertForm;
import be.technifutur.java.timairport.repository.CompanyRepository;
import be.technifutur.java.timairport.repository.PlaneRepository;
import be.technifutur.java.timairport.repository.TypePlaneRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlaneServiceImpl implements PlaneService{

    private final PlaneRepository planeRepository;
    private final CompanyRepository companyRepository;
    private final TypePlaneRepository typePlaneRepository;
    private final PlaneMapper planeMapper;

    public PlaneServiceImpl(PlaneRepository planeRepository, CompanyRepository companyRepository, TypePlaneRepository typePlaneRepository, PlaneMapper planeMapper) {
        this.planeRepository = planeRepository;
        this.companyRepository = companyRepository;
        this.typePlaneRepository = typePlaneRepository;
        this.planeMapper = planeMapper;
    }

    @Override
    public void create(PlaneInsertForm form){
        Plane plane = form.toEntity();

        Company company = companyRepository.findById(form.getCompanyId())
                .orElseThrow(RessourceNotFoundException::new);
        TypePlane typePlane = typePlaneRepository.findById(form.getTypeId())
                .orElseThrow(RessourceNotFoundException::new);
        plane.setCompany(company);
        plane.setType(typePlane);

        planeRepository.save(plane);
    }

    @Override
    public PlaneDTO getOne(UUID id) {
        return planeRepository.findById(id)
                .map(planeMapper::toDto)
                .orElseThrow(RessourceNotFoundException::new);
    }

    @Override
    public List<PlaneDTO> getALL() {



        return planeRepository.findAll()
                .stream()
                .map(planeMapper::toDto)
                .toList();


    }


}
