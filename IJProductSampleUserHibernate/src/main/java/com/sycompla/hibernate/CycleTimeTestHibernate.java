package com.sycompla.hibernate;

import com.sycompla.entity.CycleTimeTest;
import com.sycompla.entity.RequestToken;
import com.sycompla.entity.User;
import com.sycompla.entity.UserToken;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CycleTimeTestHibernate {


    private SessionFactory factory = null;

    public CycleTimeTestHibernate() {
        this.factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CycleTimeTest.class)
                .addAnnotatedClass(RequestToken.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserToken.class)
                .buildSessionFactory();

    }

    public List<CycleTimeTest> getList() {

        Session session = factory.openSession();

        List<CycleTimeTest> cycleTimeTestList = new ArrayList<CycleTimeTest>();


        try {

            Query<CycleTimeTest> theQuery =
                    session.createQuery("from CycleTimeTest",
                            CycleTimeTest.class);

            cycleTimeTestList = theQuery.getResultList();

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            //factory.close();
        }

        return  cycleTimeTestList;

    } // getList

    public CycleTimeTest getByGuid(String guid) {

        Session session = factory.openSession();

        CycleTimeTest cycleTimeTest = null;

        try {

            Query query = session.createQuery("from CycleTimeTest cycleTimeTest where cycleTimeTest.guid = '" + guid + "'");

            List<CycleTimeTest> cycleTimeTestList = query.list();

            if(cycleTimeTestList != null && cycleTimeTestList.size() > 0) {

                cycleTimeTest = cycleTimeTestList.get(0);

            }

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            //factory.close();
        }

        return cycleTimeTest;

    } // getByGuid

    public CycleTimeTest getById(int id) {

        Session session = factory.openSession();

        CycleTimeTest cycleTimeTest = null;

        try {

            cycleTimeTest = session.get(CycleTimeTest.class, id);


        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
            //factory.close();
        }

        return  cycleTimeTest;

    } // getById

    public Boolean isExistsById(int id) {return this.getById(id) != null;} // isExistsById

    public Boolean isExistsByGuid(String guid) {return this.getByGuid(guid) != null;} // isExistsByGuid

    public CycleTimeTest insert(CycleTimeTest cycleTimeTest) {

        Session session = factory.openSession();

        try {

            session.beginTransaction();

            session.save(cycleTimeTest);

            session.getTransaction().commit();

            return cycleTimeTest;

        } catch (Exception exception) {

            exception.printStackTrace();

            return cycleTimeTest;

        } finally {
            session.close();
            //factory.close();
        }

    } // insert

    public CycleTimeTest updateById(CycleTimeTest cycleTimeTest, int id) {

        Session session = factory.openSession();

        try {

            CycleTimeTest tempCycleTimeTest = session.get(CycleTimeTest.class, id);

            this.object2Object(cycleTimeTest, tempCycleTimeTest);

            session.beginTransaction();

            session.update(tempCycleTimeTest);

            session.getTransaction().commit();

            return tempCycleTimeTest;

        } catch (Exception exception) {

            exception.printStackTrace();

        } finally {
            session.close();
            //factory.close();
        }

        return null;

    } // updateById

    public CycleTimeTest updateByGuid(CycleTimeTest cycleTimeTest, String guid) {

        Session session = factory.openSession();

        try {

            CycleTimeTest tempCycleTimeTest = this.getByGuid(guid);

            this.object2Object(cycleTimeTest, tempCycleTimeTest);

            session.beginTransaction();

            session.update(tempCycleTimeTest);

            session.getTransaction().commit();

            return tempCycleTimeTest;

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

            CycleTimeTest tempCycleTimeTest = session.get(CycleTimeTest.class, id);

            session.beginTransaction();

            session.delete(tempCycleTimeTest);

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

            CycleTimeTest tempCycleTimeTest = this.getByGuid(guid);

            session.beginTransaction();

            session.delete(tempCycleTimeTest);

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

} // CycleTimeTestHibernate