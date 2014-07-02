/**
 *  Class that saves data using the Hibernate framework
 */

package com.tutorialspoint.struts2;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Database{

    public static int saveUser(User u){
        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        int i= (Integer)session.save(u);
        tr.commit();
        session.close();
        return i;
    }
}
