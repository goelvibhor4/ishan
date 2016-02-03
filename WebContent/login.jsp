<!doctype html>
<html>
<head>
<%@include file="headfile.jsp" %>
<meta charset="utf-8">
<title>C.O.B.R.A.</title>
<link href="css/LoginRegister.css" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">

</head>

<body>
<div id="wrapper">
		<header id="header"> <a href="aboutUs.jsp" id="logo"  target="_blank">  C.O.B.R.A. <span>RATINGS</span></a></header>
		<section class="clearfix">
				<h2 align="center">LOGIN</h2>
				<br>
				<form action="LoginServlet" method="post" >
        
                <p align="center">
                 <input class="form-control" type="text" name="userName" size="30" placeholder="Email Id"/>&nbsp;&nbsp;&nbsp;
            
                 <input class="form-control" type="password" name="password1" size="30" placeholder="password"/>&nbsp;
            
                <input type="submit" value="LOGIN"/>
        </form>
        <h3><a href="Register.jsp" style="color:green;">New User</a></h3>
										
		</section>
		
</div>
</body>
</html>
