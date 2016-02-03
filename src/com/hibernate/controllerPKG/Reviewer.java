package com.hibernate.controllerPKG;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.dto.FinalScore;
import com.hibernate.dto.MovieClass;
import com.hibernate.dto.Pearson;
import com.hibernate.dto.FNVhash;
import com.hibernate.dto.MovieRating;
import com.hibernate.dto.UserDetails;


public class Reviewer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Reviewer() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		long uId=FNVhash.hash64( (String)request.getSession().getAttribute("currentSessionUser"));
	
		Query query= session.createQuery("FROM MovieRating WHERE userid=" +uId+"");
		   List <MovieRating> l=query.list();	
		   
		   System.out.println(l.size()+"l ka size");
		   long [] arr= new long[l.size()];
		   double [] arr1= new double[l.size()];
		   
		   Vector<Double> vuser= new Vector();
    	   Vector<Double> vcritic= new Vector();

    	   for(int i=0;i<l.size();i=i+1){
	           arr[i]=l.get(i).getMid();
	           arr1[i]=l.get(i).getRating();
	           System.out.println(arr1[i]);
	           vuser.add(arr1[i]);
    	   }

		Query query1= session.createQuery("FROM UserDetails WHERE type=" +1+"");

		List <UserDetails> m=query1.list();	
		
		System.out.println(m.size()+"m ka size");
		
		FinalScore scored =new FinalScore();
		Pearson pson = new Pearson();
		
		for(int j=0;j<m.size();j++){

		long cid = m.get(j).getUserid();
		
		//set the cid in the database also the usid 
		System.out.println(cid+"critic ki id");
		
		Query query2= session.createQuery("FROM MovieRating WHERE userid="+cid+"");
		List <MovieRating> t = query2.list();	
		System.out.println(t.size()+"t ka size");
	
		int cnt=0;
		double [] arr2= new double[l.size()];
		
		if(t.size()!=0){
			for (int k=0,h=0;k<t.size() && h<l.size();k++)
			{	
				System.out.println(k+" k h ");
				System.out.println(h+" h h ");
				
				if(arr[h]==t.get(k).getMid())
				{
					arr2[h]=t.get(k).getRating();
					System.out.println(arr2[h]);
					vcritic.add(arr2[h]);
					h=h+1;
					k=-1;
					cnt=0;
					
				}
				else
					cnt++;
				if(cnt==t.size()){
					arr2[h]=0;
					System.out.println(arr2[h]);
					vcritic.add(arr2[h]);
					h=h+1;
					k=-1;
					cnt=0;
					
					
				}
			}
	//Vector<Double> vuser;
	//vuser = new Vector(Arrays.asList(arr1));
	//	Vector<Double> vcritic = new Vector(Arrays.asList(arr2));
    //	FinalScore scored =new FinalScore();
    //	Pearson pson = new Pearson();
	//double score=pson.GetCorrelation(vuser,vcritic);
	
			double score=pson.GetCorrelation(vuser,vcritic);
			vcritic.clear();
			
			SessionFactory sessionFactory1 = new Configuration().configure().buildSessionFactory();
			Session session1 = sessionFactory1.openSession();
			session1.beginTransaction();
			
			System.out.println(score +" pearson ka score ");
			
			Query quer= session1.createQuery("FROM FinalScore WHERE userid="+uId+" and criticid="+cid+"");
			
			List <FinalScore> t1=quer.list();	
			
			System.out.println(t1.size()+"t1 ka size");
			
			if(t1.size()!=0){
				t1.get(0).setScore(score);
	
			}
			else
			{
				scored.setScore(score);
				scored.setCriticid(cid);
				scored.setUserid(uId);
				//set score
				session1.save(scored);
				
			}
		session1.getTransaction().commit();
		}
	}
		
	
	Query query4= session.createQuery("FROM FinalScore WHERE userid=" +uId+" order by score DESC");
	
	List <FinalScore> list1=query4.list();
	
	System.out.println(list1.size()+" list1 ka size");
	
	if(list1.size()!=0)
	{	long cid1=list1.get(0).getCriticid();
		
		Query query5= session.createQuery("FROM UserDetails WHERE userid=" +cid1+"");
		List <UserDetails> list2=query5.list();
		
		String cname=list2.get(0).getUsername();
		
		Query query6= session.createQuery("FROM MovieRating WHERE userid=" +cid1+" order by rating DESC");
		
		List <MovieRating> list3=query6.list();
		
		String [] mname1=new String[list3.size()];
		String [] mdescription1=new String[list3.size()];
		double [] mrating=new double[list3.size()];
		long[] mid1=new long[list3.size()];
		
		for(int i=0;i<list3.size();i++){
			mid1[i]=list3.get(i).getMid();
			Query query7= session.createQuery("FROM MovieClass WHERE mid=" +mid1[i]+"");
			List <MovieClass> list4=query7.list();
			
			mname1[i] = list4.get(0).getMname();			
		//	mid2 = list3.get(0).getMid();
			mdescription1[i]=list3.get(i).getReviews();
			mrating[i]=list3.get(i).getRating();
		}
	
		String k="yes";
		String q="";
		
	
		if(l.size()>=2)
		{   request.setAttribute("toenter",k);
			request.setAttribute("mname1",mname1);
			request.setAttribute("mdescription1",mdescription1);
			request.setAttribute("mrating",mrating);
			request.setAttribute("movieid",mid1);
			//request.setAttribute("size",);    FOR BAWANIYA
			System.out.println("kgusgigsiygfsigfsi]ygsiug"+k);
		}
		else
		{
			request.setAttribute("toenter",q);
		}		
	}	
	
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
