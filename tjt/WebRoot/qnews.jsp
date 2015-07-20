<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>资讯_合游</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/newStyle.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">

 
		$(function(){ 
 		       
                   $("#divp1").load("qhead.jsp?RandStr="+Math.random()); 	
                   $("#divv2b").load("qdh1.jsp"); 
                   $("#divv2d2_li2").load("new!showlist2.action?num=0");  
                   var mid=$("#ipmid2").val();
	           
				 $.ajax({ 
  			          	       		
				     type:"get",
				     url:"qnews1.jsp?mid="+mid, 
				     success:function(d){				                 
				            $("#divv2d1").html(d); 
                            $("#divv2e").load("qfoot_new.jsp"); 				                  
				     }              			
				   }); 		           

                   
        });
                   
                   
                   
	</script>

  </head>
  
  <body onload="iFrameHeight()" >


		<%			             
         //分割新闻列表页传递来的ip地址参数，取得新闻id
  	     String a = request.getParameter("dd");
         String[] ln=a.split("=");	
         String ids="";
         for(int i=0;i<ln.length;i++){	
         ids=ln[1];
         System.out.println(ids+"------");
         }
	 
       %> 
       <input id="ipmid2" type="hidden" value="<%=ids %>">       
       <div id="indexdiv">                     
	        <div id="divp1">
	        	
	        </div>
	        <div id="divv2" onmouseover="rechangex1()">
	        <div  id="divv20">
	            <ul>
	              <li class="divv2a"><img alt="" src="images/home/new_1.jpg"></li>
	              <li id="divv2b"></li>
	              <li id="divv2c">
			          <table>
				          <tr>
					          <td><img alt="" src="images/home/new_03.png">&nbsp;当前位置：</td>
					          <td>首页&nbsp;<img alt="" src="images/jt07.png">&nbsp;新闻&nbsp;<img alt="" src="images/jt07.png">&nbsp;正文</td>
				          </tr>
			          </table>	              
	              </li>
	              <li id="divv2d">
			        <div id="divv2d1">
		        	
		            </div>	
		            <div id="divv2d2">
                         <ul>
                           <li>	
			        	     <%@include file="qlistsupdem_new.jsp" %>
			               </li>
                           <li style="height:40px;">	
			        	     <img alt="" width="100%" src="images/home/t2.png">
			               </li>				               
                           <li id="divv2d2_li2">	
		
			               </li>			               
                         </ul>                        		        	
		            </div>		              
	              </li>
	              <li id="divv2e"></li>

	            </ul>
		                	
	        </div>
            </div>   
       </div>

  </body>
</html>
