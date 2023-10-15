<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Lists</title>
</head>
<body>
	<form method="post" action="phoneBookNavServlet">
		<table>
		<c:forEach items ="${requestScope.allPhoneBooks}" var="currentPhoneBook">
		<tr>
		<td></td>
		<td><input type="radio" name="id" value="${currentPhoneBook.id}"></td> <!-- id of details attribute set in viewAllPhoneBooksServlet -->			
		<tr> 
			<td colspan="5"> Phone Book: ${currentPhoneBook.phoneBook.phoneBookName}</td>
		</tr>
		<c:forEach var="pbVal" items="${currentPhoneBook.listOfContacts}"><!-- listOfContacts from PhoneBookDetails class -->
		<tr>
		<td></td>
		<td colspan="5">${pbVal.name}, ${pbVal.pNumber}, ${pbVal.bDay}</td><!-- name,pNumber, bDay from Contact class -->
		</tr>
		</c:forEach>
		</c:forEach>
		</table>
	<input type="submit" value="edit" name="doThisToPhoneBook">
	<input type="submit" value="delete" name="doThisToPhoneBook">
	
	</form>
	<a href="addContactsForPhoneBookServlet">Create a new Phone Book of contacts</a><br/>
	<a href="index.html">Add a new contact</a>
</body>
</html>