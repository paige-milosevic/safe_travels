<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Read Share</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div>
			<h1>Expense Details</h1>
			<p><a href="/">Go Back</a></p>
		</div>
		
		<table>
			<tr>
				<th>Expense Name: </th>
				<td>${expense.expenseName}</td>
			</tr>
			<tr>
				<th>Expense Description: </th>
				<td>${expense.description}</td>
			</tr>
			<tr>
				<th>Vendor: </th>
				<td>${expense.vendor}</td>
			</tr>
			<tr>
				<th>Amount Spent: </th>
				<td>${expense.ammount}</td>
			</tr>
		</table>

	</div>
</body>
</html>