<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css">
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>
</head>
<body>

<div id="AccountInformationDL" data-url="AccountInformationDL" data-role="page">
<div data-role="header" data-theme="b" data-position="fixed">
<h1>取得済み地図</h1>
<div data-role="navbar">
<ul>
<li><a href="myQRAction.action?userName=<s:property value='userName'/>">MyＱＲ</a></li>
<li><a href="showDownloadAction?userID=<s:property value='userID'/>&userName=<s:property value='userName'/>" class="ui-btn-active">My地図</a></li>
<li><a href="userInfoMain.jsp?userID=<s:property value='userID'/>&userName=<s:property value='userName'/>">My情報</a></li>
</ul>
</div>

</div>

<div data-role="content">
<img  src="./images/aeon-logo.png" alt="">
<table border="2">
<s:iterator value="downloadlist" status="st">
<tr>
<td>
<a href="delDownloadAction?userID=<s:property value='userID'/>&userName=<s:property value='userName'/>&DLNo=<s:property value='%{DLNo}'/>">Del</a>
</td>
<td>
	<s:property value="%{DLName}"/>
</td>
<td>
	<s:a href="%{ImageLink}">imagelink</s:a>
</td>
<td>
	<s:a href="%{MapLink}">MapLink</s:a>
</td>
</tr>
</s:iterator>
</table>

</div></div>


</body>
</html>
