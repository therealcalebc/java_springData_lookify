<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify!</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div>
		<div>
			<span>Songs by artist: <c:out value="${qval}"/>      </span>
			<form action="/search" style="display: inline-block;">
				<input type="search" id="searchInput" name="q" placeholder="Enter artist name...">
				<button type="submit">New Search</button>
			</form>
			<a href="/dashboard">Dashboard</a>
		</div>
		<table>
		    <thead>
		        <tr>
		            <th>Name</th>
		            <th>Rating</th>
		            <th>actions</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${results}" var="song">
		        <tr>
		            <td><a href="/songs/<c:out value="${song.id}"/>"><c:out value="${song.title}"/></a></td>
		            <td><c:out value="${song.rating}"/></td>
		            <td>
						<a href="/songs/${song.id}/edit">edit</a> | 
		            	<form action="/songs/${song.id}" method="post" style="display: inline;">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="delete">
						</form>
					</td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>
