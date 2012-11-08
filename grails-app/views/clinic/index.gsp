<html>
	<head>
		<meta name="layout" content="main">
		<title>Welcome</title>
	</head>
	<body id="welcome">
		<g:img dir="images" file="pets.png" align="right" style="position:relative;right:30px;"/>
		<h2><g:message code="welcome"/></h2>

		<ul>
			<li><g:link controller="owner" action="find">Find owner</g:link></li>
			<li><g:link action="vets">Display all veterinarians</g:link></li>
			<li><g:link action="tutorial">Tutorial</g:link></li>
		</ul>
	</body>
</html>
