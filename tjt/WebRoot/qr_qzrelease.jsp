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
              if($("#forjob1").val()==1){
              $("#dr2").html('* 请先填写简历信息');
              }			                  
			   
          });             


		function submint_r(){
	  
              var jone=JSON.stringify(GetJsonData());
              alert(jone);
			  $.ajax({
				   async:false,  		  
			       type:"post",                         
			       url:"mobile!mobile.action",	 
			       dataType:"json",   
	      		   data:"&para="+JSON.stringify(GetJsonData()), 
			       success:function(d){	
			                if(d !=null){
	                         $("#divf2g_jop").html('<div style="height:200px;font-size:16px;color:red;margin-top: 100px;margin-left:45%;text-align:center;">简历保存成功!<br>'
	                                              +'<div style="margin-top:100px"><a href="qr_fjobrelease.jsp"><img src="images/home/jxfb.png"></a></div></div>');
		                    }	                                                         
		                    }	                                  		           		                  	     
			       });
	
			       }
		       
		       
       	 function GetJsonData() {
		      if($("#r1").val()==""){
				 rv1.innerHTML = "&nbsp;>请填写姓名";	
				 return false;				 	      
		      }
		      if($("#r1").val().length<2){
				 rv1.innerHTML = "&nbsp;>请填写姓名";	
				 return false;				 	      
		      }       	 
		      if($("#r2").val()==""){
				 rv2.innerHTML = "&nbsp;>请填写年龄";	
				 return false;				 	      
		      }
		      if($("#r2").val().length<2){
				 rv2.innerHTML = "&nbsp;>请填写年龄";	
				 return false;				 	      
		      }
		      if($("#r4").val()==""){
				 rv4.innerHTML = "&nbsp;>请填写所在城市";	
				 return false;				 	      
		      }
		      if($("#r4").val().length<2){
				 rv4.innerHTML = "&nbsp;>请填写所在城市";	
				 return false;				 	      
		      }	 	     
		      if($("#r5").val()==0){
				 rv5.innerHTML = "&nbsp;>请选择学历";	
				 return false;				 	      
		      }		
		      if($("#r6").val()==0){
				 rv6.innerHTML = "&nbsp;>请选择工作年限";	
				 return false;				 	      
		      }	 		      		                    	 

		      if($("#r8").val()==""){
				 rv8.innerHTML = "请填写工作经历与教育背景";	
				 return false;				 	      
		      }
		      if($("#r8").val().length<20){
				 rv8.innerHTML = "请填写工作经历与教育背景";	
				 return false;				 	      
		      }	
              var r5=document.getElementById("r5");
              var r6=document.getElementById("r6");
              var r7=document.getElementById("r7");
              var sex="";
              if(r6.value==0){
                 sex="false";
              }else{
                 sex="true";
              }
              
             var json1 = {
		                "sendtype":10010,
				        "data":{
				        "userId": $("#r0").val(),	
				        "userTruename": $("#r1").val(),				        	    		        			        
		     }}; 
              $.ajax({ 		  
			       type:"post",                         
			       url:"mobile!mobile.action",	 
			       dataType:"json",   
	      		   data:"&para="+JSON.stringify(json1), 
			       success:function(d){	
		                                                               
		                    }	                                  		           		                  	     
			       });
	
  		     var json = {
		                "sendtype":40010,
				        "data":{
				        "TUser":{"userId": $("#r0").val()},	
				        "resumeAge": $("#r2").val(),				        
				        "resumeSex": sex,
				        "resumeCity": $("#r4").val(),	
				        "resumeEducation": r5[r5.value].innerText,	
				        "resumeWork": r6[r6.value].innerText,	
				        "resumeSalary": r7[r7.value].innerText,				        			        
				        "resumeInfo": $("#r8").val(),
	    		        			        
		     }}; 
		     return json;
	     }    
      function clear2(){
          rv1.innerHTML = "";      
          rv2.innerHTML = "";	   
          rv4.innerHTML = "";	 
          rv5.innerHTML = "";
          rv6.innerHTML = "";
          rv8.innerHTML = "";
             
      }
			

		
  			  
    </script>      
  

  </head>
  
  <body>

    <%
	  int fid=0;
	  if(request.getParameter("fid")!=null){
	  fid=Integer.parseInt(request.getParameter("fid"));
    }       
    %>    
      <input id="forjob1" type="hidden" value="<%=fid %>">    
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
    %>
    <input id="r0" type="hidden" value="<%=userId %>">    
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
                
                    <table style="width:100%;font-size: 微软雅黑;line-height: 50px;">
                   
                        <tr>
		                    <td colspan="4">
		                        <div style="width:1000px;height:40px;background: #3A5FCD;">
			                        <div style="visibility: visible;position:absolute;margin-top: -5px;margin-left:20px;font-size: 18px;color:#ffffff;">填写简历信息</div>
			                    </div>
		                    </td>
                        </tr>	 
                        <tr><td colspan="4">&nbsp;</td></tr>	 
	                    <tr style="border-bottom:1px solid #C2C2C2;">
		                    <td style=""colspan="2" valign="bottom"><div id="dr2" style="color:#008B00;margin-left: 75px"></div></td>
		                    <td colspan="2" valign="bottom" >		                                                                                                                                         
		                      <img onclick="submint_r()" alt="" style="margin-left: 220px" src="images/home/ljfb.png">                                                         
		                    </td>	
		    	      		                    
	                    </tr>
	                    <tr>
		                    <td style="color:#9ACD32;line-height: 15px"  colspan="4">&nbsp;</td>
	                    </tr>	
                                        
	                    <tr>
		                    <td align="right" style="width:120px;letter-spacing:30px;">姓</td>
		                    <td width="245px">
			                    <div style="float: left">
			                                                                              名：<input id="r1" onfocus="clear2()" style="width:105px;height:30px;" type="text" name="recruitmentPeoplenum" > 
			                    </div>
			                    <div id="rv1" style="float: left;color:red;"></div>		                                                                             					          
		                    </td>
		                    <td align="right" style="letter-spacing:30px;">年</td>
		                    <td>
                                <div style="float: left">
                                                                                                                       龄：<input id="r2" onfocus="clear2()" style="width:105px;height:30px;" type="text" name="resumeAge" >
                                </div>
                                <div id="rv2" style="float: left;color:red;"></div>
		                    
		                    </td>
		               
	                    </tr>	
	                    <tr>
		                    <td align="right" style="letter-spacing:30px">性</td>
		                    <td>
		                                                                              别：<select id="r3" name="resumeSex" style="width:105px;height:30px;" onchange="showCities()">										           
						           <option value="1">男</option>
						           <option value="0">女</option>			
					           </select>              	                    
		                    
		                    </td>
		                    <td align="right" style="width:70px;">所在城</td>
		                    <td>
                                <div style="float: left">
		                                                                                         市：<input id="r4" onfocus="clear2()" style="width:105px;height:30px;" type="text" name="recruitmentPeoplenum" value="">
                                </div>
                                <div id="rv4" style="float: left;color:red;"></div>			                    

		                    </td>
		                </tr>	                    	                    
	                    <tr>
		                    <td align="right" style="letter-spacing:30px;">学</td>
		                    <td>
                                <div style="float: left">
			                                                                              历：<select id="r5" onclick="clear2()" name="resumeEducation" style="width:105px;height:30px;" onchange="showCities()">										           
							           <option value="0">请选择</option>
							           <option value="1">高中以下</option>
							           <option value="2">高中/中专</option>
							           <option value="3">大专</option>
							           <option value="4">本科</option>
							           <option value="5">研究生</option>
							           <option value="6">硕士</option>
							           <option value="7">硕士以上</option>
						           </select>
                                </div>
                                <div id="rv5" style="float: left;color:red;"></div>			                    
		                    
		                    </td>		                    
		                    <td align="right">工作年</td>
		                    <td>
                                <div style="float: left">
			                                                                              限：<select id="r6" onclick="clear2()" name="resumeWork" style="width:105px;height:30px;" onchange="showCities()">										           
							           <option value="0">请选择</option>
							           <option value="1">应届生</option>
							           <option value="2">1年以下</option>
							           <option value="3">1-2年</option>
							           <option value="4">2-3年</option>
							           <option value="5">3年以上</option>
							           <option value="6">5年以上</option>
						           </select>
                                </div>
                                <div id="rv6" style="float: left;color:red;"></div>				                    
					        </td>
	                    </tr> 
    	                    
	                    <tr>		                   		                   
		                    <td align="right">薪资要</td>
		                    <td>                          
		                                                                             求：<select id="r7" onclick="clear2()" name="resumeSalary" style="width:105px;height:30px;" onchange="showCities()">										           
						           <option value="0">面议</option>
						           <option value="1">3000以下</option>
						           <option value="2">3000-4000</option>
						           <option value="3">4000-6000</option>
						           <option value="4">6000-10000</option>
						           <option value="5">10000-20000</option>
						           <option value="6">20000以上</option>
					           </select>
   		                    
		                    </td>
	                    
	                    </tr> 
	                    <tr>
	                    </tr>
	                    <tr>
		                    <td colspan="2" style="padding-left: 50px">&nbsp;&nbsp;&nbsp;工作经历与教育背景等信息</td>	
		                    <td colspan="2" ><div id="rv8" style="float:left;color:red;"> </div></td>	                    
	                    </tr>	
	                    <tr>
		                    <td colspan="4" >&nbsp;&nbsp;&nbsp;<textarea id="r8" onfocus="clear2()" style="width:700px;height:200px;margin-left: 50px" name="resumeInfo" ></textarea></td>
	                    </tr>	  
	                                      	                    	                                       	                    	                    	                                       	                    
                    </table>
                    
                </li>                                                
              </ul>
              <br>

              <ul style="width:100%;">
	              <li>                  
	                <table style="margin-top:200px;height:200px;background: #F7F7F7;"><tr><td id="ljop3" valign="top"></td></tr></table>
	              </li>
              </ul>
         </div> 
  
       </div>
    </div>
  </body>
</html>


