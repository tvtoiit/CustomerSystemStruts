<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Training</title>

</head>
<body>
	<div class="content">
		<div class="content-text">Login</div>
		<div class="content-login">
			   <form action="./T001.do" method="POST">
				<div class="content-login__header">
					<h3>LOGIN</h3>
					<div id="lblErrorMessage">
						<html:errors property="userId" />
					</div>
				</div>
				<div class="content-login__container">
					<div class="form-group">
						<label for="fullname" class="form-label form-label__userID">User
							Id: </label>
							
						<html:text property="userId" value="" maxlength="8" styleClass="form-control" />

					</div>
					<div class="form-group__password">
						<label for="password" class="form-label">Password: </label>
						<input name="passWord" value='' maxlength="8" class="form-control" />
					</div>
					<div class="form-group__btn">
						<html:submit styleClass="form-submit" value="Login" />
						<html:reset styleClass="form-submit" value="Clear" />
					</div>
				</div>
			</form>
		</div>
	</div>
</body>

</html>