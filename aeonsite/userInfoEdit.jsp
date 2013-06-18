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

<div id="userInfoEdit"  data-role="b">
<div data-role="header" data-theme="b">
<h1>ユーザー編集</h1>
<div data-role="navbar">
<ul>
<li><a href="userInfoShowAction.action?infoParten=base" data-theme="b" data-icon="arrow-l">戻る</a></li>
</ul>
</div>

</div>

<div data-role="content">

<s:form name="frmUserInfoUpdate" action="userInfoUpdateAction">

<div data-role="fieldcontain">
<label for="inp_5511">メールアドレス</label>
<s:textfield name="userInfoBean.mailAddress" value="%{userInfoBean.mailAddress}" maxlength="20" size="20" id="inp_5511" />
</div>

<div data-role="fieldcontain">
<label for="inp_5512">既存のパスワード</label>
<s:password name="userInfoBean.oldPassword" value="%{userInfoBean.oldPassword}" maxlength="16" size="16" id="inp_5512" />
</div>

<div data-role="fieldcontain">
<label for="inp_5514">新規パスーワド</label>
<s:password name="userInfoBean.password" value="%{userInfoBean.password}" maxlength="16" size="16" id="inp_5514" />
</div>

<div data-role="fieldcontain">
<label for="inp_5507">新規パスーワド確認</label>
<s:password name="userInfoBean.passwordConfirm" value="%{userInfoBean.passwordConfirm}" maxlength="16" size="16" id="inp_5507" />
</div>

<s:hidden name="infoParten" value="%{infoParten}" />

<s:submit id="btnlogin" value="更新" data-theme="b"/>

<font color="red"><b>
<s:property value="%{messagebean.errorMsg}"/>
</b></font>

</s:form>

</div>
</div>

</body>
</html>
