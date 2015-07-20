<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Tjthome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>   
	<link href="css/linkStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/tjtmallStyle.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
  
            $(function(){   
                           
                 $("#divp1").load("qhead.jsp?RandStr="+Math.random()); 	  
                 $("#divp2_li1").load("qSearchnews.jsp");                 	  
                 $("#divp2b").load("qdh.jsp"); 	  
                 $("#divp2c3a").load("lunbot.html"); 	                  
                 $("#divp2c3b").load("qlistdate.jsp"); 	        
                 $("#divp2c2a").load("new!showlist1.action?num=0");                                    
                 $("#divp2c2b").load("qlistexchange.jsp");  
                 $("#divp2c1a").load("qlistexchange1.jsp");
                 $("#divp2c1b").load("qlistexchange2.jsp"); 
                 $("#divp2c1c").load("qlistexchange3.jsp");  
                 $("#divp2d1").load("qlistsupdem.jsp");                                  
                 $("#divp2d2").load("qlistjob.jsp");  
                 $("#divp2d3").load("qlistforjob.jsp"); 
                 $("#divp21").load("qfoot.jsp"); 

            	 $.ajax({ 
            	     async:false,   			          	       		
				     type:"get",
				     url:"qlistekNondestructive.jsp?RandStr="+Math.random(), 
				     success:function(d){				                 
				            $("#divp2f").html(d);       
				     }              			
				   });
				 $.ajax({ 
            	     async:false,   			          	       		
				     type:"get",
				     url:"qlistekPhycal.jsp?RandStr="+Math.random(), 
				     success:function(d){				                 
				            $("#divp2g").html(d);       
				     }              			
				   });
				 $.ajax({ 
            	     async:false,   			          	       		
				     type:"get",
				     url:"qlistekpressure.jsp?RandStr="+Math.random(), 
				     success:function(d){				                 
				            $("#divp2h").html(d);       
				     }              			
				   }); 
				 $.ajax({ 
            	     async:false,   			          	       		
				     type:"get",
				     url:"qlistekPole.jsp?RandStr="+Math.random(), 
				     success:function(d){				                 
				            $("#divp2i").html(d);       
				     }              			
				   });
				 $.ajax({ 
            	     async:false,   			          	       		
				     type:"get",
				     url:"qlistekmeasure.jsp?RandStr="+Math.random(), 
				     success:function(d){				                 
				            $("#divp2j").html(d);       
				     }              			
				   });
				 $.ajax({ 
            	     async:false,   			          	       		
				     type:"get",
				     url:"qlistekspecial.jsp?RandStr="+Math.random(), 
				     success:function(d){				                 
				            $("#divp2k").html(d);       
				     }              			
				   });         
				                       
            	 $.ajax({ 			          	       		
				     type:"get",
				     url:"kong.jsp", 
				     success:function(d){
				                 
				            $("#divdh").html(d);
				     		var did=document.getElementById("d1").value;  	
							document.getElementById(did).style.background="url(images/TJT/96.png)";
							document.getElementById(did).style.color="red";	       
				     }              
			
				   });
		   
	  });
	        function openhref(src){
   
       		 $.ajax({ 
			     async:false,    	       		
				     type:"get",
				     url:src+"&RandStr="+Math.random(), 
				     //dataType:json,
				     //cache:"false",

				     success:function(d){
				                 
				                 $("#divp2c2a").html(d);  
	                              
	                             }
	                            
	                        
			
				});	
			}	      
      
  
    </script>
  </head>
  
  <body>
    <div id="indexdiv"> 
       <div id="divp1">         
       </div>
       <div id="divp2" onmouseover="rechangex1()">

             <ul>
               <li id="divp2_li1" style="height:150px"><%@ include file="qSearchnews.jsp" %></li>
               <li id="divp2_li2" style="height:40px">2</li>
               <li id="divp2_li3" style="height:300px">3</li>
               <li id="divp2_li4" style="height:80px">4</li>
               <li id="divp2_li5">5</li>              
               <li id="divp2_li6">6</li>               
               <li id="divp2_li7">7</li>
               <li id="divp2_li8">8</li> 
               <li id="divp2_li9">9</li>     
               <li id="divp2_li10">10</li>                 
             </ul>                         
                         
       </div>    

    </div>
  </body>
</html>
