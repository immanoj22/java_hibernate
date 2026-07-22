package org.example.db_hooks;

import org.example.Model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetSessionFactory {
    public static SessionFactory getSessionFactory(){
        return new Configuration().configure("hibernate.cfg.xml").addAnnotatedClasses(Question.class, Answer.class, Car.class, Persion.class, Student.class,Course.class).buildSessionFactory();
    }
}
