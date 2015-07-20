<%@page import="com.tjt.entity.Admin"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@page import="org.jgroups.demos.wb.UserInfoDialog"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'mail.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.bt1{
			background-image:url(images/fb.jpg);
		}
		.bt2{
			background-image:url(images/fb2.jpg);
		}
   </style>
  </head>
  
  <body>
  
    <%
      if(session.getAttribute("login")==null){
               response.sendRedirect("admin.jsp");
               return;
         }else{

         } 
    %> 
    <% Admin u=(Admin)session.getAttribute("login"); %>
    <table width="1000" align="center" style= "border:5px solid;border-color:green;"
           height="750" bgcolor="#FCFCFC">
           
	    <tr>	        
	        <td  height="120" colspan="2" style= "border:1px solid;border-color:green;">
	            <div style="height:120px;float:left">
	                <div style="width:150px;height:120px;float:left">
	               		<table >
	               		 	<!-- <tr><td>&nbsp&nbsp<img alt="" src="images/hy.png"></td></tr> -->
	                	</table>
	                </div>
	                <div style="width:795px;margin-left:0px;float:left">
	                	<table align="center">
	                		<tr><td height="120"><strong style="font-size:30px;color:#FF0000;">智能社区后台管理系统</strong></td></tr>
	                 	</table>
	                </div>	 
                </div>          
	        </td>
	    </tr>  
	    <tr>
	       <td  colspan="2" height="52" background="images/hb1.jpg" > 
	          <div style="color:#FF0000">
		          <div style="text-align:left;float:left;margin-top:16px;">&nbsp&nbsp&nbsp欢迎：<%=u.getLoginId() %></div>
		          <div style="text-align:left;float:left;">
		          <%@ include file="dh.jsp" %></div>
	          </div>
	       </td>
	    </tr>
	    <tr style="height: 520px;">
	    
	       <td valign="top" width="150" style= "border:1px solid;border-color:green;border-top-color:#FF0000;"> 
	             	            	       
	           &nbsp<iframe  width="160" height="650" frameborder="0" src="men!showMenuByRoleId.action">  </iframe>	
	        </td>
	        <td valign="top" style= "border:1px solid;border-color:green;" >
	        
	           <!--  <div style="margin-left: 100px;margin-top:15px;height:42px">	  		            
		            <form action="con!showlist1.action" method="get" target="tv">       
		               <input id="a1" type="text" name="cn.title" size=50 style="height:25px;">
		               <input class="bt1" style="width:80px;height:25px;border: 0px solid;font-size:16px;color:#FFFFFF;" 
		                      type="submit" value="搜 索">		          	
	                </form>   
	            </div> -->
	            <iframe  frameborder="0" name="tv" width="840" height="650" style="margin-top:0px;top:0px;" src="kong.jsp"> </iframe>        
	        </td>	        
	    
	    </tr>
          
    </table>
    
  </body>
</html>
