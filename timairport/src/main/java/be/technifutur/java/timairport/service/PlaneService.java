package be.technifutur.java.timairport.service;

import be.technifutur.java.timairport.model.dto.PlaneDTO;
import be.technifutur.java.timairport.model.entity.Plane;
import be.technifutur.java.timairport.model.form.PlaneInsertForm;

import java.util.List;
import java.util.UUID;

public interface PlaneService {
    void create(PlaneInsertForm form);
    PlaneDTO getOne(UUID id);

    List<PlaneDTO> getALL();
}
