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
					<div>Welcome: <logic:notEmpty name="loggedInPsnCd"><bean:write name="loggedInPsnCd"/></logic:notEmpty></div>
				</div>
				<a href="./T001.do" class="search-container__logout">
					Log Out
				</a>
			</div>
			<div class="search-container__line"></div>
		<form id="form-Search" action="./T002.do" method="POST">
			<div class="search-container__handalSearch">
				<div class="search-container__handalSearch--margin handalSearch-customerName">
					<div class="handalSearch-customercommon handalSearch-customerName__text">Customer Name</div>
					<input id="txtCustomerName" class="input_Customer--common" name="txtCustomerName" maxLength = "50" value="<logic:notEmpty name="name"><bean:write name='name'/></logic:notEmpty>"/>
				</div>
				<div class="search-container__handalSearch--margin handalSearch-customerSex">
					<div class="handalSearch-customercommon handalSearch-customerSex__text">Sex</div>
					<select name="sex" class="input_Customer--select" id="cboSex">
					    <option value="">blank</option>
					    <option value="0" <% if ("0".equals(request.getAttribute("sex"))) { %>selected<% } %>>Male</option>
					    <option value="1" <% if ("1".equals(request.getAttribute("sex"))) { %>selected<% } %>>Female</option>
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


		    	<button name="pageAction" value="first">&lt;&lt;</button>
	     		<button name="pageAction" value="previous">&lt;</button>

		        <label for="html" class="search-container__btnContext--textstart">Previous</label>
		    </div>
		    <div class="search-container__btnContext--end">
		        <label for="html" class="search-container__btnContext--textend">Next</label>

		     	<button type="submit" name="pageAction" value="next">&gt;</button>  
		        <button type="submit" <logic:notEmpty name="disBtnEndPage">disabled</logic:notEmpty>  name="pageAction" value="last">&gt;&gt;</button>
		    </div>
		</div>
			</form>
		<table class="search-container__table" id="sortableTable">
	        <tr id="header">
	        	 <logic:iterate id="setting" name="model" property="settingHeader">
	        	 	<logic:equal name="setting" value="1">
	        	 		<th><input type="checkbox" id="checkAll" name="checkboxAll" value="" onclick="toggleAllCheckboxes()"></th>
	        	 	</logic:equal>
	        	 	<logic:equal name="setting" value="2">
	        	 		<th>Customer ID</th>
	        	 	</logic:equal>
	        	 	<logic:equal name="setting" value="3">
	        	 		 <th>Customer Name</th>
	        	 	</logic:equal>
	        	 	<logic:equal name="setting" value="4">
	        	 		 <th>Sex</th>
	        	 	</logic:equal>
	        	 	<logic:equal name="setting" value="5">
	        	 		  <th>Birthday</th>
	        	 	</logic:equal>
	        	 	<logic:equal name="setting" value="6">
	        	 		   <th>Address</th>
	        	 	</logic:equal>
	        	 	<logic:equal name="setting" value="7">
	        	 		  <th>Email</th>
	        	 	</logic:equal>
	        	 </logic:iterate>
	        </tr>
	      
	        <logic:iterate id="dept" name="model" property="pageData">
			     <tr id="tr-table">
			     	<logic:iterate id="setting" name="model" property="settingHeader">
			     		<logic:equal name="setting" value="1">
			                <td>
			                    <input type="checkbox" name="selectedCustomers" value="<bean:write name='dept' property='customerId'/>">
			                </td>
			            </logic:equal>
			            <logic:equal name="setting" value="2">
			                <td>
								<html:link action="/T003">
								    <html:param name="id">
									    <bean:write name="dept" property="customerId" />
									</html:param>
								    <bean:write name="dept" property="customerId" />
								</html:link>
					        </td>
			            </logic:equal>
			            <logic:equal name="setting" value="3">
			                 <td><bean:write name='dept' property='customerName' /></td>
			            </logic:equal>
			            <logic:equal name="setting" value="4">
			                <td><bean:write name='dept' property='sex' /></td>
			            </logic:equal>
			            <logic:equal name="setting" value="5">
			                  <td><bean:write name='dept' property='birthDay' /></td>
			            </logic:equal>
			            <logic:equal name="setting" value="6">
			                 <td><bean:write name='dept' property='address' /></td>
			            </logic:equal>
			            <logic:equal name="setting" value="7">
			                 <td><bean:write name='dept' property='email' /></td>
			            </logic:equal>
			     	</logic:iterate>
			    </tr> 
			</logic:iterate>
			
    	</table>
		<div class="search-container__btnnav">
			<a href="./save-user.do" class="btn-import__class search-container__nav-btnAdd">Add New</a>
			<button type="submit" name="action" value="delete" class ="search-container__nav-btnAdd">Delete</button>
			<a href="./Import.do" class="btn-import__class">Import</a>
		</div>

	</div>
</div>
</body>
</html>