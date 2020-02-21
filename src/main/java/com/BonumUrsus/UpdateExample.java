package com.BonumUrsus;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateExample {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            Student student = session.get(Student.class, 4);
            student.setFirstName("Yenn");
            session.save(student);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
