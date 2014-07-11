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

    public static int saveUser(User u){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        Transaction tr = session.beginTransaction();
        int i= (Integer)session.save(u);
        tr.commit();
        session.close();
        return i;
    }
    public static int deactivateUser(int id){
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
            Transaction tr = null;
            tr = session.beginTransaction();
            User u = (User) session.get(User.class, id);
            if(u != null){
                u.setIsDeactivated(true);
                session.update(u);
                tr.commit();
                session.close();
                return 1;
            }
            tr.commit();
            session.close();
        return 0;
    }
}
