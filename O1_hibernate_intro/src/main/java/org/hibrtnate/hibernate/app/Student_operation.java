package org.hibrtnate.hibernate.app;

import org.hibernate.*;
import org.hibrtnate.hibernate.hooks.GetSessionFactory;
import org.hibrtnate.hibernate.model.Student;

public class Student_operation {
    public String insertNewStudent(String name,int age,String gender,String department){
        SessionFactory sessionFactory=GetSessionFactory.getConnectedSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        String message="processsing data";
        System.out.println(message);
        try{
            Student student=new Student();
//            student.setStudentId(id);
            student.setName(name);
            student.setStudentAge(age);
            student.setStudentGender(gender);
            student.setStudentDepartment(department);

            session.persist(student);
            transaction.commit();
            message="Student data added succesfully";
        }catch(Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
            message=e.getMessage();
        }finally {
            session.close();
        }
        return message;

    }

    public String updateStudent(String name,int age,String gender,String department){
        SessionFactory sessionFactory=GetSessionFactory.getConnectedSessionFactory();
        Session session=null;
        Transaction transaction=null;
        boolean transactionStatus=false;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();

            Student student=new Student();
//            student.setStudentId(id);
            student.setName(name);
            student.setStudentAge(age);
            student.setStudentGender(gender);
            student.setStudentDepartment(department);

            session.merge(student);
            transactionStatus=true;
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            if(transactionStatus){
                transaction.commit();
            }else{
                transaction.rollback();
            }
        }

        return transactionStatus?"Operation success":"operation Failed";

    }

    public String deleteStudent(String name,int age,String gender,String department){
        SessionFactory sessionFactory=GetSessionFactory.getConnectedSessionFactory();
        Session session=null;
        Transaction transaction=null;
        boolean transactionStatus=false;
        try{
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();

            Student student=new Student();
//            student.setStudentId(id);
            student.setName(name);
            student.setStudentAge(age);
            student.setStudentGender(gender);
            student.setStudentDepartment(department);

            session.remove(student);
            transactionStatus=true;
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            if(transactionStatus){
                transaction.commit();
            }else{
                transaction.rollback();
            }
        }

        return transactionStatus?"Operation success":"operation Failed";

    }
    public Student getStudent(int id){
        SessionFactory sessionFactory=GetSessionFactory.getConnectedSessionFactory();
        Session session=null;
        Student student=null;
        try{
            session=sessionFactory.openSession();
            student=session.find(Student.class,id);
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
        return student;
    }

}
