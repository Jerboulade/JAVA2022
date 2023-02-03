package be.technifutur.java.timairport.utils;

import be.technifutur.java.timairport.model.entity.*;
import be.technifutur.java.timairport.repository.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Component
public class DataInit implements InitializingBean {

    private final PilotRepository pilotRepository;
    private final CompanyRepository companyRepository;
    private final TypePlaneRepository typePlaneRepository;
    private final PlaneRepository planeRepository;

    private final AirportRepository airportRepository;
    private final FlightRepository flightRepository;

    public DataInit(PilotRepository pilotRepository, CompanyRepository companyRepository, TypePlaneRepository typePlaneRepository, PlaneRepository planeRepository, AirportRepository airportRepository, FlightRepository flightRepository) {
        this.pilotRepository = pilotRepository;
        this.companyRepository = companyRepository;
        this.typePlaneRepository = typePlaneRepository;
        this.planeRepository = planeRepository;
        this.airportRepository = airportRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        TypePlane type = new TypePlane();
        type.setName("big_plane");
        type.setCapacity(300);

        typePlaneRepository.save( type );

        TypePlane AverageType = new TypePlane();
        AverageType.setName("average_plane");
        AverageType.setCapacity(200);

        typePlaneRepository.save( AverageType );

        TypePlane smallType = new TypePlane();
        smallType.setName("small_plane");
        smallType.setCapacity(100);

        typePlaneRepository.save( smallType );


        Company company = new Company();
        company.setName("VirginUS");
        company.setOriginCountry("USA");

        companyRepository.save( company );

        company = new Company();
        company.setName("Sabena");
        company.setOriginCountry("Belgium");

        companyRepository.save( company );

        Pilot pilot = new Pilot();
        pilot.setFirstName("jerome");
        pilot.setLastName("carere");
        pilot.setAddress("blablanowhere");
        pilot.setEmail("tamere");
        pilot.setCompany(company);
        pilot.setPhone("666");
        pilot.setLicenseAcquisition(LocalDate.of(2019,01,01));
        pilot.setLicenseId("thisId");
        pilotRepository.save(pilot);

        Pilot pilot2 = new Pilot();
        pilot2.setFirstName("timé");
        pilot2.setLastName("pregardien");
        pilot2.setAddress("blablanowhere");
        pilot2.setEmail("tamereausii");
        pilot2.setCompany(company);
        pilot2.setPhone("6969");
        pilot2.setLicenseAcquisition(LocalDate.of(2019,01,01));
        pilot2.setLicenseId("Master");
        pilotRepository.save(pilot2);

        Plane plane = new Plane();
        plane.setRegistrationDate(LocalDate.now());
        plane.setCompany(company);
        plane.setCallSign("MEGA PLANE");
        plane.setInMaintenance(false);
        plane.setType(type);
        planeRepository.save(plane);

        Airport airport = new Airport();
        airport.setName("Charleroi Airport");
        airport.setCountry("Belgium");
        airport.setCity("Charleroi");
        airport.setAddress("Rue de la Biscotte");
        airport.setPlaneParking(20);
        List<TypePlane> listtype1 = new LinkedList<>();
        listtype1.add(type);
        listtype1.add(AverageType);
        airport.setPlaneTypesAllowed(listtype1);
        airportRepository.save(airport);


        Airport airport2 = new Airport();
        airport2.setName("Bruxelle Airport");
        airport2.setCountry("Belgium");
        airport2.setCity("Bruxelle");
        airport2.setAddress("Rue de Quelquepart");
        airport2.setPlaneParking(20);
        List<TypePlane> listtype2 = new LinkedList<>();
        listtype2.add(smallType);
        listtype2.add(AverageType);
        airport2.setPlaneTypesAllowed(listtype2);
        airportRepository.save(airport2);

        Flight flight = new Flight();
        flight.setDepartureTime(LocalDateTime.parse("2023-07-13T12:48:21"));
        flight.setArrivalTime(LocalDateTime.parse("2023-07-14T18:49:27"));
        flight.setDeparture(airport);
        flight.setDestination(airport2);
        flight.setCaptain(pilot);
        flight.setFirstOfficer(pilot2);
        flight.setPlane(plane);
        flightRepository.save(flight);

        /*
                "departureTime": "2023-07-13T12:48:21",
                "arrivalTime": "2023-07-14T18:49:27",
                "airportDeparture": "86c00760-0d4f-4d0f-9862-734b6c2a16f5",
                "airportDestination": "b20adaca-ecda-4259-a98c-f4d45ee2d549",
                "captain": "2cf9d7a2-4ada-457f-add4-2a3d1bf289a6",
                "firstOfficer": "592bcfec-93c1-4d9a-a8ee-ed85a5a4a9d8",
         */


    }
}
