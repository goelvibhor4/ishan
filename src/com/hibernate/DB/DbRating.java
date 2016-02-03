package com.hibernate.DB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dto.FNVhash;
//import com.hibernate.dto.MovieClass;
import com.hibernate.dto.MovieRating;

/* use only when there is a change in column or want to check transactions */

public class DbRating {
	/*public void insert(String moviename,String moviedescription,String cast,String genre,java.sql.Timestamp releasedate){
		
		MovieClass mv= new MovieClass();	
		mv.setMcast(cast);
		mv.setMdescription(moviedescription);
		mv.setMid(FNVhash.hash64(moviename));
		mv.setMname(moviename);
		mv.setReleasedate(releasedate);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(mv);
		
		session.getTransaction().commit();
		session.close();
   
    }*/
	public static void main(String[] args){
		
		MovieRating mr = new MovieRating();
		
		mr.setMid(FNVhash.hash64("Singh Is Bliing"));
		mr.setUserid(FNVhash.hash64("ishan@gmail.com"));
		mr.setType(0);
		mr.setRating(5.6);
		mr.setReviews("bakwas");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(mr);
		 session.flush();
         session.clear();
		session.getTransaction().commit();
   }
}
