package be.technifutur.jcarere.mvc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudRepository<TENTITY, TID> implements CrudRepository<TENTITY, TID>{

    private final Class<TENTITY> entityClass;
    private final EntityManager entityManager;

    protected AbstractCrudRepository(Class<TENTITY> entityClass, EntityManager entityManager) {
        this.entityClass = entityClass;
        this.entityManager = entityManager;
    }

    @Override
    public List<TENTITY> getAll() {
        String entityName = entityClass.getSimpleName();
        String qlQuery = "SELECT e FROM "+entityName+" e";
        // String qlQuery = String.format("SELECT e FROM %s e", entityName);
        TypedQuery<TENTITY> query = entityManager.createQuery(qlQuery, entityClass);
        List<TENTITY> list = query.getResultList();
        entityManager.detach(list);
        return list;
    }

    @Override
    public Optional<TENTITY> getById(TID id) {
        TENTITY entity = entityManager.find(entityClass, id);
        entityManager.clear();
        return Optional.ofNullable(entity);
    }

    @Override
    public void create(TENTITY entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public abstract void adaptId(TID id, TENTITY entity);

    @Override
    public void update(TID id, TENTITY entity) {
        if (getById(id).isPresent()){
            entityManager.getTransaction().begin();
            adaptId(id, entity);
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        }

    }

    @Override
    public void delete(TENTITY entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        TENTITY managedEntity = entityManager.merge(entity);
        entityManager.remove(managedEntity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteById(TID id) {

        /* HARDCORE INTROSPECTION
           ----------------------
        Field[] fields = entityClass.getDeclaredFields();
        String idName = null;

        for (Field f : fields){
            if (f.isAnnotationPresent(Id.class)){
                idName = f.getName();
                break ;
            }
        }
        if (idName == null){
            throw new RuntimeException("entityClass is not an Entity class");
        }
        String qlQuery = String.format("DELETE FROM %s WHERE %s = ?1", entityClass.getSimpleName(), idName);
        Query query = entityManager.createQuery(qlQuery);
        query.setParameter(1, id);
        entityManager.getTransaction().begin();
        query.executeUpdate();
        entityManager.getTransaction().commit();
        */

        entityManager.getTransaction().begin();
        TENTITY toDelete = entityManager.find(entityClass, id);
        entityManager.remove(toDelete);
        entityManager.getTransaction().commit();
    }
}
