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
		<h1>Safe Travels</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Expenses</th>
					<th>Vendor</th> 
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${expenses}" var="expense">
				<tr>
					<td><a href="/expense/${expense.id}"><c:out value="${expense.expenseName}"></c:out></a></td>
					<td><c:out value="${expense.vendor}"></c:out></td>
					<td>$<c:out value="${expense.ammount}"></c:out></td>
					<td><a href="/expense/edit/${expense.id}">Edit</a>
					<form:form action="/delete/${expense.id}" method="delete">
					 <button>Delete</button>
					 </form:form>
					 </td>
					
					
					
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
		<h1>Add an Expense:</h1>
		<form:form action="/expenses" method="POST" modelAttribute="expense">
			<p class="form-group row"> 
				<form:label class="col-sm-2 col-form-label" path="expenseName">Expense Name:</form:label>
				<form:input path="expenseName" type="text"/>
				<form:errors class="text-danger" path="expenseName"/>
			</p>
			<p class="form-group row">
				<form:label class="col-sm-2 col-form-label" path="vendor">Vendor:</form:label>
				<form:input path="vendor" type="text"/>
				<form:errors class="text-danger" path="vendor"/>
			</p>
			<p class="form-group row">
				<form:label class="col-sm-2 col-form-label" path="ammount">Amount:</form:label>
				<form:input path="ammount" type="text"/>
				<form:errors class="text-danger" path="ammount"/>
			</p> 
			<p class="form-group row">
				<form:label class="col-sm-2 col-form-label" path="description">Description:</form:label>
				<form:textarea path="description"></form:textarea>
				<form:errors class="text-danger" path="description"/>
			</p>
			<button type="submit">Submit</button>
		</form:form>
	</div>
	
</body>
</html>