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
              $("#ljop1").load("qr_qzdetail1.jsp?fid="+$("#ipmid2").val());  
              $("#ljop2").load("qr_listsupdem.jsp");                         
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

    <input id="ipmid2" type="hidden" value="<%=request.getParameter("fid") %>">     
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
		          <td>首页&nbsp;<img alt="" src="images/jt07.png">&nbsp;招聘求职&nbsp;<img alt="" src="images/jt07.png">&nbsp;求职详情</td>
	          </tr>
             </table>	
           </div>        
           <div id="divf2h_jop">   
              <ul>
                <li id="ljop1" style="width:740px;border: 1px solid;border-color:#EAEAEA;border-top: 0px;">                    
              
                </li>
                <li  style="width:240px;margin-left: 18px;float: right;text-align: center; ">
	               <div id="ljop2" style="width:238px;height:200px;border: 1px solid;border-color:#EAEAEA;">

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


