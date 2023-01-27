package be.technifutur.java.timairport.utils;

import be.technifutur.java.timairport.model.entity.Company;
import be.technifutur.java.timairport.model.entity.Pilot;
import be.technifutur.java.timairport.model.entity.TypePlane;
import be.technifutur.java.timairport.repository.CompanyRepository;
import be.technifutur.java.timairport.repository.PilotRepository;
import be.technifutur.java.timairport.repository.TypePlaneRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInit implements InitializingBean {

    private final PilotRepository pilotRepository;
    private final CompanyRepository companyRepository;
    private final TypePlaneRepository typePlaneRepository;

    public DataInit(PilotRepository pilotRepository, CompanyRepository companyRepository, TypePlaneRepository typePlaneRepository) {
        this.pilotRepository = pilotRepository;
        this.companyRepository = companyRepository;
        this.typePlaneRepository = typePlaneRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        TypePlane type = new TypePlane();
        type.setName("big_plane");
        type.setCapacity(300);

        typePlaneRepository.save( type );

        type = new TypePlane();
        type.setName("average_plane");
        type.setCapacity(200);

        typePlaneRepository.save( type );

        type = new TypePlane();
        type.setName("small_plane");
        type.setCapacity(100);

        typePlaneRepository.save( type );


        Company company = new Company();
        company.setName("big money company");
        company.setOriginCountry("USA");

        companyRepository.save( company );

        company = new Company();
        company.setName("Deedlamerd");
        company.setOriginCountry("Belgium");

        companyRepository.save( company );

        Pilot pilot = new Pilot();
        pilot.setFirstName("jer");
        pilot.setLastName("car");
        pilot.setAddress("blablanowhere");
        pilot.setEmail("tamere");
        pilot.setCompany(company);
        pilot.setPhone("1");
        pilot.setLicenseAcquisition(LocalDate.now());
        pilot.setLicenseId("thisId");
        pilotRepository.save(pilot);
    }
}
