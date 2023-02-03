package be.technifutur.java.timairport.repository;

import be.technifutur.java.timairport.model.entity.Company;
import be.technifutur.java.timairport.model.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface PlaneRepository extends JpaRepository<Plane, UUID> {

    // UPDATE Plane p SET p.inMaintenance = ?2 WHERE p.id = ?1
    @Modifying
    @Transactional // utile dans le cas UPDATE/DELETE
    @Query("UPDATE Plane p SET p.inMaintenance = ?2 WHERE p.id = ?1")
    void updateMaintenance(UUID id, boolean maintenance);

    @Modifying
    @Transactional // utile dans le cas UPDATE/DELETE
    @Query("UPDATE Plane p SET p.company = ?2 WHERE p.id = ?1")
    void updateCompany(UUID id, Company company);

    /*
    @Query("""
            SELECT p
            FROM Plane p
            WHERE (p.inMaintenance == false)
            AND (p.type.id == :type_id)
            AND (p.company.id == :company_id)
            """)
    List<Plane> findValidAvailablePlane(UUID type_id, UUID company_id);*/

}
