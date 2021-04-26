package com.sycompla.hibernate;

import com.sycompla.entity.RequestToken;
import com.sycompla.entity.User;
import com.sycompla.entity.UserToken;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserHibernate {

    private SessionFactory factory = null;

    public UserHibernate() {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserToken.class)
                .addAnnotatedClass(RequestToken.class)
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

            Query query = session.createQuery("from User user where user.guid = '" + guid + "'");

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

    public Boolean isExistsByGuid(String guid) {return this.getByGuid(guid) != null;} // isExistsByGuid

    public User insert(User user) {

        Session session = factory.openSession();

        user.setCreatedAt(new Date());

        user.setUpdatedAt(new Date());

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

            tempUser.setUpdatedAt(new Date());

            this.object2Object(user, tempUser);

            session.beginTransaction();

            session.update(tempUser);

            session.getTransaction().commit();

            return tempUser;

        } catch (Exception exception) {

            exception.printStackTrace();

        } finally {
            session.close();
            //factory.close();
        }

        return null;

    } // updateById

    public User updateByGuid(User user, String guid) {

        Session session = factory.openSession();

        try {

            User tempUser = this.getByGuid(guid);

            tempUser.setUpdatedAt(new Date());

            this.object2Object(user, tempUser);

            session.beginTransaction();

            session.update(tempUser);

            session.getTransaction().commit();

            return tempUser;

        } catch (Exception exception) {

            exception.printStackTrace();

        } finally {
            session.close();
            //factory.close();
        }

        return null;

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

    public void object2Object(Object source, Object target) throws IllegalAccessException, NoSuchFieldException {

        Field[] properties = source.getClass().getDeclaredFields();

        for(int counter = 0; counter < properties.length; counter++) {

            Field property = properties[counter];

            if(property.get(source) != null && (property.getName() != "id" || property.getName() == "createdAt" || property.getName() == "updatedAt")) {

                Object obj = properties[counter].get(source);

                target.getClass().getDeclaredField(properties[counter].getName()).set(target, properties[counter].get(source));

            }

        }

    } // object2Object


} // UserHibernate