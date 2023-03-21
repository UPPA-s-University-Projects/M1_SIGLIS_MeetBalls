<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="./inc/style.css" />
<script type="text/javascript" src="./inc/GestionSeries.js"></script>
<title>MeetBalls test</title>
</head>
<body>
	<h1>MeetBalls test page</h1>
	<span class="erreur"><c:out value="${erreur }" /></span>
	<table style="padding: 20px; border: 1px;">
		<c:forEach var="Episode" items="${user}">
			<tr class="${user.name}_saison">
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>