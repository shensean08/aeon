<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>AEON HAZARDMAP</title>
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<script type="text/javascript" src="js/jquery.js"></script>

<body>
<img class="bg" src="images/bg.jpg" alt="" />
<div id="wrap">
<div id="showcode">
<div id="side">
<header><h1><a href="login.jsp"><img src="images/aeon-logo.png" alt="AEON HAZARDMAP"></a></h1></header>
<nav>
<ul>
<li class="nav-1"><a href="register.jsp">ご利用登録（無料）</a></li>
<li class="nav-2"><a href="login.jsp">ハザードマップとは</a></li>
<li class="nav-3"><a href="login.jsp">ＤＬ一覧</a></li>
</ul>
</nav>
<footer>
<ul><li><a href=""><img src="images/bnr-apple.png" alt="APP STORE"></a></li><li><a href=""><img src="images/bnr-android.png" alt="Android STORE"></a></li></ul>
<p><small>Disaster Preparedness 
and Visualization<br>
Public Service .NPO&nbsp;&copy;&nbsp;2013</small></p></footer>
</div>
<div id="main">
<article>
<h2>QRコード発行</h2>
<p><s:property value="%{registerConfirmBean.firstName}"/>&nbsp;様、あなたのQRコードは以下です。</p>
<p><img src="<s:property value='registerConfirmBean.qrImage'/>"/></p>
</article>
</div><!-- /main -->
</div><!-- /showcode -->
</div><!-- /wrap -->

</body>
</html>