package com.hibernate.controllerPKG;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import org.omg.CORBA.FieldNameHelper;

import com.hibernate.dto.FNVhash;
import com.hibernate.dto.MovieRating;
//import com.hibernate.dto.MovieDetails;
import com.hibernate.dto.UserDetails;

/**
 * Servlet implementation class AuthenticationServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			System.out.println(request.getParameter("userName")+"  "+request.getParameter("password1"));
		UserDetails user = new UserDetails();
		
		String username=request.getParameter("userName");
		System.out.println("username1"+username);

		String password=request.getParameter("password1");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();
		System.out.println("username1"+username);

		user.setEmail(username);
		System.out.println("username1"+username);

		user.setPassword(password);
		System.out.println("username1"+username);
		System.out.println("username1"+username);

		long uid=FNVhash.hash64(username);	
		System.out.println("username1"+username);
		System.out.println("username1"+uid);

		
		user = UserDAO.login(user);
			if (user.isValid()&& username!= null && password!= null &&username!= "" && password!= "") {
				Query query2= (Query) session1.createQuery("FROM UserDetails WHERE userid ="+uid);
				
				List <UserDetails> l=query2.list();
				
				System.out.println("l ka size"+l.size());
				
				if(l.size() ==0 ){
					response.sendRedirect("login.jsp");
				}else{
					HttpSession session = request.getSession(true);
					int type=l.get(0).getType();
					String k=Integer.toString(type);
					System.out.println("gkiugkugug1"+k);
					 
					session.setAttribute("currentSessionUser",request.getParameter("userName"));
					session.setAttribute("currentSessionType",k);
					response.sendRedirect("index.jsp");
				}
				//logged-in page
				} 
			else 
				response.sendRedirect("login.jsp"); 
			
		} 
		catch (Throwable theException) 
		{ System.out.println(theException); }
	}
	
		
		//AuthUserDB authuser =new AuthUserDB();  
        
		//authuser.checkDB(request.getParameter("email"),request.getParameter("password"));
	    
    
	
	}

