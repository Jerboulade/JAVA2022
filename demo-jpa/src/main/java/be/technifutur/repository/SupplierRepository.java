package be.technifutur.repository;

import be.technifutur.entities.Supplier;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {

    List<Supplier> getSuppliersByRegion(String region);
    void addVipLabelToSupplierCompanyNameFromRegion(String region);

}
