package be.technifutur.repository.impl;

import be.technifutur.entities.Product;
import be.technifutur.repository.ProductRepository;
import be.technifutur.utils.EMFSharer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

    private final EntityManager em = EMFSharer.getInstance().createEntityManager();

    @Override
    public Optional<Product> getOne(Long id) {
        Product p = em.find(Product.class, id);
        // em.detach(p);     detach only one entity
        em.clear();       // detach all
        return Optional.ofNullable(p);
    }

    @Override
    public List<Product> getALL() {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
        List<Product> list = query.getResultList();
        em.clear();
        return list;
    }

    @Override
    public void add(Product toInsert) {
        // 1. create transaction
        em.getTransaction().begin();
        // 2. faire en sorte que l'entity soit 'managed'
        em.persist(toInsert);
        // 3. add to DB + detach object
        em.getTransaction().commit();
    }

    @Override
    public void update(Long id, Product entity) {
        entity.setId(id);
        //SQL : SELECT COUNT(*) FROM products WHERE product_id = ?
        String qlQuery = "SELECT COUNT(p) FROM Product p WHERE p.id = ?1";
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
        Product product = em.find(Product.class, id);
        if (product != null)
            em.remove(product);
        em.getTransaction().commit();
    }

    @Override
    public List<Product> getUnitPriceBetween(double min , double max) {
        // SELECT * FROM products WHERE unit_price BETWEEN ? AND ?
        String qlQuery = "FROM Product p WHERE p.unitPrice BETWEEN ?1 AND ?2";
        TypedQuery<Product> query = em.createQuery(qlQuery, Product.class);
        query.setParameter(1, min);
        query.setParameter(2, max);
        List<Product> list = query.getResultList();
        em.clear();
        return list;
    }
}
