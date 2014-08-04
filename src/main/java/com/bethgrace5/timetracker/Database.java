package com.bethgrace5.timetracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

import org.hibernate.criterion.Restrictions;

/**
 *  Class that saves data using the Hibernate framework
 */
public class Database{
    private static final SessionFactory factory =
        new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    public static Integer saveUser(User u){
        Session session = factory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(u);
        tr.commit();
        session.close();
        return u.getId();
    }
    public static int deactivateUser(int id){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        if(user != null){
            user.setIsDeactivated(true);
            session.update(user);
            tr.commit();
            session.close();
            return 1;
        }
        tr.commit();
        session.close();
        return 0;
    }
    public static boolean existsUsernameEmail(String userName, String email){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();
        
        // test if userName exists
        Criteria criteria1 = session.createCriteria(User.class);
        criteria1.add(Restrictions.eq("userName", userName ));
        User user = (User) criteria1.uniqueResult();
        if ( user != null ){
            tr.commit();
            session.close();
            return true;
        }

        // test if email exists
        Criteria criteria2 = session.createCriteria(User.class);
        criteria2.add(Restrictions.eq("email", email));
        user = (User) criteria2.uniqueResult();
        if ( user != null ){
            tr.commit();
            session.close();
            return true;
        }

        tr.commit();
        session.close();
        return false;
    }
    public static User findUserByUsernameAndPassword(String userName,
            String password) {
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();
        // TODO -- implement using password as part of the query
        User user = (User) session.createCriteria(User.class).
                                   add(Restrictions.eq("userName", userName)).
                                   uniqueResult();
        tr.commit();
        session.close();
        return user;
    }
    public static User findUserByUsername(String userName){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();
        User user = (User) session.createCriteria(User.class).
                                   add(Restrictions.eq("userName", userName)).
                                   uniqueResult();
        tr.commit();
        session.close();
        return user;

    }
    public static User getUserById(int id){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        tr.commit();
        session.close();
        return user;
    }
    public static List<String> getClientUsers(){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();
        List<String> clients = session.createCriteria(User.class).
                               add(Restrictions.eq("type", "client")).
                               list();
        tr.commit();
        session.close();
        return clients;
    }

}
