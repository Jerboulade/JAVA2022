package be.technifutur.java.technisandwich.utils;

import be.technifutur.java.technisandwich.model.entity.Cart;
import be.technifutur.java.technisandwich.model.entity.Order;
import be.technifutur.java.technisandwich.model.entity.Sandwich;
import be.technifutur.java.technisandwich.model.entity.User;
import be.technifutur.java.technisandwich.repository.CartRepository;
import be.technifutur.java.technisandwich.repository.OrderRepository;
import be.technifutur.java.technisandwich.repository.SandwichRepository;
import be.technifutur.java.technisandwich.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit implements InitializingBean {

    private final SandwichRepository    sandwichRepository;
    private final OrderRepository       orderRepository;
    private final UserRepository        userRepository;
    private final CartRepository        cartRepository;

    public DataInit(SandwichRepository sandwichRepository, OrderRepository orderRepository, UserRepository userRepository, CartRepository cartRepository) {
        this.sandwichRepository = sandwichRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Sandwich sandwich = new Sandwich();
        sandwich.setName("Dagobert");
        sandwich.setPrice(4.5f);
        sandwich.setDescription("Miam!");
        sandwichRepository.save(sandwich);

        Sandwich sandwich2 = new Sandwich();
        sandwich2.setName("Poulet Curry");
        sandwich2.setPrice(4.f);
        sandwich2.setDescription("Kotkotkot");
        sandwichRepository.save(sandwich2);

        Cart cart = new Cart();
        cartRepository.save(cart);

        User user = new User();
        user.setCart(cart);
        userRepository.save(user);

        Order order = new Order();
        order.setDeliveryDate(LocalDate.now());
        order.setOrderDate(LocalDate.now());
        order.setDiscount(0f);
        order.setState(true);
        order.setUser(user);
        // Cart to Order-------------------------------
        List<Sandwich> sandwichList= new ArrayList<>();
        sandwichList.add(sandwich);
        order.setSandwiches(sandwichList);
        //---------------------------------------------
        orderRepository.save(order);


    }
}
