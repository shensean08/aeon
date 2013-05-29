<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>AEON HAZARDMAP</title>
<meta name="viewport" content="width=device-width,user-scalable=no,maximum-scale=1">
<link rel="stylesheet" href="style.css" type="text/css" media="screen">
<link rel="stylesheet" media="screen and (max-width: 854px)" href="rwd.css" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>

<body>
<img class="bg" src="images/bg.jpg" alt="" />
<div id="wrap">
<div id="login">
<div id="side">
<header><h1><a href="login.jsp"><img src="images/aeon-logo.png" alt="AEON HAZARDMAP"></a></h1></header>
<nav>
<ul>
<li class="nav-1"><a href="register.jsp">ご利用登録（無料）</a></li>
<li class="nav-2"><a href="login.jsp">ハザードマップとは</a></li>
</ul>
</nav>
<br class="clear">

</div>
<div id="main">
<article>
<h2>ハザードマップ&nbsp;ログイン</h2>
<s:form name="frmLogin" action="loginAction">
<table>
<tbody>
<tr>
<th>
ユーザー名
</th>
<td>
<s:textfield name="loginBean.userName" value="%{loginBean.userName}" maxlength="100"/>
</td>
</tr>
<tr>
<th>
パスワード
</th>
<td>
<s:password name="loginBean.password" value="%{loginBean.password}" maxlength="100"/>
</td>
</tr>
<tr>
<th>
</th>
<td>
<font color="red"><b>
<s:property value="%{messagebean.errorMsg}"/>
</b></font>
</td>
</tr>
</tbody>
</table>

<p class="sabmit"><s:submit id="btnlogin" value="LOGIN" cssClass="input-btn"/>　<input type="button" id="" onClick="location.href='register.jsp'" value="新規ご利用登録" class="input-btn"></p>
</s:form>
</article>
</div><!-- /main -->
<footer>
<ul class="bnr-pc"><li><a href=""><img src="images/bnr-pc-1.png" alt="APP STORE"></a></li><li><a href=""><img src="images/bnr-pc-2.png" alt="Android STORE"></a></li></ul>
<ul class="bnr-rwd"><li><a href=""><img src="images/bnr-rwd-1.png" alt="APP STORE"></a></li></ul>
<p><small>Disaster Preparedness and Visualization Public Service .NPO &copy;&nbsp;2013</small></p></footer>
</div><!-- /login -->
</div><!-- /wrap -->

</body>
</html>