package org.hibrtnate.hibernate.Cache_hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibrtnate.hibernate.hooks.GetSessionFactory;
import org.hibrtnate.hibernate.model.Student;

public class LevelTwoCache {
    public static void main(String[] args) {
        SessionFactory sessionFactory= GetSessionFactory.getConnectedSessionFactory();
        Session session=null;
        Session session1=null;
        try{
            session=sessionFactory.openSession();
            Student stu=session.find(Student.class,2);
            System.out.println(stu.getName());

            Student stu1=session.find(Student.class,2);
            System.out.println(stu1.getName());

            session1=sessionFactory.openSession();
            Student stu2=session1.find(Student.class,2);
            System.out.println(stu2.getName());

        }catch(HibernateException exception){
            exception.printStackTrace();
        }finally{
            sessionFactory.close();
            session1.close();
            session.close();
        }
    }
}
