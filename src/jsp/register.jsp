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
						<s:textfield name="userinfobean.userID" value="%{userinfobean.userID}" size="50" />
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
						<s:password name="userinfobean.passwordConfirm" value="%{userinfobean.passwordConfirm}" size="20" />
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
						<s:password name="userinfobean.passwordConfirm" value="%{userinfobean.passwordConfirm}" size="20" />
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
						<s:textfield name="userinfobean.firstnameSpelling" value="%{userinfobean.firstnameSpelling}"/>
					</td>
					<td>
						名(カタカナ)
					</td>
					<td>
						<s:textfield name="userinfobean.lastnameSpelling" value="%{userinfobean.lastnameSpelling}"/>
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
						<s:textfield name="userinfobean.firstname" value="%{userinfobean.firstname}"/>
					</td>
					<td>
						名(漢字)
					</td>
					<td>
						<s:textfield label="名(漢字)" name="userinfobean.lastname" value="%{userinfobean.lastname}"/>
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
						<s:textfield name="userinfobean.handPhoneNo" value="%{userinfobean.handPhoneNo}"/>
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
						<s:textfield name="userinfobean.homeAddress" value="%{userinfobean.homeAddress}"/>
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
						<s:textfield name="userinfobean.workAddress" value="%{userinfobean.workAddress}"/>
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
						<s:checkbox name="userinfobean.isValidate" value="%{userinfobean.isValidate}"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<s:s:property value="%{userinfobean.errorMsg}"/>
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