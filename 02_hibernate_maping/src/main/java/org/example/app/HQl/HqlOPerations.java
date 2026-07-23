package org.example.app.HQl;

import org.example.CommonHooks.InputHooks;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.example.Model.Student;
import org.example.db_hooks.GetSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;


public class HqlOPerations {
    public static void main(String[] args) {
        HqlOPerations hqlOPerations=new HqlOPerations();
        hqlOPerations.GetStudentOnlyName();
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

    public void GetStudentByname(){
        String name= InputHooks.getStringValue("Enter the student name");
        Session session=null;

        try{
            session=GetSessionFactory.getSessionFactory().openSession();
            Query<Student> query=session.createQuery("from Student where name = :stname",Student.class).setParameter("stname",name);
            for(Student stu:query.list()){
                System.out.println(stu);
            }
        }catch(HibernateException exception){
            exception.printStackTrace();
        }
    }

    public void GetStudentOnlyName(){
        String name= InputHooks.getStringValue("Enter the student name");
        Session session=null;

        try{
            session=GetSessionFactory.getSessionFactory().openSession();
            Query<String> query=session.createQuery("select name from Student where name = :stname",String.class).setParameter("stname",name);
            for(String stu:query.list()){
                System.out.println(stu);
            }
        }catch(HibernateException exception){
            exception.printStackTrace();
        }
    }

    public void updateAlllist(){
        Session session=null;
        String college= InputHooks.getStringValue("Enter the student college");
        String name= InputHooks.getStringValue("Enter the student name");
        Transaction transaction=null;
        try{
            session=GetSessionFactory.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            int rowsAffected=session.createQuery("update Student set college = :sclg where name = :stname and college != :scollege")
                    .setParameter("stname",name)
                    .setParameter("scollege",college)
                    .setParameter("sclg",name)
                    .executeUpdate();
            transaction.commit();
        }catch(HibernateException exception){
            exception.printStackTrace();
        }finally {
            session.close();
//            transact
        }
    }
}
