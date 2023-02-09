package be.technifutur.java.technisandwich.service;

import be.technifutur.java.technisandwich.model.dto.OrderDTO;
import be.technifutur.java.technisandwich.model.entity.Order;
import be.technifutur.java.technisandwich.model.form.insert.OrderInsertForm;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAll();

    void createOrder(OrderInsertForm form);
}
