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

<div data-role="page">
<div data-role="header" data-theme="b">
<h1>アカウント情報</h1>
<a href="#" data-icon="delete" class="ui-btn-right" onclick="location.href='login.jsp'">Logout</a>
<div data-role="navbar">
<ul>
<li><a href="#" onclick="location.href='myQRAction.action'" data-theme="b">マイQR</a></li>
<li><a href="#" onclick="location.href='showDownloadAction.action'" data-theme="b">マイマップ</a></li>
</ul>
</div>
<div data-role="navbar">
<ul>
<li><a href="userInfoMain.jsp" data-theme="b">アカウント</a></li>
<li><a href="#" data-theme="b">防災図鑑</a></li>
</ul>
</div>

</div>

<div data-role="content">

<div data-role="controlgroup">
<input type="button" onClick="location.href='userInfoShowAction.action?infoParten=base'" value="ユーザー情報" data-icon="arrow-r" data-iconpos="right" data-theme="b">
<input type="button" onClick="location.href='userInfoShowAction.action?infoParten=address1'" value="確認したい住所１" data-icon="arrow-r" data-iconpos="right" data-theme="b">
<input type="button" onClick="location.href='userInfoShowAction.action?infoParten=address2'" value="確認したい住所２" data-icon="arrow-r" data-iconpos="right" data-theme="b">
<input type="button" onClick="location.href='userInfoShowAction.action?infoParten=address3'" value="確認したい住所３" data-icon="arrow-r" data-iconpos="right" data-theme="b">
<input type="button" onClick="location.href='userInfoShowAction.action?infoParten=address4'" value="確認したい住所４" data-icon="arrow-r" data-iconpos="right" data-theme="b">
<input type="button" onClick="location.href='userInfoShowAction.action?infoParten=address5'" value="確認したい住所５" data-icon="arrow-r" data-iconpos="right" data-theme="b">
</div>
</div>
</div>

</body>
</html>
