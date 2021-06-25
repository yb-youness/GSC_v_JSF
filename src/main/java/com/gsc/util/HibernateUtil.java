package com.gsc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class HibernateUtil {

	private static SessionFactory sessionFactoryObj = buildSessionFactoryObj();

	public static SessionFactory buildSessionFactoryObj() {
		try {
			sessionFactoryObj = new Configuration().configure().buildSessionFactory();
		} catch (ExceptionInInitializerError exceptionObj) {
			exceptionObj.printStackTrace();
		}
		return sessionFactoryObj;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactoryObj;
	}
	

}