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
		<br>
		<form:form action="/songs/${song.id}" method="post" modelAttribute="song" id="editSongForm">
			<input type="hidden" name="_method" value="put">
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
		    <!-- <input type="submit" value="Update"/> -->
		</form:form>
		<button type="submit" form="editSongForm">Update</button>
		<form action="/songs/${song.id}" method="post" style="display: inline;">
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</body>
</html>
