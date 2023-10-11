<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Training</title>
<style type="text/css">
	<%@include file="../WEB-INF/css/T001.css" %>
</style>
</head>
<body>
	<%@include file="../common/web/header.jsp" %>
	<div class="content">
		<div class="content-text">Login</div>
		<div class="content-login">
			   <form action="./T001.do" method="POST">
				<div class="content-login__header">
					<h3>LOGIN</h3>
					<div id="lblErrorMessage">
						 <html:errors/>
					</div>
				</div>
				<div class="content-login__container">
					<div class="form-group">
						<label for="fullname" class="form-label form-label__userID">User
							Id: </label>
						<logic:empty name="userId">
							<input name="userId" id="txtUserID" value="" maxlength="8" class="form-control" />
						</logic:empty>	
						<logic:notEmpty name="userId">
							<input name="userId" id="txtUserID" value="<bean:write name="userId"/>" maxlength="8" class="form-control" />
						</logic:notEmpty>
					</div>
					<div class="form-group__password">
						<label for="password" class="form-label">Password: </label>
						<logic:empty name="passWord">
							<html:text property="passWord" styleId="txtPassword"  value='' maxlength="8" styleClass="form-control" />
						</logic:empty>
						<logic:notEmpty name="passWord">
							<input name="passWord" id="txtPassword"  value="<bean:write name="passWord"/>" maxlength="8" class="form-control" />
						</logic:notEmpty>
					</div>
					<div class="form-group__btn">
						<html:submit styleId="btnLogin" styleClass="form-submit" value="Login" />
						<html:reset styleId="btnClear" styleClass="form-submit" value="Clear"/>
					</div>
				</div>
			</form>
		</div>
	</div>
	<%@include file="../common/web/footer.jsp" %>
</body>

</html>