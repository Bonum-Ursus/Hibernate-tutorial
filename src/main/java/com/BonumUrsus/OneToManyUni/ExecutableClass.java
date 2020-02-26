package com.BonumUrsus.OneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ExecutableClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-one-to-many-uni.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            Course course = new Course("Driving");
            course.addReview(new Review("Good"));
            course.addReview(new Review("Not bad"));
            course.addReview(new Review("So so"));
            course.addReview(new Review("bad"));
            session.save(course);
            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }

    }
}
