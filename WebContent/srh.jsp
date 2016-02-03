
<script>
		function showHint(str)
		{
		var xmlhttp;
		if (str.length==0)
		  { 
		  document.getElementById("txt").innerHTML="";
		  return;
		  }
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.onreadystatechange=function()
		  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
		    {
		    document.getElementById("txt").innerHTML=xmlhttp.responseText;
		    }
		  }
		xmlhttp.open("GET","MovieSearchServlet?search="+str,true);
		xmlhttp.send();
		}
	
	
	</script>
	
				
	<div id="txt">
		<% //+"file="+<%out.println(this.getClass().getName());
		
						      if((String)request.getAttribute("mname")!=null ){
						    	%>  
						      	
				    	    	<%
						    	String mname = (String)request.getAttribute("mname"),mId = (String)request.getAttribute("mid");
				    	    	String namelist[] =new String[10],mid[] = new String[10];
				    	    	
				    	    	namelist = mname.split(";");
				    	    	mid = mId.split(";");
				    	    	
				    	    	for( int i = 0; i < namelist.length; i++ ){
						%>
				   		
				   		<form action="aboutmovie" method="get">	
				   			<button class="searchmov"  name="mId"  type="submit"  value=<%out.println(mid[i]); %> >
				   				<%	out.println(namelist[i]); %>
				   			</button>
				   			
				   			<br/><hr/>
				   		</form>
				    	<% 		} 
				 	    %>		
				    	    	
						  <% }
				 	  
					    %>
					</div>
	
	<style>
		button.searchmov{
			background:#fff;
			color:#000;
			width:100%;
			border:none;						
		}
		button.searchmov:hover{
			font-size: 1.2em;
			font-style: italic;
						
		}
	</style>
