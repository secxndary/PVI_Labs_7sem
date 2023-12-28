package by.bstu.service;

import by.bstu.dao.WSRefDao;
import by.bstu.entity.WSRef;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class WSRefService implements WSRefDao {
    private EntityManager entityManager;

    public WSRefService() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("MyPersistence");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(WSRef wsRef) {
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(wsRef);

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public WSRef findById(int id) {
        return entityManager.find(WSRef.class, id);
    }

    @Override
    public List<WSRef> findAll() {
        return entityManager.createQuery("SELECT w FROM WSRef w", WSRef.class).getResultList();
    }

    @Override
    public List<WSRef> findAllByKey(String key) {
        return entityManager.createQuery("SELECT w FROM WSRef w WHERE w.description LIKE :key", WSRef.class)
                .setParameter("key", "%" + key + "%")
                .getResultList();
    }

    @Override
    public void update(WSRef wsRef) {
        try {
            entityManager.getTransaction().begin();

            entityManager.merge(wsRef);

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        WSRef wsRef = findById(id);
        if (wsRef != null) {
            try {
                entityManager.getTransaction().begin();

                entityManager.remove(wsRef);

                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void addLike(int id) {
        WSRef wsRef = findById(id);
        wsRef.setPlus(wsRef.getPlus() + 1);
        update(wsRef);
    }

    @Override
    public void addDisLike(int id) {
        WSRef wsRef = findById(id);
        wsRef.setMinus(wsRef.getMinus() + 1);
        update(wsRef);
    }
}

