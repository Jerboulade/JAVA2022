package be.technifutur.java.technisandwich.repository;

import be.technifutur.java.technisandwich.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {
}
