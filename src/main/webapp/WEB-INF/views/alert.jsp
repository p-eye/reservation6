<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALERT</title>
</head>
<body>

	<script>
		alert("${errorMsg}");

		<c:if test="${empty currentURI }">
		location.href = './';
		</c:if>
		
		<c:if test="${not empty currentURI }">
		location.href = '${currentURI}';
		</c:if>
	</script>
</body>
</html>
