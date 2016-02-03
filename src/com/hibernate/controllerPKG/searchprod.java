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

/**
 * Servlet implementation class searchprod
 */
public class searchprod extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchprod() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String str= request.getParameter("search");
		System.out.println(str);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query= session.createQuery("FROM MovieClass WHERE LOWER(mname) LIKE '%"+str+"%'");
		
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
	
		//RequestDispatcher dspchr =  request.getRequestDispatcher("experi.jsp");
		
		//dspchr.forward(request,response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
