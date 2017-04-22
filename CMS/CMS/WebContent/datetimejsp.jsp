<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
<%
response.setHeader("Refresh", "1");
%>

<b>当前时间:</b>
<%
Date d=new Date();
out.println(d.toLocaleString());
%>
</body>
</html>