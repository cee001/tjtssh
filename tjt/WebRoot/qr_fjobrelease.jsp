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
              var uid=document.getElementById("f0").value;	
              var json2 = {
		                "sendtype":40006,
				        "data":{
				        "uid": uid,		   
				        "ps": 1,	
				        "pn": 1,	     			        
		      }}; 	
          
			  $.ajax({
				   async:false,  		  
			       type:"post",                         
			       url:"mobile!mobile.action",	 
			       dataType:"json",   
	      		   data:"&para="+JSON.stringify(json2), 
			       success:function(d){	
			                
			                var data=d.data;			   
			                var data1=data.list;
			  
			               // $(data1).each(function(index,rdata){
			                //var rid=0;
                            //rid=rdata.resumeId; 
                            //alert(rid);
                            if(data1.length<1){
			                window.location.href="qr_qzrelease.jsp?fid=1";
			                }                                        
	                       // document.getElementById("rid10").value=rid;
	                       // });
	                        		                    	                                                         
		                    }	                                  		           		                  	     
			       });	
			       
			  $.ajax({ 
            	     async:false,   			          	       		
				     type:"get",
				     url:"qhead.jsp?RandStr="+Math.random(), 
				     success:function(d){				                 
				            $("#divp1").html(d); 
      	                  
				     }              			
				   });                          
 	                     
              $("#ljop3").load("qfoot_new.jsp"); 	
             		  
   
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
	                         $("#divf2g_jop").html('<div style="height:200px;font-size:16px;color:red;margin-top: 100px;margin-left:45%;">求职发布成功!</div>');	                         
		                    }	                                                         
		                    }	                                  		           		                  	     
			       });
	
			       }
		       
		       
       	 function GetJsonData() {
		      if($("#f1").val()==""){
				 rv1.innerHTML = "标题至少于2字，不能大于30字";	
				 return false;				 	      
		      }
		      if($("#f1").val().length<2){
				 rv1.innerHTML = "标题至少于2字，不能大于30字";	
				 return false;				 	      
		      }	   
		      if($("#f1").val().length>30){
				 rv1.innerHTML = "标题不能大于30字";	
				 return false;				 	      
		      }	  	
		      if($("#f2").val()==""){
				 rv1.innerHTML = "内容至少10字";	
				 return false;				 	      
		      }	
		      if($("#f2").val().length<10){
				 rv1.innerHTML = "内容至少10字";	
				 return false;				 	      
		      }	 		      		                    	 
 		      if($("#f2").val().length>500){
				 rv1.innerHTML = "内容不能超过500字";	
				 return false;				 	      
		      }	   
   
  		     var json = {
		                "sendtype":40009,
				        "data":{
				        "userId": $("#f0").val(),
				        "forjobTittle": $("#f1").val(),
				        "forjobInfo": $("#f2").val(),
				        //"TResume":{"resumeId": $("#rid10").val()},
		        			        
		     }}; 
		     return json;
	     }    
      function clear2(){
          rv1.innerHTML = "";	   

             
      }
			

		
  			  
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
		                    <td>
		                        <div style="width:1000px;height:35px;background: #3A5FCD;">
			                        <div style="visibility: visible;position:absolute;margin-top: -7px;margin-left:20px;font-size: 18px;color:#ffffff;">发布求职</div>
			                    </div>
		                    </td>
                        </tr>	 
	                    <tr>
		                    <td valign="bottom">&nbsp;<div id="rv1" style="float:left;color:red;font-size: 15px;margin-left: 300px"></div></td>
	                    </tr>
	                    <tr>
		                    <td style="padding-left: 150px"  valign="bottom" >		                                                                          
		                                                                            标&nbsp;题&nbsp;<input id="f1" onfocus="clear2()" style="width:420px;height:25px;border:0px;border-bottom: 1px solid;" type="text" name="recruitmentTitle" >		                                                                            
		                      <img onclick="submint_r()" alt="" style="margin-left: 25px" src="images/home/ljfb.png">                                                         
		                    </td>	
		    	      		                    
	                    </tr>
	                    <tr>
		                    <td style="color:#9ACD32;line-height: 15px" colspan="4">&nbsp;</td>
	                    </tr>	                                        
	                    <tr>
		                    <td style="padding-left: 150px;line-height: 35px">内&nbsp;容<div id="rv2" style="float:left;color:red;"> </div></td>	
		                    
	                    </tr>	
	                    <tr>
		                    <td align="center"><textarea id="f2" onfocus="clear2()" style="width:700px;height:200px;" name="recruitmentInfo" ></textarea></td>
	                    </tr>
	                    	  	                                      	                    	                                       	                    	                    	                                       	                    
                    </table>
                    
                </li>                                                
              </ul>
              <br>
              <ul style="width:100%;">
	              <li>	      
	                <table style="height:200px;background: #F7F7F7;margin-top: 200px;"><tr><td id="ljop3" valign="top"></td></tr></table>
	              </li>
              </ul>
         </div> 
  
       </div>
    </div>
  </body>
</html>


