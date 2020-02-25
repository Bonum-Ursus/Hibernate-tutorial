package com.BonumUrsus.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-one-to-many.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            Instructor instructor = new Instructor(
                    "Cousin Avi","Avi","Avi@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail(
                    "Avi online", "Courier");
            instructor.setInstructorDetail(instructorDetail);

            session.save(instructor);

            Course course1 = new Course("How to do not lose diamond");
            Course course2 = new Course("How to keep calm in any situation");

            instructor.addCourse(course1);
            instructor.addCourse(course2);

            session.save(course1);
            session.save(course2);
            session.getTransaction().commit();

        }catch (Exception ex){
            session.close();
            factory.close();
            ex.printStackTrace();
        }

    }
}
