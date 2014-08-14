<html>
	<head>
		<meta name="layout" content="main">
		<title>Select Owner</title>
	</head>

	<body id="selection">
		<h2>Owners:</h2>

		<table>
			<thead>
			<tr>
				<th>Name</th>
				<th>Address</th>
				<th>City</th>
				<th>Telephone</th>
				<th>Pets</th>
			</tr>
			</thead>
			<g:each var="o" in="${owners}">
				<tr>
					<td>
                        <g:link action="show" id="${o.id}">${o.firstName} ${o.lastName}</g:link>
					</td>
					<td>${o.address}</td>
					<td>${o.city}</td>
					<td>${o.telephone}</td>
					<td>
						<g:each var="pet" in="${o.pets}">
							${pet.name} &nbsp;
						</g:each>
					</td>
				</tr>
			</g:each>
		</table>
	</body>
</html>