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
              $("#ljop1").load("qr_zpdetail1.jsp?rid="+$("#ipmid2").val());                          

              $("#ljop3").load("qfoot_new.jsp"); 				                  
			   
          });             


		function openinfo(n){

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
		    				

			
		}
		
  			  
    </script>      
  

  </head>
  
  <body>

    <input id="ipmid2" type="hidden" value="<%=request.getParameter("rid") %>">     
    <input id="routid" type="hidden" value="1">
    <input id="doutid" type="hidden" value="3"> 
    <div id="indexdiv"> 
       <div id="divp1">
         
       </div>
       <div id="divp2" onmouseover="rechangex1()">
           <div id="divf2a_new" onmouseover="rechangex1()"  style="border:0px">                  
  
           </div> 
           <div id="divf2b_jop">                  
             <table style="font-size:15px">
	          <tr>
		          <td><img alt="" src="images/home/new_03.png">&nbsp;当前位置：</td>
		          <td>首页&nbsp;<img alt="" src="images/jt07.png">&nbsp;招聘求职&nbsp;<img alt="" src="images/jt07.png">&nbsp;招聘详情</td>
	          </tr>
             </table>	
           </div>
           <div id="divf2f_jop">
             <table width="100%">
	             <tr>
	               <td style="padding-left: 20px;">
	                 &nbsp;<div id="dl12" style="font-size: 22px;font-family: 微软雅黑;"></div>
	                 <div id="dl13" style="float: left;margin-top: 10px;font-size: 15px;font-family: 微软雅黑;"></div>
	                 <img alt="" style="float: left;margin-top: 14px;margin-left: 5px" src="images/home/zp_12.png">	                 	                
	               </td>
	               <td align="right" >
	                 <img onmousemove="this.src='images/home/zp_18.png'" onmouseout="this.src='images/home/zp_10.png'" 
	                      style="margin-right: 50px;margin-top: 20px" src="images/home/zp_10.png">
	               </td>
	             </tr>
             </table>
           </div>            
           <div id="divf2g_jop">   
              <ul>
                <li id="ljop1" style="width:740px;">
                    
                </li>
                <li id="ljop2" style="width:240px;margin-left: 18px;float: right; ">
	               <div style="padding-left:20px;width:218px;height:200px;font-size: 16px;border: 1px solid;border-color:#EAEAEA;background:#F0F8FF;">
	                 <ul>
	                   <li id="dl14" style="text-align:left;margin-top: 40px;width:200px;"></li>
	                   <li id="dl15" style="text-align:left;margin-top: 20px;width:200px;"></li>
	                   <li id="dl16" style="text-align:left;margin-top: 20px;width:200px;"></li>
	              
	                   
	                 </ul>
	               </div><br>  
	               <img alt="" width="240" src="images/home/zp_15.png">   
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


