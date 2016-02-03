package com.hibernate.controllerPKG;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;





import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.DB.DbRating;
import com.hibernate.dto.FNVhash;
import com.hibernate.dto.MovieRating;

public class RatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public RatingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long mId=null ;
		if(request.getParameter("reviews")!=null && request.getParameter("sliderinput")!=null){
		String review=request.getParameter("reviews");
		Double sliderinput = Double.parseDouble(request.getParameter("sliderinput"));
		Double toBeTruncated = sliderinput;
		
		sliderinput =new BigDecimal(toBeTruncated ).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

		if(request.getParameter("mId")!=null ){
			
			mId = Long.parseLong(request.getParameter("mId")); 
			request.setAttribute("m-Id",mId);
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		long uId=FNVhash.hash64( (String)request.getSession().getAttribute("currentSessionUser"));
		int type =  Integer.parseInt((String)request.getSession().getAttribute("currentSessionType"));
		MovieRating rate=new MovieRating();
		
		
		Query query2= (Query) session.createQuery("FROM MovieRating WHERE userid ="+uId+"and mid="+mId+"");
		
		List <MovieRating> l=query2.list();
		
		if( l.size()!=0 ){
			l.get(0).setRating(sliderinput);
			l.get(0).setReviews(review);
		}
		else{
		
		rate.setMid(mId);
//		rate.setUserid(FNVhash.hash64( session.getAttribute( "currentSessionUser")));
		rate.setUserid(uId);
		rate.setType(type);
		rate.setRating(sliderinput);
		rate.setReviews(review);
		session.save(rate);
			
		
		}
		session.getTransaction().commit();
		session.close();
				
		RequestDispatcher dspchr =  request.getRequestDispatcher("aboutmovie");
		
		dspchr.forward(request,response);
}}else{
	RequestDispatcher dspchr =  request.getRequestDispatcher("index.jsp");
	dspchr.forward(request,response);

}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

}}
