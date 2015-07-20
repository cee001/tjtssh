
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>个人中心_合游</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link href="css/uicenter1Style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>

	<link rel="stylesheet" href="kindeditor/themes/default/default.css" />

	<script charset="utf-8" type="text/javascript" language="javascript" src="kindeditor-4.1.10/kindeditor-min.js"></script>
	
	<script charset="utf-8" type="text/javascript" language="javascript" src="kindeditor-4.1.10/lang/zh_CN.js"></script>
	

    <style type="text/css">

		.bt10{
			background-image:url(images/ui1.png);
		}
		.bt11{
			background-image:url(images/ui2.png);
		}  
 
	#ulu{padding: 0px;margin-top:10px;margin-left: 200px;height:30px;list-style-type: none;}
    #ulu li{ float: left;font-size:15px;margin: 0 10px;padding-top:5px;width:80px;height:30px;text-align: center;font-family: 微软雅黑;color:#4A708B;cursor:pointer;}    
    </style>
    <script type="text/javascript">
		function changed(a){
			document.getElementById("l"+a).style.background="#4A708B";
			document.getElementById("l"+a).style.color="#ffffff";
				
		}
		function rechanged(a){		
			var outid=document.getElementById("outid").value;	   
			if(a==outid){

			document.getElementById(a).style.background="#4A708B";
            document.getElementById("l"+a).style.color="#ffffff";
			}else{	     
		     
		    document.getElementById("l"+a).style.background="none";
		    document.getElementById("l"+a).style.color="#4A708B";
		    }

			}	
		function changedd(){

		     document.getElementById(l1).style.background="#104E8B";
		     document.getElementById(l1).style.color="#ffffff";
		     document.getElementById(l2).style.background="#104E8B";
		     document.getElementById(l2).style.color="#ffffff";
		     document.getElementById(l3).style.background="#104E8B";
		     document.getElementById(l3).style.color="#ffffff";
		     document.getElementById(l4).style.background="#104E8B";
		     document.getElementById(l4).style.color="#ffffff";
		     document.getElementById(l5).style.background="#104E8B";
		     document.getElementById(l5).style.color="#ffffff";
		     document.getElementById(l6).style.background="#104E8B";
		     document.getElementById(l6).style.color="#ffffff";
			
		}	
	
            $(function(){   
    
                 document.getElementById("l1").style.background="#4A708B";
                 document.getElementById("l1").style.color="#ffffff";  	
                 });             
                 
        function openhref(src){
        
              window.open(src,target="_blank");
               
        }          
    </script>

  </head>
  
  <body>
       <input id="outid" type="hidden" value="1">
       <div style="width:100%;height:50px;padding: 0px;margin-top:0px;margin-left: 0px;">	
          <ul id="ulu">             			            

             <li id="l1" onclick="openhref('Tjthome.html')" onmousemove="changed(1)" onmouseout="rechanged(1)">首页</li>
  
             <li id="l2" onclick="openhref('Tjtmall.html')" onmousemove="changed(2)" onmouseout="rechanged(2)" >商城</li>
     
             <li id="l3" onclick="openhref('qrecruitment.jsp')" onmousemove="changed(3)" onmouseout="rechanged(3)">招聘求职</li>
         
             <li id="l4" onclick="openhref('Tjtforum.html')" onmousemove="changed(4)" onmouseout="rechanged(4)">论坛</li>
       
             <li id="l5" onclick="openhref('Tjtforum.html')" onmousemove="changed(5)" onmouseout="rechanged(5)">知识</li>
    
             <li id="l6" onclick="openhref('com!showlist2.action?ruid=')" onmousemove="changed(6)" onmouseout="rechanged(6)">管理</li>                          			                
         </ul>	
         <ul style="padding: 0px;margin-top:0px;width:100%;height:10px;" >            			            
             <li style="padding: 0px;width:100%;height:5px;background:#4A708B">&nbsp;</li>
         </ul>	
   
       </div>



  </body>
</html>
