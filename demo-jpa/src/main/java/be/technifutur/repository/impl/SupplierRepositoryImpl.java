package be.technifutur.repository.impl;

import be.technifutur.entities.Product;
import be.technifutur.entities.Region;
import be.technifutur.entities.Supplier;
import be.technifutur.repository.SupplierRepository;
import be.technifutur.utils.EMFSharer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class SupplierRepositoryImpl implements SupplierRepository {
    private final EntityManager em = EMFSharer.getInstance().createEntityManager();

    @Override
    public Optional getOne(Long id) {
        Supplier s = em.find(Supplier.class, id);
        // em.detach(s);     detach only one entity
        em.clear();       // detach all
        return Optional.ofNullable(s);
    }

    @Override
    public List getALL() {
        TypedQuery<Supplier> query = em.createQuery("SELECT p FROM Supplier p", Supplier.class);
        List<Supplier> list = query.getResultList();
        em.clear();
        return list;
    }

    @Override
    public void add(Supplier toInsert) {
        // 1. create transaction
        em.getTransaction().begin();
        // 2. faire en sorte que l'entity soit 'managed'
        em.persist(toInsert);
        // 3. add to DB + detach object
        em.getTransaction().commit();
    }

    @Override
    public void update(Long id, Supplier entity) {
        entity.setId(id);
        //SQL : SELECT COUNT(*) FROM suppliers WHERE product_id = ?
        String qlQuery = "SELECT COUNT(s) FROM Supplier s WHERE p.id = ?1";
        TypedQuery<Long> countQuery = em.createQuery(qlQuery, Long.class);
        countQuery.setParameter(1, id);
        long count = countQuery.getSingleResult();
        // if (getOne(id).isPresent) --> less effective because of conversion
        if (count == 1){
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        }
        else
            throw new IllegalArgumentException(String.format("%s with id:%d does not exists",entity.getClass().toString(), id));
    }

    @Override
    public void remove(Long id) {
        em.getTransaction().begin();
        Supplier supplier = em.find(Supplier.class, id);
        if (supplier != null)
            em.remove(supplier);
        em.getTransaction().commit();

    }

    @Override
    public List<Supplier> getSuppliersByRegion(String region) {
        String qlQuery = "FROM Supplier s WHERE s.region = ?1";
        TypedQuery<Supplier> query = em.createQuery(qlQuery, Supplier.class);
        query.setParameter(1, region);
        List<Supplier> list = query.getResultList();
        em.clear();
        return list;
    }

    @Override
    public void addVipLabelToSupplierCompanyNameFromRegion(String region) {
        em.getTransaction().begin();
        getSuppliersByRegion(region)
                .forEach(
                        s -> {
                            s.setCompanyName(s.getCompanyName() + " - VIP");
                            em.merge(s);
                        }
                );
        em.getTransaction().commit();
    }
}
