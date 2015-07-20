<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'qaddcom.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/tjtmallStyle.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
      <div id="divv2fd_new1_ulvi" style="background: #FCFCFC;margin-left: 30px;margin-top: 0px">   
          <input id="recom2" type="hidden" name="TUser.uid" value="">
          <input id="rehuifu" type="hidden" name="huifu" value="">
   	   <ul>
         <li style="float: left;width:100px;margin-left:10px;font-size:16px;font-family:微软雅黑;color:#2E2E2E;">回复评论： </li>	
         <li id="relp00" style="width:400px;text-align:center;margin-left:120px;font-size:15px;color:red;float: right;">&nbsp;</li>  
		 <li style="margin-top:3px;margin-left:630px;height:20px;width:20px;padding: 0px;">
		   <img alt="" onclick="closerecom()" style="cursor:pointer;" src="images/gb.jpg">
		 </li>      
         <li style="margin-top: 42px;margin-left: 10px;width:630px;">	                     
            <textarea id="recom1" onFocus="clearcom()" style="width:610px;height:108px;"></textarea>	                    	                   
         </li>    	                 
         <li style="margin-left:80px;margin-top:160px;">
             <div onclick="addcom(1)" onmousemove="this.style.background='#FFA500'" onmouseout="this.style.background='#CD9B1D'" 
                  style="text-align:center;width:100px;height:22px;padding-top:5px;font-size:15px;color:#FFFFFF;background:#CD9B1D;cursor:pointer;">发 表</div>                             
         </li>                                                 
       </ul>
      </div>   
  </body>
</html>
