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
		<h1>Add an Expense:</h1>
		<form:form action="/expenses" method="POST" modelAttribute="expense">
			<p class="form-group row"> 
				<form:label class="col-sm-2 col-form-label" path="expenseName">Expense Name:</form:label>
				<form:input path="expenseName" type="text"/>
			</p>
			<p class="form-group row">
				<form:label class="col-sm-2 col-form-label" path="vendor">Vendor:</form:label>
				<form:input path="vendor" type="text"/>
			</p>
			<p class="form-group row">
				<form:label class="col-sm-2 col-form-label" path="ammount">Amount:</form:label>
				<form:input path="ammount" type="text"/>
			</p> 
			<p class="form-group row">
				<form:label class="col-sm-2 col-form-label" path="description">Description:</form:label>
				<form:textarea path="description"></form:textarea>
			</p>
			<button type="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>