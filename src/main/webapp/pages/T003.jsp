<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit - Training</title>
<%@include file="../common/taglib.jsp" %>
<style type="text/css">
	<%@include file="/WEB-INF/css/T003.css"%>
</style>
</head>
<body>
	<div id="main">
		<div class="header">
			<h3 class="header-text">Training</h3>
			<div class="header-br"></div>
		</div>
		<div class = "edit-container">
			<div class = "edit-container__header">
				<span class = "edit-container__headerText edit-container__headerText">Login > Search Customer > Edit Customer Info</span>
				<div class = "edit-container__wellcom">
				<div class = "edit-container__wellcomLeft edit-container__headerText">
				Welcome
				<logic:present name="namenamewellcom">
					<div class = "edit-container__wellcomname">
						<bean:write name="namenamewellcom"/>
					</div>
				</logic:present>
				</div>
					<div class="edit-container__wellcomRight edit-container__headerText">
						<a href ="#">Log Out</a>
					</div>
				</div>
			<logic:empty name="dtoCustomerId">
				<div class="line-br">Add New</div>
			</logic:empty>
			<logic:notEmpty name="dtoCustomerId">
				<div class="line-br">Edit</div>
			</logic:notEmpty>
		</div>
	<form action="./T003.do" method="POST">
		<div class="edit-container__content">
			<div class="edit-container__content--error">
			</div>
			<div class="edit-container__content-Id">
				<div class="edit-container__content-IdText edit-container__headerText">Customer Id</div>
			</div>
			
			 <logic:notEmpty name="dtoCustomerId">
			 	 <input type="hidden" name="customerId" value='<bean:write name="dtoCustomerId"/>'/>
			 	 <label for=dtoCustomerId class="edit-container__content-IdLable edit-container__headerText" id ="lblCustomerID"><bean:write name='dtoCustomerId'/></label>
			 </logic:notEmpty>
			 <logic:empty name="dtoCustomerId">
			 	 <label for="dtoCustomerId" class = "edit-container__content-IdLable edit-container__headerText" id ="lblCustomerID"></label>
			 </logic:empty>
			<div class="edit-container__content-Name">
				<label class="edit-container__contentName-input edit-container__headerText">Customer Name</label>
				<logic:notEmpty name="dtoCustomerName">
					<input id="txtCustomerName" type="text" class="form-with__input" name="customerName" maxlength="50" value="<bean:write name="dtoCustomerName"/>"/>
				</logic:notEmpty>
				<logic:empty name="dtoCustomerName">
					<input id="txtCustomerName" type="text" class="form-with__input" name="customerName" maxlength="50" value=""/>
				</logic:empty>
			</div>
			
			<logic:notEmpty name="dtoCustomerSex">
				<div class="edit-container__content-Sex edit-container__btnContent-margin">
					<div class="edit-container__content-Sexlable edit-container__headerText">Sex</div>
				   <select id="cboSex" name="sex">
				        <option value="" class="cbooption"></option>
				        <option class="cbooption" value="0" <logic:equal name="dtoCustomerSex" value="0">selected</logic:equal>>Male</option>
					  	<option class="cbooption" value="1" <logic:equal name="dtoCustomerSex" value="1">selected</logic:equal>>Female</option>
					</select>
				</div>
			</logic:notEmpty>
			<logic:empty name="dtoCustomerSex">
				<div class="edit-container__content-Sex edit-container__btnContent-margin">
				<div class="edit-container__content-Sexlable edit-container__headerText">Sex</div>
		    	<select name="sex" >
			    	 <option value="" class="cbooption"></option>
			    	<option class="cbooption" value="0">Male</option>
			    	<option class="cbooption" value="1">Female</option>
		    	</select>  
			</div>
			</logic:empty>
			<div class="edit-container__content-Birthday edit-container__btnContent-margin">
				<div class="edit-container__contentBirthday-input edit-container__headerText">Birthday</div>
				<logic:empty name="dtoCustomerBirthDay">
					<input id="txtCustomerBirthday"  class="form-with__input" name="birthDay" maxlength ="10" value= ""/>
				</logic:empty>
				<logic:notEmpty name="dtoCustomerBirthDay">
					<input id="txtCustomerBirthday"  class="form-with__input" value="<bean:write name="dtoCustomerBirthDay"/>" name = "birthDay" maxlength="10"/>
				</logic:notEmpty>
			</div>
			<div class="edit-container__content-Email edit-container__btnContent-margin">
				<div class="edit-container__contentEmail-input edit-container__headerText">Email</div>
				<logic:notEmpty name="dtoCustomerEmail">
					<input id ="txtCustomerEmail" type="text"  class="form-with__input" name ="email" maxlength="40" value="<bean:write name="dtoCustomerEmail"/>" />
				</logic:notEmpty>
				<logic:empty name="dtoCustomerEmail">
					<input id="txtCustomerEmail" type="text" class="form-with__input" name="email" maxlength="40" value=""/>
				</logic:empty>
			</div>
			<div class="edit-container__content-Address edit-container__btnContent-margin">
				<div class="test-aline__editAddress">				
					<div class="edit-container__contentAddress-input edit-container__headerText">Address</div>
				</div>
				<logic:empty name="dtoCustomerAddress">
					<textarea id="txaAddress" rows="3"  name="address"></textarea>
				</logic:empty>
				<logic:notEmpty name="dtoCustomerAddress">
					<textarea id="txaAddress"  name="address"><bean:write name="dtoCustomerAddress"/></textarea>
				</logic:notEmpty>
			</div>
			<div class="edit-container__btnContent">
				<button type="submit" class="edit-container__btnContent-Save">Save</button>
				<button type="button"  id="btnClearEdit" onclick="clearForm()" class="edit-container__btnContent-Clear">Clear</button>
			</div>
		</div>
	</form>
		</div>
		<div class="footer">
			<div class="header-br"></div>
			<div class="footer-text__copyright">Copyright (c) 2000-2008
			FUJINET, All Rights Reserved.</div>
		</div>
	</div>
	<script>
		<%@include file ="/WEB-INF/js/T003.js"%>
	</script>
</body>
</html>