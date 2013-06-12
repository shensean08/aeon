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
<link rel="stylesheet" href="css/mobile.css" />
</head>
<body>

<div id="Address1Edit" data-url="Address1Edit" data-role="page">
<div data-role="header" data-theme="b">
<h1>住所編集</h1>
<div data-role="navbar">
<ul>
<li><a href="userInfoMain.jsp?userID=<s:property value='userInfoBean.userID'/>&userName=<s:property value='userInfoBean.userName'/>" data-theme="b" data-icon="arrow-l">戻る</a></li>
</ul>
</div>

</div>

<div data-role="content">

<form id="form_5518" method="POST">

<div data-role="fieldcontain">
<label for="inp_5521">ハーザドマップで表示する住所名</label>
<s:textfield name="userInfoBean.address1Name" value="%{userInfoBean.address1Name}" name="inp_5521" id="inp_5521" />
</div>

<div data-role="fieldcontain">
<label for="inp_5519">〒　郵便番号　（ハイフン無し入力）</label>
<s:textfield name="userInfoBean.address1Postalcode" value="%{userInfoBean.address1Postalcode}" name="inp_5519" id="inp_5519" />
</div>

<div data-role="fieldcontain">
<label for="inp_5520">住所確認</label>
<s:textfield name="userInfoBean.address1Address" value="%{userInfoBean.address1Address}" name="inp_5520" id="inp_5520" />
</div>

<a href="Address1Display.html" data-role="button" data-theme="b">変更する</a>
</form>

</div></div>

</body>
</html>
