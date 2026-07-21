package org.example.db_hooks;

import org.example.Model.Answer;
import org.example.Model.Question;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetSessionFactory {
    public static SessionFactory getSessionFactory(){
        return new Configuration().configure("hibernate.cfg.xml").addAnnotatedClasses(Question.class, Answer.class).buildSessionFactory();
    }
}
