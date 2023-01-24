package be.technifutur.repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<TENTITY, TID> {
    // Read
    Optional<TENTITY> getOne(TID id);
    List<TENTITY> getALL();

    // Create
    void add(TENTITY toInsert);

    // Update
    void update(TID id, TENTITY entity);

    // Delete
    void remove(TID id);
}
