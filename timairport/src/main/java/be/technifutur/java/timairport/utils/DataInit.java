package be.technifutur.java.timairport.utils;

import be.technifutur.java.timairport.model.entity.Pilot;
import be.technifutur.java.timairport.repository.PilotRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInit implements InitializingBean {

    private final PilotRepository pilotRepository;

    public DataInit(PilotRepository pilotRepository) {
        this.pilotRepository = pilotRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Pilot pilot = new Pilot();
        pilot.setFirstName("jer");
        pilot.setLastName("car");
        pilotRepository.save(pilot);
    }
}
