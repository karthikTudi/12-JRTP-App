<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
</head>

<h1 style="color: red; text-align: center;">Edit Contact Details</h1>

<h3 align="center"><a href="getall">View All Contacts</a></h3>

	<h3 align="center"><a href="welcome">+Add New Contact</a></h3>

<frm:form action="editdata" method="POST" modelAttribute="contactedit">

	<table class="table table-striped table-dark">
	     <tr>
			<td class="text-center">ContactId::</td>
			<td class="text-center"><frm:input path="contactId" readonly="true"/></td>
		 </tr>
		<tr>
			<td class="text-center">ContactName::</td>
			<td class="text-center"><frm:input path="contactName" /></td>
		</tr>
		<tr>
			<td class="text-center">ContactNumber:</td>
			<td class="text-center"><frm:input path="contatcNumber" /></td>
		</tr>
		<tr>
			<td class="text-center">ContactEmail:</td>
			<td class="text-center"><frm:input path="contactEmail" /></td>
		</tr>
		<tr>
			<td colspan="2" class="text-center"><input type="submit" value="SaveData" /></td>
		</tr>
	</table>

</frm:form>