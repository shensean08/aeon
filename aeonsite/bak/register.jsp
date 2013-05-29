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
<script src="http://ajaxzip3.googlecode.com/svn/trunk/ajaxzip3/ajaxzip3.js" charset="UTF-8"></script>
<body>
<img class="bg" src="images/bg.jpg" alt="">
<div id="wrap">
<div id="register">
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
<h2>ハザードマップご利用登録</h2>
<s:form name="frmRegister" action="registerAction">


<table cellspacing="0" cellpadding="0" border="0">
	<tbody>
        <tr>
			<th class="t-title" colspan="3" scope="rowgroup">ログイン情報</th>
		</tr>
        
        <tr>
			<th scope="row">ユーザー名</th>
			<td><s:textfield name="registerBean.userName" value="%{registerBean.userName}" size="20" maxlength="20" onpaste="value=value.replace(/[^a-z0-9_]/g,'')" onkeyup="value=value.replace(/[^a-z0-9_]/g,'')"/></td>
            <td></td>
		</tr>
        <tr>
			<th scope="row">メールアドレス</th>
			<td colspan="2"><s:textfield name="registerBean.mailAddress" value="%{registerBean.mailAddress}" size="40" maxlength="40"/></td>
		</tr>
         <tr>
			<th scope="row">パスワード</th>
			<td colspan="2"><s:password name="registerBean.password" value="%{registerBean.password}" size="20" maxlength="20"/></td>
		</tr>
         <tr>
			<th scope="row">パスワード&nbsp;<span class="note red">＊確認</span></th>
			<td colspan="2"><s:password name="registerBean.passwordConfirm" value="%{registerBean.passwordConfirm}" size="20" maxlength="20"/></td>
		</tr>
	</tbody>
	<tbody>
		<tr>
			<th class="t-title" colspan="3" scope="rowgroup">お客様情報</th>
		</tr>
        
		<tr>
			<th scope="row">お名前</th>
            <td class="i-cap2">姓<s:textfield name="registerBean.firstname" value="%{registerBean.firstname}" size="20" maxlength="20"/></td>
            <td class="i-cap2">名<s:textfield label="名(漢字)" name="registerBean.lastname" value="%{registerBean.lastname}" size="20" maxlength="20"/></td>
		</tr>
        <tr>
			<th scope="row">フリガナ</th>
            <td class="i-cap2">姓<s:textfield name="registerBean.firstnameSpelling" value="%{registerBean.firstnameSpelling}" size="20" maxlength="20"/></td>
            <td class="i-cap2">名<s:textfield name="registerBean.lastnameSpelling" value="%{registerBean.lastnameSpelling}" size="20" maxlength="20"/></td>
		</tr>
        <tr>
			<th scope="row">携帯番号&nbsp;<span class="note red">＊ハイフンなし</span></th>
            <td><s:textfield name="registerBean.handPhoneNo" value="%{registerBean.handPhoneNo}" size="11" maxlength="11" onpaste="value=value.replace(/[^0-9]/g,'')" onkeyup="value=value.replace(/[^0-9]/g,'')"/></td>
            <td class="i-cap"><s:checkbox name="registerBean.isValidate" value="%{registerBean.isValidate}"/>SMS送信</td>
		</tr>
	</tbody>

	<tbody>
		<tr>
			<th class="t-title" colspan="3" scope="rowgroup">ハザードマップを確認したい住所</th>
		</tr>
        
        <tr>
			<th scope="row">住所１</th>
            <td><s:textfield name="registerBean.address1Name" value="%{registerBean.address1Name}" size="20" maxlength="20" /></td>
            <td>例：家</td>
		</tr>
		<tr>
			<th></th>
            <td class="i-cap2">〒<s:textfield name="registerBean.address1Postalcode" value="%{registerBean.address1Postalcode}" onKeyUp="value=value.replace(/[^0-9]/g,'');AjaxZip3.zip2addr(this,'','registerBean.address1Address','registerBean.address1Address');" size="7" maxlength="7" onpaste="value=value.replace(/[^0-9]/g,'')"/></td>
            <td class="i-cap"><input type="button" name="" value="住所表示" id="" class="input-btn"><span class="note red">＊ハイフンなし７桁</span></td>
		</tr>

		<tr>
			<th></th>
            <td colspan="2"><s:textfield name="registerBean.address1Address" value="%{registerBean.address1Address}" size="100" maxlength="100"/></td>
		</tr>
		<tr>
			<th scope="row">住所２</th>
            <td><s:textfield name="registerBean.address2Name" value="%{registerBean.address2Name}" size="20" maxlength="20" /></td>
            <td>例：学校</td>
		</tr>
		<tr>
			<th></th>
            <td class="i-cap2">〒<s:textfield name="registerBean.address2Postalcode" value="%{registerBean.address2Postalcode}" onKeyUp="value=value.replace(/[^0-9]/g,'');AjaxZip3.zip2addr(this,'','registerBean.address2Address','registerBean.address2Address');" size="7" maxlength="7" onpaste="value=value.replace(/[^0-9]/g,'')"/></td>
            <td class="i-cap"><input type="button" name="" value="住所表示" id="" class="input-btn"><span class="note red">＊ハイフンなし７桁</span></td>
		</tr>

		<tr>
			<th></th>
            <td colspan="2"><s:textfield name="registerBean.address2Address" value="%{registerBean.address2Address}" size="100" maxlength="100"/></td>
		</tr>
		
		<tr>
			<th scope="row">住所３</th>
            <td><s:textfield name="registerBean.address3Name" value="%{registerBean.address3Name}" size="20" maxlength="20" /></td>
            <td>例：勤務地</td>
		</tr>
		<tr>
			<th></th>
            <td class="i-cap2">〒<s:textfield name="registerBean.address3Postalcode" value="%{registerBean.address3Postalcode}" onKeyUp="value=value.replace(/[^0-9]/g,'');AjaxZip3.zip2addr(this,'','registerBean.address3Address','registerBean.address3Address');" size="7" maxlength="7" onpaste="value=value.replace(/[^0-9]/g,'')"/></td>
            <td class="i-cap"><input type="button" name="" value="住所表示" id="" class="input-btn"><span class="note red">＊ハイフンなし７桁</span></td>
		</tr>

		<tr>
			<th></th>
            <td colspan="2"><s:textfield name="registerBean.address3Address" value="%{registerBean.address3Address}" size="100" maxlength="100"/></td>
		</tr>
		
		<tr>
			<th scope="row">住所４</th>
            <td><s:textfield name="registerBean.address4Name" value="%{registerBean.address4Name}" size="20" maxlength="20" /></td>
            <td>例：勤務地</td>
		</tr>
		<tr>
			<th></th>
            <td class="i-cap2">〒<s:textfield name="registerBean.address4Postalcode" value="%{registerBean.address4Postalcode}" onKeyUp="value=value.replace(/[^0-9]/g,'');AjaxZip3.zip2addr(this,'','registerBean.address4Address','registerBean.address4Address');" size="7" maxlength="7" onpaste="value=value.replace(/[^0-9]/g,'')"/></td>
            <td class="i-cap"><input type="button" name="" value="住所表示" id="" class="input-btn"><span class="note red">＊ハイフンなし７桁</span></td>
		</tr>

		<tr>
			<th></th>
            <td colspan="2"><s:textfield name="registerBean.address4Address" value="%{registerBean.address4Address}" size="100" maxlength="100"/></td>
		</tr>
		
		<tr>
			<th scope="row">住所５</th>
            <td><s:textfield name="registerBean.address5Name" value="%{registerBean.address5Name}" size="20" maxlength="20" /></td>
            <td>例：勤務地</td>
		</tr>
		<tr>
			<th></th>
            <td class="i-cap2">〒<s:textfield name="registerBean.address5Postalcode" value="%{registerBean.address5Postalcode}" onKeyUp="value=value.replace(/[^0-9]/g,'');AjaxZip3.zip2addr(this,'','registerBean.address5Address','registerBean.address5Address');" size="7" maxlength="7" onpaste="value=value.replace(/[^0-9]/g,'')"/></td>
            <td class="i-cap"><input type="button" name="" value="住所表示" id="" class="input-btn"><span class="note red">＊ハイフンなし７桁</span></td>
		</tr>

		<tr>
			<th></th>
            <td colspan="2"><s:textfield name="registerBean.address5Address" value="%{registerBean.address5Address}" size="100" maxlength="100"/></td>
		</tr>
		
		<tr>
			<th></th>
			<td colspan="2"><font color="red"><b>
			<s:property value="%{messagebean.errorMsg}"/>
			</b></font></td>
		</tr>
	</tbody>
</table>

<p class="sabmit"><s:submit value="登録" cssClass="input-btn"/></p>

</s:form>
</article>
</div><!-- /main -->
<footer>
<ul class="bnr-pc"><li><a href=""><img src="images/bnr-pc-1.png" alt="APP STORE"></a></li><li><a href=""><img src="images/bnr-pc-2.png" alt="Android STORE"></a></li></ul>
<ul class="bnr-rwd"><li><a href=""><img src="images/bnr-rwd-1.png" alt="APP STORE"></a></li></ul>
<p><small>Disaster Preparedness and Visualization Public Service .NPO &copy;&nbsp;2013</small></p></footer>
</div><!-- /register -->
</div><!-- /wrap -->

</body>
</html>