<!DOCTYPE html>
<html>
<head lang="en">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<meta http-equiv="x-ua-compatible" content="ie=edge">
	<title>Sign In</title>

	<link href="resources/img/favicon.144x144.png" rel="apple-touch-icon" type="image/png" sizes="144x144">
	<link href="resources/img/favicon.114x114.png" rel="apple-touch-icon" type="image/png" sizes="114x114">
	<link href="resources/img/favicon.72x72.png" rel="apple-touch-icon" type="image/png" sizes="72x72">
	<link href="resources/img/favicon.57x57.png" rel="apple-touch-icon" type="image/png">
	<link href="resources/img/favicon.png" rel="icon" type="image/png">
	<link href="resources/img/favicon.ico" rel="shortcut icon">

	<link rel="stylesheet" href="resources/css/separate/pages/login.min.css">
    <link rel="stylesheet" href="resources/css/lib/font-awesome/font-awesome.min.css">
    <link rel="stylesheet" href="resources/css/lib/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/main.css">
</head>
<body>

    <div class="page-center">
        <div class="page-center-in">
            <div class="container-fluid">
                <form class="sign-box" method="post" action="submitlogin">
                	
                	<%
					if(session.getAttribute("message")!=null){				
						out.print("<div class=\"alert alert-danger\"><strong>Danger!</strong> "+session.getAttribute("message")+"</div>");
						session.removeAttribute("message");
					}
					%>					
                    <div class="sign-avatar">
                        <img src="resources/img/avatar-sign.png" alt="">
                    </div>
                    <header class="sign-title">Sign In</header>                    
                    <div class="form-group">
                        <input type="text" name="txtemail" class="form-control" placeholder="E-Mail"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="txtpassword" class="form-control" placeholder="Password"/>
                    </div>
                    <button type="submit" class="btn btn-rounded">Sign in</button>
                    
                </form>
            </div>
        </div>
    </div><!--.page-center-->


<script src="resources/js/lib/jquery/jquery.min.js"></script>
<script src="resources/js/lib/tether/tether.min.js"></script>
<script src="resources/js/lib/bootstrap/bootstrap.min.js"></script>
<!-- <script src="resources/js/plugins.js"></script> -->
<script type="text/javascript" src="resources/js/lib/match-height/jquery.matchHeight.min.js"></script>
<script>
    $(function() {
        $('.page-center').matchHeight({
            target: $('html')
        });

        $(window).resize(function(){
            setTimeout(function(){
                $('.page-center').matchHeight({ remove: true });
                $('.page-center').matchHeight({
                    target: $('html')
                });
            },100);
        });
    });
</script>
<script src="resources/js/app.js"></script>
</body>
</html>