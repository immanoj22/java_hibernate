package org.example.app.manyToOne;

import org.example.CommonHooks.InputHooks;
import org.example.Model.Car;
import org.example.Model.Persion;
import org.example.db_hooks.GetSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class ManyToOneOperations {
    public static void main(String[] args) {
        getCarsToPersion();
    }
    public static void getCarsToPersion(){
        int carId= InputHooks.getInputValue("Enter the car Id");

        Session session=null;

        try{
            session= GetSessionFactory.getSessionFactory().openSession();
            Car car=session.find(Car.class,carId);
            System.out.println(car);
            System.out.println(car.getPersion());
        }catch (HibernateException exception){
            System.out.println(exception.getMessage());
        }finally {
            session.close();
        }
    }
}
