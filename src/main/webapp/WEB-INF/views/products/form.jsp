<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form method="POST" action="/livrospring/produtos" commandName="product" enctype="multipart/form-data">
		<div>
			<label for="title">Titulo</label>
			<form:input path="title"/>
			<form:errors path="title"/>
		</div>
		<div>
			<label for="summary">Sumario do Livro</label>
			<input type="file" name="summary"/>
			<form:errors path="summaryPath"></form:errors>
		</div>
		<div>
			<label for="description">Descricao</label>
			<form:textarea rows="10" cols="20" path="description"/>
			<form:errors path="description"/>
		</div>
		<div>
			<label for="pages">Numero de Paginas</label> 
			<form:input path="pages"/>
			<form:errors path="pages"/>
		</div>
		<c:forEach items="${types}" var="bookType" varStatus="status">
			<div>
				<label for="price_${bookType}">${bookType}</label>
				<form:input path="prices[${status.index}].value" id="price_${bookType }"/>
				<form:errors path="prices"/>
				<input type="hidden" name="prices[${status.index}].bookType" value="${bookType}" />
			</div>		
		</c:forEach>
		<br/>
		<div>
			<label for="releaseDate">Data de lançamento</label>
			<form:input type="date" path="releaseDate"/>
			<form:errors path="releaseDate"/>
		</div>
		
		<div>
			<input type="submit" value="Enviar" />
		</div>
	</form:form>
	
</body>
</html>