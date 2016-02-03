package com.hibernate.DB;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dto.AveragedMovieRating;
import com.hibernate.dto.MovieRating;

public class CalculateWeightedScore {

	public static void main(String args[]){
		
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
				Query query6= session.createQuery("FROM MovieRating where mid="+mid+" and type = 0");			
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
				
			Double toBeTruncated =  weightedScore;
	
			weightedScore =new BigDecimal(toBeTruncated ).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();	
			list1.get(i).setWeightedScore(weightedScore);
			
		}session.getTransaction().commit();
		session.close();
	}
}
