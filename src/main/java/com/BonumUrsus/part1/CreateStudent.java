package com.BonumUrsus.part1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateStudent {
    public static Logger LOG = LoggerFactory.getLogger(CreateStudent.class.getName());
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            LOG.info("Creating new Student object...");
            Student theStudent = new Student(
                    "Jack", "Sparrow", "JackSparrow@gmail.com");
            session.beginTransaction();
            LOG.info("Saving the student...");
            session.save(theStudent);
            session.getTransaction().commit();
            LOG.info("Committed");
        }finally {
            session.close();
            factory.close();
            LOG.info("SessionFactory closed");
        }

    }
}
