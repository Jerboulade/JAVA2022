package be.technifutur.java.timairport.service;

import be.technifutur.java.timairport.model.entity.Flight;
import be.technifutur.java.timairport.model.entity.TypePlane;
import be.technifutur.java.timairport.model.form.FlightInsertForm;
import be.technifutur.java.timairport.repository.AirportRepository;
import be.technifutur.java.timairport.repository.CompanyRepository;
import be.technifutur.java.timairport.repository.TypePlaneRepository;

import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class FlightServiceImpl implements FlightService{

    private final TypePlaneRepository typePlaneRepository;
    private final CompanyRepository companyRepository;
    private final AirportRepository airportRepository;

    public FlightServiceImpl(TypePlaneRepository typePlaneRepository, CompanyRepository companyRepository, AirportRepository airportRepository) {
        this.typePlaneRepository = typePlaneRepository;
        this.companyRepository = companyRepository;
        this.airportRepository = airportRepository;
    }

    @Override
    public void create(FlightInsertForm form) {
        Flight flight = form.toEntity();


    }

    private boolean checkFormValidity(FlightInsertForm form){
        List<TypePlane> = airportRepository.findById()
        return (DAYS.between(form.getDepartureTime(), form.getArrivalTime()) < 2) &&
                (form.getAirport_departure() != form.getAirport_destination()) &&
                (form.getCaptain() != form.getFirstOfficer()) &&
                (typePlaneRepository.findById(form.getPlane().getType()) == companyRepository.findById(form.getPlane().getWanted_company()).)

    }
}
