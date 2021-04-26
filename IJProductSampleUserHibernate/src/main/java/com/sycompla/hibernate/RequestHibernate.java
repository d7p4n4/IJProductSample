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

public class RequestHibernate {

    private SessionFactory factory = null;

    public RequestHibernate() {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(RequestToken.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserToken.class)
                .buildSessionFactory();

    }

    public List<RequestToken> getList() {

        Session session = factory.openSession();

        List<RequestToken> requestTokenList = new ArrayList<RequestToken>();


        try {

            Query<RequestToken> theQuery =
                    session.createQuery("from Request",
                            RequestToken.class);

            requestTokenList = theQuery.getResultList();

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            //factory.close();
        }

        return  requestTokenList;

    } // getList

    public RequestToken getByGuid(String guid) {

        Session session = factory.openSession();

        RequestToken requestToken = null;

        try {

            Query query = session.createQuery("from RequestToken request where request.guid = '" + guid + "'");

            List<RequestToken> requestTokenList = query.list();

            if(requestTokenList != null && requestTokenList.size() > 0) {

                requestToken = requestTokenList.get(0);

            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            //factory.close();
        }

        return requestToken;

    } // getByGuid

    public RequestToken getById(int id) {

        Session session = factory.openSession();

        RequestToken requestToken = null;

        try {

            requestToken = session.get(RequestToken.class, id);


        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            //factory.close();
        }

        return  requestToken;

    } // getById

    public Boolean isExistsById(int id) {return this.getById(id) != null;} // isExistsById

    public Boolean isExistsByGuid(String guid) {return this.getByGuid(guid) != null;} // isExistsByGuid

    public RequestToken insert(RequestToken requestToken) {

        Session session = factory.openSession();

        try {

            session.beginTransaction();

            session.save(requestToken);

            session.getTransaction().commit();

            return requestToken;

        } catch (Exception exception) {

            exception.printStackTrace();

            return requestToken;

        } finally {
            session.close();
            //factory.close();
        }

    } // insert

    public RequestToken updateById(RequestToken requestToken, int id) {

        Session session = factory.openSession();

        try {

            RequestToken tempRequestToken = session.get(RequestToken.class, id);

            this.object2Object(requestToken, tempRequestToken);

            session.beginTransaction();

            session.update(tempRequestToken);

            session.getTransaction().commit();

            return tempRequestToken;

        } catch (Exception exception) {

            exception.printStackTrace();

        } finally {
            session.close();
            //factory.close();
        }

        return null;

    } // updateById

    public RequestToken updateByGuid(RequestToken requestToken, String guid) {

        Session session = factory.openSession();

        try {

            RequestToken tempRequestToken = this.getByGuid(guid);

            this.object2Object(requestToken, tempRequestToken);

            session.beginTransaction();

            session.update(tempRequestToken);

            session.getTransaction().commit();

            return tempRequestToken;

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

            RequestToken tempRequestToken = session.get(RequestToken.class, id);

            session.beginTransaction();

            session.delete(tempRequestToken);

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

            RequestToken tempRequestToken = this.getByGuid(guid);

            session.beginTransaction();

            session.delete(tempRequestToken);

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
    
} // RequestHibernate
