<!DOCTYPE html>
<html lang="pt-BR">

<head>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="" />
<meta name="author" content="" />

<title>SisDoe - Autorização</title>

<!-- Bootstrap Core CSS -->
<link href="./css/bootstrap.min.css" rel="stylesheet" />

<!-- Custom CSS -->
<link href="./css/sb-admin.css" rel="stylesheet" />

<!-- Custom Fonts -->
<link href="./font-awesome/css/font-awesome.min.css" rel="stylesheet" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<div id="page-wrapper">

			<div class="container-fluid">

				<div class="row">
					<div class="col-lg-8">
							<div class="container">
							    <h2>Confirmação</h2>
							
							    <p>
							        Do you authorize "${authorizationRequest.clientId}" at "${authorizationRequest.redirectUri}" to access your
							        protected resources
							        with scope ${authorizationRequest.scope?join(", ")}.
							    </p>
							    <form id="confirmationForm" name="confirmationForm"
							          action="../oauth/authorize" method="post">
							        <input name="user_oauth_approval" value="true" type="hidden"/>
							        <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							        <button class="btn btn-primary" type="submit">Aprovar</button>
							    </form>
							    <form id="denyForm" name="confirmationForm"
							          action="../oauth/authorize" method="post">
							        <input name="user_oauth_approval" value="false" type="hidden"/>
							        <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							        <button class="btn btn-primary" type="submit">Negar</button>
							    </form>
							</div>

					</div>
					<!--  /.col-lg-8 -->

				</div>
				<!-- /.row -->

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="./js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="./js/bootstrap.min.js"></script>
</body>

</html>
