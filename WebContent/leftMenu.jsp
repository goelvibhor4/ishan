
	
		<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
			<h3>Menu</h3>
			<a href="index.jsp">Home</a>
		
			<a href="logout.jsp">Logout</a>
		</nav>
		
			<%	if(request.getSession().getAttribute("currentSessionUser")== null ){ %>
						 	<a class="navbar-brand"  href="login.jsp"><img src="img/logo.png" alt=""></a>
						 	<%	}else{ %>
						 	<a class="navbar-brand"  id="showLeftPush"><img src="img/logo.png" alt=""></a>
						 	<%	} %>
			
					<!-- Classie - class helper functions by @desandro https://github.com/desandro/classie -->
		<script src="js/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				
				body = document.body;

			
			
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			

			function disableOther( button ) {
				
				
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
				
			}
		</script>
	