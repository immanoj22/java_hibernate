package org.hibrtnate.hibernate.Cache_hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibrtnate.hibernate.hooks.GetSessionFactory;
import org.hibrtnate.hibernate.model.Student;

public class LevelTwoCache {
    public static void main(String[] args) {
        SessionFactory sessionFactory = GetSessionFactory.getConnectedSessionFactory();
        Session session = null;
        Session session1 = null;
        try {
            // First Session - Query 1: DB hit (L1 & L2 cache miss)
            session = sessionFactory.openSession();
            Student stu = session.find(Student.class, 2);
            System.out.println("First Query (Session 1): " + stu.getName());

            // First Session - Query 2: L1 cache hit (same session, same object)
            Student stu1 = session.find(Student.class, 2);
            System.out.println("Second Query (Session 1): " + stu1.getName());

            // Second Session - Query 3: L2 cache hit (different session, but L2 cache shared)
            session1 = sessionFactory.openSession();
            Student stu2 = session1.find(Student.class, 2);
            System.out.println("Third Query (Session 2): " + stu2.getName());

        } catch (HibernateException exception) {
            exception.printStackTrace();
        } finally {
            if (session != null) session.close();
            if (session1 != null) session1.close();
            sessionFactory.close();
        }
    }
}
