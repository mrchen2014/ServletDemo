<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="cn.edu.ccnu.imd.study.demo.vo.OrderVo" %>
<%
String path = request.getContextPath();
List l = (List)request.getAttribute("OrderList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta http-equiv="content-language" content="zh-CN" />  
	<title>订单列表</title>
	<meta name="Keywords" content="订单列表"/>
	<meta name="Description" content="订单列表"/>
 </head>
 <body>
   <h1>订单列表</h1>
	<div><a href="<%=path %>/servlets/Order.do?method=toAdd">添加订单</a></div>
		<table>
		<tr>
			<th>消费人</th>	 
			<th>品名</th>	 
			<th>单价</th>	 
			<th>数量</th>
			<th>总价</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<% 
		for(int i=0;l!=null && i<l.size();i++){
			OrderVo vo = (OrderVo)l.get(i);
		%>
		<tr>	 
			<td ><%=vo.getUserid() %></td>
			<td ><%=vo.getName() %></td>
			<td ><%=vo.getPrice() %></td>
			<td ><%=vo.getNumbers() %></td>
			<td ><%=vo.getTotal() %></td>
			<%if(vo.getState() == 1){%>
			<td style="color:green;">已支付</td>
			<%}else {%>
			<td style="color:red;">未支付</td>
			<%}%>
			<td ><%if(vo.getState() == 0){%><a href="<%=path %>/servlets/Order.do?method=updateState&state=1&id=<%=vo.getId() %>">支付</a>&nbsp;<a href="<%=path %>/servlets/Order.do?method=toUpdate&id=<%=vo.getId() %>">修改</a>&nbsp;<a href="<%=path %>/servlets/Order.do?method=delete&id=<%=vo.getId() %>">删除</a><%}%> &nbsp;</td>
		</tr>
		<% 
		}
		%>	
	</table>
	
 </body>
</html>
