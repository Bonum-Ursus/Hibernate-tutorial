package com.BonumUrsus;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            Student theStudent1 = new Student(
                    "Geralt", "from Rivia", "Geralt@gmail.com");
            Student theStudent2 = new Student(
                    "Yennefer", "from Belleteyn", "Yennefer@gmail.com");
            Student theStudent3 = new Student(
                    "Triss", "from Maribor ", "Triss@gmail.com");
            session.beginTransaction();
            session.save(theStudent1);
            session.save(theStudent2);
            session.save(theStudent3);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
