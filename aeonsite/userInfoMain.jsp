<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String userID = request.getParameter("userID");
	String userName = request.getParameter("userName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css">
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>
<link rel="stylesheet" href="jquery.mobile-1.1.0.custom.css?" />
</head>
<body>

<div id="AccountInformationUser" data-url="AccountInformationUser" data-role="page">
<div data-role="header" data-theme="b">
<h1>アカウント情報</h1>
<div data-role="navbar">
<ul>
<li><a href="myQRAction.action?userName=<%=userName%>">MyＱＲ</a></li>
<li><a href="showDownloadAction?userID=<%=userID%>">My地図</a></li>
<li><a href="userInfoMain.jsp?userID=<%=userID%>&userName=<%=userName%>" class="ui-btn-active">My情報</a></li>
</ul>
</div>

</div>

<div data-role="content">

<div data-role="controlgroup">
<a href="userInfoEditAction?userID=<%=userID%>&infoParten=base" data-role="button" data-icon="arrow-r" data-iconpos="right" data-theme="b">ユーザー情報</a>
<a href="userInfoEditAction?userID=<%=userID%>&infoParten=address1" data-role="button" data-icon="arrow-r" data-iconpos="right" data-theme="b">確認したい住所１</a>
<a href="userInfoEditAction?userID=<%=userID%>&infoParten=address2" data-role="button" data-icon="arrow-r" data-iconpos="right" data-theme="b">確認したい住所２</a>
<a href="userInfoEditAction?userID=<%=userID%>&infoParten=address3" data-role="button" data-icon="arrow-r" data-iconpos="right" data-theme="b">確認したい住所３</a>
<a href="userInfoEditAction?userID=<%=userID%>&infoParten=address4" data-role="button" data-icon="arrow-r" data-iconpos="right" data-theme="b">確認したい住所４</a>
<a href="userInfoEditAction?userID=<%=userID%>&infoParten=address5" data-role="button" data-icon="arrow-r" data-iconpos="right" data-theme="b">確認したい住所５</a>
</div>

</div></div>


</body>
</html>
