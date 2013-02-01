<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<s:form name="frmRegister" action="registerAction">
<table width=800 border=1>
	<tr>
		<td>
			<table width=800>
				<tr>
					<td>
						<s:property value="%{registerConfirmBean.firstName}"/>
					</td>
					<td>
						様、あなたのQRコードは以下です。
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr>
		<td>
			<img src="<s:property value='registerConfirmBean.qrImage'/>"/>
		</td>
	</tr>
</table>
</s:form>
</body>
</html>