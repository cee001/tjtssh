<%@page import="com.tjt.entity.Power"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'grzxh.jsp' starting page</title>
    
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
    <input id="d1" type="hidden" value="300">
    <% ArrayList<Power> al=(ArrayList<Power>)request.getAttribute("al");%>   
    <table  style="visibility: visible;position:absolute;font-size: 15px;height:40px;width:810px;left: 2.2%;" >
     <tr align="center">
       <% 
         for(Power p:al){
         if(p.getMenu().getMid()<31001 &&p.getMenu().getMid()>29999){
         
        %>  
       <td style="font-family: 黑体;color:#1874CD"><%=p.getMenu().getMtitle() %> ></td>
       <%
       for(Power pr:al){
       if(pr.getMenu().getParentId()==p.getMenu().getMid()){ %>
       <td style="border-right: 1px solid;border-right-color: #ffffff"><a href="http://xheyou.com/TJT/<%=pr.getMenu().getNurl() %>" target="tv"><%=pr.getMenu().getMtitle() %></a></td>
 
       <%}}}} %>
     </tr>
    </table>
  
  </body>
</html>
