<html>
	<head>
		<meta name="layout" content="main">
		<title>Veterinarians</title>
	</head>
	<body id="vets">
		<h2>Veterinarians:</h2>

		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Specialties</th>
				</tr>
			</thead>
			<g:each var="vet" in="${vets}">
				<tr>
					<td>${vet.firstName} ${vet.lastName}</td>
					<td>
						<g:each var="speciality" in="${vet.specialities}">
						${speciality.name}
						</g:each>
						<g:if test="${!vet.specialities}">none</g:if>
					</td>
				</tr>
			</g:each>
		</table>
	</body>
</html>
