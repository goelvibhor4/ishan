package com.hibernate.DB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dto.FNVhash;
import com.hibernate.dto.MovieClass;

public class DbMovieDetails {
		public void insert(String moviename,String moviedescription,String cast,String genre,java.sql.Timestamp releasedate,String showtype){
	
		MovieClass mv= new MovieClass();	
		
		mv.setMcast(cast);
		mv.setMdescription(moviedescription);
		mv.setMid(FNVhash.hash64(moviename));
		mv.setMname(moviename);
		mv.setReleasedate(releasedate);
		mv.setGenre(genre);
		mv.setShowtype(showtype);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(mv);		
		session.getTransaction().commit();
		session.close();
   
    }
	/*
	public static void main(String[] args){
		
		MovieClass mv= new MovieClass();	
		mv.setMcast("fuck fuck fuck");
		mv.setMdescription("");
		mv.setMid(FNVhash.hash64("tere bin"));
		mv.setMname("tere bin laden");
		mv.setGenre("genre test");
		mv.setShowtype("");
				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(mv);
		// session.flush();
         //session.clear();
		session.getTransaction().commit();
		//session.close();
    
	}*/

	
}
