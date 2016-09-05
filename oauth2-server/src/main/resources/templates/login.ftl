<!DOCTYPE html>

<html>
	<head>
	    <title>SisDoe - Login</title>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta name="description" content="" />
		<meta name="author" content="" />
		
		<!-- Core CSS - Include with every page -->
		<link href="./css/bootstrap.min.css" rel="stylesheet" />
		
		<!-- Custom Fonts -->
		<link href="./font-awesome/css/font-awesome.min.css" rel="stylesheet" />
		
		<!-- SB Admin CSS - Include with every page -->
		<link href="./css/sb-admin.css" rel="stylesheet" />
		
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
		    <![endif]-->
	</head>

	<body>
	
	    <div class="container">
	        <div class="row">
	            <div class="col-md-4 col-md-offset-4">
	                <div class="login-panel panel panel-default">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">SisDoe - Login</h3>
	                    </div>
	                    <div class="panel-body">
	                        <form role="form" action="login" method="post" >
	                            <fieldset>
	                                <div class="form-group">
	                                    <input class="form-control" placeholder="Usuário" id="username" name="username" type="text" autofocus="autofocus"/>
	                                </div>
	                                <div class="form-group">
	                                    <input class="form-control" placeholder="Senha" id="password" name="password" type="password" value=""/>
	                                </div>
	                                
	                                <!-- Change this to a button or input when using this as a form -->
	                                <button class="btn btn-lg btn-success btn-block" type="submit" >Login</button>
	                            </fieldset>
	                        </form>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    
	    <!-- Core Scripts - Include with every page -->
		<script src="./js/jquery.js"></script>
	
		<script src="./js/bootstrap.min.js"></script>
	
	</body>
</html>