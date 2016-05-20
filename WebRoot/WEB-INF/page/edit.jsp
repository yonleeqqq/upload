<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
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
  	<form action="/upload/ModifyServlet" method="post" enctype="multipart/form-data">
    <table border = "1">
    	<tr>
    		<th colspan="2" align="center">修改商品</th>
    	</tr>
    	<tr>
    		<td>商品名称：</td>
    		<td><input type="text" name = "name" value="${requestScope.product.name }"/></td>
    	</tr>
    	<tr>
    		<td>商品价格：</td>
    		<td><input type="text" name = "price" value="${requestScope.product.price }"/></td>
    	</tr>
    	<tr>
    		<td>库存：</td>
    		<td><input type="text" name ="pnum" value="${requestScope.product.pnum }"/></td>
    	</tr>
    	<tr>
    		<td>商品描述：</td>
    		<td>
    			<textarea rows="10" cols="50" name = "description" >
    			${requestScope.product.description }
    			</textarea>
    		</td>
    	</tr>
    	<tr>
    		<td>商品类型:</td>
    		<td>
    			<select name="type" >
    				<option value="日用百货" ${requestScope.product.type=="日用百货"?"selected":"" }>日用百货</option>
    				<option value="电子产品" ${requestScope.product.type=="电子产品"?"selected":"" }>电子产品</option>
    				<option value="床上用品" ${requestScope.product.type=="床上用品"?"selected":"" }>床上用品</option>
    			</select>
    		</td>
    	</tr>
    	<tr>
    		<td>图</td>
    		<td><img src="/upload${requestScope.product.imgurl }" width="300" height="200"/></td>
    	</tr>
    	<tr>
    		<td>商品图：</td>
    		<td>
    			<input type="file" name="img"/>
    		</td>
    	</tr>
    	<tr>
    		<td colspan="2" align="center">
    			<input type="submit" name="修改"/>
    			<input type="button" name="删除"/>
    		</td>
    	</tr>
    </table>
    <input type="hidden" name="id" value="${requestScope.product.id }"/>
    </form>
  </body>
</html>
