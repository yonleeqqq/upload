<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="/upload/AddServlet" method="post" enctype="multipart/form-data">
    <table border = "1">
    	<tr>
    		<th colspan="2" align="center">添加商品</th>
    	</tr>
    	<tr>
    		<td>商品名称：</td>
    		<td><input type="text" name = "name"/></td>
    	</tr>
    	<tr>
    		<td>商品价格：</td>
    		<td><input type="text" name = "price"/></td>
    	</tr>
    	<tr>
    		<td>库存：</td>
    		<td><input type="text" name ="pnum"/></td>
    	</tr>
    	<tr>
    		<td>商品描述：</td>
    		<td>
    			<textarea rows="10" cols="50" name = "description"></textarea>
    		</td>
    	</tr>
    	<tr>
    		<td>商品类型:</td>
    		<td>
    			<select name="type">
    				<option value="日用百货">日用百货</option>
    				<option value="电子产品">电子产品</option>
    				<option value="床上用品">床上用品</option>
    			</select>
    		</td>
    	</tr>
    	<tr>
    		<td>商品图：</td>
    		<td>
    			<input type="file" name="img"/>
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2" align="center">
    			<input type="submit" name="添加"/>
    		</td>
    	</tr>
    </table>
    </form>
  </body>
</html>
