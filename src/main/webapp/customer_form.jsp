<%@page import="java.util.ArrayList"%>
<%@ page import="domain.Customer" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head lang="en">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Customer Management</title>

	<link href="resources/img/favicon.144x144.png" rel="apple-touch-icon" type="image/png" sizes="144x144">
	<link href="resources/img/favicon.114x114.png" rel="apple-touch-icon" type="image/png" sizes="114x114">
	<link href="resources/img/favicon.72x72.png" rel="apple-touch-icon" type="image/png" sizes="72x72">
	<link href="resources/img/favicon.57x57.png" rel="apple-touch-icon" type="image/png">
	<link href="resources/img/favicon.png" rel="icon" type="image/png">
	<link href="resources/img/favicon.ico" rel="shortcut icon">

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
    <link rel="stylesheet" href="resources/css/lib/font-awesome/font-awesome.min.css">
    <link rel="stylesheet" href="resources/css/lib/bootstrap/bootstrap.min.css">      
    <link rel="stylesheet" href="resources/css/main.css">
    
</head>
<body class="with-side-menu">

	<header class="site-header">
	    <div class="container-fluid">
	
	        <a href="#" class="site-logo">
	            <img class="hidden-md-down" src="resources/img/logo-2.png" alt="">
	            <img class="hidden-lg-up" src="resources/img/logo-2-mob.png" alt="">
	        </a>
	
	        <button id="show-hide-sidebar-toggle" class="show-hide-sidebar">
	            <span>toggle menu</span>
	        </button>
	
	        <button class="hamburger hamburger--htla">
	            <span>toggle menu</span>
	        </button>
	        <div class="site-header-content">
	            <div class="site-header-content-in">
	                <div class="site-header-shown">
	                    
	                    
	
	                    
	
	                    <div class="dropdown user-menu">
	                        <button class="dropdown-toggle" id="dd-user-menu" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                            <img src="resources/img/avatar-2-64.png" alt="">
	                        </button>
	                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dd-user-menu">
	                            <a class="dropdown-item" href="#"><span class="font-icon glyphicon glyphicon-user"></span>Profile</a>
	                            <a class="dropdown-item" href="#"><span class="font-icon glyphicon glyphicon-cog"></span>Settings</a>
	                            <a class="dropdown-item" href="#"><span class="font-icon glyphicon glyphicon-question-sign"></span>Help</a>
	                            <div class="dropdown-divider"></div>
	                            <a class="dropdown-item" href="/signout"><span class="font-icon glyphicon glyphicon-log-out"></span>Logout</a>
	                        </div>
	                    </div>
	
	                    <button type="button" class="burger-right">
	                        <i class="font-icon-menu-addl"></i>
	                    </button>
	                </div><!--.site-header-shown-->
	
	            </div><!--site-header-content-in-->
	        </div><!--.site-header-content-->
	    </div><!--.container-fluid-->
	</header><!--.site-header-->

	<div class="mobile-menu-left-overlay"></div>
	<nav class="side-menu">
	    <ul class="side-menu-list">
	        
	        <li class="blue-dirty">
	            <a href="/customerlist">
	                <span class="glyphicon glyphicon-th"></span>
	                <span class="lbl">Customer List</span>
	            </a>
	            <a href="/customerform">
	                <span class="glyphicon glyphicon-edit"></span>
	                <span class="lbl">Customer Form</span>
	            </a>
	        </li>
	        
	    </ul>
	
	   
	</nav><!--.side-menu-->

	<div class="page-content">
		<%
		Customer cust	=	new Customer();		
		int id	=	0;
		String firstName	=	"";
		String lastName	=	"";
		String gender	=	"";
		String email	=	"";
		String phone	=	"";
		String address	=	"";
		String dob	=	"";
		if(request.getAttribute("cust")!=null){
			cust	=	(Customer) request.getAttribute("cust");
			id	=	cust.getId();
			firstName	=	cust.getFirstName();
			lastName	=	cust.getLastName();
			gender	=	cust.getGender();
			email	=	cust.getEmail();
			phone	=	cust.getPhone();
			address	=	cust.getAddress();
			//dob	=	cust.getDob();
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dob	=	dateFormat.format(cust.getDob());
		}
		%>
		<h5 class="m-t-lg with-border">Add/Update Customer</h5>
		<div class="row">
			<form method="post" action="addcustomer">
				<div class="col-xs-8">				
					<div class="row">
						<div class="col-xs-6">
							<fieldset class="form-group">
								<label class="form-label semibold" for="firstname">First Name</label>
								<input type="text" class="form-control" name="firstName" id="firstname" placeholder="First Name" value="<%=firstName %>"/>						
							</fieldset>
						</div>
						<div class="col-xs-6">
							<fieldset class="form-group">
								<label class="form-label semibold" for="lastname">Last Name</label>
								<input type="text" class="form-control" name="lastName" id="lastname" placeholder="Last Name" value="<%=lastName%>">
							</fieldset>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6">
							<fieldset class="form-group">
								<label class="form-label semibold" for="gender">Gender</label>
								<select class="form-control" id="gender" name="gender">
									<option>Male</option>
									<option>Female</option>							
								</select>
							</fieldset>
						</div>
						
						<div class="col-xs-6">
							<fieldset class="form-group">
								<label class="form-label semibold" for="date-mask-input">Date of birth</label>
								<input type="text" class="form-control" name="dob" id="date-mask-input" value="<%=dob %>"/>						
							</fieldset>
						</div>				
					</div>
					<div class="row">
						<div class="col-xs-6">
							<fieldset class="form-group">
								<label class="form-label semibold" for="email">Email</label>
								<input type="email" class="form-control" name="email" id="email" placeholder="Email" value="<%=email %>">						
							</fieldset>
						</div>
						<div class="col-xs-6">
							<fieldset class="form-group">
								<label class="form-label semibold" for="phone">Phone</label>
								<input type="text" class="form-control" name="phone" id="phone" placeholder="Phone" value="<%=phone%>">
							</fieldset>
						</div>
					</div>
					<div class="row">					
						<div class="col-xs-12">
							<fieldset class="form-group">
								<label class="form-label semibold" for="address">Address</label>
								<input type="text" class="form-control" name="address" id="address" placeholder="Address" value="<%=address%>">
							</fieldset>
						</div>
					</div>
					<div class="row">					
						<div class="col-xs-12 text-center">
							<%
							String submitType	=	"Add";
							if(id>0){
								submitType	=	"Update";								
							}
							%>
							<input type="hidden" name="id" value="<%=id %>"/>
							<input type="hidden" name="submit" value="<%=submitType%>"/>
							<input type="submit" value="Submit" class="btn btn-primary"/>
							<a href="/customerlist" class="btn btn-default">Cancel</a>
						</div>
					</div>
				</div>
			</form>
		</div><!--.row-->
	</div><!--.page-content-->

	<script src="resources/js/lib/jquery/jquery.min.js"></script>
	<script src="resources/js/lib/bootstrap/bootstrap.min.js"></script>

	<script src="resources/js/lib/input-mask/jquery.mask.min.js"></script>	
	
	
	<script>
		$(document).ready(function(){			
			$('#date-mask-input').mask("00/00/0000", {placeholder: "dd/mm/yyyy"});
			//alert('123');
		});
	</script>

<script src="resources/js/app.js"></script>
</body>
</html>