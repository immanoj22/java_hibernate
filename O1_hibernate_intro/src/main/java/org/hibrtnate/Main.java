package org.hibrtnate;

import org.hibrtnate.hibernate.app.Student_operation;
import org.hibrtnate.hibernate.hooks.ScannerHook;
import org.hibrtnate.hibernate.model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

//        insertStudent();
//        updateStudent();
//        delteStudent();
        getStudent();

    }
    public static void insertStudent(){

        int id= ScannerHook.getNumericScannerValue("Enter a preffered student Id :");

        String name=ScannerHook.getStringScannerValue("Enter student name :");

        int age=ScannerHook.getNumericScannerValue("Enter student age :");

        String gender=ScannerHook.getStringScannerValue("Enter student gender :");

        String department=ScannerHook.getStringScannerValue("Student department :");

        Student_operation newoperation=new Student_operation();

        String message=newoperation.insertNewStudent(id,name,age,gender,department);

        System.out.println(message);

    }

    public static void updateStudent(){

        int id= ScannerHook.getNumericScannerValue("Enter a preffered student Id :");

        String name=ScannerHook.getStringScannerValue("Enter student name :");

        int age=ScannerHook.getNumericScannerValue("Enter student age :");

        String gender=ScannerHook.getStringScannerValue("Enter student gender :");

        String department=ScannerHook.getStringScannerValue("Student department :");

        Student_operation newoperation=new Student_operation();

        String message=newoperation.updateStudent(id,name,age,gender,department);

        System.out.println(message);

    }

    public static void delteStudent(){

        int id= ScannerHook.getNumericScannerValue("Enter a preffered student Id :");

        String name=ScannerHook.getStringScannerValue("Enter student name :");

        int age=ScannerHook.getNumericScannerValue("Enter student age :");

        String gender=ScannerHook.getStringScannerValue("Enter student gender :");

        String department=ScannerHook.getStringScannerValue("Student department :");

        Student_operation newoperation=new Student_operation();

        String message=newoperation.deleteStudent(id,name,age,gender,department);

        System.out.println(message);

    }

    public static void getStudent(){
        Student_operation newoperation=new Student_operation();
        Student student=newoperation.getStudent(ScannerHook.getNumericScannerValue("Enter student id :"));
        System.out.println(student.getName());
    }

}