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
              $("#divf2a_new ").load("qdh_forum.jsp"); 
              $("#divp21").load("qfoot_new.jsp"); 
              var mid=$("#ipmid2").val();	           
				 $.ajax({ 
            	     async:false,   			          	       		
				     type:"get",
				     url:"qforum_news1.jsp?mid="+mid, 
				     success:function(d){				                 
				            $("#l2150").html(d); 
                            $("#divp21").load("qfoot_new.jsp"); 				                  
				     }              			
				   }); 	
          });             

		function changep(){
			document.getElementById("ap1").className="bt10";
			
		}
		function rechangep(){
			document.getElementById("ap1").className="bt11";
			
			
		}   	
	
        function changep1(){
			document.getElementById("image3").src="images/tjtp1.png";
			
		}
		function rechangep1(){
			document.getElementById("image3").src="images/tjtp.png";
			
		}
		function changep2(){
			document.getElementById("image2").src="images/cxxz1.png";
			
		}
		function rechangep2(){
			document.getElementById("image2").src="images/cxxz.png";
			
		}
            
           
            var imgsrc="";
			KindEditor.ready(function(K) {
				var editor = K.editor({
					uploadJson : 'kindeditor-4.1.10/jsp/upload_json.jsp',					
					allowFileManager : true
					//allowImageUpload : true		
				});

				K('#image3').click(function() {
					editor.loadPlugin('image', function() {
						editor.plugin.imageDialog({
							showRemote : false,		               	  													
							imageUrl : K('#url3').val(),
							
						clickFn : function(url, title, width, height, border, align) {

							K('#url3').val(url);
							editor.hideDialog();
							
							$(function(){ 

                            var imgurl="";
                           
                            if(url.length>45){
                             document.getElementById('avatar_priview').innerHTML = "<img width='150px' height='105px' src='" + url + "'/> " ;
                             $("#prw").append($("#avatar_priview").html());                            
                             imgurl=url.split('http://xheyou.com//TJT/image/');   
                            }else{
                             document.getElementById('avatar_priview').innerHTML = "<img width='150px' height='105px' src='http://xheyou.com" + url + "'/> " ;
                             $("#prw").append($("#avatar_priview").html());                           
                             imgurl=url.split('/TJT/image/');  
                            }                                                                                                		        
				            imgsrc=imgsrc+imgurl;
				            
                            document.getElementById("meg3").value=imgsrc;
				 
							});	
							}
							
						});
						
					});
									 
				});
				
			});
	   function reimg(){

			$("#prw").html("");
			imgsrc="";
			document.getElementById("meg3").value="";
			}

	    function rehref(){
	          window.location.href= "qaddcon1.jsp";  
	    	    
	    }     
        function showconr(){ 

	          var img= document.getElementById("meg3").value;
              var strimg="";
          
              if(img!=""){ 
              img=img.substring(1);                           
              img=img.split(',');               
              var strimg2="";	
              for(var i=0; i<img.length; i++){
              	strimg2 ="http://xheyou.com/TJT/image/"+img[i]+",";
				strimg+=strimg2;
              }
              }
              if(strimg!="" && strimg.length>32){
               document.getElementById("meg3").value=strimg;
               }else{
               document.getElementById("meg3").value="";
               }

	        var objre1=document.getElementById("meg1");

            var objre2=document.getElementById("content1");
            var objre3=document.getElementById("meg10");            
            if(objre1.value==""){          
                 alert("标题不能为空");  
				 return false;	                    
            }  
            if(objre1.value.length<5){
                 alert("标题不能少于5字"); 
			     return false;	                     
           }             
             if(objre1.value.length>60){
                 alert("标题不能超过60字"); 
				 return false;	                     
            }            
           
            if(objre2.value==""){
                 alert("内容不能为空");  
			     return false;	                    
            }  
            if(objre2.value.length<10){
                alert("内容不能少于10字"); 
			    return false;	                     
           }  
            if(objre3.value==0){
                 alert("请选择所属栏目");  
			     return false;	                    
            } 	     		     	 
		  $.ajax({
			   async:false,  		  
		       type:"post",                         
		       url:"mobile!mobile.action",	 
		       //contentType: "application/json; charset=utf-8",    
		       dataType:"json",   
      		   data:"&para="+JSON.stringify(GetJsonData()), 
		       success:function(d){	
		                
                         $("#ljop1").html('<div style="font-size:16px;color:red;margin-top: 100px;text-align:center;">帖子发布成功!<br>'
	                                     +'<div style="margin-top:100px"><a href="qf_release.jsp" target="_parent"><img src="images/home/jxfb.png"></a></div></div>');
	                                                                             
	                    }	                                  		           		                  	     
		       });

		       }
		       
		       
       	   function GetJsonData() {
   		         var json = {
			                "sendtype":20002,
					        "data":{
					        "TUser":{"userId":1},
					        "TMessagestype":{"messagestypeId":$("#meg10").val()},
					        "messagesTitle": $("#meg1").val(),
					        "messagesInfo": $("#content1").val(),		
					        "messagesImgsrcs": $("#meg3").val(),				        
			        			        
			     }}; 
			     return json;
			}    
    </script>      
  

  </head>
  
  <body>

    <input id="meg3" type="hidden" name="messagesImgsrcs" value="">      
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


           <div id="divf2b_jop" style="margin-top: 0px;">                  
             <table style="font-size:15px">
	          <tr>
		          <td><img alt="" src="images/home/new_03.png">&nbsp;当前位置：</td>
		          <td>首页&nbsp;<img alt="" src="images/jt07.png">&nbsp;招聘求职&nbsp;<img alt="" src="images/jt07.png">&nbsp;发布帖子</td>
	          </tr>
             </table>	
           </div>
   
           <div id="divf2g_jop" style="margin-top: 50px;width:995px;height:800px;border: 1px solid;border-color:#EAEAEA;">   
              <ul>
                <li id="ljop1" style="width:995px;">
                
                    <table style="width:100%;font-size: 微软雅黑;">
                        <tr>
		                    <td>
		                        <div style="width:100%;height:35px;background: url(images/home/tiao_03.png); background-size:100% 35px;">
			                        <div style="visibility: visible;position:absolute;margin-top: -10px;margin-left:20px;font-size: 16px;"></div>
			                    </div>
		                    </td>
                        </tr>	 
	                    <tr>
		                    <td valign="bottom" height="35px">&nbsp;<div id="rv1" style="float:left;color:red;font-size: 15px;margin-left: 300px">&nbsp;</div></td>
	                    </tr>
	                    <tr>
		                    <td style="padding-left: 150px;"  valign="bottom" >		                                                                          
		                                                                            标&nbsp;题&nbsp;<input id="meg1" onfocus="clear2()" style="width:430px;height:25px;border:0px;border-bottom: 1px solid;" type="text" name="recruitmentTitle" >		                                                                            
		                      <img onclick="showconr()" alt="" style="margin-left: 25px;cursor:pointer;" src="images/home/ljfb.png">                                                         
		                    </td>	
		    	      		                    
	                    </tr>
	                    <tr>
		                    <td style="color:#9ACD32;eight: 25px" colspan="4">&nbsp;</td>
	                    </tr>	                                        
	                    <tr>
		                    <td style="padding-left: 150px;line-height: 35px">内&nbsp;容<div id="rv2" style="float:left;color:red;"> </div></td>	
		                    
	                    </tr>	
	                    <tr>
		                    <td align="center"><textarea id="content1"  onfocus="clear2()" style="width:700px;height:200px;" name="recruitmentInfo" ></textarea></td>
	                    </tr>
	                    <tr>
		                    <td align="center">
                              <div style="margin-top: 12px;width:700px;">
	                            <ul style="float: left;padding: 0px;list-style-type: none;">
	                                <li style="float: left;padding-left: 0px;border:1px dashed #F00;width:83px;height:25px;float: left;">
	                                   <div style="float: left;margin-top: 2px;">
	                                      <img id="image3" onmousemove="changep1()" onmouseout="rechangep1()" src="images/tjtp.png">
	                                   </div>
	                                   
	                                </li>
	                                <li style="float: left;border:1px dashed #F00;width:83px;height:25px;margin-left: 5px;padding: 0px">
	                                    <div style="float: left;margin-top: 2px;margin-left: 0px">
	                                       <a href="#" onclick="reimg()"><img id="image2" onmousemove="changep2()" onmouseout="rechangep2()" src="images/cxxz.png"></a>
	                                    </div>
	                                </li>
	                                <li style="float: left">
							            &nbsp;<b style="color:red;">*</b>所属栏目: 
							            <select id="meg10" name="messagestypeId" onclick="clearl()">	
								           <option value="0" >--请选择--</option>            									           
								           <option value="4001">技术交流</option>
								           <option value="4002">专家答疑</option>
								           <option value="4003">行业杂谈</option>
								           <option value="4004">考证交流</option>       	           
							            </select>               
							         </li>	                                
	                            </ul>	                              
	                        </div>		                 
		                    </td>
	                    </tr>
	                    <tr><td><div id="prw" style="margin-left: 150px;margin-top: 5px;width:700px;"></div><div id="avatar_priview" style="display: none"></div></td></tr>	                    	  	                                      	                    	                                       	                    	                    	                                       	                    
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
  </body>
</html>


