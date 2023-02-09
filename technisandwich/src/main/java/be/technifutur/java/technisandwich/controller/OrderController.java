package be.technifutur.java.technisandwich.controller;

import be.technifutur.java.technisandwich.model.dto.OrderDTO;
import be.technifutur.java.technisandwich.model.entity.Order;
import be.technifutur.java.technisandwich.model.form.insert.OrderInsertForm;
import be.technifutur.java.technisandwich.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public List<OrderDTO>   getAll(){
        return orderService.getAll();
    }

    @PostMapping("/add")
    public void             createOrder(@RequestBody @Valid OrderInsertForm form){
        orderService.createOrder(form);
    }
}
