<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>AEON HAZARDMAP</title>
<meta name="viewport" content="width=device-width,user-scalable=no,maximum-scale=1">
<link rel="stylesheet" href="style.css" type="text/css" media="screen">
<link rel="stylesheet" media="screen and (max-width: 854px)" href="rwd.css" type="text/css">
<script type="text/javascript" src="js/jquery.js"></script>

<body>
<img class="bg" src="images/bg.jpg" alt="" />
<div id="wrap">
<div id="aeonlink">
<div id="side">
<header><h1><a href="login.jsp"><img src="images/aeon-logo.png" alt="AEON HAZARDMAP"></a></h1></header>
<nav>
<ul>
<li class="nav-1"><a href="register.jsp">ご利用登録（無料）</a></li>
<li class="nav-2"><a href="login.jsp">ハザードマップとは</a></li>
<li class="nav-3"><a href="showDownload.jsp">ＤＬ一覧</a></li>
</ul>
</nav>
<br class="clear">
</div>
<div id="main">
<article>
<h2>ＤＬ一覧</h2>
<ul>
<table border="2">
<s:iterator value="downloadlist" status="st">
<tr>
<td>
	<s:property value="%{DLName}"/>
</td>
<td>
	<s:a href="%{ImageLink}">imagelink</s:a>
</td>
<td>
	<s:a href="%{MapLink}">MapLink</s:a>
</td>
</tr>
</s:iterator>
</table>
</ul>
</article>
</div><!-- /main -->
<footer>
<ul class="bnr-pc"><li><a href=""><img src="images/bnr-pc-1.png" alt="APP STORE"></a></li><li><a href=""><img src="images/bnr-pc-2.png" alt="Android STORE"></a></li></ul>
<ul class="bnr-rwd"><li><a href=""><img src="images/bnr-rwd-1.png" alt="APP STORE"></a></li></ul>
<p><small>Disaster Preparedness and Visualization Public Service .NPO &copy;&nbsp;2013</small></p></footer>
</div><!-- /aeonlink -->
</div><!-- /wrap -->

</body>
</html>>