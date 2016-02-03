package com.hibernate.controllerPKG;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dto.UserDetails;

public class UserDAO {
//	 static Connection currentCon = null; 
	// static ResultCursor rs = null;
	 public static UserDetails login(UserDetails bean) {
		 //preparing some objects for connection 
	//	 Statement stmt = null;
		 
			 String email = bean.getEmail();
			 String password = bean.getPassword(); 
		 
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//session.save(user);
			
			Query query=session.createQuery("from UserDetails where email='" + email + "' and password='" + password+"'" );
			
			@SuppressWarnings("rawtypes")
			
			List l= query.list();
			
			if(l.size()==0)
			{
				System.out.println("YOU ARE NOT A REGISTERED USER");
				
				bean.setValid(true);
			}
			else
				bean.setValid(true);
			
			session.getTransaction().commit();
			session.close();
			return bean;
			

	 }
		 
		 }
	 

