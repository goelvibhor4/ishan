<!DOCTYPE html>
<html lang="en">

<%@include file="headfile.jsp" %>

<body>
		
	<div id="wrapper" class="behind" >
	     <%
	    	if( request.getAttribute("m-Id")!=null ){
		 %>   		
		 
		<header style="background:url(<%out.println("'images/"+request.getAttribute("m-name")+" HD.jpg'");%>) no-repeat center center;background-size:cover;
		position: relative;
		overflow: hidden;
		height: 600px;">
			<div class="container">
					
					<div class="col-md-6 intro-text hidden-sm hidden-xs wow animated fadeInUp" >
						
					</div>
			</div>
		</header>
	
		<nav class="navbar navbar-default" >
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
								 <input class="form-control" type="search"  name="search" placeholder="Search Movie" onkeyup="showHint(this.value)" />
							</form>
						</li>
						<li><a href="#About" class="scrollto">About</a></li>
						<li><a href="#Rateit" class="scrollto">Rate it</a></li>
						<li><a href="#Reviews" class="scrollto">Reviews</a></li>
						
						<%	if(request.getSession().getAttribute("currentSessionUser")== null ){ %>  
						<li><a href="login.jsp" class="scrollto">Login/Register</a></li>
						<%} %>
						<%@include file="srh.jsp" %>
					</ul>
				</div><!-- /.navbar-collapse -->
			</div><!-- /.container-fluid -->
		</nav>

		
		

		<section id="About">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
		
						<h3>Users' Rating
						<%	Double weightedScore = (Double)request.getAttribute("weightedScore"); 	
							
						%>
						</h3>
						<div class="rating">
						<%for(int j=0;j<Math.floor(weightedScore);j++){%>
							<span class="rate active"></span>
							<%} %>
							<h3><%out.println(weightedScore); %>/10</h3>
							
						</div>
					</div>
					
					<div class="col-md-6">
						<h2 class="heading wow animated fadeInUp" style="font-size:2.0em;">
							
							About <%	out.println(request.getAttribute("m-name"));	%>
						</h2>
						
						<h4 class="subheading wow animated fadeInUp">
							<p class="small wow animated fadeInUp" style="background:#f0f0f0;">
								Release Date:
								<%	String dt = request.getAttribute("m-releasedate").toString();
								    dt= dt.replace("00:00:00.0","");
									out.println(dt);
								%>
							</p>
							
							Cast:<br>
							<% if((String)request.getAttribute("m-cast")!=null){ 
				               		String mcast[] = new String[50],getmcast=(String)request.getAttribute("m-cast");
				            		mcast = getmcast.split(";");
				                        	 
				            		for(int i=0;i<mcast.length;i++)
				             		out.println(mcast[i]+" ");
				            	}
				            %>
				        </h4>
				        
						<p class="small wow animated fadeInUp" style="background:#f0f0f0;">
							<%	if((String)request.getAttribute("m-description")!=null)
									out.println( (String)request.getAttribute("m-description"));
							%>
						</p>
						
					</div>
				</div>
			</div>
		</section>
	
		<%
			String desc_str =(String)request.getAttribute("m-description");
			
			if( !desc_str.equalsIgnoreCase( "TBA" )  ) {
		%>

		<section class="call-to-action" id="Rateit">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center wow animated fadeInUp">
					
						<p class="white" style="font-size:1.8em;">
							Your Reviews
							<br>
							
							<%@include file="slider.jsp" %>
							
							<div class="rating" id="changerating">
								<span class='rate' ></span>
								<span class='rate' ></span>
								<span class='rate' ></span>
								<span class='rate' ></span>
								<span class='rate' ></span>
								<span class='rate' ></span>
								<span class='rate' ></span>
								<span class='rate' ></span>
								<span class='rate' ></span>
								<span class='rate' ></span>									
							</div>
			 				
			 				<form action="RatingServlet" method="get">
				  
					  			<input class="form-control" id="sliderValue" type="text" name="sliderinput" step="0.1" data-slider="true" data-slider-theme="volume" />
					  			<span class="rt"></span>
							    <input class="form-control" type="textarea" name="reviews" maxlength="150" placeholder="Write Reviews"/>
							   <%	if(request.getSession().getAttribute("currentSessionUser")!= null ){ %>
								    <button name="mId" class="rateit" type="submit" value=<%out.println(request.getAttribute("m-Id")); %> >
								    	Save
								    </button>
						 		<%
						 			}
							   		else{
							   	%>
							   		
								    	login to rate it
								    
								    
							   	<%	}
						 		
						 		%>
						    </form>
							
							<script>
								$("[data-slider]")
							    	.each(function () {
							      	
							    		var input = $(this);
							      		$("<span>")
							        	.addClass("output")
							        	.insertAfter(input);
							    	})
							
								    .bind("slider:ready slider:changed", function (event, data) {
								      $(this)
								        .nextAll(".output:first")
								          .html(data.value.toFixed(1));
								    });
							  
				  		 								        
				  		 		$('[data-slider]').change(function() {
						    	    var n = Math.floor($(this).val());
						    	    
						    		switch( n ){
						    		case 1: $("#changerating").html("<span class='rate active' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span>");
						    		break;
						    		case 2: $("#changerating").html("<span class='rate active' ></span><span class='rate active' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span>");
									break;
						    		case 3: $("#changerating").html("<span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span>");
									break;
						    		case 4: $("#changerating").html("<span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span>");
						    		break;
						    		case 5: $("#changerating").html("<span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span>");
									break;
						    		case 6: $("#changerating").html("<span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span>");
						    		break;
						    		case 7: $("#changerating").html("<span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span>");
						    		break;
						    		case 8: $("#changerating").html("<span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate' ></span><span class='rate' ></span>");
									break;
						    		case 9: $("#changerating").html("<span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate' ></span>");
						    		break;
						    		case 10:$("#changerating").html("<span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span><span class='rate active' ></span>");
						    		break;
						    		default :$("#changerating").html("<span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span><span class='rate' ></span>"); 
						    		}		    	   
						    	});
					  	
					
							  </script>	
		 				</p> 
					</div>
				</div>
			</div>
		</section>

		<section id="Reviews" class="reviews">
			<div class="container">
				<div class="row">	
					<div class="col-sm-6 text-left">
						<h2 class="heading">Critic Reviews</h2>
					</div>
					<%	String criticname[]=new String[3];
							
							if((String[])request.getAttribute("criticname")!=null){
							%>
					<div class="col-sm-6 text-right text-left-mobile">
						<div class="rate-amount text-right">
								
							 <span>(<%out.println(request.getAttribute("criticsize"));%> Reviews)</span>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="owl-reviews">
						<%
								
								criticname=(String[])request.getAttribute("criticname");
								String criticreviews[]=new String[3];
								criticreviews=(String[])request.getAttribute("criticreviews");
								
								double criticrating[]=new double[3];
								
								criticrating=(double[])request.getAttribute("criticrating");			
								
								int len = criticname.length > 3? 3 :criticname.length;
								
								for(int i=0;i<len;i++){
									if(criticname[i]!=null){
						%>
							
						<div class="item">
							<div class="review text-center wow animated fadeInUp">
								
								<h4 class="subheading reviewer-name">
									<% 
											out.println(criticname[i]);
									%> 
								</h4>
								
								<div class="rating">
									<%	
									 	for(int j=0;j<Math.floor(criticrating[i]);j++){
									%>
									
									<span class="rate active"></span>
									<%	
										} 
									%>
								</div>
		
								<p class="small">
									<% if(criticreviews[i]!=null) 
											out.println(criticreviews[i]);
									%>
								</p>
							</div>
						</div>
						<% 			}
								}
							}
						
						%>
						
					</div>
				</div>
			</div>
		</section>

		<section id="reviews" class="reviews">
			<div class="container">
				<div class="row">	
					<div class="col-sm-6 text-left">
						<h2 class="heading">User Reviews</h2>
					</div>
					<% String username[]=new String[3];
					
						if(	(String[])request.getAttribute("username")!=null ){
					%>
					<div class="col-sm-6 text-right text-left-mobile">
						<div class="rate-amount text-right">
							<span>(<%out.println(request.getAttribute("usersize"));%> Reviews)</span>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="owl-reviews">
					<%							
							username=(String[])request.getAttribute("username");
							
							String userreviews[]=new String[3];
							
							userreviews=(String[])request.getAttribute("userreviews");
							
							double userrating[]=new double[3];
							
							userrating=(double[])request.getAttribute("userrating");			
							
							int len = username.length > 3? 3 :username.length;
							
							for(int i=0;i<len;i++){ 
								if( username[i]!=null ) {
					%>
						
						<div class="item">
							<div class="review text-center wow animated fadeInUp">
								
								<h4 class="subheading reviewer-name">
									<%	
										
											out.println( username[i] );
									%> 
								</h4>
								
								<div class="rating">
									<%	
										for( int j = 0 ; j < Math.abs(userrating[i]) ; j++ ){
									%>
									<span class="rate active"></span>
									<%	
										}
									%>
								</div>
		
								<p class="small">
									<% if( userreviews[i]!=null ) 
											out.println( userreviews[i] );
									%>
								</p>
							</div>
						</div>
						<%			}
								}
							}
						%>

					</div>
				</div>
			</div>
		</section>

	<%  	
			}  /*** check if movie released or not  ***/
		}	/*** check if movie id is null or not ***/
		
		else{
			    String site = new String("index.jsp");
			    response.setStatus(response.SC_MOVED_TEMPORARILY);
			    response.setHeader("Location", site);
	        }
	%>

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
	
	<script src="js/preloader.js"></script>
	<script src="js/main.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>