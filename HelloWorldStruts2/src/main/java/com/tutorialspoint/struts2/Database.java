/**
 *  Class that saves data using the Hibernate framework
 */

package com.tutorialspoint.struts2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Database{
    private static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private static Session session = factory.openSession();

    public static int saveUser(User u){
        Transaction tr = session.beginTransaction();
        int i= (Integer)session.save(u);
        tr.commit();
        return i;
    }
    public static int deactivateUser(User u){
        Transaction tr = session.beginTransaction();
        u.setDeactivated(1);
        //session.update(u);
        int i= (Integer)session.save(u);
        tr.commit();
        return i;
    }
}
