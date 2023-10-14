<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New List</title>
</head>
<body>
	<form action="createNewPhoneBookServlet" method="post">
		Phone Book Name: <input type="text" name="phonebookname"><br /> 
		Available Contacts:<br /> <select name="allContactsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allItems}" var="currentcontact">
				<option value="${currentcontact.id}">
					${currentcontact.name}
					| ${currentcontact.pNumber}
					| ${currentcontact.bday}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create Phone Book and Add Contacts">
	</form>
	<a href="index.html">Add a new contact instead.</a>


</body>
</html>