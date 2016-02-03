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

import com.hibernate.dto.AveragedMovieRating;
import com.hibernate.dto.MovieClass;
import com.hibernate.dto.MovieRating;
import com.hibernate.dto.UserDetails;


public class aboutmovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public aboutmovie() {
        super();
     
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		Long mId=null ;
		
	
		  if(request.getParameter("mId")!=null){
				mId = Long.parseLong(request.getParameter("mId")); 
				
				System.out.println(mId);
		
				/* Movie Details  */
			    Query query= session.createQuery("FROM MovieClass WHERE mid="+mId);
			    
			    List<MovieClass> l= query.list();
			    String mname=l.get(0).getMname(),mdescription=l.get(0).getMdescription(),mcast=l.get(0).getMcast();
			    
			   // System.out.println(l.get(0).getMname()+l.get(0).getMname()+l.get(0).getMdescription()+l.get(0).getMcast());					
			    request.setAttribute("m-Id",mId);
			    request.setAttribute("m-name",mname);
				request.setAttribute("m-description",mdescription);
				request.setAttribute("m-cast",mcast);
				request.setAttribute("m-releasedate",l.get(0).getReleasedate());
			
				//	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				//Session session = sessionFactory.openSession();
				//session.beginTransaction();
				
				/* Critic reviews  */
				
				Query query1= session.createQuery("FROM MovieRating WHERE type=" +1+"AND mId="+mId+"");
				
				List <MovieRating> m=query1.list();
				if(m.size()!=0){
				String [] criticname=new String[m.size()];
				String [] criticreviews=new String[m.size()];
				double [] criticrating=new double[m.size()];
				try{
				for(int i=0;i<m.size();i++){
					long cid=m.get(i).getUserid();
				
					Query query2= session.createQuery("FROM UserDetails WHERE userid="+cid+"");
				
					List <UserDetails> n=query2.list();
					
					criticname[i]=n.get(0).getUsername();
					criticreviews[i]=m.get(i).getReviews();
					criticrating[i]=m.get(i).getRating();
					
				}}catch(Exception e){System.out.println("error from try 1"+e);}
				
				request.setAttribute("criticname", criticname);
				request.setAttribute("criticreviews", criticreviews);
				request.setAttribute("criticrating", criticrating);
				request.setAttribute("criticsize", m.size());  
				}
				/* User reviews  */
				
				Query query3= session.createQuery("FROM MovieRating WHERE type="+0+"AND mId="+mId+"");
				
				List <MovieRating> m1=query3.list();
				if(m1.size()!=0){
				String [] username = new String[ m1.size() ];
				String [] userreviews = new String[ m1.size() ];
				double [] userrating = new double[ m1.size() ];
				
				System.out.println(m1.size());
				try{
				for(int i=0;i<m1.size();i++){
					long uid = m1.get(i).getUserid(); //get(0)
					System.out.println( "uid"+uid );
					Query query4= session.createQuery("FROM UserDetails WHERE userid="+uid+"");
					
					List <UserDetails> n1=query4.list();
					
					username[i]=n1.get(0).getUsername();// get(0)
					userreviews[i]=m1.get(i).getReviews();
					userrating[i]=m1.get(i).getRating();
					
				}
				}catch(Exception e){System.out.println("error from try 2"+e);}
				
				request.setAttribute("username", username);
				request.setAttribute("userreviews", userreviews);
				request.setAttribute("userrating", userrating);
				request.setAttribute("usersize", m1.size());
				}
				Query query4= session.createQuery("FROM AveragedMovieRating where movieid="+mId);
				
				List <AveragedMovieRating> list1=query4.list();  
				request.setAttribute("weightedScore",list1.get(0).getWeightedScore() );
				
				RequestDispatcher dspchr =  request.getRequestDispatcher("AboutMovie.jsp");
			
				dspchr.forward(request,response);
				
		  }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
