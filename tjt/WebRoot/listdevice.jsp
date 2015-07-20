<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'listui.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>	 
	<style type="text/css">
		a:link{text-decoration : none ;color :#104E8B;} 
		a:visited {text-decoration : none ;color : #525252;} 
		a:hover {text-decoration : underline ;color :#CD0000 ;} 
		a:active {text-decoration : none ;color :#212121 ;}	  	
	</style>
    <script type="text/javascript">
			$(function(table){
			    $("tr:odd").css({background: "#F8F8FF"}); // 1, 3…… 行
			    $("tr:even").css({background: "#ffffff"}); // 2, 4…… 行
			});
  	    function changeif(a){

            if(a==1){
	        document.getElementById("dvif1").style.display="block";
            }else{
	        document.getElementById("dvif1").style.display="none";	   
	        } 
	    }   
	   function rehref(){
	   
	   } 
	   
       function doUpdate(cid,para){
             if(para==1){
             if(confirm("确定恢复吗？")){
                $.ajax({
                       async:false,
				       type:"post",                         
				       url:"any!doUpdate1.action?cid="+cid,	 
				       data:"companyStatus="+para,		
				       success:function(d){	
				               if(d>0){
				                      
		                       }                                                                     
			                    }	                                  		           		                  	     		     		
				       });
				     

         }
         alert("ok");
         window.location.href="any!showlist.action?aid="+3; 		
         }else{
             if(confirm("确定冻结吗？")){
                $.ajax({
                       async:false,
				       type:"post",                         
				       url:"any!doUpdate1.action?cid="+cid,	 
				       data:"companyStatus="+para,		
				       success:function(d){	
				               if(d>0){
				                      
		                       }                                                                     
			                    }	                                  		           		                  	     		     		
				       });
				     

         }
         alert("ok");         
         window.location.href="any!showlist.action?aid="+1; 	         
         
         }
         }
         	  	    
    </script>

  </head>
  
  <body >
    <table border="1" bordercolor="#B2DFEE" align="center" style="border-collapse: collapse;width:100%;line-height: 25px;font-size:15px;" cellpadding="0" cellspacing="0">
         <tr>     
          <td colspan="6" bgcolor="#F0F8FF">
            <div style="font-size:15px;border-bottom:1px solid;border-bottom-color:#B2DFEE;">
                 <div  style="margin-top: 5px;margin-left: 12px"> 
                 <b>列表设备</b> 
                 </div>
            </div>
          </td>   
         </tr> 
        <tr>     
          <td colspan="6"  bgcolor="#ffffff">
	       <div id="dvif1" style="display: none;width:100%;">
	       	<div style="font-size:15px;width:100%;">
               <div  style="margin-top: 0px;margin-left: 0px;padding:0px;text-align: right;width:100%;"> 
                  <ul style="padding: 0px;margin-top:0px;list-style-type: none;float: right;width:100%;border-bottom:1px solid;border-bottom-color:#B2DFEE;background: #F8F8FF;">
                   <li style="margin-right: 0px;margin-top: 0px;margin-right:1px;float: right;">
                     <img width="22px" onclick="changeif()"  alt="" src="images/gb.jpg">
                   </li>
                   <li style="margin-right: 47%;float: right;color:#5B5B5B"><b>详情</b></li>
                  </ul>             
	          </div>
              <iframe frameborder="0" name="tvc" style="width:100%;height:550px;margin-top:0px;" ></iframe>         
             </div>     
	       </div>
          </td>   
      </tr>        
         <tr align="center">
             <td>设备所有人</td>
             <td>设备名称</td>
             <td>录入时间</td>
             <td>录入人员</td>
      
             <td>操作</td>  
          </tr>
    <c:forEach var="de" items="${requestScope.al}">
    
         <tr align="center">
             <td>${de.TUserByUserId.userNikename}</td>         
             <td>${de.deviceName}</td>
             <td>${de.deviceFirsttime}</td>             
             <td>${de.TUserByCreateuserId.userNikename}</td>


             <td>

               <a onclick="changeif(1)" href="dev!showDetail.action?de.deviceId=${de.deviceId }" target="tvc">详细</a> 
 		                
             </td>  
          </tr>
    </c:forEach>
          <tr>
             <td colspan="6" >&nbsp;</td>
          </tr>
          <tr>
             <td colspan="6" align="center">${requestScope.pager} </td>
          </tr>            
    </table>
  </body>
</html>
