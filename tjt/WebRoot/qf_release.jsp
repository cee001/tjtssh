<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>  
	<link href="css/linkStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/tjtmallStyle.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="kindeditor-4.1.10/themes/default/default.css" />
	<script charset="utf-8" type="text/javascript" language="javascript" src="kindeditor-4.1.10/kindeditor.js"></script>	
	<script charset="utf-8" type="text/javascript" language="javascript" src="kindeditor-4.1.10/lang/zh_CN.js"></script>

    <script type="text/javascript">  
         $(function(){   
                        
              $("#divp1").load("qhead_forum.jsp?RandStr="+Math.random()); 	  

 
          });             


    </script>      
  

  </head>
  
  <body>

    <input id="rid10" type="hidden" value="">     
	<% 
      Cookie[] cookies= request.getCookies();
      int userId=0;
      if(cookies!=null &&cookies.length>0){
         for(int i=0;i<cookies.length;i++){
          if(cookies[i].getName().equals("mrCookie")){
             userId=Integer.parseInt(cookies[i].getValue().split("#")[0]); 
         }
      }
      }
     if(userId==0){
        response.sendRedirect("qlogin.jsp");
        return;
      }
    %>
    <input id="f0" type="hidden" value="<%=userId %>">    
    <div id="indexdiv"> 
       <div id="divp1">
         
       </div>
       <div id="divp2" onmouseover="rechangex1()">
           
	       <div style="visibility: visible;position:absolute;width:1000px;height:800px;overflow:hidden;">
             <iframe frameborder="0" style="width:100%;height:1200px;margin-top:0px;" src="qf_release1.jsp"></iframe>     
	         
	       </div>
 
  
       </div>
    </div>
  </body>
</html>


