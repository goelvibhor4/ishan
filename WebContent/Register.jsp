<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="java.io.*,java.util.*,java.sql.*,java.net.*"%>
<%@ page language="java" import="java.text.*" %>
<%@include file="headfile.jsp" %>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>C.O.B.R.A.</title>
<link href="css/LoginRegister.css" rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.11/themes/base/jquery-ui.css" />
</head>

<body>
<div id="wrapper">
		<header id="header"> <a href="aboutUs.jsp" id="logo"  target="_blank" > C.O.B.R.A. <span>RATINGS</span></a></header>
		<section class="clearfix">
				<h2 align="center">Hi!</h2><br>
				<h2 align="center">REGISTER HERE</h2>
				<br>
      <div>
	   <form action="RegisterServlet" method="post" name="myform" onsubmit="return validateForm()">
       
            <input class="form-control" type="text" name="userName" size="30" placeholder="User Name" /><br>
            <input class="form-control" type="password" name="password1" size="30" placeholder="Password" /><br>
            <input class="form-control" type="text" name="email" size="30" placeholder="Email" /><br>
           
           	<div>
            Gender <input  type="radio" name="gender" size="30" value ="male"  />Male
                   <input  type="radio" name="gender" size="30" value ="female" />Female
                   <input  type="radio" name="gender" size="30" value ="others" />Others<br>
            </div>
			
			<br>                 
            Date of Birth<select name="DOBMonth" >
									<option> - Month - </option>
									<%int i;for(i=1;i<=12;i++){%><option value=<% out.println(i);%>><% out.println(i);}%>  </option>
									
								</select>

								<select  name="DOBDay" >
									<option> - Day - </option>
									<%for( i=1;i<=31;i++){%><option value=<% out.println(i);%>><% out.println(i);}%>  </option>
									
								</select>

								<select  name="DOBYear" >
									<option> - Year - </option>
									<%for(i=1900;i<=2015;i++){%><option value=<% out.println(i);%>><% out.println(i);}%>  </option>
																		
								</select><br>
								
                 <input class="form-control" type="text" name="city" size="30" placeholder="City"  /><br>
                        
			     <input type="submit" value="Register" /><br>
		
        </form>
        </div>

		</section>
</div>
<script>

function validateForm() {
    var uname = document.forms["myform"]["userName"].value;
    if (uname == null || uname == "") {
        alert("Name must be filled out");
        return false;
    }
    var pass  = document.forms["myform"]["password1"].value;
    if (pass == null || pass == "") {
        alert("password must be filled out");
        return false;
    }
    if ( pass.length < 8 ) {
        alert("password must be atleast 8 character long");
        return false;
    }
    
    var email  = document.forms["myform"]["email"].value;
    var elength = email.length;
    if (email == null || email == "") {
        alert("email must be filled out");
        return false;
    }
    
    
    if( email.substring( elength-10,elength ).equals("@gmail.com") || email.substring( elength-10,elength ).equals("@ymail.com") || email.substring( elength-10,elength ).equals("@yahoo.com") || email.substring( elength-12,elength ).equals("@outlook.com"))
     {
    	return true;    	    	
     }
    else{
    	alert("email must be correct");
        return false;
    }
    
    var gender  = document.forms["myform"]["gender"].value;
    if (gender == null || gender == "") {
        alert("gender must be filled out");
        return false;
    }
    
    var month  = document.forms["myform"]["DOBMonth"].value;
    if ( isNaN(month) ) {
        alert("month must be filled out");
        return true;
    }
   
    var date  = document.forms["myform"]["DOBDay"].value;
 
    if(  isNaN(date) ==false ) {  
	   	if( month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12  ){
	   		
	   		if( date <=0 && date >=32){ 
	   			alert("date must be correct");
	   	     	return false;     
	       }
	   	}
	   	
	   	if( month==4 || month==6 || month==9 || month==11 ){
	   		if( date <=0 && date >=31){ 
		       
	   	 	 	alert("date must be correct");
		        return false;
	       }
	   	}
	   	
	   	if( month==2){
	   		if( date <=0 && date >=30){ 
		       
	   			alert("date must be correct");
		        return false;
	       }
	   	}
	   	
	}else{
	 	 alert("date must be filled");
	     return false;
	}
    
    
    var year  = document.forms["myform"]["DOBYear"].value;
    if ( isNaN(year) ) {
    	alert("year must be correct");
        return false;
    }
    
    	
    var city  = document.forms["myform"]["city"].value;
    if (city == null || city == "") {
        alert("city must be filled out");
        return false;
    }
    
    
}
</script>
</body>
</html>
    