<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.lut.bean.User,com.lut.dao.DBhandleImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>授权</title>
<link rel='stylesheet' type="text/css"  href="css/bootstrap.css">
<link rel='stylesheet' type="text/css"  href="css/bootstrap-theme.css">
<link rel='stylesheet' type="text/css"  href="css/pure-min.css">
</head>
<body>

<s:set value="#request.modify" id="usr"></s:set>
<s:set value="#request.u" id="u"></s:set>

<form action="GrantAction">
<%
	request.setAttribute("id", request.getAttribute("id"));
%>
<center>
<table class="table table table-condensed table-bordered">
<h3 name='maid'>maid:</h3>
<h3 name='id'>id: </h3>
<input type="text" disabled="disabled" value="<s:property value='#usr.id' ></s:property>" name="id"/>
<input type="text" disabled="disabled" value="<s:property value='#u.id' ></s:property>" name="mid"/>
<tr>
<h3>用户名:<s:property value="#usr.username"></s:property></h3>
</tr>
<tr>
<td align="center">
<h3>过去权限:
<s:if test="%{#usr.role==1}">
     	审核</s:if>
     <s:elseif test="%{#usr.role==2}">默认</s:elseif>
     <s:elseif test="%{#usr.role==3}">系统</s:elseif>
</h3>
</td>
</tr>
<tr>
<td align="center">
授权:
<select name="grant">
   <option value="0">发布
   <option value="1">审核
   <option value="2">默认
   <option value="3">系统
  </select>
  </td>
</tr>

<tr>
<td align="center">
<input type="submit" value="提交"/>
<!--   <a class="btn btn-default " href="GrantAction.action?maid=<s:property value='#u.id' ></s:property>&id=<s:property value='#usr.id' ></s:property>">提交</a>
-->
	<input type=button value="返回" class="btn btn-default "onClick="history.back(-1)" >
</td>
</tr>

</table>
</center>
</form>

</body>
</html>