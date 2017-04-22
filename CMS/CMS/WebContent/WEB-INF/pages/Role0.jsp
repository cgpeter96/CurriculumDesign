<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.lut.bean.Page,com.lut.dao.ResDBimpl,com.lut.bean.User" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link rel='stylesheet' type="text/css"  href="css/bootstrap.css">
<link rel='stylesheet' type="text/css"  href="css/bootstrap-theme.css">
<link rel='stylesheet' type="text/css"  href="css/pure-min.css">
</head>
<body>
<div  class="container">
		<div class="row">
			<div >
			<!-- <s:property value="#request.u.getUsername()"/> -->
			<center><h2><span class="label label-default">管理员:<s:property value="#request.u.username"/></span></h2></center>
			<nav class=''>
				<center>
					<label class="btn btn-info btn-lg">用户列表</label>
					
				</center>
			</nav>

			</div>
		</div>
</div>
<div>
 	<%
   	User u1=(User)request.getAttribute("u");//manager
   		out.println(u1+"in role");
   	request.setAttribute("user", u1);
   //	session.putValue("user", u1);
   	%>
<table class="table table-condensed table-bordered table-hover">
<tr><th>编号</th><th>用户名</th><th>权限</th><th>操作</th></tr>
   <s:iterator value="#request.users" id="user">
   	<tr>
  
   	<td align="center"><s:property value="#user.id"/></td>
     <td align="center"><s:property value="#user.username"/></td>
     <td align="center"><s:if test="%{#user.role==1}">
     	审核</s:if>
     <s:elseif test="%{#user.role==2}">默认</s:elseif>
     <s:elseif test="%{#user.role==3}">系统</s:elseif>
     </td>    
     <td>
     
     <a class="btn btn-default " href="OpeateAction.action?a=1&ch=<s:property value="#user.id"/>&maid=<s:property value="#request.u.id"/>">设置权限</a>
	<a class="btn btn-default " href="OpeateAciton.action?a=2&ch=<s:property value="#user.id"/>&maid=<s:property value="#request.u.id"/>">删除用户</a>
     </td>
     </tr>
   </s:iterator>
</table>

</div>

</body>
</html>