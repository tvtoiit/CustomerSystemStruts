<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<!DOCTYPE html>
<html>
<head>
   <title><tiles:getAsString name="title" /></title>
</head>
<body>
    <div class="header">
		<h3 class="header-text">Training</h3>
		<div class="header-br"></div>
	</div>
      <tiles:insert attribute="body" />
	<footer class="footer">
		<div class="header-br"></div>
		<div class="footer-text__copyright">Copyright (c) 2000-2008 FUJINET, All Rights Reserved.</div>
	</footer>
</body>
</html>
