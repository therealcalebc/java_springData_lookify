<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify!</title>
	<!-- <link rel="stylesheet" type="text/css" href="css/style.css" /> -->
</head>
<body>
	<div>
		<h1>Top Ten Songs</h1>
		<a href="/dashboard">Dashboard</a>
		<table>
		    <thead>
		        <tr>
		            <th>Rating</th>
		            <th>Song Title</th>
		            <th>Artist</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${toptensongs}" var="song">
		        <tr>
		            <td><c:out value="${song.rating}"/> - </td>
		            <td><a href="/songs/<c:out value="${song.id}"/>"><c:out value="${song.title}"/></a></td>
		            <td> - <c:out value="${song.artist}"/></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>
