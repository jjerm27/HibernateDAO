package dao;


import models.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class UserDao {
    public UsersEntity findById(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        UsersEntity usersEntity = session.get(UsersEntity.class, id);
        session.close();
        return usersEntity;
    }

    public void save(UsersEntity user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(UsersEntity user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        //session.saveOrUpdate(user);
        session.update(user);
        tx1.commit();
        session.close();
    }

    public void delete(UsersEntity user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    public List<UsersEntity> getAll(){

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UsersEntity> cr = criteriaBuilder.createQuery(UsersEntity.class);
        Root<UsersEntity> from = cr.from(UsersEntity.class);
        cr.select(from);

        Query<UsersEntity> query = session.createQuery(cr);
        List<UsersEntity> results = query.getResultList();

        return results;
    }
}
