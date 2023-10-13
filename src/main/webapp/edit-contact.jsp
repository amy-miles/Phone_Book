<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!-- Amy Miles -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Contact</title>
</head>
<body>
		<form action="editContactServlet" method="post">
		Name: <input type="text" name="name" value="${contactToEdit.name}">
		Phone Number: <input type="text" name="pNumber" value="${contactToEdit.pNumber}">
		Birthday: <input type="text" name="bDay" value="${contactToEdit.bDay}">
		<input type="hidden" name="id" value="${contactToEdit.id}"> <input
			type="submit" value="Save Edited Contact">
	</form>
</body>
</html>