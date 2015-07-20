<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showup.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
 <body bgcolor="#ffffff">

 
  <input type="hidden" name="u.uid" value="${requestScope.u.userId }">

    <table border="1" bordercolor="#B2DFEE" align="center" style="border-collapse: collapse;width:100%;line-height: 25px;font-size:15px;" cellpadding="0" cellspacing="0">
   
    <tr>
       <td align="right" width="48%" bgcolor="#F8F8FF">昵称:</td>
       <td style="padding-left: 20px;">${requestScope.u.userNikename }</td>
    </tr>

     <tr>
        <td align="right"  bgcolor="#F8F8FF">电话:</td>
        <td style="padding-left: 20px;">${requestScope.u.userPhone}</td>
     </tr>
     <tr>
        <td  align="right" bgcolor="#F8F8FF" >姓名:</td>
        <td style="padding-left: 20px;">${requestScope.u.userTruename}</td>
     </tr>
     <tr>
        <td  align="right" bgcolor="#F8F8FF" >职业:</td>
        <td style="padding-left: 20px;">${u.userProfession}</td>
     </tr>



     <tr>        
        <td colspan="2" align="center"> <img src="${requestScope.u.userImgface}"><br>--- 头像  ---</td>
     </tr>
     <tr>
        <td  align="right" bgcolor="#F8F8FF" >注册时间:</td>
        <td style="padding-left: 20px;">${requestScope.u.userTime }</td>
     </tr>
     <tr>
        <td  align="right" bgcolor="#F8F8FF" >地区:</td>
        <td style="padding-left: 20px;" >${u.userCity}&nbsp;${requestScope.u.userAddress}</td>
     </tr>

                  		  

    </table>
 
    
  </body>
</html>
