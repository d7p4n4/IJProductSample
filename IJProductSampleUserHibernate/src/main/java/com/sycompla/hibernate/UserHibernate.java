package com.sycompla.hibernate;

import com.sycompla.entity.Request;
import com.sycompla.entity.User;
import com.sycompla.entity.UserToken;
import org.hibernate.Criteria;
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

    public User getByGuid(String guid) {

        Session session = factory.openSession();

        User user = null;

        try {

            Query query = session.createQuery("from User user where user.guid = " + guid);

            List<User> userList = query.list();

            if(userList != null && userList.size() > 0) {

                user = userList.get(0);

            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            //factory.close();
        }

        return user;

    } // getByGuid

    public User getById(int id) {

        Session session = factory.openSession();

        User user = null;

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

    public Boolean isExistsById(int id) {return this.getById(id) != null;} // isExistsById

    public Boolean isExistsById(String guid) {return this.getByGuid(guid) != null;} // isExistsByGuid

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

        } catch (Exception exception) {

            exception.printStackTrace();

        } finally {
            session.close();
            //factory.close();
        }

        return user;

    } // updateById

    public User updateById(User user, String guid) {

        Session session = factory.openSession();

        try {

            User tempUser = this.getByGuid(guid);

            user.setId(tempUser.getId());

            session.beginTransaction();

            session.update(user);

            session.getTransaction().commit();

        } catch (Exception exception) {

            exception.printStackTrace();

        } finally {
            session.close();
            //factory.close();
        }

        return user;

    } // updateByGuid

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

    public void deleteByGuid(String guid) {

        Session session = factory.openSession();

        try {

            User tempUser = this.getByGuid(guid);

            session.beginTransaction();

            session.delete(tempUser);

            session.getTransaction().commit();


        } catch (Exception exception) {

            exception.printStackTrace();

        } finally {
            session.close();
            //factory.close();
        }

    } // deleteByGuid


} // UserHibernate