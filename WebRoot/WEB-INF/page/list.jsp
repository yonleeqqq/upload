<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP "list.jsp" starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function fun1(){
			var table = document.getElementById("one");
			
			//get JsonArray
			var jsonArray = eval(${requestScope.json});
			//traverse JsonArray and put data to table
			for(var i = 0; i<jsonArray.length;){
				//get tr object
				var tr = document.createElement("tr");
				//get a jsonObject
				var product = jsonArray[i++];
				//get a td object
				var td = document.createElement("td");
				td.innerHTML="<img src='/upload"+product["imgurl"]+"' width='300' height='200'/><br><a href='/upload/EditServlet?id="+product["id"]+"' >"+product["name"]+"</a><br>"+product["price"]+"元";
				//put td to tr
				tr.appendChild(td);
				//check i to confirm data not null
				if(i<jsonArray.length){
					//get another jsonObject
					var productA = jsonArray[i++];
					//get another td object
					var tdA = document.createElement("td");
					tdA.innerHTML="<img src='/upload"+productA["imgurl"]+"' width='300' height='200'/><br><a href='/upload/EditServlet?id="+productA["id"]+"' >"+productA["name"]+"</a><br>"+productA["price"]+"元";
					//put td to tr
					tr.appendChild(tdA);
				}
				//put tr to table
				table.appendChild(tr);
			};
		}
	</script>

  </head>
  
  <body onload="fun1()" >
  	<table border="1" id="one">
  	<tr>
  	<th colspan="2" align="center">商品列表
  	</th>
  	</tr>
  	</table>
  </body>
</html>
