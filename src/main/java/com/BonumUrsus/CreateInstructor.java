package com.BonumUrsus;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-one-to-one.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            Instructor instructor = new Instructor("Bonum", "Ursus", "Bonum.Ursus@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("MyChannel", "Computer science");
            instructor.setInstructorDetailId(instructorDetail);
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
        }finally {

        }
    }
}
