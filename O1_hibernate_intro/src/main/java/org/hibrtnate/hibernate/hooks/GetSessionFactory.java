package org.hibrtnate.hibernate.hooks;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetSessionFactory {
    public static SessionFactory getConnectedSessionFactory(){
        return new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
    }
}
