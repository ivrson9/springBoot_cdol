<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1 maximum-scale=1, user-scalable=no">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="">
	<meta name="author" content="">
	<!-- <link rel="icon" href="../../favicon.ico"> -->
	
	<title>Starter Template for Bootstrap</title>
	
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<!-- ckEditor -->
	<script type = "text/javascript" src = "/resources/lib/ckeditor/ckeditor.js"></script>
	<!-- Bootstrap core CSS -->
	<link href="/resources/lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<link href="/resources/lib/bootstrap/docs/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
	
	<!-- Custom styles for this template -->
	<link href="/resources/css/dashboard.css" rel="stylesheet">
	
	<!-- Custom styles for this template -->
	<link href="/resources/css/carousel.css" rel="stylesheet">
	
	<link href="/resources/css/style.css" rel="stylesheet">
	
	<!-- Custom Fonts -->
	<link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />
</body>
</html>