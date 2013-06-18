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
<script src="http://ajaxzip3.googlecode.com/svn/trunk/ajaxzip3/ajaxzip3.js" charset="UTF-8"></script>
</head>
<body>

<div id="UserInformationInput" data-url="UserInformationInput" data-role="page" data-theme="b">
<div data-role="header" data-theme="b">
<h1>ログイン情報</h1>
</div>

<div data-role="content">
<img  src="./images/aeon-logo.png" style="width: 165px; display: block;" align="center" alt=""/>

<s:form name="frmRegister" action="registerAction">

<div data-role="fieldcontain">
<label for="inp_5416">ユーザー名</label>
<s:textfield name="registerBean.userName" value="%{registerBean.userName}" size="20" maxlength="20" id="inp_5416" />
</div>

<div data-role="fieldcontain">
<label for="inp_5415">メールアドレス</label>
<s:textfield name="registerBean.mailAddress" value="%{registerBean.mailAddress}" size="30" maxlength="30" id="inp_5415" />
</div>

<div data-role="fieldcontain">
<label for="inp_5423">パスワード</label>
<s:password name="registerBean.password" value="%{registerBean.password}" size="16" maxlength="16" id="inp_5423" />
</div>

<div data-role="fieldcontain">
<label for="inp_5426">パスワード確認</label>
<s:password name="registerBean.passwordConfirm" value="%{registerBean.passwordConfirm}" size="16" maxlength="16" id="inp_5426" />
</div>

<div data-role="fieldcontain">
<label for="inp_5427">ハーザドマップで表示住所名</label>
<s:textfield name="registerBean.address1Name" value="%{registerBean.address1Name}" size="10" maxlength="10" id="inp_5427" />
</div>

<div data-role="fieldcontain">
<label for="inp_5428">〒　郵便番号　（ハイフン無し入力）</label>
<s:textfield name="registerBean.address1Postalcode" value="%{registerBean.address1Postalcode}" onKeyUp="value=value.replace(/[^0-9]/g,'');AjaxZip3.zip2addr(this,'','registerBean.address1Address','registerBean.address1Address');" size="7" maxlength="7" onpaste="value=value.replace(/[^0-9]/g,'')" id="inp_5428" />
</div>

<div data-role="fieldcontain">
<label for="inp_5428">住所確認</label>
<s:textfield id="addressAddress" name="registerBean.address1Address" value="%{registerBean.address1Address}" size="100" maxlength="100" id="inp_5428" />
</div>

<p class="input-btn"><s:submit id="btnlogin" value="登録" cssClass="input-btn"/></p>

<font color="red"><b>
<s:property value="%{messagebean.errorMsg}"/>
</b></font>

</s:form>

</div></div>


</body>
</html>
