<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Move Items</title>
    <%@include file="../common/taglib.jsp" %>
	 <link rel="stylesheet" href="https://cdn.materialdesignicons.com/5.9.55/css/materialdesignicons.min.css">

    <style type="text/css">
		<%@include file="../WEB-INF/css/import.css" %>
	</style>
</head>
<body>

    <form action="./Import.do" method="POST">
	    <select id="leftList" name="listLeft" multiple>
	        <logic:iterate id="setting" name="importForm" property="listLeft">
	       	 	<logic:equal name="setting" value="1">
	       	 		<option value="1">Check Box</option>
	       	 	</logic:equal>
	       	 	<logic:equal name="setting" value="2">
	       	 		<option value="2">Customer ID</option>
	       	 	</logic:equal>
	       	 	<logic:equal name="setting" value="3">
	       	 		<option value="3">Customer Name</option>
	       	 	</logic:equal>
	       	 	<logic:equal name="setting" value="4">
	       	 		<option value="4">Sex</option>
	       	 	</logic:equal>
	       	 	<logic:equal name="setting" value="5">
	       	 		<option value="5">Birthday</option>
	       	 	</logic:equal>
	       	 	<logic:equal name="setting" value="6">
	       	 		<option value="6">Address</option>
	       	 	</logic:equal>
	       	 	<logic:equal name="setting" value="7">
	       	 		<option value="7">Email</option>
	       	 	</logic:equal>
	       	 </logic:iterate>
	    </select>
	    <button type="submit" name="sMode" value="right" id="moveRight">Move Right</button>
    <button type="button" id="moveLeft">Move Left</button>
		
	    <select name="listRight" id="rightList" multiple>
	    	<logic:iterate id="setting" name="importForm" property="settingHeader">
	       	 	<logic:equal name="setting" value="1">
	       	 		<option value="1">Check Box</option>
	       	 	</logic:equal>
	       	 	<logic:equal name="setting" value="2">
	       	 		<option value="2">Customer ID</option>
	       	 	</logic:equal>
	       	 	<logic:equal name="setting" value="3">
	       	 		<option value="3">Customer Name</option>
	       	 	</logic:equal>
	       	 	<logic:equal name="setting" value="4">
	       	 		<option value="4">Sex</option>
	       	 	</logic:equal>
	       	 	<logic:equal name="setting" value="5">
	       	 		<option value="5">Birthday</option>
	       	 	</logic:equal>
	       	 	<logic:equal name="setting" value="6">
	       	 		<option value="6">Address</option>
	       	 	</logic:equal>
	       	 	<logic:equal name="setting" value="7">
	       	 		<option value="7">Email</option>
	       	 	</logic:equal>
	       	 </logic:iterate>
	    </select>
	    <button id="moveDown">Move Down</button>
	    <input type="hidden" name="settingHeader" id="settinginputsubmit" value=""/>
	    <button type="submit" id="saveButton" onclick="updateInput()">Save</button>
	</form>

   <script>
  
   function updateInput() {
   	
       // Lấy thẻ select
       var selectElement = document.getElementById("rightList");

       // Mảng để lưu trữ giá trị của các tùy chọn
       var selectedValues = [];

       // Lặp qua tất cả các tùy chọn và lưu giá trị vào mảng
       for (var i = 0; i < selectElement.options.length; i++) {
           selectedValues.push(selectElement.options[i].value);
       }

       // Nối giá trị của mảng thành một chuỗi, sử dụng dấu phẩy làm phân cách
       var concatenatedValues = selectedValues.join(',');

       // Cập nhật giá trị của thẻ input
       var inputElement = document.getElementById("settinginputsubmit");
       inputElement.value = concatenatedValues;
   }
   
   document.getElementById('moveDown').addEventListener('click', function () {
       var rightList = document.getElementById('rightList');
       var selectedOption = rightList.selectedOptions[0];

       if (!selectedOption) {
           alert('行を選択してください。');
           return;
       }

       var currentIndex = selectedOption.index;

       if (currentIndex === rightList.options.length - 1) {
           // At the bottom position, cannot move down further
           return;
       }

       // Get the item below and swap positions
       var belowItem = rightList.options[currentIndex + 1];
       var clonedSelected = selectedOption.cloneNode(true);

       // Swap positions
       rightList.options[currentIndex + 1] = clonedSelected;
       rightList.options[currentIndex] = belowItem;

       // Update selected status
       rightList.options[currentIndex].selected = false;
       rightList.options[currentIndex + 1].selected = true;
   });
    
</script>
</body>
</html>
