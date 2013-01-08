<head>
  <meta name="layout" content="main">
  <title>View Source Code</title>
<r:require modules="codemirror,jquery-ui"/>
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

      // Allow the code area to resize (requires jQuery UI).
      $(element).parent().find('.CodeMirror').resizable({
        stop: function() { myCodeMirror.refresh(); },
        resize: function() {
          $(".CodeMirror-scroll").height($(this).height());
          $(".CodeMirror-scroll").width($(this).width());
          myCodeMirror.refresh();
        }
      });
    });

    $('#viewBtn').click(function(){
      $('#controllerEdit').hide();
      $('#viewEdit').show();
      $('#viewBtn').addClass('active');
      $('#controllerBtn').removeClass('active');
    });

    $('#controllerBtn').click(function(){
      $('#viewEdit').hide();
      $('#controllerEdit').show();
      $('#controllerBtn').addClass('active');
      $('#viewBtn').removeClass('active');
    });
    $('#viewBtn').click();
  });
</r:script>
<style>
  .CodeMirror div {
    font-family: inherit;
  }
  .CodeMirror {
    height: 300px;
    width:580px;
    marign-bottom: 5px;
  }
  .CodeMirror-scroll {
    background-color: white;
    border: 1px solid #000; 
  }
  .tab {
    padding: 3px 15px;
    margin-right: 10px;
    border: 1px solid black;
    background-color: #bbb;
    font-size: 14px;
    cursor: pointer;
  }
  .tab.active {
    background-color: white;
    cursor: default;
    font-weight: bold;
  }
  .submitBtn {
    margin: 10px 0;
    float: right;
  }
  #fileSwitchButtons {
    height: 1.5em;
    list-style-image: none;
    list-style-type: none;
    margin: 10px 0 15px 0;
    padding: 0;
  }
  #fileSwitchButtons li {
    float: left;
  }
  #editorsWrapper {
    margin-bottom: 5px;
  }
</style>
</head>
<body>
  <ul id="fileSwitchButtons">
    <li id="viewBtn" class="tab">View</li>
    <li id="controllerBtn" class="tab">Controller</li>
  </ul>
  <div id="editorsWrapper">
    <g:each in="${files}" var="file">
      <div id="${file.elementId}">
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
