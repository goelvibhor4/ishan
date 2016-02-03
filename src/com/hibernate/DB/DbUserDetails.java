package com.hibernate.DB;

//import com.hibernate.dto.MovieDetails;
import com.hibernate.dto.FNVhash;
import com.hibernate.dto.SHA512;
import com.hibernate.dto.UserDetails;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DbUserDetails {
	
	
	public void insert(String email,String userName,int dobmonth,int dobday,int dobyear,String city,String gender,String password,int type){
	UserDetails user = new UserDetails(); 
	SHA512 sha512 = new SHA512();
	
    user.setUserid(FNVhash.hash64(email));
    user.setEmail(email);
    user.setUsername(userName);
	user.setMonth(dobmonth);
	user.setDate(dobday);
	user.setYear(dobyear);
	user.setCity(city);
	user.setGender(gender);
	try {
		user.setPassword(sha512.hashText(password));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	user.setType(0);
	
	/* user.setEmail("e");	    user.setUsername("sh");		user.setMonth(2);		user.setDate(3);		user.setYear(1990);		user.setCity("d");		user.setGender("male");		user.setPassword("1");		user.setType(0);*/
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
	}
}