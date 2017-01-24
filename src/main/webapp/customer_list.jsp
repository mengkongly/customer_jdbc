<%@page import="java.util.ArrayList"%>
<%@ page import="domain.Customer" %>
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
		<div class="container-fluid">
			<section class="box-typical">
				<header class="box-typical-header">
					<div class="tbl-row">
						<div class="tbl-cell">
							<h3>Customer List</h3>
						</div>
						<div class="tbl-cell pull-right">
							<a href="/customerform" class="btn"><span class="glyphicon glyphicon-plus small"></span> Add</a>
						</div>
					</div>
				</header>
				<div class="box-typical-body">
					<div class="table-responsive">
						<table class="table table-bordered table-hover">
							<thead>
							<tr>
								<th width="1">ID</th>
								<th>First Name</th>
								<th>Last Name</th>					
								<th>Email</th>
								<th>Phone</th>											
								<th>Action</th>
							</tr>
							</thead>
							<tbody>
								<%
								ArrayList<Customer> custs	=	new ArrayList<>();
								if(request.getAttribute("custs")!=null)	custs	=	(ArrayList<Customer>) request.getAttribute("custs");
		                        String strDis	=	"";
		                        String urlEdit	=	"/customerform?id=";
		                        String urlDelete	=	"/customerdelete?id=";
		                        for(Customer cust:custs){
		                        	strDis+="<tr><td>"+cust.getId()+"</td><td>"+cust.getFirstName()+"</td><td>"
		                        	+cust.getLastName()+"</td><td>"+cust.getEmail()+"</td><td>"+cust.getPhone()+
		                        	"</td><td class=\"hidden-xs\"><a class=\"btn btn-primary btn-sm\" href=\""+urlEdit+cust.getId()+"\"><i class=\"fa fa-pencil\"></i></a>"+
		                        	" <a class=\"btn btn-danger btn-sm\" href=\""+urlDelete+cust.getId()+"\"><i class=\"fa fa-trash-o \"></i></a></td></tr>";
		                        }                        
		                        %>
		                        <%=strDis %>
								
							</tbody>
						</table>
						<div class="container-fluid">
							<div class="pull-right ">
								<nav aria-label="">
								  <ul class="pagination">
								  	<%								  	
								  	String strPage	=	"";
								  	String url	=	"/customerlist?page=";
								  	int currentPage	=	1;
								  	if(request.getAttribute("currentPage") != null)	currentPage	=	(Integer) request.getAttribute("currentPage");
								  	int totalPage	=	1;								  	
								  	if(request.getAttribute("totalPage") != null)	totalPage	=	(Integer)request.getAttribute("totalPage");
								  									  									  
								    if (currentPage>1) {								    	
								    	int previous	=	currentPage-1;
								        strPage+="<li class=\"page-item\"><a class=\"page-link\" href=\""+url+previous+"\" tabindex=\"-1\">Previous</a></li>";
								    }else{
								    	strPage+="<li class=\"page-item disabled\"><a class=\"page-link\" href=\"#\" tabindex=\"-1\">Previous</a></li>";
								    }
								    //out.println(totalPage);
								    //out.println(currentPage);
								    for(int i=1;i<=totalPage;i++){
								    	if(currentPage==i){
								    		strPage+="<li class=\"page-item active\"><a class=\"page-link\" href=\""+url+i+"\">"+i+"</a></li>";
								    	}else{
								    		strPage+="<li class=\"page-item\"><a class=\"page-link\" href=\""+url+i+"\">"+i+"</a></li>";
								    	}
								    }
								    
								    if(currentPage<totalPage){
								    	int next	=	currentPage+1;
								    	strPage+="<li class=\"page-item\"><a class=\"page-link\" href=\""+url+next+"\">Next</a></li>";
								    }else{
								    	
								    	strPage+="<li class=\"page-item disabled\"><a class=\"page-link\" href=\"#\">Next</a></li>";
								    }
								    %>
								    <%=strPage %>
								  </ul>
								</nav>
							</div>
						</div>
					</div>
				</div><!--.box-typical-body-->
			</section><!--.box-typical-->

			<br>
			
		</div><!--.container-fluid-->
	</div><!--.page-content-->

	<script src="resources/js/lib/jquery/jquery.min.js"></script>
	<script src="resources/js/lib/bootstrap/bootstrap.min.js"></script>
	<script>
	$(document).ready(function(){
		//alert('abc');
	});
	</script>

	
	

<script src="resources/js/app.js"></script>
</body>
</html>