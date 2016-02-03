<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.io.*,java.util.*,java.sql.*,java.net.*"%>
<%@ page language="java" import="java.text.*" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>&lt;C.O.B.R.A.&gt;RATINGS.com </title>
<link href="css/LoginRegister.css" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.11/themes/base/jquery-ui.css" />
</head>

<body>
<div id="wrapper">
		<header id="header"> <a href="http://htmllion.com/" id="logo"  target="_blank" title="htmllion" > C.O.B.R.A.&nbsp;&nbsp;<span>RATINGS</span></a></header>
		<section class="clearfix">
				<h2 align="center">Hi!</h2><br>
				<h2 align="center">ENTER Movie/Tv Show DETAILS</h2>
				<br>
      <div align="center">
	   <form action="movieServlet" method="post" >
       
            Movie/Tv Show  Name <input type="text" name="moviename" size="30" /><br>
            Movie/Tv Show  Description <input type="text" name="moviedescription" size="30" /><br>
              Cast <input type="text" name="cast" size="30" /><br>
            Genre <input type="text" name="genre" size="30" /><br>
          	Release date <input type="text" name="releasedate" size="30" /><br>
          	Type<select name="showtype" >
          		<option>Movie</option>
          		<option>TvShow</option>
          	</select>
               <input type="submit" value="Submit" /><br>
		
        </form>
        </div>

		</section>
</div>
</body>
</html>