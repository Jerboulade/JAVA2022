package be.technifutur.java.timairport.service.impl;

import be.technifutur.java.timairport.exception.NoPlaneAvailableException;
import be.technifutur.java.timairport.exception.RessourceNotFoundException;
import be.technifutur.java.timairport.mapper.FlightMapper;
import be.technifutur.java.timairport.model.dto.FlightDTO;
import be.technifutur.java.timairport.model.entity.Flight;
import be.technifutur.java.timairport.model.entity.Plane;
import be.technifutur.java.timairport.model.entity.TypePlane;
import be.technifutur.java.timairport.model.form.FlightInsertForm;
import be.technifutur.java.timairport.model.form.FlightUpdateScheduleForm;
import be.technifutur.java.timairport.repository.*;
import be.technifutur.java.timairport.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository      flightRepository;
    private final TypePlaneRepository   typePlaneRepository;
    private final CompanyRepository     companyRepository;
    private final AirportRepository     airportRepository;
    private final PlaneRepository       planeRepository;
    private final PilotRepository       pilotRepository;
    private final FlightMapper          flightMapper;

    public FlightServiceImpl(FlightRepository flightRepository, TypePlaneRepository typePlaneRepository, CompanyRepository companyRepository, AirportRepository airportRepository, PlaneRepository planeRepository, PilotRepository pilotRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.typePlaneRepository = typePlaneRepository;
        this.companyRepository = companyRepository;
        this.airportRepository = airportRepository;
        this.planeRepository = planeRepository;
        this.pilotRepository = pilotRepository;
        this.flightMapper = flightMapper;
    }


    @Override
    public List<FlightDTO> getAll() {
        List<FlightDTO> list  = flightRepository.findAll().stream()
                .map(flightMapper::toDto)
                .toList();
        System.out.println("mistsize : " + list.size());
        return list;
    }

    @Override
    public void create(FlightInsertForm form) {
        if (!isValidFlightForm(form)) {
            System.out.println("---------------RETURN");
            return;
        }        Plane plane = planeRepository.findAll().stream()
                .filter(pl ->
                    pl.getType().getId().equals(form.getWantedPlaneType()) &&
                    pl.getCompany().getId().equals( form.getWantedCompany()) &&
                    !pl.isInMaintenance()
                )
                .findFirst()
                .orElseThrow(NoPlaneAvailableException::new);
        Flight flight = form.toEntity();
        flight.setDeparture(airportRepository.findById(form.getAirportDeparture())
                .orElseThrow(() -> new RessourceNotFoundException("No AirportDeparture found")));
        flight.setDestination(airportRepository.findById(form.getAirportDestination())
                .orElseThrow(() -> new RessourceNotFoundException("No AirportDestination found")));
        flight.setPlane(plane);
        flight.setCaptain(pilotRepository.findById(form.getCaptain())
                .orElseThrow(() -> new RessourceNotFoundException("No Captain found")));
        flight.setFirstOfficer(pilotRepository.findById(form.getFirstOfficer())
                .orElseThrow(() -> new RessourceNotFoundException("No FirstOfficer found")));
        flightRepository.save(flight);
    }

    private boolean isValidFlightForm(FlightInsertForm form){
        List<TypePlane> planeTypesAllowed = airportRepository.findById(form.getAirportDeparture())
                                            .orElseThrow(RessourceNotFoundException::new)
                                            .getPlaneTypesAllowed();
        System.out.println("coucou");
        System.out.println(DAYS.between( form.getDepartureTime(), form.getArrivalTime() ) < 2);
        System.out.println(!form.getAirportDeparture().equals(form.getAirportDestination()));
        System.out.println(!form.getCaptain().equals(form.getFirstOfficer()));
        System.out.println(planeTypesAllowed.contains( typePlaneRepository.findById(form.getWantedPlaneType())
                .orElseThrow(() -> new NoPlaneAvailableException("departureAirport doesn't allow this type of plane"))));
        return  ( DAYS.between( form.getDepartureTime(), form.getArrivalTime() ) < 2) &&
                ( !form.getAirportDeparture().equals(form.getAirportDestination()) ) &&
                ( !form.getCaptain().equals(form.getFirstOfficer()) ) &&
                ( planeTypesAllowed.contains( typePlaneRepository.findById(form.getWantedPlaneType()).orElseThrow(() -> new NoPlaneAvailableException("departureAirport doesn't allow this type of plane"))));
    }

    public void cancelFlight(UUID id){
        flightRepository.cancelFlight(id);
    }

    @Override
    public void updateSchedule(FlightUpdateScheduleForm form) {
        flightRepository.updateSchedule(form.getId(), form.getDepartureTime(), form.getArrivalTime());
    }


}
