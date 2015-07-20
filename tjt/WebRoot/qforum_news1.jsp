
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showup.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/newStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/login-linkStyle.css" rel="stylesheet" type="text/css" />	
    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
    
    
         $(function(){    
 
            var mid=document.getElementById("ipmid").value;                                
		    var json1 = {
		        "sendtype":20003,
		        "data":{
		        "messagesId":mid,			  				        			        			        
		     }};        		     		     		     	 
		  $.ajax({
		       type:"post",                         
		       url:"mobile!mobile.action",	 
		       dataType:"json",   
      		   data:"&para="+JSON.stringify(json1), 
		       success:function(d){	
		                if(d !=null){	
		                	                			
				     var data1=d;				
				     var data2=data1.data;
				     var data3=data2.meg;
				         document.getElementById("newuid").value=data3.TUser.userId;					         
                         $("#ln1").html(data3.messagesTitle);      
                      if(data3.TMessagestype.messagestypeId>5000){
                          document.getElementById("ipsrc").value=data3.messagesAnnex;
                         $("#ln3").html('<div style="text-align: left;font-size:15px;"><ul><li>资料类别：'+data3.TMessagestype.messagestypeName+'<li><li style="margin-top:15px;">'+data3.messagesTitle+'</li>'
                         +'<li onclick="downdata()" style="width:100px;height:30px;cursor:pointer;background:#FF7F24;padding-left:36px;color:#ffffff;padding-top:6px;margin-top:15px; ">'
                         +'<img src="images/home/xiazai.png">&nbsp;<div style="float:right;margin-top:4px;margin-right:36px">下载</div></li></ul></div>');
                      }else{  
                         $("#ln3").html('<div style="text-align: left;padding-left:5px;width:900px;line-height: 25px;font-size:15px;word-wrap:break-word;"><pre>'+data3.messagesInfo+'</pre><br></div>');
                         var strimg="";                  
                         var img="";
                         if(data3.messagesImgsrcs!=null & data3.messagesImgsrcs.length>2){
                           strimg=data3.messagesImgsrcs;
                           img=strimg.split(',');  			
			               for(var i=0; i<img.length; i++){
                           $("#l4").html($("#ln4").html()+'<div><img width="600px" src='+img[i]+'><br></div>');
			            
			             }                         
                         } 
                        }
                         $("#ln5").html('<div><img src="'+data3.TUser.userImgface+'"></div>');   
                         $("#ln6").html(data3.TUser.userNikename+'<br><br>'+data3.messagesTime); 
                         document.getElementById("com2").value=data3.TUser.userId;
                      var json ={
					    "sendtype":20013,
					    "data":{
					    "mid":mid,				
					    }};	
					    var num="";					     
			           $.ajax({   
					         async:false,  	           	       		
						     type:"post",
				             url:"mobile!mobile.action",	 				      
						     dataType:"json",
			     		         data:"para="+JSON.stringify(json), 
						     success:function(d){  
						      num=d.data;
						     } 
						     }); 
                         $("#ln7").html("浏览量："+data3.messagesTouchnum+"&nbsp;&nbsp;回复："+num);   
		 		       	 var m=1;	           
				         getdata(m);                                                                     
	                    }	                                                         
	                    }	                                  		           		                  	     
		       });
		       

		       });

		 //通过帖子id获取帖子下的评论
	     function getdata(m){  

	     			 var n= document.getElementById("nid").value;  
		             if(m==1 & n!=1){
		             n=n-2;
  		             }   
            var mid=document.getElementById("ipmid").value; 		       
		    var json3 = {
		        "sendtype":20011,
		        "data":{
		        "mid":mid,
		        "pn":n,
		        "ps":15,			  				        			        			        
		     }};  
		       		     		     		     	 
	           $.ajax({   	       		
				     type:"post",
		             url:"mobile!mobile.action",	 				      
				     dataType:"json",
      		         data:"para="+JSON.stringify(json3), 
				     success:function(d){
					 $("#ln8").html("");               			     				     				
				     var data1=d.data;
				     var data2=data1.Commentslist;			                
				     var cn=0;	
				     var pn=d.pn;
		
			         n=pn+1;						 
			         document.getElementById("nid").value=n;
				     var count=d.count;
	
				     lastPager=Math.ceil(count/15);				     
	                 if(n==2){									       
				  	    $("#page1").html('<div>上一页 </div>');  				     
				     }else{						
				  	    $("#page1").html('<div><a onclick="getdata(1)" href="#">'+"上一页"+'</a></div>');  				     
				     }
				     if(n<=lastPager){
								      			     
				  	   $("#page2").html('<div><a onclick="getdata(0)" href="#">'+"下一页"+'</a>('+pn+'/'+lastPager+')</div>');  				     
				     }else{		
				       
				  	   $("#page2").html('<div>下一页('+pn+'/'+lastPager+')</div>');  				     
				     }	
			    
				     $(data2).each(function(index,rdata){
				     cn=cn+1;
				    
				    $("#ln8").html($("#ln8").html()+'<input id="uid'+rdata.commentsId+'" type="hidden" value="'+rdata.TUser.userId+'""><div style="border-bottom:1px solid;border-bottom-color:#CDC673;;width:100%;">'	
				    +'<table style="width:100%;width:100%;font-size:15px;"><tr align="center"><td rowspan="3" width="200px" valign="top" style="background:#FFFFFF">'
				    +'<div style="width:200px;height:100%;padding-top:20px;color:#CD9B1D "><img src="'+rdata.TUser.userImgface+'"><br><br>'
				    +'<div id="du'+rdata.commentsId+'">'+rdata.TUser.userNikename+'</div><br><br>'+rdata.commentsTime+'</div></td>'
			        +'<td align="left"  valign="top" style="width:50px;height:30px;border-left: 1px solid;border-left-color:#EAEAEA;padding:10px;">'
			        +'<div onclick="openrecom('+rdata.commentsId+')" style="cursor:pointer; "><img style="width:20px;height:13px;" src="images/home/wd2.png">回复</div></td><td align="right"' 
			        +'style="padding-right:10px"><b style="font-size:20px;color:#FFA500;">'+cn+'</b>楼</td></tr><tr>'
			        +'<td colspan="2" style="border: 1px solid;border-color:#EAEAEA;border-bottom: 0px;padding:10px; ">'
			        +'<div id="di'+rdata.commentsId+'">'+rdata.commentsInfo+'</div><br><div style="width:100%;height:200px"> </div></td></tr><tr><td  align="center" id="hf'+rdata.commentsId+'"></td></tr></table> </div>');
	               });         
				                                              
			    } 
			    });

			   }
			//文件下载   
  	       function downdata(){

		  	    location.href=$("#ipsrc").val();
  	       } 
  	       
  	       
  	       function addcom(parm){   

  	            var foruid=document.getElementById("huifu").value;
  	            var uid=document.getElementById("userid10").value;
	
  	            var json ="";
  	            var comcon="";
  	            if(parm==1){ 
  	              if(uid==0){
		                  relp00.innerHTML = "请登录再评论";
					      return false;  	            
  	              } 
		  	             comcon=$("#recom1").val();
  	              if(comcon==""){
		                  relp00.innerHTML = "内容不能为空";
					      return false;  	            
  	              }	 
	              if(comcon.length<2){
		                  relp00.innerHTML = "内容不能少于2字";
					      return false;  	            
  	              }  	                  
	  	            comcon=$("#recom1").val()+"//@"+$("#du"+foruid).text()+":"+$("#di"+foruid).text();
	  	            json = {
				        "sendtype":20012,
				        "data":{
				        "commentsInfo":comcon,
				        "TMessages":{"messagesId":$("#ipmid").val()},
				        "TUser":{"userId":$("#userid10").val()},	
				        "ruserId":$("#uid"+foruid).val(),	  				        			        			        
				     }};  
  	            }else{
  	              if(uid==0){
		                  lp00.innerHTML = "请登录再评论";
					      return false;  	            
  	              }  	            
  	                var comcon=$("#com1").val();
  	                if(comcon==""){
		                  lp00.innerHTML = "内容不能为空";
					      return false;  	            
		  	            }
  	                if(comcon.length<2){
		                  lp00.innerHTML = "内容不能少于2字";
					      return false;  	            
		  	            }		  	            
				     json = {
				        "sendtype":20012,
				        "data":{
				        "commentsInfo":$("#com1").val(),
				        "TMessages":{"messagesId":$("#ipmid").val()},
				        "TUser":{"userId":$("#userid10").val()},	
				        "ruserId":$("#newuid").val(),	  				        			        			        
				     }};    	            
  	            }

		       		     		     		     	 
	           $.ajax({   	       		
				     type:"post",
		             url:"mobile!mobile.action",	 				      
				     dataType:"json",
      		         data:"para="+JSON.stringify(json), 
				     success:function(d){
				     if(d.ret==0){
				     if(parm==1){
				       $("#hf"+foruid).html('<div style="width:100%;"><div style="color:red;">评论发表成功！</div><br><div style="width:95%;border: 1px solid;border-color:#EAEAEA;padding:10px;font-size:15px;">'+comcon+'</div><br><br></div>');
				     }else{
				       alert("评论发表成功！");
				       getdata(1);
				       document.getElementById("com1").value="";
				     }
				     				     				     				     
				     }
				     				    				     
				     }
				     
				     });  	       
  	       
  	       }
  	       function openrecom(id){  

  	           document.getElementById("huifu").value=id; 	       
  	           $.ajax({ 
				     async:false,    	       		
					 type:"get",
					 url:"qfourm_recom.jsp", 
					 success:function(d){			                 
					        $("#hf"+id).html(d); 				
					        recom1.focus(); 
		                              
		             }
                           	                        		
			  });	
		  }	      
  	        
           	
  	       function closerecom(){   
  	           var id=document.getElementById("huifu").value;	           
  	           $("#hf"+id).html("");  
  	        
           }          
  	 function clearcom(){
	     lp00.innerHTML = "";
	     relp00.innerHTML = "";
	 
	 }		         
	</script>
  </head>
  
  <body>
       <input id="nid" type="hidden" value="1">
       <input id="ipmid" type="hidden" value="<%=request.getParameter("mid") %>">
       <input id="ipsrc" type="hidden" value="">
       <input id="newuid" type="hidden" value="">
      <% 
         Cookie[] cookies= request.getCookies();
         int uid=0;
         if(cookies!=null &&cookies.length>0){
           for(int i=0;i<cookies.length;i++){
             if(cookies[i].getName().equals("mrCookie")){
             uid=Integer.parseInt(cookies[i].getValue().split("#")[0]); 
            }
         }
         }   
         %>
         <input id="userid10" type="hidden" value="<%=uid%>">  

         
         
       <div id="divv2fd_new1">   
          
           <ul id="divv2fd_new1_ul"  style="background: url(images/home/tiao_03.png); background-size:100% 35px;">    
             <li id="ln1" style="padding: 10px;"></li>                                                                
           </ul>       
           <ul id="divv2fd_new1_ull">                           
             <li id="ln5" style="width:100px;margin-top: 30px;"></li>  
             <li id="ln6" style="width:200px;margin-top: 85px"></li>              
             <li id="ln7" style="width:300px;float: right;text-align:right;margin-top:120px;margin-right: 20px;"></li>                                               
           </ul>	                                  
           <ul id="divv2fd_new1_ulll">                              
             <li id="ln3" style="margin-left: 50px"></li>    
             <li id="ln4" style="padding-left: 5px;"></li> 
             <li style="height:200px;">&nbsp;</li>                                             
           </ul>	
           <ul>                              
             <li id="ln8" style="margin-left: 0px;border-top:1px solid;border-top-color:#CDC673;">           
           
             </li>  
             <li style="margin-left: 0px;height:370px;text-align: center;"> 
               <div id="divv2fd_new1_uliv">
                  <table style="float: right;margin-top: 5px">
	                  <tr>
		                  <td id="page1"></td>
		                  <td id="page2"></td>
		                  <td>
		                                                                    到第<input onclick="" id="gopage" type="text" style="border:1px solid;border-color:#CD9B1D;width:35px">页
						      <input onclick="gogetdate()" onmousemove="this.style.background='#EE9A00'" onmouseout="this.style.background='#CD9B1D'" type="button" value="确定" 
						             style="margin-left: 2px; border:none;width:50px; height:20px;font-size:15px;color:#ffffff; background:#CD9B1D;">&nbsp;	
					      </td>
				      </tr>
			      </table>
               </div> 
               <br>
               <div id="divv2fd_new1_ulvi">   
                   <input id="com2" type="hidden" name="TUser.uid" value="">
                   <input id="huifu" type="hidden" name="huifu" value="">
	           	   <ul>
	                 <li style="float: left;width:100px;margin-left:10px;font-size:16px;font-family:微软雅黑;color:#2E2E2E;">发表评论： </li>	
	                 <li id="lp00" style="width:400px;text-align:center;margin-left:120px;font-size:15px;color:red;float: right;">&nbsp;</li>        
	                 <li style="margin-top: 42px;margin-left: 10px;width:630px;">	                     
	                    <textarea id="com1" onFocus="clearcom()" style="width:610px;height:108px;"></textarea>	                    	                   
	                 </li>    	                 
	                 <li style="margin-left:530px;margin-top:160px;">
	                     <div id="ap1" onclick="addcom(0)" onmousemove="this.style.background='#FFA500'" onmouseout="this.style.background='#CD9B1D'" 
	                          style="text-align:center;width:100px;height:22px;padding-top:5px;font-size:15px;color:#FFFFFF;background:#CD9B1D;cursor:pointer;">发 表</div>                             
	                 </li>                                                 
	               </ul>
               </div>      
             </li>                                            
           </ul>           	                                                                 	        
       </div>	

  </body>
</html>