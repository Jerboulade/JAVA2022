package be.technifutur.java.technisandwich.repository;

import be.technifutur.java.technisandwich.model.entity.Sandwich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface SandwichRepository extends JpaRepository<Sandwich, Long> {
    @Query("""
            SELECT s
            FROM Sandwich s
            WHERE s.name = :name
            """)
    Optional<Sandwich> findByName(String name);

    @Query("""
            SELECT s
            FROM Sandwich s
            WHERE s.id = :id
            """)
    Optional<Sandwich> findById(Long id);


    @Modifying
    @Transactional
    @Query("""
            UPDATE Sandwich s
            SET s.name = :name, s.description = :description, s.price = :price
            WHERE s.id = :id
            """)
    void update(Long id, String name, String description, Float price);

    @Query("""
            DELETE
            FROM Sandwich s
            WHERE s.name = :name
            """)
    @Modifying
    @Transactional
    void deleteByName(String name);
}
