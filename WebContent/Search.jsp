		<% 
		
		      if((String)request.getAttribute("mname")!=null ){

		      	out.println("<div class='search-result'>");
    	    	
		    	String mname = (String)request.getAttribute("mname"),mId = (String)request.getAttribute("mid");
    	    	String namelist[] =new String[10],mid[] = new String[10];
    	    	
    	    	namelist = mname.split(";");
    	    	mid = mId.split(";");
    	    	
    	    	for( int i = 0; i < namelist.length; i++ ){
		%>
   		
   		<form action="aboutmovie" method="get">	
   			<button  name="mId"  type="submit"  value=<%out.println(mid[i]); %> >
   				<%	out.println(namelist[i]); %>
   			</button>
   			
   			<br/><hr/>
   		</form>
    	<% 		} 
 	    		
    	    	out.println("</div>");
		   }
 	  
	    %>
	
			