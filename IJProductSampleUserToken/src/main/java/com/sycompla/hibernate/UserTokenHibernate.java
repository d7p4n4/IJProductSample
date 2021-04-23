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

public class UserTokenHibernate {

    private SessionFactory factory = null;

    public UserTokenHibernate() {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserToken.class)
                .addAnnotatedClass(Request.class)
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

    public UserToken getById(int id) {

        Session session = factory.openSession();

        UserToken userToken = new UserToken();

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

} // UserTokenHibernate