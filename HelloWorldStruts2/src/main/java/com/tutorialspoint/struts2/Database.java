/**
 *  Class that saves data using the Hibernate framework
 */

package com.tutorialspoint.struts2;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import java.lang.Integer;
import java.lang.String;

public class Database{

    public static Integer saveUser(User u){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(u);
        tr.commit();
        session.close();
        return u.getId();
    }
    public static int deactivateUser(int id){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
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
    public static int saveTeam(Team team, User user){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction tr = session.beginTransaction();
        team.getUsers().add(user);
        session.refresh(user);
        user.getTeams().add(team);
        session.save(team);
        tr.commit();
        session.close();
        return team.getId();
    }
    public static User getUserById(int id){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();
        User user = (User) session.get(User.class, id);
        tr.commit();
        session.close();

        return user;
    }
}
