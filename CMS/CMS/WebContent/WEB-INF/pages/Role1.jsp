<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.lut.bean.Page,com.lut.dao.ResDBimpl" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>审核管理</title>
<link rel='stylesheet' type="text/css"  href="css/bootstrap.css">
<link rel='stylesheet' type="text/css"  href="css/bootstrap-theme.css">
<link rel='stylesheet' type="text/css"  href="css/pure-min.css">
</head>

<body>
<div  class="container">
		<div class="row">
			<div >
			<center><h2><span class="label label-default">审核:<s:property value="#request.username"/></span></h2></center>
			<nav class=''>
				<center>
					<button class="btn btn-info btn-lg">文章列表</button>
					<button class="btn btn-info btn-lg">审核文章</button>
				</center>
			</nav>

			</div>
		</div>
</div>
<div>
<s:set name="pages" value="#request.pages"></s:set>
<table class="table table-condensed table-bordered table-hover">
<tr><th>编号</th><th>标题</th><th >类型</th><th>内容</th><th>状态</th><th>操作</th></tr>
   <s:iterator value="pages" id="page">
   	<tr>
   	<td align="center"><s:property value="#page.id"/></td>
     <td align="center"><s:property value="#page.title"/></td>
     <td align="center"><s:if test="%{#page.kind==1}">
     	生活</s:if>
     <s:elseif test="%{#page.kind==2}">时事</s:elseif>
     <s:elseif test="%{#page.kind==3}">娱乐</s:elseif>
     <s:elseif test="%{#page.kind==4}">军事</s:elseif>
     </td>
     <td align="center"><s:property value="#page.content"/></td>
     <td align="center"><s:property value="#page.role"/></td>
     <td>
     <a class="btn btn-default " href="AgreeAction?id=<s:property value="#page.id"/>&username=${ request.username}">接受</a>
     
	<a class="btn btn-default " href="RejectAction?id=<s:property value="#page.id"/>&username=${ request.username}">拒绝</a>
     </td>
     </tr>
   </s:iterator>
</table>
</div>
</body>
</html>