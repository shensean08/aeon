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

<div id="userInfoaddress3Show" data-role="page">
<div data-role="header" data-theme="b">
<h1>確認したい住所③</h1>
<div data-role="navbar">
<ul>
<li><a href="userInfoMain.jsp" data-icon="arrow-l">戻る</a></li>
<li><a href="#" onclick="location.href='userInfoEditAction.action?infoParten=address3'" data-theme="b" data-icon="arrow-r">編集する</a></li>
</ul>
</div>

</div>

<div data-role="content" align="center">

<table border="2" width="100%" height="100%">
<tr>
<td>
<label>住所名:</label>
</td>
<td>
<s:property value="%{userInfoBean.address3Name}"/>
</td>
</tr>
<tr>
<td>
<label>〒　郵便番号:</label>
</td>
<td>
<s:property value="%{userInfoBean.address3Postalcode}"/>
</td>
</tr>
<tr>
<td>
<label>住所確認:</label>
</td>
<td>
<s:property value="%{userInfoBean.address3Address}"/>
</td>
</tr>
</table>
</div></div>


</body>
</html>
