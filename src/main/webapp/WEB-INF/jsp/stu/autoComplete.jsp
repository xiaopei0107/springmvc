<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
	<title>学生</title>	
	<jsp:include page="/WEB-INF/jsp/rel.jsp"></jsp:include>	
	<script type="text/javascript">

	$(function(){
			alert("1");
			 $("#vip_n").bigAutocomplete({data:[{title:"book"},
			                                    {title:"blue"},
			                                    {title:"冠达尔钢结构（江苏）有限公司"},
			                                    {title:"本钢国贸有限公司"},
			                                    {title:"bool6"},
			                                    {title:"bool2"},
			                                    {title:"bus"}]});
			 
		$('#stu').bigAutocomplete({
			url:'${pageContext.request.contextPath}/stu/searchAuto',
			callback:function(data){
		            alert(data.title);    
		    }
		
		});

	});
	</script>
  </head>
  
  <body>
  自动补全： <input id="vip_n" type="text"/>
  <br/>
  <input id="stu" type="text"/>
    
  </body>
</html>
