package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Config {
	private static final SessionFactory sessionFactory = 
			buildSessionFactory();
			
	private static SessionFactory buildSessionFactory(){
		return 
			new Configuration().configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
