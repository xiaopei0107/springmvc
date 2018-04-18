<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
	<title>新增学生</title>	
	<jsp:include page="/WEB-INF/jsp/rel.jsp"></jsp:include>	
  </head>
  
  <body>
   <form:form action="saveStu" id="stu" modelAttribute="stu" method="post">
	    <table>
	    	<tr>
	    		<td>学生编号</td>
	    		<td>学生姓名</td>
	    		<td>学生年龄</td>
	    	</tr>
	    	<tr>
	    		<td><form:input path="stuId" id="stuId" /></td>
	    		<td><form:input path="stuName" id="stuName" /></td>
	    		<td><form:input path="stuAge" id="stuAge" /></td>
	    	</tr>
	    	<tr><td><input type="submit" value="提交"/></td></tr>
	    </table>
   
   </form:form>
    <br/>
    
  </body>
</html>
