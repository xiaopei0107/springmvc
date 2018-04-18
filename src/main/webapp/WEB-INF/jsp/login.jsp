<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
	<title>登录</title>
	
	<jsp:include page="/WEB-INF/jsp/rel.jsp"></jsp:include>
	<script type="text/javascript">
		$(function(){
			//alert("登录页面");
		});
	</script>	
  </head>
  
  <body>
  
  	 <a href="${pageContext.request.contextPath}/stu/toAddStu">添加学生信息</a>
  	<br>
     <a href="${pageContext.request.contextPath}/stu/showStu">学生信息</a>
  </body>
</html>
