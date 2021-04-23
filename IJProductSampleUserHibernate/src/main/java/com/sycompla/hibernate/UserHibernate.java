package com.sycompla.hibernate;

import com.sycompla.entity.Request;
import com.sycompla.entity.User;
import com.sycompla.entity.UserToken;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserHibernate {

    private SessionFactory factory = null;

    public UserHibernate() {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserToken.class)
                .addAnnotatedClass(Request.class)
                .buildSessionFactory();

    }

    public List<User> getList() {

        Session session = factory.openSession();

        List<User> userList = new ArrayList<User>();


        try {

            Query<User> theQuery =
                    session.createQuery("from User",
                            User.class);

            userList = theQuery.getResultList();

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            //factory.close();
        }

        return  userList;

    } // getList

    public User getById(int id) {

        Session session = factory.openSession();

        User user = new User();

        try {

            user = session.get(User.class, id);


        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            //factory.close();
        }

        return  user;

    } // getById

    public User insert(User user) {

        Session session = factory.openSession();

        try {

            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();

            return user;

        } catch (Exception exception) {

            exception.printStackTrace();

            return user;

        } finally {
            session.close();
            //factory.close();
        }

    } // insert

    public User updateById(User user, int id) {

        Session session = factory.openSession();

        try {

            User tempUser = session.get(User.class, id);

            user.setId(tempUser.getId());

            session.beginTransaction();

            session.update(user);

            session.getTransaction().commit();

            return user;

        } catch (Exception exception) {

            exception.printStackTrace();

            return user;

        } finally {
            session.close();
            //factory.close();
        }

    } // updateById

    public void delete(int id) {

        Session session = factory.openSession();

        try {

            User tempUser = session.get(User.class, id);

            session.beginTransaction();

            session.delete(tempUser);

            session.getTransaction().commit();


        } catch (Exception exception) {

            exception.printStackTrace();

        } finally {
            session.close();
            //factory.close();
        }

    } // delete


} // UserHibernate