<head>
	<meta name="layout" content="main">
	<title>View Source Code</title>
	<r:require modules="codemirror"/>
	<r:script>
    $(function () {
        var myCodeMirror = CodeMirror.fromTextArea(document.getElementById('sourceCode'), {
            lineNumbers: true,
            wordWrap: true,
            lineWrapping: true,
            gutter: true,
            fixedGutter: true,
            autofocus: true,
			mode: '${lang}'
        });
    });
	</r:script>
	<style>
	div.CodeMirror div {
		font-family: inherit;
	}
	</style>
</head>
<body>
	<g:form action="save">
		<g:hiddenField name="filePath" value="${path}"/>
		<g:hiddenField name="controllerName" value="${controller}"/>
		<g:hiddenField name="actionName" value="${action}"/>
		<g:hiddenField name="id" value="${id}"/>
		<textarea id="sourceCode" name="sourceCode">${sourceCode}</textarea>
		<g:submitButton name="save" value="Save"/>
	</g:form>
</body>
