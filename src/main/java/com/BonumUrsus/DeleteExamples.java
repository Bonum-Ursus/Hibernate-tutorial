package com.BonumUrsus;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteExamples {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            // Version 1
            Student student = session.get(Student.class, 1);
            session.delete(student);

            // Version 2
            session.createQuery("delete from Student where id=1").executeUpdate();

            session.getTransaction().commit();
        }finally {
            factory.close();
        }

    }
}
