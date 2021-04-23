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

public class RequestHibernate {

    private SessionFactory factory = null;

    public RequestHibernate() {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserToken.class)
                .addAnnotatedClass(Request.class)
                .buildSessionFactory();

    }

    public List<Request> getList() {

        Session session = factory.openSession();

        List<Request> requestList = new ArrayList<Request>();


        try {

            Query<Request> theQuery =
                    session.createQuery("from Request",
                            Request.class);

            requestList = theQuery.getResultList();

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            //factory.close();
        }

        return  requestList;

    } // getList

    public Request getById(int id) {

        Session session = factory.openSession();

        Request request = new Request();

        try {

            request = session.get(Request.class, id);


        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            //factory.close();
        }

        return  request;

    } // getById

} // RequestHibernate
