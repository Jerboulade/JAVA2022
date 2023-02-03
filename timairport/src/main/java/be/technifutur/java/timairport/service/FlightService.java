package be.technifutur.java.timairport.service;

import be.technifutur.java.timairport.model.dto.FlightDTO;
import be.technifutur.java.timairport.model.form.FlightInsertForm;
import be.technifutur.java.timairport.model.form.FlightUpdateScheduleForm;

import java.util.List;
import java.util.UUID;

public interface FlightService {

    List<FlightDTO> getAll();
    void create(FlightInsertForm form);
    void cancelFlight(UUID id);
    void updateSchedule(FlightUpdateScheduleForm form);
}

