package com.BonumUrsus.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ExecutableClass {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-many-to-many.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

//            Course course = new Course("Ship navigation");
//            session.save(course);
//
//            Student student1 = new Student("Garry", "The Pirat", "Garry@gmail.com");
//            Student student2 = new Student("Johny", "The Pirat", "Johny@gmail.com");
//            Student student3 = new Student("Kuk", "The Pirat", "Kuk@gmail.com");
//
//            course.addStudent(student1);
//            course.addStudent(student2);
//            course.addStudent(student3);
//
//            session.save(student1);
//            session.save(student2);
//            session.save(student3);

            Student student = session.get(Student.class, 3);
            Course course = new Course("Sail like the God");
            student.addCourse(course);
//            session.save(student);
            session.save(course);


            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }

    }
}
