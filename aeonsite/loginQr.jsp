<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
<title>Web QR</title>
<script type="text/javascript" src="js/jquery.js"></script>
<SCRIPT type="text/javascript">
function clickButton() {    
	var qrdecode = document.getElementById("qrdecode");
	var url = 'loginQrAction';
	var params = {
                 'qrdecode':'1315492432'
				 };
	$.post(url,
		   params,
	       function(result) {
           		alert(result);
           },"json");
    }    
</SCRIPT>
        
</head>
<body>
<input id="name" type="text">
  <input type="button" id="qrdecode" value="ok" onclick="javascript:clickButton();">
</body>
</html>