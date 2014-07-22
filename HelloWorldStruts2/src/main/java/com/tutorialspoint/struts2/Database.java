package com.tutorialspoint.struts2;

import java.util.ArrayList;
import java.util.List;

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
        //ArrayList<String> clients = new ArrayList<String>();
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
