<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
	<title>学生</title>	
	<jsp:include page="/WEB-INF/jsp/rel.jsp"></jsp:include>	
  </head>
  
  <body>
    <table>
    	<tr>
    		<td>姓名</td>
    		<td>年龄</td>
    	</tr>
    	<c:forEach items="${stuList}" var="stu">
    	<tr>
    		<td>${stu.stuName }</td>
    		<td>${stu.stuAge }</td>
    	</tr>
    	</c:forEach>
    </table>
    <br/>
    
  </body>
</html>
