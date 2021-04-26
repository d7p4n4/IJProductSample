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

public class UserTokenHibernate {

    private SessionFactory factory = null;

    public UserTokenHibernate() {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserToken.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(RequestToken.class)
                .buildSessionFactory();

    }

    public List<UserToken> getList() {

        Session session = factory.openSession();

        List<UserToken> userTokenList = new ArrayList<UserToken>();


        try {

            Query<UserToken> theQuery =
                    session.createQuery("from UserToken",
                            UserToken.class);

            userTokenList = theQuery.getResultList();

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            //factory.close();
        }

        return  userTokenList;

    } // getList

    public UserToken getByGuid(String guid) {

        Session session = factory.openSession();

        UserToken userToken = null;

        try {

            Query query = session.createQuery("from UserToken userToken where userToken.guid = '" + guid + "'");

            List<UserToken> userTokenList = query.list();

            if(userTokenList != null && userTokenList.size() > 0) {

                userToken = userTokenList.get(0);

            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            //factory.close();
        }

        return userToken;

    } // getByGuid

    public UserToken getById(int id) {

        Session session = factory.openSession();

        UserToken userToken = null;

        try {

            userToken = session.get(UserToken.class, id);


        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            //factory.close();
        }

        return  userToken;

    } // getById

    public Boolean isExistsById(int id) {return this.getById(id) != null;} // isExistsById

    public Boolean isExistsByGuid(String guid) {return this.getByGuid(guid) != null;} // isExistsByGuid

    public UserToken insert(UserToken userToken) {

        Session session = factory.openSession();

        try {

            session.beginTransaction();

            session.save(userToken);

            session.getTransaction().commit();

            return userToken;

        } catch (Exception exception) {

            exception.printStackTrace();

            return userToken;

        } finally {
            session.close();
            //factory.close();
        }

    } // insert

    public UserToken updateById(UserToken userToken, int id) {

        Session session = factory.openSession();

        try {

            UserToken tempUserToken = session.get(UserToken.class, id);

            this.object2Object(userToken, tempUserToken);

            session.beginTransaction();

            session.update(tempUserToken);

            session.getTransaction().commit();

            return tempUserToken;

        } catch (Exception exception) {

            exception.printStackTrace();

        } finally {
            session.close();
            //factory.close();
        }

        return null;

    } // updateById

    public UserToken updateByGuid(UserToken userToken, String guid) {

        Session session = factory.openSession();

        try {

            UserToken tempUserToken = this.getByGuid(guid);

            this.object2Object(userToken, tempUserToken);

            session.beginTransaction();

            session.update(tempUserToken);

            session.getTransaction().commit();

            return tempUserToken;

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

            UserToken tempUserToken = session.get(UserToken.class, id);

            session.beginTransaction();

            session.delete(tempUserToken);

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

            UserToken tempUserToken = this.getByGuid(guid);

            session.beginTransaction();

            session.delete(tempUserToken);

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

} // UserTokenHibernate