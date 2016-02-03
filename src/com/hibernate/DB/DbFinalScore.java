package com.hibernate.DB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dto.FNVhash;
import com.hibernate.dto.FinalScore;

public class DbFinalScore {
public static void main(String[] args){
		
		FinalScore fs =new FinalScore();
		
		fs.setCriticid(FNVhash.hash64("utpal@gmail.com"));
		fs.setUserid(FNVhash.hash64("ishan@gmail.com"));
		fs.setScore(8.8);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(fs);
		// session.flush();
         ///session.clear();
		session.getTransaction().commit();
}
}
