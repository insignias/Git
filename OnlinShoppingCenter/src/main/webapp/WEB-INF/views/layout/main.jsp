<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html data-ng-app="productApp">  
  <head>  
    <title>
    	Online Shopping Center
	</title>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" href="<c:url value="resources/css/productcatalog/style.css"/>" type="text/css" media="all" />
		<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/angular-local-storage/0.1.5/angular-local-storage.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.3.15/angular-route.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="resources/js/productcatalog/jquery-1.7.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="resources/js/productcatalog/jquery.jcarousel.js"/>" type="text/javascript"></script>
		<script src="<c:url value="resources/js/productcatalog/DD_belatedPNG-min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="resources/js/productcatalog/functions.js"/>" type="text/javascript"></script>
		<script src="<c:url value="resources/js/productcatalog/productApp.js"/>" type="text/javascript"></script>
		<script src="<c:url value="resources/js/pdfpopup/popup.js"/>" type="text/javascript"></script>
		<%-- <script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" />"></script>
		<script src="<c:url value="resources/js/login/login.js" />"></script> --%>
</head>
<body>
	<div >
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
		<tiles:insertAttribute name="body"></tiles:insertAttribute>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
</body>  
</html>

