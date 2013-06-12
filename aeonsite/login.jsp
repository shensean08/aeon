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

<div id="Login" data-url="Login" data-role="page" data-theme="b">
<div data-role="header" data-theme="b">
<h1>ログイン</h1>
</div>

<div data-role="content">
<br><br><a href="#Login" data-rel=""><img  src="images/aeon-logo.png" class="selected " style="width: 165px; height: 115px;" align="left" alt=""></a>

<s:form name="frmLogin" action="loginAction">

<div data-role="fieldcontain">
<label for="inp_5419">ユーザー名</label>
<s:textfield name="loginBean.userName" value="%{loginBean.userName}" maxlength="100" id="inp_5419" />
</div>

<div data-role="fieldcontain">
<label for="inp_5432">パスワード</label>
<s:password name="loginBean.password" value="%{loginBean.password}" maxlength="100" id="inp_5432" />
</div>

<p class="input-btn"><s:submit id="btnlogin" value="Login" cssClass="input-btn"/>
<input type="button" id="" onClick="location.href='register.jsp'" value="新規ご利用登録" class="input-btn"></p>
<font color="red"><b>
<s:property value="%{messagebean.errorMsg}"/>

</b></font>
</s:form>


</body>
</html>
