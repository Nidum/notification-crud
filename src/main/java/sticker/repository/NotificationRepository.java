package sticker.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sticker.entity.Notification;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Emiliia Nesterovych on 3/17/2018.
 */
@Repository
public class NotificationRepository {

    @Autowired
    @PersistenceContext
    private final EntityManager entityManager;

    public NotificationRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Notification> getAll() {
        List list = entityManager.createQuery( "from Notification ", Notification.class ).getResultList();
        return list;
    }

    public Notification find(long id) {
        return entityManager.find(Notification.class, id);
    }

    public void update(Notification notification){
        entityManager.merge(notification);
        entityManager.flush();
    }

    public void create(Notification notification){
        entityManager.persist(notification);
    }

    public void delete(long id){
        Notification notification = entityManager.find(Notification.class, id);
        entityManager.remove(notification);
    }
}
