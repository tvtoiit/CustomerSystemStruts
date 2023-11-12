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
		<div class = "edit-container">
			<div class = "edit-container__header">
				<span class = "edit-container__headerText edit-container__headerText">Login > Search Customer > Edit Customer Info</span>
				<div class = "edit-container__wellcom">
				<div class = "edit-container__wellcomLeft edit-container__headerText">
				Welcome: ABC
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
				<div class="line-br">Edit</div>
		</div>
	<form action="./T003.do" method="POST">
		<div class="main-edit__cotainer">
			<div class="edit-container__content">
				<div class="edit-container__content--error">Thông báo lỗi</div>
				<div class="edit-container__content-Id edit-container__end">
					<label class="edit-container__content-IdText edit-context__minWith">Customer Id</label>
					<label for=dtoCustomerId class="edit-container__content-IdLable edit-container__headerText" id ="lblCustomerID"></label>
				</div>
				<div class="edit-container__content-Name edit-context__minWith">
					<label class="edit-container__contentName-input edit-container__headerText">Customer Name</label>
					<input id="txtCustomerName" type="text" class="form-with__input" name="customerName" maxlength="50" value="<logic:notEmpty name="dtoCustomerName"><bean:write name="dtoCustomerName"/></logic:notEmpty>"/>
				</div>
					<div class="edit-container__content-Sex edit-context__minWith">
					<label class="edit-container__content-Sexlable edit-container__headerText">Sex</label>
					   <select id="cboSex" name="sex">
					        <option value="" class="cbooption"></option>
					        <option class="cbooption" value="0" <logic:equal name="dtoCustomerSex" value="0">selected</logic:equal>>Male</option>
						  	<option class="cbooption" value="1" <logic:equal name="dtoCustomerSex" value="1">selected</logic:equal>>Female</option>
						</select>
					</div>
				<div class="edit-container__content-Birthday edit-context__minWith">
					<label class="edit-container__contentBirthday-input">Birthday</label>
					<input id="txtCustomerBirthday"  class="form-with__input" value="<logic:notEmpty name="dtoCustomerBirthDay"><bean:write name="dtoCustomerBirthDay"/></logic:notEmpty>" name ="birthDay" maxlength="10"/>			
				</div>
				<div class="edit-container__content-Email edit-context__minWith">
					<label class="edit-container__contentEmail-input edit-container__headerText">Email</label>
					<input id ="txtCustomerEmail" type="text"  class="form-with__input" name ="email" maxlength="40" value="<logic:notEmpty name="dtoCustomerEmail"><bean:write name="dtoCustomerEmail"/></logic:notEmpty>" />
				</div>
				<div class="edit-container__content-Address edit-context__minWith">			
					<label class="edit-container__contentAddress-input edit-container__headerText">Address</label>
					<textarea id="txaAddress"  name="address"><logic:notEmpty name="dtoCustomerAddress"><bean:write name="dtoCustomerAddress"/></logic:notEmpty></textarea>
				</div>
				<div class="edit-container__btnContent">
					<button type="submit" class="edit-container__btnContent-Save">Save</button>
					<button type="button"  id="btnClearEdit" onclick="clearForm()" class="edit-container__btnContent-Clear">Clear</button>
				</div>
			</div>
		</div>
	</form>
		</div>
	</div>
</body>
</html>