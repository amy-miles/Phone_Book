<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit and Existing Phone List</title>
</head>
<body>
	<form action="editListDetailsServlet" method="post">
		<input type="hidden" name="id" value="${pbDetailsToEdit.id }">		
		Phone Book Name: <input type="text" name = "phoneBookName" value="${pbDetailsToEdit.phoneBook.phoneBookName }">
		<br/>
		
		Available Contacts:<br/>		
		<select name="allContactsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allContacts}" var="currentcontact">
				<option value ="${currentcontact.id}">
				${currentcontact.name } | ${currentcontact.pNumber} | ${currentcontact.bDay}
				</option>
			</c:forEach>		
		</select><br/>
		
		<input type="submit" value="Edit List and Add Contacts"><br/>			
	</form>
	<a href = "index.html">Add New Contacts Instead</a>
</body>
</html>