package com.BonumUrsus.part1;

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
            student.setFirstName("Yennefer");

//            session.createQuery("UPDATE Student set email='witcher.characters@gmal.com'")
//                    .executeUpdate();

            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
