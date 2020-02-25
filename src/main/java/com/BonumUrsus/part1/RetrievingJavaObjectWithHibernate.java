package com.BonumUrsus.part1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RetrievingJavaObjectWithHibernate {
    public static Logger log = LoggerFactory.getLogger(RetrievingJavaObjectWithHibernate.class.getName());
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            Student theStudent;
            session.beginTransaction();
            theStudent = session.get(Student.class, 4);
            log.info(theStudent.toString());
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
