package be.technifutur.java.timairport.service;

import be.technifutur.java.timairport.exception.NoPlaneAvailableException;
import be.technifutur.java.timairport.exception.RessourceNotFoundException;
import be.technifutur.java.timairport.model.entity.Flight;
import be.technifutur.java.timairport.model.entity.Plane;
import be.technifutur.java.timairport.model.entity.TypePlane;
import be.technifutur.java.timairport.model.form.FlightInsertForm;
import be.technifutur.java.timairport.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class FlightServiceImpl implements FlightService{

    private final FlightRepository      flightRepository;
    private final TypePlaneRepository   typePlaneRepository;
    private final CompanyRepository     companyRepository;
    private final AirportRepository     airportRepository;
    private final PlaneRepository       planeRepository;
    private final PilotRepository       pilotRepository;

    public FlightServiceImpl(FlightRepository flightRepository, TypePlaneRepository typePlaneRepository, CompanyRepository companyRepository, AirportRepository airportRepository, PlaneRepository planeRepository, PilotRepository pilotRepository) {
        this.flightRepository = flightRepository;
        this.typePlaneRepository = typePlaneRepository;
        this.companyRepository = companyRepository;
        this.airportRepository = airportRepository;
        this.planeRepository = planeRepository;
        this.pilotRepository = pilotRepository;
    }

    @Override
    public void create(FlightInsertForm form) {
        if (!isValidFlightForm(form))
            return ;
        Plane plane = planeRepository.findAll().stream()
                .filter(p ->
                    p.getType().getId() == form.getWantedPlaneType() &&
                    p.getCompany().getId() == form.getWantedCompany()
                )
                .findFirst()
                .orElseThrow(NoPlaneAvailableException::new);
        Flight flight = form.toEntity();
        flight.setDeparture(airportRepository.findById(form.getAirportDeparture())
                .orElseThrow(RessourceNotFoundException::new));
        flight.setDestination(airportRepository.findById(form.getAirportDestination())
                .orElseThrow(RessourceNotFoundException::new));
        flight.setPlane(plane);
        flight.setCaptain(pilotRepository.findById(form.getCaptain())
                .orElseThrow(RessourceNotFoundException::new));
        flight.setFirstOfficer(pilotRepository.findById(form.getFirstOfficer())
                .orElseThrow(RessourceNotFoundException::new));
        flightRepository.save(flight);
    }

    private boolean isValidFlightForm(FlightInsertForm form){
        List<TypePlane> planeTypesAllowed = airportRepository.findById(form.getId())
                                            .orElseThrow()
                                            .getPlaneTypesAllowed();
        return  ( DAYS.between( form.getDepartureTime(), form.getArrivalTime() ) < 2) &&
                ( form.getAirportDeparture() != form.getAirportDestination() ) &&
                ( form.getCaptain() != form.getFirstOfficer() ) &&
                ( planeTypesAllowed.contains( typePlaneRepository.findById(form.getWantedPlaneType())
                                            .orElseThrow(NoPlaneAvailableException::new)) );
    }
}
