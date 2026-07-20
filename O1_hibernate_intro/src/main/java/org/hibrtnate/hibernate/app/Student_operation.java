package org.hibrtnate.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibrtnate.hibernate.hooks.GetSessionFactory;
import org.hibrtnate.hibernate.model.Student;

public class Student_operation {
    public String insertNewStudent(int id,String name,int age,String gender,String department){
        SessionFactory sessionFactory=GetSessionFactory.getConnectedSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        String message="processsing data";
        System.out.println(message);
        try{
            Student student=new Student();
            student.setStudentId(id);
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

}
