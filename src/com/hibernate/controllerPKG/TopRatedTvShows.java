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
import com.hibernate.dto.MovieClass;

/**
 * Servlet implementation class TopRatedTvShows
 */
public class TopRatedTvShows extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopRatedTvShows() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query4= session.createQuery("FROM AveragedMovieRating where usertype = 0  and showtype like 'TvShow' order by weightedScore DESC");
		
		List <AveragedMovieRating> list1=query4.list();
		System.out.println(list1.size()+" tvshow ka size");
		
		String [] TvShowname6=new String[list1.size()];
		String [] TvShowdescription6=new String[list1.size()];
		double [] TvShowrating6=new double[list1.size()];
		long [] TvShowid=new long[list1.size()];
		
		 int count=0;
		 
		if(list1.size()!=0)
		{
		   
			for(int i=0;i<list1.size();i++){
				long mid1=list1.get(i).getMovieid();
				try{
					if(list1.get(i).getWeightedScore() > 5 ){		
					Query query7= session.createQuery("FROM MovieClass WHERE mid=" +mid1+"");
					List <MovieClass> list4=query7.list();
					
					
						TvShowname6[count] = list4.get(0).getMname();			
										
						TvShowrating6[count]=list1.get(i).getWeightedScore();
						TvShowid[count]=list1.get(i).getMovieid();
						count++;
					}
					
				}catch(Exception e){System.out.println(e);
				 
				}
			}
				if(count!=0){
				request.setAttribute("TvShowid",TvShowid);
				request.setAttribute("TvShowname6",TvShowname6);
				request.setAttribute("TvShowdescription6",TvShowdescription6);
				request.setAttribute("TvShowrating6",TvShowrating6);	
				
				}
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
