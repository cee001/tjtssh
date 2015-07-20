<%@page import="com.tjt.entity.Power"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
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
    <input id="d1" type="hidden" value="400">   
    <% ArrayList<Power> al=(ArrayList<Power>)request.getAttribute("al");%>   
    <table  style="visibility: visible;position:absolute;font-size: 15px;height:40px;width:95%;text-align: center;" >
     <tr align="center">
     <td style="border-right: 1px solid;border-right-color: #ffffff;">&nbsp;</td>
       <% 
         for(Power p:al){
         if(p.getMenu().getMid()<41001 &&p.getMenu().getMid()>40000){
         
        %> 
       <td style="border-right: 1px solid;border-right-color: #ffffff;width:90px;"><a href="<%=p.getMenu().getNurl() %>" target="tv"><%=p.getMenu().getMtitle() %></a></td>
       <%}} %>
       <td>&nbsp;</td>
     </tr>
    </table>
  </body>
</html>
