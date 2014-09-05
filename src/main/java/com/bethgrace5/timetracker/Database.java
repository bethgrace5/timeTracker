package com.bethgrace5.timetracker;

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.cfg.Configuration;

/**
 *  Class that accesses or edits Database using the Hibernate framework
 */
public class Database{
    private static final SessionFactory factory =
        new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    // Save User as new, or Update if existing
    public static Integer saveUser(User user){
        Session session = factory.openSession();
        Transaction tr = session.beginTransaction();
        // add user if they do not exist
        if( !exists(user) )
            session.save(user);
        // update if they do exist
        else
            session.update(user);
        tr.commit();
        session.close();
        return user.getId();
    }
    // Save Repository as new, or Update if existing
    public static Integer saveRepository(Repository repo, int userId){
        Session session = factory.openSession();
        Transaction tr = session.beginTransaction();
        User user = getUserById(userId);
        session.refresh(user);

        // refresh the repository if it has not been saved to the database 
        if(repo.getId() != 0){
            session.refresh(repo);

            // check for an existing connection between user and repository
            if(repo.getUsers().contains(user) || user.getRepositories().contains(repo))
                return 0;
        }

        // make the connection between the user and repository
        repo.getUsers().add(user);
        user.getRepositories().add(repo);
        session.update(user);

        tr.commit();
        session.close();
        return repo.getId();
    }
    
    // Save time session as new, or update if existing
    public static Integer saveTimeSession(TimeSession timeSession){
        Session session = factory.openSession();
        Transaction tr = session.beginTransaction();

        if( !exists(timeSession) )
            session.save(timeSession);
        // update if they do exist
        else
            session.update(timeSession);

        tr.commit();
        session.close();
        return timeSession.getId();
    }

    // Check if User exists in database
    public static boolean exists( User user ){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();

        user = (User) session.createCriteria(User.class).
            add( Restrictions.eq("id", user.getId()) ).
            uniqueResult(); 

        tr.commit();
        session.close();
        return( user != null );
    }
    // Check if Repository exists in database
    public static boolean exists( Repository repository ){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();

        repository = (Repository) session.createCriteria(Repository.class)
            .add( Restrictions.eq("id", repository.getId() )).
            uniqueResult(); 

        tr.commit();
        session.close();
        return( repository != null );
    }
    public static boolean exists( TimeSession timeSession ){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();

        timeSession = (TimeSession) session.createCriteria(TimeSession.class)
            .add( Restrictions.eq("id", timeSession.getId() )).
            uniqueResult(); 

        tr.commit();
        session.close();
        return( timeSession != null );
    }
    // get User by userName and password
    public static User getUserByUserNamePassword(String userName, String password) {
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
    // get User by UserName only
    public static User getUserByUserName(String userName){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();

        // name is expected to be unique
        User user = (User) session.createCriteria(User.class).
            add(Restrictions.eq("userName", userName)).
            uniqueResult();

        tr.commit();
        session.close();
        return user;
    }
    // get User by Name only
    public static User getUserByName(String name){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();

        // name is expected to be unique
        User user = (User) session.createCriteria(User.class).
            add(Restrictions.eq("name", name)).
            uniqueResult();

        tr.commit();
        session.close();
        return user;
    }
    // get User by id
    public static User getUserById(int id){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();

        User user = (User) session.get(User.class, id);

        tr.commit();
        session.close();
        return user;
    }
    // get Repository by name 
    public static Repository getRepository(String name){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();

        Repository repo = (Repository) session.
            createCriteria(Repository.class).
            add(Restrictions.eq("name", name)).
            uniqueResult();

        tr.commit();
        session.close();
        return repo;
    }
    // get all Users that are Clients
    public static List<String> getClientUsers(){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class, "u").
            add(Restrictions.eq("type", "client")).
            addOrder(Order.asc("userName"));

        ProjectionList proList = Projections.projectionList();
        proList.add(Projections.property("u.name"));
        criteria.setProjection(proList);
        List<String> clients = new ArrayList<String>(criteria.list());

        tr.commit();
        session.close();
        return clients;
    }
    public static List<String> getRepositories(int userId){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();

        // we need to look through the repositories in the user class
        // for this user's repositories
        Criteria criteria = session.createCriteria(User.class, "u").
            createAlias("u.repositories", "r").
            add(Restrictions.eq("u.id", userId)).
            addOrder(Order.asc("r.name"));

        // we need a list of the names from the repository class
        ProjectionList proList = Projections.projectionList();
        proList.add(Projections.property("r.name"));
        criteria.setProjection(proList);
        List<String> repositories = new ArrayList<String>(criteria.list());

        tr.commit();
        session.close();
        return repositories;
    }

    // update the last login for the specified user
    public static Integer updateLastLogin(User user) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        user.setLastLogin(now);

        return saveUser(user);
    }

    public static  TimeSession getLastTimeSession( int userId ){
        Session session = factory.openSession();
        Transaction tr = null;
        tr = session.beginTransaction();

        // get the timesessions associated with the user ordered by 
        // newest to oldest. Time session id increments, so the newest
        // should have the highest id number.
        List<TimeSession> timeSessions = session.createCriteria(TimeSession.class, "t").
            createAlias("t.user", "u").
            add(Restrictions.eq("u.id", userId)).
            addOrder(Order.desc("t.id")).
            list();

        tr.commit();
        session.close();
        return timeSessions.get(0);
    }

}
