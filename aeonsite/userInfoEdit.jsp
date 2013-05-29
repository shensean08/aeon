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

<div id="UserInformationEdit" data-url="UserInformationEdit" data-role="page">
<div data-role="header" data-theme="b">
<h1>ユーザー編集</h1>
<div data-role="navbar">
<ul>
<li><a href="userInfoMain.jsp?userID=<s:property value='userInfoBean.userID'/>&userName=<s:property value='userInfoBean.userName'/>" data-theme="b" data-icon="arrow-l">戻る</a></li>
</ul>
</div>

</div>

<div data-role="content">

<form id="form_5506" method="POST">

<div data-role="fieldcontain">
<label for="inp_5511">メールアドレス</label>
<s:textfield name="userInfoBean.mailAddress" value="%{userInfoBean.mailAddress}" maxlength="100" name="inp_5511" id="inp_5511" />
</div>

<div data-role="fieldcontain">
<label for="inp_5512">既存のパスワード</label>
<input type="password" name="inp_5512" id="inp_5512" />
</div>

<div data-role="fieldcontain">
<label for="inp_5514">新規パスーワド</label>
<input type="password" name="inp_5514" id="inp_5514" />
</div>

<div data-role="fieldcontain">
<label for="inp_5507">新規パスーワド確認</label>
<input type="password" name="inp_5507" id="inp_5507" />
</div>

<a href="UserInformationDisplay.html" data-role="button" data-theme="b">更新する</a>
</form>

</div></div>


</body>
</html>
