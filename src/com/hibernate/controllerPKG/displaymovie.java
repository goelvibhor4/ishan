package com.hibernate.controllerPKG;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dto.MovieClass;

public class displaymovie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public displaymovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int i;

		    	String mname="",mid="",mdescription="",mcast="",mreleasedate="";
		
		
			    Query query= session.createQuery("FROM MovieClass WHERE releasedate > current_timestamp ");
				List<MovieClass> l=query.list();
				for(i=0;i<l.size();i++){
					mname += l.get(i).getMname()+";";			
					mid += l.get(i).getMid()+";";
					}
				request.setAttribute("mname",mname);
				request.setAttribute("mid",mid);
			
					
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
