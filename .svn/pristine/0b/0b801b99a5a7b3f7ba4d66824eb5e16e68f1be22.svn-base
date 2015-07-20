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
	<style type="text/css">
		.b1t1{
			background:#3A5FCD;
		}
		.b1t2{
			background:#EEE685;
		}			
	</style>
    <script type="text/javascript">  
         $(function(){   
                        
              $("#divp1").load("qhead.jsp?RandStr="+Math.random()); 	  
              $("#divf2a_new ").load("qdh_mall.jsp"); 
			  $.ajax({ 
            	     async:false,   			          	       		
				     type:"get",
				     url:"qr_zpSearch.jsp", 
				     success:function(d){				                 
				            $("#divf2c_jop").html(d); 
                  			                  
				     }              			
				   });                        
			  $.ajax({ 
            	     async:false,   			          	       		
				     type:"get",
				     url:"qr_listjob.jsp", 
				     success:function(d){				                 
				            $("#ljop1").html(d); 
                            $("#ljop3").load("qfoot_new.jsp"); 				                  
				     }              			
				   }); 	
			document.getElementById("rl1").style.background="#3A5FCD";
			document.getElementById("rl1").style.color="#ffffff";				   
          });             

		function changer(a){
			document.getElementById("rl"+a).style.background="#3A5FCD";
			document.getElementById("rl"+a).style.color="#ffffff";
				
		}
		function rechanger(a){		
			var outid=document.getElementById("routid").value;	   
			if(a==outid){

			document.getElementById(a).style.background="#3A5FCD";
            document.getElementById("rl"+a).style.color="#ffffff";
			}else{	     
		     
		    document.getElementById("rl"+a).style.background="none";
		    document.getElementById("rl"+a).style.color="#3A5FCD";
		    }

			}	
		function changedr(){

		     document.getElementById("rl1").style.background="none";
		     document.getElementById("rl1").style.color="#3A5FCD";
		     document.getElementById("rl2").style.background="none";
		     document.getElementById("rl2").style.color="#3A5FCD";
			
		}	
		function openinfo(n){
		    changedr();
		    if(n==0){
		      document.getElementById("routid").value=1;
			  $.ajax({ 
            	     async:false,   			          	       		
				     type:"get",
				     url:"qr_zpSearch.jsp", 
				     success:function(d){				                 
				            $("#divf2c_jop").html(d); 
                  		    $("#ljop1").load("qr_listjob.jsp"); 	                  
				     }              			
				   });   		    
		    				
			}else{
			  document.getElementById("routid").value=2;
			  $.ajax({ 
            	     async:false,   			          	       		
				     type:"get",
				     url:"qr_qzSearch.jsp", 
				     success:function(d){				                 
				            $("#divf2c_jop").html(d); 
                  		    $("#ljop1").load("qr_listforjob.jsp"); 	                  
				     }              			
				   });  			
			
			}
			
		}
		
  			  
    </script>      
  

  </head>
  
  <body>

    <input id="routid" type="hidden" value="1">
    <input id="doutid" type="hidden" value="3"> 
    <div id="indexdiv"> 
       <div id="divp1">
         
       </div>
       <div id="divp2" onmouseover="rechangex1()">
           <div id="divf2a_new" onmouseover="rechangex1()"  style="border:0px">                  
  
           </div> 
           <div id="divf2b_jop">                  
	          <ul>             			            	
	             <li id="rl1" onclick="openinfo(0)" onmousemove="changer(1)" onmouseout="rechanger(1)">招聘职位</li>
	  
	             <li id="rl2" onclick="openinfo(1)" onmousemove="changer(2)" onmouseout="rechanger(2)" style="margin-left: 10px">求职简历</li>                        			                
	         </ul>	
	         <ul style="width:100%;height:5px;" >            			            
	             <li style="padding:0px;margin-top:0px;width:100%;height:5px;background:#3A5FCD;border-top: 0px;">&nbsp;</li>
	         </ul>	
 
           </div>
           <div id="divf2c_jop">

           </div>            
           <div id="divf2d_jop">   
              <ul>
                <li id="ljop1" style="width:800px">
                    
                </li>
                <li id="ljop2" style="width:180px;margin-left: 18px;float: right;text-align: right;">
	               <img alt="" width="175" src="images/home/zp_06.png"> <br><br>   
	               <img alt="" width="175" src="images/home/zp_07.png">   
                </li>                                                  
              </ul>
              <br>
              <ul style="width:100%;">
	              <li>
	                <br>	
	                <br>	      
	                <table style="height:200px;background: #F7F7F7;"><tr><td id="ljop3" valign="top"></td></tr></table>
	              </li>
              </ul>
         </div> 
  
       </div>
    </div>
  </body>
</html>


