<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://ajaxzip3.googlecode.com/svn/trunk/ajaxzip3/ajaxzip3.js" charset="UTF-8"></script>
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.css">
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.1.0/jquery.mobile-1.1.0.min.js"></script>
</head>
<body>

<div id="Address1Edit" data-role="page">
<div data-role="header" data-theme="b">
<h1>住所編集</h1>
<div data-role="navbar">
<ul>
<li><a href="userInfoMain.jsp?userID=<s:property value='userInfoBean.userID'/>&userName=<s:property value='userInfoBean.userName'/>" data-theme="b" data-icon="arrow-l">戻る</a></li>
</ul>
</div>

</div>

<div data-role="content">

<s:form name="frmUserInfoEdit" action="userInfoEditAction">

<div data-role="fieldcontain">
<label for="inp_5521">ハーザドマップで表示住所名</label>
<s:textfield name="userInfoBean.address1Name" value="%{userInfoBean.address1Name}" size="10" maxlength="10" id="inp_5521" />
</div>

<div data-role="fieldcontain">
<label for="inp_5519">〒　郵便番号　（ハイフン無し入力）</label>
<s:textfield name="userInfoBean.address1Postalcode" value="%{userInfoBean.address1Postalcode}" onKeyUp="value=value.replace(/[^0-9]/g,'');AjaxZip3.zip2addr(this,'','userInfoBean.address1Address','userInfoBean.address1Address');" size="7" maxlength="7" onpaste="value=value.replace(/[^0-9]/g,'');AjaxZip3.zip2addr(this,'','userInfoBean.address1Address','userInfoBean.address1Address'" id="inp_5519" />
</div>

<div data-role="fieldcontain">
<label for="inp_5520">住所確認</label>
<s:textfield name="userInfoBean.address1Address" value="%{userInfoBean.address1Address}" size="100" maxlength="100" id="inp_5520" />
</div>

<s:hidden name="userID" value="%{userID}" />
<s:hidden name="userName" value="%{userName}" />
<s:hidden name="infoParten" value="%{infoParten}" />

<s:submit id="btnlogin" value="更新" data-theme="b"/>

<font color="red"><b>
<s:property value="%{messagebean.errorMsg}"/>
</b></font>

</s:form>

</div></div>

</body>
</html>
