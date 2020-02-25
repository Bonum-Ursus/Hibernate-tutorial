package com.BonumUrsus.part1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class HibernateQueryExample {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            List<Student> studentList = session.createQuery("from Student").getResultList();
            studentList.forEach(student -> System.out.println(student));
            List<Student> studentList2 = session.createQuery("from Student s where s.id=4").getResultList();
            studentList2.forEach(student -> System.out.println(student));
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }

    }
}
