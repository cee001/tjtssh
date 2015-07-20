<%@page import="com.tjt.entity.Power"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
			
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'head.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="jquery-1.4.1.js"></script>
	<style type="text/css">
		.bh1{
			background-image:url(images/TJT/96.png);
		}
		.bh2{
			background-image:url(images/TJT/1.png);
		}


   </style>
 
       <script type="text/javascript">
   
		function changeh(id){
			document.getElementById(id).style.background="url(http://xheyou.com/TJT/images/TJT/96.png)";
			document.getElementById(id).style.color="red";
								
		}
		function rechangeh(id){
		    var did=document.getElementById("d1").value;
            if(id==did){
	            document.getElementById(id).style.background="url(http://xheyou.com/TJT/images/TJT/96.png)";
				document.getElementById(id).style.color="red";
            }else{
				document.getElementById(id).style.background="none";
				document.getElementById(id).style.color="#ffffff";
            }
	    }
	    function clickchange(){
				document.getElementById(100).style.background="none";
				document.getElementById(100).style.color="#ffffff";  	    
				document.getElementById(200).style.background="none";
				document.getElementById(200).style.color="#ffffff";  
				document.getElementById(300).style.background="none";
				document.getElementById(300).style.color="#ffffff";  
				document.getElementById(400).style.background="none";
				document.getElementById(400).style.color="#ffffff";  
				document.getElementById(500).style.background="none";
				document.getElementById(500).style.color="#ffffff";  	
				document.getElementById(600).style.background="none";
				document.getElementById(600).style.color="#ffffff";  																    
	    }
	    
	    
	    $(function(){   
            getMyTime();
       		var did=document.getElementById("d1").value;  	
			document.getElementById(did).style.background="url(images/TJT/96.png)";
			document.getElementById(did).style.color="red";	
       	  });
       	              //获取系统时间
            function getMyTime(){
              var myDate = new Date();
              var Y=myDate.getFullYear();   
 
              var M=myDate.getMonth();  
              M=M+1;   
              if(M<10){
                 M="0"+M;
              }         
              var D=myDate.getDate();  
              if(D<10){
                 D="0"+D;
              }  
              var H=myDate.getHours();
              var MI=myDate.getMinutes();
              var X= myDate.getDay();
              if(X==0){
              X="星期天";
              }else if(X==1){
              X="星期一";
              }else if(X==2){
              X="星期二";
              }else if(X==3){
              X="星期三";
              }else if(X==4){
              X="星期四";
              }else if(X==5){
              X="星期五";
              }else if(X==6){
              X="星期六";
              }
              if(MI<10){
                    MI="0"+MI;
              }  
              var time=Y+"年"+M+"月"+D+"日 "+X+" "+H+":"+MI;
                    
              $("#timeid").html(time); 
              window.setTimeout("getMyTime()",20000);
              }
		</script>
  </head>
  
  <body >

       
        <div style="width:100%;height:40px;overflow:hidden;background:url(images/TJT/dh.png);">   
        <% ArrayList<Power> al=(ArrayList<Power>)request.getAttribute("al");%>     
        <table width="100%" style="height:40px;overflow:hidden;margin-left: -1px;">        
           <tr>
              <td style="width:18%;border-right: 1px solid;border-right-color:#757575;">
                  <div style="width:100%;height:100%;text-align: left;">
                  	    <div style="height:100%;width:20%;float: left">
	                     
	                    </div>
	                    <div style="margin-top:4%;width:60%;float: left">
	                     <img width="100%" height="50%" src="images/TJT/ht.png">
	                    </div>
                  </div>
              </td>

            <% 
              for(Power p:al){
              if(p.getMenu().getMid()<700){
             %>     
              <td align="center" style="width:120px;border-right: 1px solid;border-right-color:#757575;">
               <div style="width:100%;height:100%;overflow:hidden;">
                 <div style="margin-top:8px;">  
                                                                    
	             <a style=" text-decoration : none ;color :#ffffff;"  onclick="openhref('<%=p.getMenu().getMid() %>')" >
	                                                  
	              <input id="<%=p.getMenu().getMid() %>" onmouseover="changeh(<%=p.getMenu().getMid() %>)" 
	                     onmouseout="rechangeh(<%=p.getMenu().getMid()%>)"   
	                     style="width:96px;height:32px;border: 0px;font-family:黑体; font-size:14px;color:#FFFFFF;background:none" 
	                     type="button" value="<%=p.getMenu().getMtitle() %>">                                 
	             </a> 
	             
                 </div>
                </div>     	                                                                        
              </td>              

               <%}} %>  
              <td align="right"><div id="timeid" style="margin-right: 30px;font-size: 15px;color:#ffffff;"></div></td>  
        </table>
       </div>
 

	
	        
  </body>
</html>
	        