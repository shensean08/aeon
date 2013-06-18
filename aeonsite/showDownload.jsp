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
<script type="text/javascript">
	function shMinus() {
		var imgs = document.getElementsByTagName("img");
		var imgMinus = [];
		var shMinusE = document.getElementById("shMinusE");
		var shMinusC = document.getElementById("shMinusC");
		
		var len = 0;
		for (var i = 0; i < imgs.length; i++) {
			if (imgs[i].id.indexOf("sh") >= 0) {
				imgMinus[len++] = imgs[i];
			}
		}

		for(var i = 0;i < imgMinus.length;i++) {
    		if (imgMinus[i].style.visibility =="hidden") {
				imgMinus[i].style.visibility = "visible";

			} else {
				imgMinus[i].style.visibility = "hidden";
				if (imgMinus[i].src.indexOf("minus2") >= 0) {
					minus(imgMinus[i].id);
				}
			}
		}
		
		if (shMinusE.style.visibility == "hidden") {
			shMinusE.style.visibility = "visible";
			shMinusC.style.visibility = "hidden";
		} else {
			shMinusE.style.visibility = "hidden";
			shMinusC.style.visibility = "visible";
		}

	}
	
	function minus(shImgID) {
		var imgObj = document.getElementById(shImgID);
		var delObjID = "del" + shImgID.substr(2);
		var delObj = document.getElementById(delObjID);
		
		if (imgObj.src.indexOf("minus.png") >= 0) {
			imgObj.src = "images/minus2.png";
			delObj.style.visibility = "visible";
		} else {
			imgObj.src = "images/minus.png";
			delObj.style.visibility = "hidden";
		}
	}
	
	function load() {
		var showMinus = document.getElementById("minusStates").value;
		if (showMinus == "show") {
			shMinus();
		}
	}
</script>
</head>
<body onload="load()">

<div id="showDownload" data-role="page">
<div data-role="header" data-theme="b" data-position="fixed">
<h1>取得済み地図</h1>
<a href="login.jsp" data-icon="delete" class="ui-btn-right">Logout</a>
<div data-role="navbar">
<ul>
<li><a href="myQRAction.action">MyＱＲ</a></li>
<li><a href="showDownloadAction.action" class="ui-btn-active">My地図</a></li>
<li><a href="userInfoMain.jsp">My情報</a></li>
</ul>
</div>
</div>
<div data-role="footer" data-theme="c"> 
	<a id="shMinusE" href="#" data-icon="gear" class="ui-btn-right" onclick="shMinus()" >Edit</a>
	<a id="shMinusC" style="visibility: hidden" href="#" data-icon="gear" class="ui-btn-right" onclick="shMinus()" >Cancel</a>
	<span class="ui-title" />
</div>
<div class="ui-grid-a" data-theme="b">
<s:iterator value="downloadlist" status="st">
	<div class="ui-block-a" style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">
		<img id="sh<s:property value='%{DLNo}'/>" style="visibility: hidden" src="images/minus.png" onclick="minus('sh' + '<s:property value='%{DLNo}'/>')" height=22 width=22/>
		<s:property value="%{DLName}"/>
	</div>
	<div class="ui-block-b">
		<s:a href="#" onclick="location.href=<s:property value='%{ImageLink}'/>">image</s:a>
		&nbsp;		
		<s:a href="#" onclick="location.href=<s:property value='%{MapLink}'/>">Map</s:a>
		<img id="del<s:property value='%{DLNo}'/>" src="images/del.png" onclick="location.href='delDownloadAction.action?&DLNo=<s:property value='%{DLNo}'/>'" style="visibility: hidden" align="right" width=37 height=23/>
	</div>
</s:iterator>
<s:hidden id="minusStates" name="showMinus" value="%{showMinus}" />
</div>

</div>


</body>
</html>
