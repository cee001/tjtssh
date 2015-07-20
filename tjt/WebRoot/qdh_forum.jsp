
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
  
 
	#ulu{padding: 0px;margin-top:0px;margin-left: 200px;height:40px;list-style-type: none;}
    #ulu li{ float: left;font-size:15px;margin: 0 10px;padding-top:10px;width:80px;height:30px;text-align: center;font-family: 微软雅黑;color:#ffffff;cursor:pointer;}    
    </style>
    <script type="text/javascript">
		function changedh(a){
			document.getElementById("l"+a).style.background="#CD9B1D";
	
				
		}
		function rechangedh(a){		
			var outid=4;	   
			if(a==outid){
			document.getElementById(a).style.background="#CD9B1D";
     
			}else{	     
		     
		    document.getElementById("l"+a).style.background="#EEE685";

		    }

			}	

            $(function(){   
    
                 document.getElementById("l4").style.background="#CD9B1D";

                 });                    
                 
        function openhref(src){
        
               window.location.href=src;
               
        }               
        
        
        
                
    </script>

  </head>
  
  <body>
       <input id="outid" type="hidden" value="2">
       <div style="width:100%;height:40px;padding: 0px;margin-top:0px;margin-left: 0px;background:#EEE685">	
          <ul id="ulu">             			            

             <li id="l1" onclick="openhref('Tjthome.html')" onmousemove="changed(1)" onmouseout="rechanged(1)">首页</li>
  
             <li id="l2" onclick="openhref('Tjtmall.html')" onmousemove="changed(2)" onmouseout="rechanged(2)" >商城</li>
     
             <li id="l3" onclick="openhref('qrecruitment.jsp')" onmousemove="changed(3)" onmouseout="rechanged(3)">招聘求职</li>
         
             <li id="l4" onclick="openhref('Tjtforum.html')" onmousemove="changed(4)" onmouseout="rechanged(4)">论坛</li>
       
             <li id="l5" onclick="openhref('Tjtforum.html')" onmousemove="changed(5)" onmouseout="rechanged(5)">知识</li>
    
             <li id="l6" onclick="openhref('com!showlist2.action?ruid=')" onmousemove="changedh(6)" onmouseout="rechangedh(6)">管理</li>                          			                
         </ul>	

   
       </div>



  </body>
</html>
