<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<s:form name="frmRegister" action="registerAction">
<table width=800 border=1>
	<tr>
		<td>
			<table>
				<tr>
					<td>
						メールアドレス(ユーザ名)
					</td>
					<td>
						<s:textfield name="registerBean.userID" value="%{registerBean.userID}" size="50" maxlength="50"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table>
				<tr>
					<td>
						パスワード
					</td>
					<td>
						<s:password name="registerBean.password" value="%{registerBean.password}" size="20" maxlength="20"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table>
				<tr>
					<td>
						パスワード(確認)
					</td>
					<td>
						<s:password name="registerBean.passwordConfirm" value="%{registerBean.passwordConfirm}" size="20" maxlength="20"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table>
				<tr>
					<td>
						氏(カタカナ)
					</td>
					<td>
						<s:textfield name="registerBean.firstnameSpelling" value="%{registerBean.firstnameSpelling}" size="20" maxlength="20"/>
					</td>
					<td>
						名(カタカナ)
					</td>
					<td>
						<s:textfield name="registerBean.lastnameSpelling" value="%{registerBean.lastnameSpelling}" size="20" maxlength="20"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr>
		<td>
			<table width=800>
				<tr>
					<td>
						氏(漢字)
					</td>
					<td>
						<s:textfield name="registerBean.firstname" value="%{registerBean.firstname}" size="20" maxlength="20"/>
					</td>
					<td>
						名(漢字)
					</td>
					<td>
						<s:textfield label="名(漢字)" name="registerBean.lastname" value="%{registerBean.lastname}" size="20" maxlength="20"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr>
		<td>
			<table>
				<tr>
					<td>
						携帯番号(例:08011111111)
					</td>
					<td>
						<s:textfield name="registerBean.handPhoneNo" value="%{registerBean.handPhoneNo}" size="11" maxlength="11"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
		
	<tr>
		<td>
			<table>
				<tr>
					<td>
						お住まい
					</td>
					<td>
						<s:textfield name="registerBean.homeAddress" value="%{registerBean.homeAddress}" size="100" maxlength="100"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr>
		<td>
			<table>
				<tr>
					<td>
						勤務地/学校所在地
					</td>
					<td>
						<s:textfield name="registerBean.workAddress" value="%{registerBean.workAddress}" size="100" maxlength="100"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	
	<tr>
		<td>
			<table>
				<tr>
					<td>
						SMS送信可否
					</td>
					<td>
						<s:checkbox name="registerBean.isValidate" value="%{registerBean.isValidate}"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<font color="red">
			<s:property value="%{messagebean.errorMsg}"/>
			</font>
		</td>
	</tr>
	
	<tr>
		<td>
			<table>
				<tr>
					<td>
						<s:submit value="送信"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</s:form>
</body>
</html>