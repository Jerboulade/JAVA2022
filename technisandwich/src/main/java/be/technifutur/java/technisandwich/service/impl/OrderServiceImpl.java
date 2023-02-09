package be.technifutur.java.technisandwich.service.impl;

import be.technifutur.java.technisandwich.mapper.OrderMapper;
import be.technifutur.java.technisandwich.model.dto.OrderDTO;
import be.technifutur.java.technisandwich.model.entity.Sandwich;
import be.technifutur.java.technisandwich.model.form.insert.OrderInsertForm;
import be.technifutur.java.technisandwich.repository.OrderRepository;
import be.technifutur.java.technisandwich.repository.SandwichRepository;
import be.technifutur.java.technisandwich.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository   orderRepository;
    private final SandwichRepository sandwichRepository;
    private final OrderMapper       orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, SandwichRepository sandwichRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.sandwichRepository = sandwichRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDTO)
                .toList();
    }

    @Override
    public void createOrder(OrderInsertForm form) {
        orderRepository.save(orderMapper.toEntity(form));
    }
}
