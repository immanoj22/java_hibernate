package org.example.app.HQl;

import org.hibernate.query.Query;
import org.example.Model.Student;
import org.example.db_hooks.GetSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;


public class HqlOPerations {
    public static void main(String[] args) {
        HqlOPerations hqlOPerations=new HqlOPerations();
        hqlOPerations.getAllStudent();
    }

    public void getAllStudent(){
        Session session=null;
        try{
            session= GetSessionFactory.getSessionFactory().openSession();
            Query<Student> query=session.createQuery("FROM Student", Student.class);
            List<Student> list=query.list();

            list.forEach((stu)-> System.out.println(stu));
        }catch (HibernateException exception){
            exception.printStackTrace();

        }finally {
            session.close();
        }
    }
}
