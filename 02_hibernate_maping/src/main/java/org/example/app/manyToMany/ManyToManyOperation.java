package org.example.app.manyToMany;

import org.example.CommonHooks.InputHooks;
import org.example.Model.Course;
import org.example.Model.Student;
import org.example.db_hooks.GetSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class ManyToManyOperation {
    public static void main(String[] args) {
//        insertNewStudentAndCourse();
        getStudentCourses();
    }

    public static void insertNewStudentAndCourse(){

        Student student=new Student();


        Session session=null;
        Transaction transaction=null;

        student.setCollege(InputHooks.getStringValue("Enter the college name"));
        student.setAge(InputHooks.getInputValue("Enter the age"));
        student.setName(InputHooks.getStringValue("Enter the name"));

        boolean value=true;
        Set<Course>courses=new HashSet<>();

        Set<Student>students=new HashSet<>();
        students.add(student);
        while (value){

            Course course=new Course();
            course.setCourseName(InputHooks.getStringValue("Enter the course name"));
            course.setStudent(students);
            courses.add(course);

            value=InputHooks.getBooleanValue("Need another course");
        }

        student.setCourses(courses);

        try{
            session= GetSessionFactory.getSessionFactory().openSession();
            transaction=session.beginTransaction();
            session.persist(student);
            transaction.commit();
        }catch(HibernateException exception){
            exception.printStackTrace();
        }finally {
            session.close();
        }
    }

    public static void getStudentCourses(){
        Session session=null;
        int studentId=InputHooks.getInputValue("Enter the student id");

        try{
            session=GetSessionFactory.getSessionFactory().openSession();
            Student student=session.find(Student.class,studentId);
            System.out.println(student);
            for(Course course:student.getCourses()){
                System.out.println(course);
            }

        }catch (HibernateException exception){
            exception.getMessage();
        }finally {
            session.close();
        }
    }
}
