package com.hibernate.controllerPKG;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dto.MovieClass;

public class MovieSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MovieSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String str= request.getParameter("search");
		if(str !=null || str!=""){
			
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	    
		
		Query query= session.createQuery("FROM MovieClass WHERE UPPER(mname) LIKE UPPER('%" +str+"%')");
		
		List<MovieClass> l=query.list();
		int i;
		String mname="",mid="";
		
		System.out.println(l.size());
		
		for(i=0;i<l.size();i++){
			mname += l.get(i).getMname()+";";			
			mid += l.get(i).getMid()+";";
			
	
		if(i == 10) break;
		}
		
		request.setAttribute("mname",mname);
		request.setAttribute("mid",mid);
		System.out.println("ans"+request.getPathInfo());
	
		RequestDispatcher dspchr =  request.getRequestDispatcher("srh.jsp");
		
		dspchr.forward(request,response);
		}
		
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
