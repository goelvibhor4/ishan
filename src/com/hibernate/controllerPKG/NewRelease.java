package com.hibernate.controllerPKG;

import java.io.IOException;
import java.security.Timestamp;
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

/**
 * Servlet implementation class NewRelease
 */
public class NewRelease extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRelease() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		int i;

		    	String mname="",mid="",mdescription="",mcast="",mreleasedate="";
		//Timestamp newtime=new Timestamp(2015-01-01 00:00:00);
		
			    Query query= session.createQuery("FROM MovieClass WHERE releasedate <= current_timestamp  ORDER BY releasedate  DESC");
				List<MovieClass> l=query.list();
				for(i=0;i<3;i++){
					mname += l.get(i).getMname()+";";			
					mid += l.get(i).getMid()+";";
					}
				request.setAttribute("mname",mname);
				request.setAttribute("mid",mid);
				}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
