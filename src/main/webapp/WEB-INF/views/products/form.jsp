<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="/livrospring/produtos">
		<div>
			<label for="title">Titulo</label> <input type="text" name="title" id="title" />
		</div>
		<div>
			<label for="description">Descricao</label>
			<textarea rows="10" cols="20" name="description" id="description">
			</textarea>
		</div>
		<div>
			<label for="pages">Numero de Paginas</label> <input type="text" name="pages" id="pages" />
		</div>
		<c:forEach items="${types}" var="bookType" varStatus="status">
			<div>
				<label for="price_${bookType}">${bookType}</label>
				<input type="text" name="prices[${status.index}].value" id="price_${bookType}"/>
				
				<input type="hidden" name="prices[${status.index}].bookType" value="${bookType}" />
			</div>		
		</c:forEach>
		<div>
			<input type="submit" value="Enviar" />
		</div>
	</form>
	
</body>
</html>