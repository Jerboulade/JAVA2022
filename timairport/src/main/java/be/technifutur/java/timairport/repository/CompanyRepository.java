package be.technifutur.java.timairport.repository;

import be.technifutur.java.timairport.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
}
