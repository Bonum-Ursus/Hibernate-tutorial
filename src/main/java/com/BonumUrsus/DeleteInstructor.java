package com.BonumUrsus;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructor {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-one-to-one.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
//            Version1
            Instructor instructor = session.get(Instructor.class, 1);
            session.delete(instructor);

//            Version2(Do NOT delete from InstructorDetail)
//            session.createQuery("delete from Instructor i where i.id=2").executeUpdate();
//            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
