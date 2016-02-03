package com.hibernate.controllerPKG;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import javax.servlet.http.HttpSession;



import javax.servlet.http.HttpSession;

//import com.hibernate.DB.AuthUserDB;
import com.hibernate.DB.DbUserDetails;



public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID =  1L;    
	
	private String userName="";
	private String password="";
	private String email="";
	private String city="";
	private String gender="";
	private int dobmonth=0;
	private int dobday=0;
	private int dobyear=0;
	private int type;
	
	
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	    userName = request.getParameter("userName");
        password = request.getParameter("password1");
        email = request.getParameter("email");
        city = request.getParameter("city");
        gender = request.getParameter("gender");
        dobmonth = Integer.parseInt(request.getParameter("DOBMonth"));
        dobday = Integer.parseInt(request.getParameter("DOBDay"));
        dobyear = Integer.parseInt(request.getParameter("DOBYear"));
        type =0;
        
        
			HttpSession session = request.getSession(true); 
			session.setAttribute("currentSessionUser",userName); 
			session.setAttribute("currentSessionType","0");
			
            DbUserDetails user = new DbUserDetails();
            user.insert( email, userName,dobmonth, dobday, dobyear,city,gender, password,type);
            
            
            response.sendRedirect("index.jsp");
        

		
	}
	
}
