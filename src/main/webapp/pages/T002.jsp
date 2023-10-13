<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../common/taglib.jsp" %>
<style type="text/css">
	<%@include file="../WEB-INF/css/T002.css" %>
</style>
</head>
<body>
	<div class="search-container">
		<div class="search-container__dan">
				<div class="search-container__text">
					Login > Search Customer
				</div>
			<div class="search-container__context">
				<div class="search-container__logo">
					<div>Welcome </div>
				</div>
				<a href="#" class="search-container__logout">
					Log Out
				</a>
			</div>
			<div class="search-container__line"></div>
		<form id="form-Search" action="./T002.do" method="POST">
			<div class="search-container__handalSearch">
				<div class="search-container__handalSearch--margin handalSearch-customerName">
					<div class="handalSearch-customercommon handalSearch-customerName__text">Customer Name</div>
					<logic:empty name="name">
						<input id="txtCustomerName" class="input_Customer--common" name="txtCustomerName" maxLength = "50" value=""/>
					</logic:empty>
					<logic:notEmpty name="name">
						<input id="txtCustomerName" class="input_Customer--common" name="txtCustomerName" maxLength = "50" value="<bean:write name='name'/>"/>
					</logic:notEmpty>
				</div>
				<div class="search-container__handalSearch--margin handalSearch-customerSex">
					<div class="handalSearch-customercommon handalSearch-customerSex__text">Sex</div>
					<select name="sex" class ="input_Customer--select" id ="cboSex">
						<option value="">blank</option>
				      	<option value="0" >Male</option>
		    			<option value="1" >Female</option>
					</select>
				</div>
				<div class="search-container__handalSearch--margin handalSearch-BirthdayFrom">
					<div class="handalSearch-customercommon handalSearch-BirthdayFrom__text">Birthday</div>
					<logic:empty name="birthdayFrom">
						<input id="txtBirthdayForm" class ="input_Customer--common txtCustomerValidateFROM" name ="txtBirthdayFromName" maxLength ="10" value=""/>
					</logic:empty>
					<logic:notEmpty name="birthdayFrom">
						<input id="txtBirthdayForm" class ="input_Customer--common txtCustomerValidateFROM" name ="txtBirthdayFromName" maxLength ="10" value="<bean:write name="birthdayFrom"/>"/>
					</logic:notEmpty>
					<label for="html" class="handalSearch-customercommon handalSearch-BirthdayFrom__ngangcach">～</label>
					<logic:empty name="birthdayTo">
						<input id="txtBirthdayTo" class="input_Customer--common txtCustomerValidateTO" name ="txtBirthdayToName" maxLength ="10" value=""/>
					</logic:empty>
					<logic:notEmpty name="birthdayTo">
						<input id="txtBirthdayTo" class="input_Customer--common txtCustomerValidateTO" name ="txtBirthdayToName" maxLength ="10" value="<bean:write name="birthdayTo"/>"/>	
					</logic:notEmpty>
				</div>
				<div class="handalSearch-btnSearch">
					<button type="submit" name="action" value="search" id="btnSearch">Search</button>
				</div>
			</div>
			<div class="search-container__btnContext--chuyenhuong">
			<input type="hidden" name="currentPage" value="<bean:write name="tag"/>"/>	
		    <div class="search-container__btnContext--start">
		    <logic:equal name="tag" value="1">
		    	<button disabled type="submit" name="pageAction" value="first">&lt;&lt;</button>
	     		<button disabled type="submit" name="pageAction" value="previous">&lt;</button>
		    </logic:equal>
		    <logic:greaterThan name="tag" value="1">
		    	<button name="pageAction" value="first">&lt;&lt;</button>
	     		<button name="pageAction" value="previous">&lt;</button>
		    </logic:greaterThan>
		        <label for="html" class="search-container__btnContext--textstart">Previous</label>
		    </div>
		    <div class="search-container__btnContext--end">
		        <label for="html" class="search-container__btnContext--textend">Next</label>
		     <logic:equal name="tag" value="<bean:write name='endl'/>">
		     	<button disabled type="submit" name="pageAction" value="next">&gt;</button>  
		        <button disabled type="submit" name="pageAction" value="last">&gt;&gt;</button>
		     </logic:equal>
		     <logic:lessThan name="tag" value="endl">
		     	<button type="submit" name="pageAction" value="next">&gt;</button>  
		        <button type="submit" name="pageAction" value="last">&gt;&gt;</button>
		     </logic:lessThan>
		    </div>
		</div>
		<table class="search-container__table">
	        <tr class="search-container__table--tieude">
	        	<th><input type="checkbox" id="checkAll" name="checkboxAll" value=""></th>
	            <th>Customer ID</th>
	            <th>Customer Name</th>
	            <th>Sex</th>
	            <th>Birthday</th>
	            <th>Address</th>
	        </tr>
	        <logic:iterate id="dept" name="model" property="pageData">
			    <tr>
			        <td><input type="checkbox" name="selectedCustomers" value="<bean:write name='dept' property='customerId'/>"></td>
			        <td>
						<html:link action="/T003">
						    <html:param name="id">
							    <bean:write name="dept" property="customerId" />
							</html:param>
						    <bean:write name="dept" property="customerId" />
						</html:link>
			        </td>
			        <td><bean:write name='dept' property='customerName' /></td>
			        <td><bean:write name='dept' property='sex' /></td>
			        <td><bean:write name='dept' property='birthDay' /></td>
			        <td><bean:write name='dept' property='address' /></td>
			    </tr>
			</logic:iterate>
    	</table>
		<div class="search-container__btnnav">
			<a href="./save-user.do" class="search-container__nav-btnAdd">Add New</a>
			<button type="submit" name="action" value="delete" class ="search-container__nav-btnAdd">Delete</button>
		</div>
	</form>
	</div>
</div>
</body>
</html>