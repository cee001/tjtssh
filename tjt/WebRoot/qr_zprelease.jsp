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

    <script type="text/javascript">  
         $(function(){   
                        
              $("#divp1").load("qhead.jsp?RandStr="+Math.random()); 	  
              $("#divf2a_new ").load("qdh_mall.jsp");                       
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

           <div id="divf2b_jop" style="margin-top: 0px;">                  
             <table style="font-size:15px">
	          <tr>
		          <td><img alt="" src="images/home/new_03.png">&nbsp;当前位置：</td>
		          <td>首页&nbsp;<img alt="" src="images/jt07.png">&nbsp;招聘求职&nbsp;<img alt="" src="images/jt07.png">&nbsp;发布职位</td>
	          </tr>
             </table>	
           </div>
   
           <div id="divf2g_jop" style="margin-top: 50px;border: 1px solid;border-color:#EAEAEA;">   
              <ul>
                <li id="ljop1" style="width:1000px;">
                
                    <table style="width:100%;font-size: 微软雅黑;font-size: 15px;line-height: 45px;">
                        <tr>
		                    <td colspan="2">
		                        <div style="width:1000px;height:32px;background: #3A5FCD;">
			                        <div style="visibility: visible;position:absolute;margin-top: -5px;margin-left:20px;font-size: 16px;color:#ffffff;">填写职位信息</div>
			                    </div>
		                    </td>
                        </tr>	 
	                    <tr>
		                    <td style="color:#9ACD32;"  colspan="2"><b>*</b>为必填</td>
	                    </tr>
	                    <tr>
		                    <td align="right" style="letter-spacing:30px;width:70px;">标</td>
		                    <td>题：<input style="width:200px;height:30px;" type="text" name="recruitment_title" value=""></td>
	                    </tr>
	                    <tr>
		                    <td align="right" style="letter-spacing:30px;width:70px;">职</td>
		                    <td>位：<input style="width:200px;height:30px;" type="text" name="recruitment_title" value=""></td>
	                    </tr>
	                    <tr>
		                    <td align="right">招聘人</td>
		                    <td>数：<input style="width:200px;height:30px;" type="text" name="recruitment_title" value="">人</td>
	                    </tr>
	                    <tr>
		                    <td align="right">工作年</td>
		                    <td>限：<input style="width:200px;height:30px;" type="text" name="recruitment_title" value=""></td>
	                    </tr> 
	                    <tr>
		                    <td align="right" style="letter-spacing:30px;width:70px;">学</td>
		                    <td>历：<input style="width:200px;height:30px;" type="text" name="recruitment_title" value=""></td>
	                    </tr> 
	                    <tr>
		                    <td align="right">工作城</td>
		                    <td>市：<input style="width:200px;height:30px;" type="text" name="recruitment_title" value=""></td>
	                    </tr> 
	                    <tr>
		                    <td align="right" style="letter-spacing:30px;width:70px;">月</td>
		                    <td>薪：<input style="width:200px;height:30px;" type="text" name="recruitment_title" value=""></td>
	                    </tr> 	 
	                    <tr>
		                    <td align="right" style="letter-spacing:30px;width:70px;">手</td>
		                    <td>机：<input style="width:200px;height:30px;" type="text" name="recruitment_title" value=""></td>
	                    </tr>
	                    <tr>
		                    <td colspan="2" style="">&nbsp;&nbsp;&nbsp;岗位描述与公司情况</td>
	                    </tr>	
	                    <tr>
		                    <td colspan="2" >&nbsp;&nbsp;&nbsp;<textarea style="width:700px;height:220px;" name="recruitment_title" ></textarea></td>
	                    </tr>	                    	                    	                                       	                    	                    	                                       	                    
                    </table>
                    
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


