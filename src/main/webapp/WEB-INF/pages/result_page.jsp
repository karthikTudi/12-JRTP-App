<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<script type="text/javascript">
   function OnDelete(){
	  return confirm('are you sure want to delete the contact')
	  }
</script>
</head>
<h3 style="color: red; text-align: center;">Total ContactDetails"</h3>
<h3 style="color: red; text-align: center;">
	<a href="welcome">+Add New Contact</a>
</h3>

<c:choose>
	<c:when test="${!empty alldetails}">
		<table class="table table-striped">
		<tr class="table-primary">
			<th>ContactId</th>
			<th>ContactName</th>
			<th>ContatcNumber</th>
			<th>ContactEmail</th>
			<th>activeSw</th>
			<th>Operations</th>
			</tr>
			<c:forEach var="details" items="${alldetails}" >
			<tr>
                   <td>${details.contactId}</td>
                   <td>${details.contactName}</td>
                    <td>${details.contatcNumber}</td>
                    <td>${details.contactEmail}</td>
                    <td>${details.activeSw}</td>
                    <td><a href="editdetails?contactId=${details.contactId}">Edit</a>&nbsp;&nbsp;<a href="deletedetails?contactId=${details.contactId}" onclick="return OnDelete()">Delete</a>&nbsp;
			</tr>
			</c:forEach>
		</table>

	</c:when>
	<c:otherwise>
		<h3 style="color: red; text-align: center;">Contact Details Not
			Found</h3>
	</c:otherwise>
</c:choose>

