<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty success}">
		<p>${success }</p>
	</c:if>
	<table>
		<tr>
			<td>Titulo</td>
			<td>Valores</td>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td><img alt="summary-image" src="${product.summaryPath}"></td>
				<td>${product.title}</td>
				<td>
					<c:forEach var="p" items="${product.prices}">
						[${p.value } - ${p.bookType }]
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>