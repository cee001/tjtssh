<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'listur.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>	 	
	<style type="text/css">
   
    a:link{text-decoration : none ;color :#212121;} 
	a:visited {text-decoration : none ;color : #525252 ;} 
	a:hover {text-decoration : underline ;color :#CD0000 ;} 
	a:active {text-decoration : none ;color :#212121 ;}	  
	</style>
    <script>
		 $(function(div){
			   // $("div:odd").css({background: "#FCFCFC"}); // 1, 3…… 行
			   //$("div:even").css({background: "#B3EE3A"}); // 2, 4…… 行
		 });	         
	     $(function(){   

	           $.ajax({   	       		
				     type:"post",
		             url:"mobile!mobile.action",	 				      
				     dataType:"json",
      		         data:"para="+JSON.stringify(GetJsonData()), 
				     success:function(d){
				     var data1=d;				
				     var data2=data1.data;
				     var data3=data2.messagelist;	
							     
				     $(data3).each(function(index,rdata){
			
				     var url=rdata.messagesAnnex;
				     
				     fileUrl=url.split('#!!')[0]; 				

				     $("#dmsgid1").html($("#dmsgid1").html()+'<div style="border-bottom:1px solid;border-bottom-color:#B2DFEE;width:80px;font-size:13px;">'+rdata.messagesId+'</div>'); 

				     $("#dmsgid2").html($("#dmsgid2").html()+'<div style="border-bottom:1px solid;border-bottom-color:#B2DFEE;font-size:13px;"><a href="'+fileUrl+'" >'+rdata.messagesTitle+'</a></div>');

				     $("#dmsgid3").html($("#dmsgid3").html()+'<div style="border-bottom:1px solid;border-bottom-color:#B2DFEE;font-size:13px;">'+rdata.messagesTime+'</div>');  
				     $("#dmsgid4").html($("#dmsgid4").html()+'<div style="border-bottom:1px solid;border-bottom-color:#B2DFEE;width:60px;"><a onclick="doUpdate('+rdata.messagesId+')" href="">'+"删除"+'</a></div>');			          				     			      
				     });         
				                                              
			    } 
			    });
			    });
			    		       
       	 function GetJsonData() {
       
			    var json ={
			    "sendtype":20001,
			    "data":{
			    "messagestypeId":5003,
			    "pn":1,
			    "ps":15,
			    }};
			    return json;
			}
       function doUpdate(mid){
			    var json = {
			        "sendtype":20005,
			        "data":{
			        "messagesId":mid,			  				        			        			        
			     }
			     };
             if(confirm("确定删除吗？")){
                $.ajax({
			           async:false,                
				       type:"post",                         
				       url:"mobile!mobile.action",	 
				       dataType:"json",   
		      		   data:"&para="+JSON.stringify(json),
				       success:function(d){	
				                
		                          window.location.href="listregulations.jsp";
			                                                                            
			                    }	                                  		           		                  	     		     
		
				       });
  
         }
         }			    		
    </script>
  </head>
  
  <body>

   <input type="hidden">
   <div id="dvmsgid">
    <table   border="1" bordercolor="#B2DFEE" align="center" style="border-collapse: collapse;width:100%;line-height: 25px;font-size:15px;" cellpadding="0" cellspacing="0">   
      <tr>     
          <td colspan="5" bgcolor="#F0F8FF">
            <div style="font-size:15px;border-bottom:1px solid;border-bottom-color:#B2DFEE;">
                 <div  style="margin-top: 5px;margin-left: 12px"> 
                 <b>政策法规列表</b> 
                 </div>
            </div>
          </td>   
      </tr>
      
       <tr>     
          <td colspan="5" >
	       <div id="dvif1" style="display: none;width:100%;">
	       	<div style="font-size:15px;width:100%;">
               <div  style="margin-top: 0px;margin-left: 0px;padding0pxtext-align: right;width:100%;"> 
                  <ul style="padding: 0px;margin-top:0px;list-style-type: none;float: right;width:100%;background:#F8F8FF;border-bottom:1px solid;border-bottom-color:#B2DFEE;">
                   <li style="margin-right: 0px;margin-top: 0px;margin-right:1px;float: right;">
                     <img width="22px" onclick="changeif()"  alt="" src="images/gb.jpg">
                   </li>
                   <li style="margin-right: 47%;float: right;color:#5B5B5B"><b>详情</b></li>
                  </ul>             
	          </div>
              <iframe frameborder="0" name="tvc" style="width:100%;height:550px;margin-top:0px;" ></iframe>         
             </div>     
	       </div>
          </td>   
      </tr>      
      <tr align="center">     
          <td width="80px">ID</td>   
          <td>文件标题</td>   
          <td>发布时间</td>
          <td width="60px">审核</td>          
      </tr >   

     <tr align="center">

     <td><div id="dmsgid1"></div></td>
     <td><div id="dmsgid2"></div></td>
     <td><div id="dmsgid3"></div></td>
     <td><div id="dmsgid4"></div></td>     
     </tr>	

  </table>
</div>
  </body>
</html>
