<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.tjt.entity.RoleInfo"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'listbook.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>
		   function dodelete(roleId){
		   if(roleId==6){
		      confirm("员工角色为默认角色，不能删除");
		   	  return false;
		   }
		   if(roleId==1){
		      confirm("超级管理员为最高权限角色，不能删除");
		   	  return false;
		   }
	       if(confirm("确定删除吗？")){
	        
	              location.href="role!doDel.action?ri.roleId="+roleId;
	       }
	   }
	
	</script>
	<style type="text/css">
    a:link{text-decoration : none ;color :#212121;} 
	a:visited {text-decoration : none ;color : #525252 ;} 
	a:hover {text-decoration : underline ;color :#CD0000 ;} 
	a:active {text-decoration : none ;color :#212121 ;}	  
    </style>
  </head>
  
  <body bgcolor="#FFFFFF">
     <div style="width:820px;height:320px;margin-left: 20px;margin-top: 30px;border: 1px solid;border-color:#B2DFEE;overflow:hidden;">
            <div style="width:818px;height:27px;border:1px solid;font-size:15px;
                 border-color:#ffffff;border-bottom-color:#B2DFEE;background: #F0F8FF;">
                 <div  style="margin-top: 5px;margin-left: 12px"> 
                    <b>列表角色</b> 
                 </div>
            </div>
     <br>            
     <table align="center">
          <%
            ArrayList<RoleInfo> al=(ArrayList<RoleInfo>)request.getAttribute("al");
   
            for(RoleInfo bt:al){
           %>              
          <tr> 
             
             <td>
                <ul style="margin-left:-3px;width:820px;height:25px;font-size:15px;
                    border: 1px solid;border-color:#B2DFEE;border-left-color:#ffffff;padding: 0px">
                   <li style="margin-left:0px;width:100px;float: left;color:#FF6347;text-align:right;width:271px;height:23px;
                       border: 1px solid;border-color:#FFFFFF;border-right-color: #B2DFEE;background: #F0F8FF;">
                     <div style="margin-top: 4px"><%=bt.getRoleName() %></div>
                   </li>             
                   <li style="float: left;list-style-type:none;width:271px;height:23px;text-align:center;
                       border: 1px solid;border-color:#FFFFFF;border-right-color: #B2DFEE;">
                       <div style="margin-top: 4px"><a href="#" onclick="dodelete(<%=bt.getRoleId() %>)">删除</a></div>
                   </li>   
                   <li style="float: left;list-style-type:none;text-align:center;width:271px;height:23px;">               
                       <div style="margin-top: 4px"><a href="men!showlist.action?rid=<%=bt.getRoleId() %>"  >权限分配</a></div>                       
                   </li>
                   
                </ul>
  
             </td>
            <%
               }
             %>
          </tr>
     </table>
     <br/> 
     </div>
  </body>
</html>
