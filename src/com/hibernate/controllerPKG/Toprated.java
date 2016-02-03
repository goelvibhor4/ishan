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

import com.hibernate.dto.AveragedMovieRating;
import com.hibernate.dto.FinalScore;
import com.hibernate.dto.MovieClass;
import com.hibernate.dto.MovieRating;
import com.hibernate.dto.UserDetails;

/**
 * Servlet implementation class Toprated
 */
public class Toprated extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Toprated() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query4= session.createQuery("FROM AveragedMovieRating where usertype = 0 and showtype like 'movie' order by weightedScore DESC ");
		
		List <AveragedMovieRating> list1=query4.list();
		System.out.println(list1.size()+" list1 ka size");
		
		String [] mname6=new String[list1.size()];
		String [] mdescription6=new String[list1.size()];
		double [] mrating6=new double[list1.size()];
		long [] movieid=new long[list1.size()];
		
		if(list1.size()!=0)
		{
		
			for(int i=0;i<list1.size();i++){
				long mid1=list1.get(i).getMovieid();
				try{					
					
					Query query7= session.createQuery("FROM MovieClass WHERE mid=" +mid1+"");
					List <MovieClass> list4=query7.list();
					
					if(list4.size() == 0) break;
					
					mname6[i] = list4.get(0).getMname();			
					
					
					mrating6[i]=list1.get(i).getWeightedScore();
					movieid[i]=list1.get(i).getMovieid();
				
				}catch(Exception e){System.out.println(e);}
			}						
				request.setAttribute("movieid",movieid);
				request.setAttribute("mname6",mname6);
				request.setAttribute("mdescription6",mdescription6);
				request.setAttribute("mrating6",mrating6);					
				
		}
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
