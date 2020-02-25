package com.BonumUrsus.EagerVsLazyLoading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetInstructor {
    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(GetInstructor.class.getName());
        SessionFactory factory = new Configuration()
                .configure("hibernate-one-to-many.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 1);
            log.info(instructor.toString());
            log.info(instructor.getCourses().toString());
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
