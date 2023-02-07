package be.technifutur.java.technisandwich.service.impl;

import be.technifutur.java.technisandwich.mapper.SandwichMapper;
import be.technifutur.java.technisandwich.model.dto.SandwichDTO;
import be.technifutur.java.technisandwich.repository.SandwichRepository;
import be.technifutur.java.technisandwich.service.SandwichService;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
