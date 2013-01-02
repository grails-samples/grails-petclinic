<head>
  <meta name="layout" content="main">
  <title>View Source Code</title>
<r:require modules="codemirror"/>
<r:script>
  $(function () {
    $('.sourceCode').each(function(index,element) {
      var myCodeMirror = CodeMirror.fromTextArea(element, {
        lineNumbers: true,
        wordWrap: true,
        lineWrapping: true,
        gutter: true,
        fixedGutter: true,
        autofocus: true,
        mode: $(element).data('lang')
      });
    });
    $('#viewBtn').click(function(){
      $('#controllerEdit').hide();
      $('#viewEdit').show();
      $('#viewBtn').css('font-weight','bold');
      $('#controllerBtn').css('font-weight','normal');
    });
    $('#controllerBtn').click(function(){
      $('#viewEdit').hide();
      $('#controllerEdit').show();
      $('#controllerBtn').css('font-weight','bold');
      $('#viewBtn').css('font-weight','normal');
    });
    $('#viewBtn').click();
  });
</r:script>
<style>
  div.CodeMirror div {
    font-family: inherit;
  }
  .CodeMirror {
    width:580px;
  }
  .tab {
    padding: 3px 15px;
    margin-right: 10px;
    border: 1px solid black;
    background-color: #bbb;
    font-size: 14px;
  }
  .submitBtn {
    margin-top: 5px;
    float: right;
  }
</style>
</head>
<body>
  <span class="tab" id="viewBtn">View</span><span class="tab" id="controllerBtn">Controller</span><br />
  <div style="position: relative; top:10px;height: 300px; width: 580px; border: 1px solid #000; margin-bottom:50px;" >
    <g:each in="${files}" var="file">
      <div style="position:absolute; top: 0;" id="${file.elementId}">
        <g:form action="save">
          <g:hiddenField name="filePath" value="${file.path}"/>
          <g:hiddenField name="controllerName" value="${file.controller}"/>
          <g:hiddenField name="actionName" value="${file.action}"/>
          <g:hiddenField name="id" value="${file.id}"/>
          <textarea class="sourceCode" name="sourceCode" data-lang="${file.lang}">${file.sourceCode}</textarea>
          <g:submitButton name="save" value="Save" class="submitBtn"/>
        </g:form>
      </div>
    </g:each>
  </div>
</body>
