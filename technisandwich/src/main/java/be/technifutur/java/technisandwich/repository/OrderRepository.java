package be.technifutur.java.technisandwich.repository;

import be.technifutur.java.technisandwich.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository  extends JpaRepository<Order, UUID> {

}
