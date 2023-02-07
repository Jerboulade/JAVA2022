package be.technifutur.java.technisandwich.service;

import be.technifutur.java.technisandwich.model.dto.SandwichDTO;
import be.technifutur.java.technisandwich.model.form.insert.SandwichInsertForm;
import be.technifutur.java.technisandwich.model.form.update.SandwichUpdateForm;

import java.util.List;

public interface SandwichService {

    List<SandwichDTO> getAll();

    SandwichDTO getOneByName(String name);

    SandwichDTO getOneById(Long id);

    Long createSandwich(SandwichInsertForm form);

    void updateSandwich(Long id, SandwichUpdateForm form);

    void deleteSandwich(String name);
}
