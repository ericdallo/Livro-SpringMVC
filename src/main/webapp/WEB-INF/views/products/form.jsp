<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de produtos</title>
</head>
<body>

	<h2>Cadastro de Produtos</h2>
	<form method="POST" action='<c:url value="/produtos"/>'>
		<div>
			<label for="title">Titulo</label>
			 <input type="text" name="title" id="title" />
		</div>
		<div>
			<label for="description">Descricao</label>
			<textarea rows="4" cols="20" name="description" id="description">
			</textarea>
		</div>
		<div>
			<label for="pages">Numero de Paginas</label> 
			<input type="text" name="pages" id="pages" />
		</div>
		<div>
			<input type="submit" value="Enviar" />
		</div>
	</form>
</body>
</html>