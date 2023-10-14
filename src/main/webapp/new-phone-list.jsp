<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Phone List</title>
</head>
<body>
	<form action="createNewPhoneBookServlet" method="post">
		Phone Book Name: <input type="text" name="phoneBookName"><br /> 
		Available Contacts:<br /> <select name="allContactsToAdd" multiple size="6"><!-- allContacts from AddContactsForPhoneBookServlet -->
			<c:forEach items="${requestScope.allContacts}" var="currentcontact">
				<option value="${currentcontact.id}">
					${currentcontact.name}
					| ${currentcontact.pNumber}
					| ${currentcontact.bDay}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create Phone Book and Add Contacts">
	</form>
	<a href="index.html">Add a new contact instead.</a>


</body>
</html>