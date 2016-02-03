<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="Movie">
		<div class = "upcomingMovie">
		    <header>Upcoming</header>
		        <div class="view view-fifth">
		        
				<jsp:include page="/displaymovie"  />
								
				<%
			
			      if(request.getAttribute("mname")!=null){
			    	        
			    	    	String mname = (String)request.getAttribute("mname"),mId=(String)request.getAttribute("mid");
			    	    	
			    	    	String namelist[] =new String[10],mid[] = new String[10];
			    	    	
			    	    	namelist = mname.split(";");
			    	    	mid = mId.split(";");
			    	    	
			    	    	for(int i = 0; i < namelist.length; i++){
			    	    	
			    	  
			    %>
                    <img src="images/<%out.println(namelist[i]);%>.jpg" />
                    <div class="mask">
                        <h2><%out.println(namelist[i]);%></h2>
                        <p>N Stars</p>
                        <form action="aboutmovie" method="get">	<button name="mId" type="submit" value=<%out.println(mid[i]); %>>Info</button></form>
				
			</div>
                   <%	}
			    	  }
			        %> 
                </div>
			   				
            </div>
			
		<div class = "allMovie" >
		   <header>All</header>
		        <div class="view view-fifth">
                    <img src="images/1.jpg" />
                    <div class="mask">
                        <h2>Hover Style #5</h2>
                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
                        <a href="AboutMovie.jsp?mId=1" class="info">Read More</a>
                    </div>
                </div>
                				
            </div>
       </div>
	   
 