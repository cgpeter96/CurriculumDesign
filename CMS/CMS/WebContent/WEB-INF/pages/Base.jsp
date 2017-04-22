<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel='stylesheet' type="text/css"  href="css/bootstrap.css">
<link rel='stylesheet' type="text/css"  href="css/bootstrap-theme.css">
<link rel='stylesheet' type="text/css"  href="css/pure-min.css">

<script language=javascript>
function showhidediv(id){
	var d1=document.getElementById("items");
	var d2=document.getElementById("sendpage");
	if(id == 2){
		
		d1.style.display='none';
		d2.style.display='block'
	}
	else{
		d1.style.display='block';
		d2.style.display='none';
	}
}  

</script>
</head>
<body>
<div  class="container">
		<div class="row">
			<div >
			<center><h2><span class="label label-default">用户:<s:property value="#request.u.getUsername()"/></span></h2></center>
			<nav class=''>
				<center>
					<button class="btn btn-info btn-lg"  onclick="showhidediv(1)">文章列表</button>
					<button class="btn btn-info btn-lg"  onclick="showhidediv(2)">发表文章</button>
				</center>
			</nav>

			</div>
		</div>
</div>
	<div id="items" style="display:block;">
		<s:set value="#request.pages" name="pages"></s:set>
		<caption>最新文章</caption>
		<table class="table">
		<tr><th>标题</th><th>文章内容</th></tr>
  <s:iterator value="pages" id='page'>
  <tr>
  <td><s:property value='#page.title'/></td>
  <td><s:property value='#page.content'/></td>
  </tr>
  </s:iterator>
   
</table>
	<%
		request.setAttribute("username", request.getAttribute("username"));
	%>	
	</div>
	<div id="sendpage" style="display:none;">
		<form method="post" action="SendPage">
			<table>
				<tr>
					<input type="text" class="form-control" name="title" placeholder="标题">
				</tr>
				<br>
				<tr><center>
					<div class="" >
						<input type="radio" name="options"
							id="option1" value="1"  checked="checked"> 生活
						<input type="radio" name="options"
							id="option2" value="2">时事
						 <input type="radio" name="options"
							id="option3" value="3"> 娱乐
						 <input type="radio" name="options"
							id="option4" value="4"> 军事
					</div></center>
				</tr>
				<tr>
					<div class="form-group">
						<label for="name">文本框</label>
						<textarea class="form-control" rows=12 id='txt' name="content" placeholder="请输入新闻内容">
					</textarea>
					</div>
				</tr>
				<tr>
				<center>
				
				  <input class="btn btn-default" type="submit" value="提交">
				<!--<s:submit name="redirect:Base.jsp" value="提交" class="btn btn-default"></s:submit>-->
					<input class="btn btn-default" type="reset" value="重置">
					
					
				</center>
				</tr>
			</table>
		</form>
	</div>
	




</body>
</html>