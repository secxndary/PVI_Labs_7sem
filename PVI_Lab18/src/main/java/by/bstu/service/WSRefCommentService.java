package by.bstu.service;

import by.bstu.dao.WSRefCommentDao;
import by.bstu.entity.WSRefComment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import java.util.List;

public class WSRefCommentService implements WSRefCommentDao {

    @PersistenceContext
    private EntityManager entityManager;

    public WSRefCommentService() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("MyPersistence");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(WSRefComment wsRefComment) {
        try {
            entityManager.getTransaction().begin();

            entityManager.persist(wsRefComment);

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            ex.printStackTrace();
        }
    }

    @Override
    public WSRefComment findById(int id) {
        return entityManager.find(WSRefComment.class, id);
    }

    @Override
    public List<WSRefComment> findAll() {
        return entityManager.createQuery("SELECT w FROM WSRefComment w", WSRefComment.class).getResultList();
    }

    @Override
    public List<WSRefComment> findAllByWsRefId(int wsRefId) {
        return entityManager.createQuery("SELECT w FROM WSRefComment w WHERE wsref.id = :wsRefId", WSRefComment.class)
                .setParameter("wsRefId", wsRefId)
                .getResultList();
    }

    @Override
    public void update(WSRefComment wsRefComment) {
        try {
            entityManager.getTransaction().begin();

            entityManager.merge(wsRefComment);

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
        WSRefComment wsRefComment = findById(id);
        if (wsRefComment != null) {
            try {
                entityManager.getTransaction().begin();

                entityManager.remove(wsRefComment);

                entityManager.getTransaction().commit();
            } catch (Exception ex) {
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
                ex.printStackTrace();
            }
        }
    }
}