package be.technifutur.java.technisandwich.service.impl;

import be.technifutur.java.technisandwich.mapper.SandwichMapper;
import be.technifutur.java.technisandwich.model.dto.SandwichDTO;
import be.technifutur.java.technisandwich.model.entity.Sandwich;
import be.technifutur.java.technisandwich.model.form.insert.SandwichInsertForm;
import be.technifutur.java.technisandwich.model.form.update.SandwichUpdateForm;
import be.technifutur.java.technisandwich.repository.SandwichRepository;
import be.technifutur.java.technisandwich.service.SandwichService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SandwichServiceImpl implements SandwichService {

    private final SandwichRepository    sandwichRepository;
    private final SandwichMapper        sandwichMapper;

    public SandwichServiceImpl(SandwichRepository sandwichRepository, SandwichMapper sandwichMapper) {
        this.sandwichRepository = sandwichRepository;
        this.sandwichMapper = sandwichMapper;
    }

    @Override
    public List<SandwichDTO> getAll() {
        return sandwichRepository.findAll().stream()
                .map(sandwichMapper::toDTO)
                .toList();
    }

    @Override
    public SandwichDTO getOneByName(String name) {

        return sandwichMapper.toDTO(sandwichRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Sandwich not found")));
    }

    @Override
    public SandwichDTO getOneById(Long id) {
        return sandwichMapper.toDTO(sandwichRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sandwich not found")));
    }

    @Override
    public Long createSandwich(SandwichInsertForm form) {

        Sandwich s = sandwichRepository.save(sandwichMapper.toEntity(form));
        return s.getId();
    }

    @Override
    public void updateSandwich(Long id, SandwichUpdateForm form) {
        Sandwich entity = sandwichRepository.findById(id).orElseThrow(RuntimeException::new);
        String  name =          form.getName() != null        ? form.getName()        : entity.getName();
        String  description =   form.getDescription() != null ? form.getDescription() : entity.getDescription();
        Float   price =         form.getPrice() != null       ? form.getPrice()       : entity.getPrice();
        sandwichRepository.update(id, name, description, price);
    }

    @Override
    public void deleteSandwich(String name) {
        sandwichRepository.deleteByName(name);
    }


}
