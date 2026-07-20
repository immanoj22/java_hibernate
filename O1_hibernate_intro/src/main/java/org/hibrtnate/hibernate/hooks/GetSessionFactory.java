package org.hibrtnate.hibernate.hooks;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibrtnate.hibernate.app.Student_operation;
import org.hibrtnate.hibernate.model.Student;

public class GetSessionFactory {
    public static SessionFactory getConnectedSessionFactory(){
        return new Configuration().configure("Hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
    }
}
