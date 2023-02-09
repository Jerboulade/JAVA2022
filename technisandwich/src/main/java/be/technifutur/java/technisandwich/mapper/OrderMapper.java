package be.technifutur.java.technisandwich.mapper;

import be.technifutur.java.technisandwich.model.dto.OrderDTO;
import be.technifutur.java.technisandwich.model.entity.Order;
import be.technifutur.java.technisandwich.model.form.insert.OrderInsertForm;
import be.technifutur.java.technisandwich.repository.SandwichRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    private final SandwichRepository sandwichRepository;

    public OrderMapper(SandwichRepository sandwichRepository) {
        this.sandwichRepository = sandwichRepository;
    }

    public OrderDTO toDTO(Order entity){
        return OrderDTO.builder()
                .id(entity.getId())
                .orderDate(entity.getOrderDate())
                .deliveryDate(entity.getDeliveryDate())
                .discount(entity.getDiscount())
                .discount(entity.getDiscount())
                /*.user(OrderDTO.UserDTO.builder()
                        .firstName(entity.getUser().getFirstName())
                        .build())*/
                .sandwiches(entity.getSandwiches().stream()
                        .map(sandwich -> OrderDTO.SandwichDTO.builder()
                                .id(sandwich.getId())
                                .name(sandwich.getName())
                                .build())
                        .toList())
                .build();
    }

    public Order toEntity(OrderInsertForm form){
        Order order = new Order();
        order.setSandwiches(form.getSandwiches_id().stream()
                .map(id -> sandwichRepository.findById(id).orElseThrow())
                .toList()
        );
        order.setDeliveryDate(form.getDeliveryDate());
        return order;
    }
}
