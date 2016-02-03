<!DOCTYPE html>
<html lang="en">
<%@include file="headfile.jsp" %>

<body class="cbp-spmenu-push" >
	
		
	<div id="wrapper" class="behind" >
	<nav class="navbar navbar-default" style="background:#fff;">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					
				</button>
				
				<%@include file="leftMenu.jsp" %>
			</div>
	
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right main-nav">
									
					<li>
					<form action="" > 
			
						 <input class="form-control" id="txt1" type="search"  name="search" placeholder="Search Movie" onkeyup="showHint(this.value)"/>
					</form>										
					</li>
					<li><a href="#Recommended" class="scrollto">Recommended</a></li>
					<li><a href="#Toprated" class="scrollto">Top Rated</a></li>
					<li><a href="#NewRelease" class="scrollto">New Release</a></li>
					<li><a href="#Upcoming" class="scrollto">Upcoming</a></li>
					<%	if(request.getSession().getAttribute("currentSessionUser")== null ){ %>  
					<li><a href="login.jsp" class="scrollto">Login/Register</a></li>
					<%} %>
						
				</ul>
				<%@include file="srh.jsp" %>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>
	<div>
	</div>
	
	
<%	if(request.getSession().getAttribute("currentSessionUser")!= null) { %>
<section id="Recommended" class="reviews">
	<div class="container">
		<div class="row">	
			<div class="col-sm-6 text-left">
				
				<h2 class="heading">Recommendation</h2>
			</div>
		
		</div>
		
		<div class="row">
			
			<jsp:include page="/Reviewer"  />
			
			<div class="owl-reviews">
			
			<%
			//if(request.getParameter("toenter")!=null){
			String mname[]=new String[3];
			
			if((String[])request.getAttribute("mname1")!=null){
			mname=(String[])request.getAttribute("mname1");
			String mdescription1[]=new String[3];
			mdescription1=(String[])request.getAttribute("mdescription1");
			double mrating[]=new double[3];
			mrating=(double[])request.getAttribute("mrating");	
			long movieid[]=new long[3];
			movieid=(long[])request.getAttribute("movieid");	
			
				int len = mname.length > 3? 3 :mname.length;
				for(int i=0;i<len;i++){ %>
				
				<div class="item">
					<div class="review text-center wow animated fadeInUp">
						<img src="<%out.println("images/"+mname[i]+".jpg");%>" class="reviewer-pic" alt="">
						<h5 class="subheading reviewer-name"><% if(mname[i]!=null) out.println(mname[i]);%> 
						</h5>
						<h5><%out.println(mrating[i]);%>/10
						</h5>
						<div class="rating">
						<%for(int j=0;j<Math.floor(mrating[i]);j++){%>
							<span class="rate active"></span>
							<%} %>
						</div>
						<p class="small">
							<a class="form-control" href="aboutmovie?mId=<%out.println(movieid[i]);%>">link</a>
						</p>
					</div>
				</div>
				<%}  }%>
				
			</div>
		</div>
	</div>
</section>
<% }%>
<section id="Toprated" class="reviews" style="background:#5cb85c;">
	<div class="container">
		<div class="row">	
			<div class="col-sm-6 text-left">
				<h2 class="heading">Top Rated Movies</h2>
			</div>
		
		</div>
		<div class="row">
		<jsp:include page="/Toprated"  />
						
			<div class="owl-reviews">
			
			<%
			//if(request.getParameter("toenter")!=null){
			String mname6[]=new String[3];
			if((String[])request.getAttribute("mname6")!=null){
				
			
			mname6=(String[])request.getAttribute("mname6");
			String mdescription6[]=new String[3];
			mdescription6=(String[])request.getAttribute("mdescription6");
			
			double mrating6[]=new double[3];
			mrating6=(double[])request.getAttribute("mrating6");			
			
			long movieid[]=new long[3];
			movieid=(long[])request.getAttribute("movieid");	
			
			int len = mname6.length > 3? 3 :mname6.length;
				
			for(int i=0;i<len;i++){ %>
				
				<div class="item">
					<div class="review text-center wow animated fadeInUp">
						<img src="<%out.println("images/"+mname6[i]+".jpg");%>" class="reviewer-pic" alt="">
						<h5 class="subheading reviewer-name"><% if(mname6[i]!=null) out.println(mname6[i]);%> 
						</h5>
						<h5> <%	out.println(mrating6[i]);	%>/10
						</h5>
						<div class="rating">
						<%for(int j=0;j<Math.floor(mrating6[i]);j++){%>
							<span class="rate active"></span>
							<%} %>
						</div>
						<p class="small"> 
							
							<a class="form-control" href="aboutmovie?mId=<%out.println(movieid[i]);%>">link</a>
						
						</p>
					</div>
				</div>
				<% } }%>
				
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="row">	
			<div class="col-sm-6 text-left">
				<h2 class="heading">Top Rated Tv Shows</h2>
			</div>
		
		</div>
		<div class="row">
		<jsp:include page="/TopRatedTvShows"  />
						
			<div class="owl-reviews">
			
			<%
			//if(request.getParameter("toenter")!=null){
			String TvShowname6[]=new String[3];
			if((String[])request.getAttribute("TvShowname6")!=null){
				
			
			TvShowname6=(String[])request.getAttribute("TvShowname6");
			String TvShowdescription6[]=new String[3];
			TvShowdescription6=(String[])request.getAttribute("TvShowdescription6");
			
			double TvShowrating6[]=new double[3];
			TvShowrating6=(double[])request.getAttribute("TvShowrating6");			
			
			long TvShowid[]=new long[3];
			TvShowid=(long[])request.getAttribute("TvShowid");	
	
						
			int len = mname6.length > 3? 3 :mname6.length;
				
			for(int i=0;i<len;i++){ %>
				
				<div class="item">
					<div class="review text-center wow animated fadeInUp">
						<img src="<%out.println("images/"+TvShowname6[i]+".jpg");%>" class="reviewer-pic" alt="">
						<h5 class="subheading reviewer-name"><% if(TvShowname6[i]!=null) out.println(TvShowname6[i]);%> </h5>
						<h5> <%	out.println(TvShowrating6[i]);	%>/10
						</h5>
						<div class="rating">
						<%for(int j=0;j<Math.floor(TvShowrating6[i]);j++){%>
							<span class="rate active"></span>
							<%} %>
						</div>
						<p class="small"> 
							<a class="form-control" href="aboutmovie?mId=<%out.println(TvShowid[i]);%>">link</a>
						</p>
									
					</div>
				</div>
				<% } }%>
				
			</div>
		</div>
	</div>
</section>

	
	<section id="NewRelease" class="reviews" style="background:#5cb85c;">
		<div class="container">
			<div class="row">	
				<div class="col-sm-6 text-left">
					<h2 class="heading">NewRelease</h2>
				</div>
				<div class="col-sm-6 text-right text-left-mobile">
					<div class="rate-amount text-right">
						 <span>
						    <%	if(request.getSession().getAttribute("currentSessionUser")== null ){ %>
						 	<a href="login.jsp">More</a>
						 	<%	}else{ %>
						 	<a href="moreUpcoming.jsp">More</a>
						 	<%	} %>
						 </span>
					</div>
					
				</div>
			</div>
			<div class="row">
				<div class="owl-reviews">
					<jsp:include page="/NewRelease"  />
												
						<%
					
					      if(request.getAttribute("mname")!=null){
					    	        
					    	    	String mnam = (String)request.getAttribute("mname"),mId=(String)request.getAttribute("mid");
					    	    	
					    	    	String namelis[] =new String[10],mid[] = new String[10];
					    	    	
					    	    	namelis = mnam.split(";");
					    	    	mid = mId.split(";");
					    	    	
					    	    	for(int i = 0; i < namelis.length; i++){
					    	    	
					    	  
					    %>			
					<div class="item">
						<div class="review text-center wow animated fadeInUp">
							
				                    <img src="images/<%out.println(namelis[i]);%>.jpg" class="reviewer-pic" />
				            	
							<h5 class="subheading reviewer-name"><%out.println(namelis[i]);%></h5>
														
							<p class="small">
								<a class="form-control" href="aboutmovie?mId=<%out.println(mid[i]);%>">link</a>
							</p>
							        
						</div>
					</div>
					
						           <%	}
							    	  }
							        %> 
				</div>
			</div>
		</div>
	</section>
	
	<section id="Upcoming" class="reviews" style="background:#5cb85c;">
		<div class="container">
			<div class="row">	
				<div class="col-sm-6 text-left">
					<h2 class="heading">Upcoming</h2>
				</div>
				<div class="col-sm-6 text-right text-left-mobile">
					<div class="rate-amount text-right">
						 <span>
						    <%	if(request.getSession().getAttribute("currentSessionUser")== null ){ %>
						 	<a href="login.jsp">More</a>
						 	<%	}else{ %>
						 	<a href="moreUpcoming.jsp">More</a>
						 	<%	} %>
						 </span>
					</div>
					
				</div>
			</div>
			<div class="row">
				<div class="owl-reviews">
									
					<div class="item">
						<div class="review text-center wow animated fadeInUp">
							<jsp:include page="/displaymovie"  />
												
								<%
							
							      if(request.getAttribute("mname")!=null){
							    	        
							    	    	String mnam = (String)request.getAttribute("mname"),mId=(String)request.getAttribute("mid");
							    	    	
							    	    	String namelis[] =new String[10],mid[] = new String[10];
							    	    	
							    	    	namelis = mnam.split(";");
							    	    	mid = mId.split(";");
							    	    	
							    	    	for(int i = 0; i < namelis.length; i++){
							    	    	
							    	  
							    %>
				                    <img src="images/<%out.println(namelis[i]);%>.jpg" class="reviewer-pic"/>
				            	
							<h5 class="subheading reviewer-name"><%out.println(namelis[i]);%></h5>
														
							<p class="small"> 
								<a class="form-control" href="aboutmovie?mId=<%out.println(mid[i]);%>">link</a>
							</p>
							        
								
						           <%	}
							    	  }
							        %> 
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	
	</div>
	
	<div class="mobile-nav">
		<ul class="menu">
			
		</ul>
	</div>

  
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/owl.carousel.js"></script>
	<script src="js/lightbox.min.js"></script>
	<script src="js/wow.min.js"></script>
	<script src="js/jquery.onepagenav.js"></script>
	<script src="js/core.js"></script>
	<script src="js/tooltip.js"></script>
	<script src="js/jquery.form-validator.js"></script>
	<script src="js/preloader.js"></script>
	<script src="js/main.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
		
</body>
</html>