package com.hibernate.controllerPKG;

import java.io.IOException;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.DB.DbMovieDetails;
import com.hibernate.dto.AveragedMovieRating;
import com.hibernate.dto.FNVhash;


public class movieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private String moviename="";
	   private String moviedescription ="";
	   private String cast="";
	   private String genre="";
	   java.sql.Timestamp releasedate;
	   private String showtype;
	   
    public movieServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		moviename=request.getParameter("moviename");
		moviedescription=request.getParameter("moviedescription");
		cast=request.getParameter("cast");
		genre=request.getParameter("genre");
		showtype=request.getParameter("showtype");
		
				
		try{
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    Date parsedDate = dateFormat.parse(request.getParameter("releasedate"));
		     releasedate = new java.sql.Timestamp(parsedDate.getTime());
		}catch(Exception e){
		}
		
		DbMovieDetails user1= new DbMovieDetails();
		user1.insert(moviename, moviedescription, cast, genre, releasedate,showtype);
		
		//Initialize movie's weighted average score to zero
		
		AveragedMovieRating amr = new AveragedMovieRating();
		// for all users
		amr.setMovieid(FNVhash.hash64(moviename));
		amr.setUsertype(0);
		amr.setWeightedScore(0.0);
		amr.setShowtype(showtype);
		
		//for all critics
		amr.setMovieid(FNVhash.hash64(moviename));
		amr.setUsertype(1);
		amr.setWeightedScore(0.0);
		amr.setShowtype(showtype);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(amr);		
		session.getTransaction().commit();
		session.close();
		
		response.sendRedirect("movie.jsp");

	}

}
