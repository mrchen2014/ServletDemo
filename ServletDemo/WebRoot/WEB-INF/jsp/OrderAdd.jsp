<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="content-language" content="zh-CN" />  
	<title>添加订单</title>
	<meta name="Keywords" content="添加订单"/>
	<meta name="Description" content="添加订单"/>
 </head>
 <body>
   <h1>添加订单</h1>
	<form method="post" action="<%=path %>/servlets/Order.html?action=2">
		<table>
		<tr>
			<td>消费人</td>
			<td><input type="text" id="userid" name="userid"/></td>
		</tr>
		<tr>
			<td>品名</td>
			<td><input type="text" id="name" name="name" /></td>
		</tr>
		<tr>
			<td>单价</td>
			<td><input type="text" id="price" name="price" /></td>
		</tr>
		<tr>
			<td>数量</td>
			<td><input type="text" id="numbers" name="numbers" /></td>
		</tr>
		<tr>
			<td>总价</td>
			<td><input type="text" id="total" name="total" /></td>
		</tr>
		<tr> 
			<td colspan="2"><input type="submit" value="提交" /></td>
		</tr>
	</table>
	</form>
 </body>
</html>
