<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="aaa"></c:out>
	<c:set var="a" value="bbb" scope="session"></c:set>
	${sessionScope.a}
	<c:remove var="a"/>
	${sessionScope.a == null}
	<br/>
	<c:url value="/index.jsp">
		<c:param name="username" value="张三"></c:param>
	</c:url>
	<c:if test="${ 1==1 }">
	</c:if>
	<c:choose>
		<c:when test=""></c:when>
	</c:choose>
	<c:forEach var="i" begin="1" end="10" step="2">
		${i }
	</c:forEach>
	<%
		Date date = new Date();
		request.setAttribute("date", date);
	%>
	<fmt:formatDate value="${requestScope.date}" pattern="yyyy-MM-dd HH:mm:ss"/>
</body>
</html>