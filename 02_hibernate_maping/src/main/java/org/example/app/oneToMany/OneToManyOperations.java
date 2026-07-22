package org.example.app.oneToMany;

import org.example.CommonHooks.InputHooks;
import org.example.Model.Car;
import org.example.Model.Persion;
import org.example.db_hooks.GetSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class OneToManyOperations {
    public static void main(String[] args) {
        insertPersion();
        getPersionWithcar();
    }

    public static void insertPersion(){
        String persionName= InputHooks.getStringValue("Enter the persion name");

        boolean iscarDetailsEnabled=true;

        Persion persion=new Persion();
        persion.setName(persionName);

        Set<Car>cars=new HashSet<>();

        while(iscarDetailsEnabled){

            Car car=new Car();

            car.setCar_Company(InputHooks.getStringValue("Enter the car company"));
            car.setCar_model(InputHooks.getStringValue("Enter the car model"));
            car.setCar_number(InputHooks.getInputValue("Enter car number"));
            car.setCarDistrict(InputHooks.getStringValue("Enter car district"));
            car.setPersion(persion);

            cars.add(car);

            iscarDetailsEnabled=InputHooks.getBooleanValue("To Enter car details enter true if not enter false");
        }

        persion.setCars(cars);

        Session session=null;
        Transaction transaction=null;
        try{
            session= GetSessionFactory.getSessionFactory().openSession();
            transaction=session.beginTransaction();

            session.persist(persion);
            transaction.commit();

        }catch (HibernateException exception){
            exception.printStackTrace();
            transaction.rollback();

        }finally {
            session.close();
        }
    }

    public static void getPersionWithcar(){
        Session session=null;
        int persionId=InputHooks.getInputValue("Enter persion unique id");

        try{
            session=GetSessionFactory.getSessionFactory().openSession();
            Persion persion=session.find(Persion.class,persionId);

            System.out.println("persion : "+persion);

            if(persion!=null){
                for (Car cars:persion.getCars()){
                    System.out.println(cars);
                };
            }


        }catch (HibernateException Exception){
            Exception.printStackTrace();
        }finally {
            session.close();
        }
    }
}
