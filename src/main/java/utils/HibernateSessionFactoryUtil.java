package utils;

import models.GroupEntity;
import models.UsersEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        try {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(GroupEntity.class);
                configuration.addAnnotatedClass(UsersEntity.class);

                configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            }
        } catch (Exception ex) {
            System.out.println("Exception!");
        }
        return sessionFactory;
    }

}
