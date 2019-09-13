package dao;

import models.GroupEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GroupDao {
    public GroupEntity findById(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        GroupEntity groupEntity = session.get(GroupEntity.class, id);
        session.close();
        return groupEntity;
    }

    public void save(GroupEntity group){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(group);
        tx1.commit();
        session.close();
    }

    public void update(GroupEntity group){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(group);
        tx1.commit();
        session.close();
    }

    public void delete(GroupEntity group){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(group);
        tx1.commit();
        session.close();
    }

    public List<GroupEntity> getAll(){

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<GroupEntity> cr = criteriaBuilder.createQuery(GroupEntity.class);
        Root<GroupEntity> from = cr.from(GroupEntity.class);
        cr.select(from);

        Query<GroupEntity> query = session.createQuery(cr);
        List<GroupEntity> results = query.getResultList();

        return results;
    }
}
