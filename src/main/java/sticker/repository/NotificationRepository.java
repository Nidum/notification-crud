package sticker.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    private SessionFactory sessionFactory;

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public List<Notification> getAll() {
        List list = getCurrentSession().createQuery( "from Notification ", Notification.class ).getResultList();
        return list;
    }

    public Notification find(long id) {
        return getCurrentSession().find(Notification.class, id);
    }

    public void update(Notification notification){
        Session session = getCurrentSession();
        session.merge(notification);
        session.flush();
    }

    public void create(Notification notification){
        getCurrentSession().persist(notification);
    }

    public void delete(long id){
        Session session = getCurrentSession();
        Notification notification = session.find(Notification.class, id);
        session.remove(notification);
    }
}
