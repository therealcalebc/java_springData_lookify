<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify!</title>
</head>
<body>
	<div>
		<a href="/dashboard">Dashboard</a>
		<form:form action="/songs" method="post" modelAttribute="song">
		    <p>
		        <form:label path="title">Title</form:label>
		        <form:errors path="title"/>
		        <form:input path="title"/>
		    </p>
		    <p>
		        <form:label path="artist">Artist</form:label>
		        <form:errors path="artist"/>
		        <form:input path="artist"/>
		    </p>
		    <p>
		        <form:label path="rating">Rating</form:label>
		        <form:errors path="rating"/>
		        <form:input path="rating" type="number"/>
		    </p>
		    <input type="submit" value="AddSong"/>
		</form:form>
	</div>
</body>
</html>
