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
import com.hibernate.dto.MovieRating;

public class AveragedMovieRatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AveragedMovieRatingServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	
		Query query5= session.createQuery("FROM AveragedMovieRating");
		List <AveragedMovieRating> list1=query5.list();
		int len=list1.size();
		 //art where (from MovieRating where movieid=mid)
		for(int i=0;i<len;i++){
			long mid=list1.get(i).getMovieid();
			//if(list1.get(i).getMid()==list1.get(j).getMid()){
				Query query6= session.createQuery("FROM MovieRating where mid="+mid);			
				List <MovieRating> list2=query6.list();
			int len1=list2.size();
			int cnt=0;
			double score=0;
			System.out.println("len h yeh"+len1);
			for(int k=0;k<len1;k++){
				score+=list2.get(k).getRating();
				cnt++;
				
				
			}
			double weightedScore;
			if(cnt!=0){
			weightedScore=score/cnt;}
			else{
			 weightedScore=0.0;}
				System.out.println("score h yeh"+weightedScore);
			list1.get(i).setWeightedScore(weightedScore);
			
		}session.getTransaction().commit();
		session.close();}
					
		
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
