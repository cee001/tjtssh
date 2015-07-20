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
         $(function(){    
	               	var m=1;	           
		            getdata(m);                        
                   });

	     function getdata(m){  
	                 var title= document.getElementById("title2").value;  
	                
	     			 var n= document.getElementById("nid").value;  
		             if(m==1 & n!=1){
		             n=n-2;
		             }
   				     
			   var json ={
					   "sendtype":20001,
					   "data":{
					   "key":title,
					   "pn":n,
					   "ps":15,
					   }};	
				     
	           $.ajax({   
			         async:false,  	           	       		
				     type:"post",
		             url:"mobile!mobile.action",	 				      
				     dataType:"json",
      		         data:"para="+JSON.stringify(json), 
				     success:function(d){
				                
				                 $("#dmsgid1").html("");
				                 $("#dmsgid2").html("");
				                 $("#dmsgid3").html("");
				                 $("#dmsgid4").html("");
							     var data1=d;				
							     var data2=data1.data;
							     var data3=data2.messagelist;	
						         var pn=data1.pn;
						         n=pn+1;						 
						         document.getElementById("nid").value=n;
						         var h=	data3.length;	
						         document.getElementById("hid").value=h;
				                 var count=data1.count;
				                 lastPager=Math.ceil(count/15);	
				                 if(n==2){									       
							  	   $("#dmsgid7").html('<div>上一页 </div>');  				     
							     }else{						
							  	    $("#dmsgid7").html('<div><a onclick="getdata(1)" href="#">'+"上一页"+'</a></div>');  				     
							     }
							     if(n<=lastPager){
											      			     
							  	   $("#dmsgid8").html('<div><a onclick="getdata(0)" href="#">'+"下一页"+'</a>('+pn+'/'+lastPager+')</div>');  				     
							     }else{		
							       
							  	   $("#dmsgid8").html('<div>下一页('+pn+'/'+lastPager+')</div>');  				     
							     }	
     							     
				     $(data3).each(function(index,rdata){			
				     if(data3.length>0 & rdata.TMessagestype.messagestypeId>5000){		
				     var url=rdata.messagesAnnex;				     
				     fileUrl=url.split('#!!')[0]; 				
                     var datatitle=rdata.messagesTitle;
                     if(datatitle.length>50){
                       datatitle=datatitle.substring(0, 51)+"...";
                     }
				     $("#dmsgid1").html($("#dmsgid1").html()+'<div style="border-bottom:1px solid;border-bottom-color:#B2DFEE;width:80px;font-size:13px;">'+rdata.messagesId+'</div>'); 

				     $("#dmsgid2").html($("#dmsgid2").html()+'<div style="float: left;"><b style="color:#000000">[</b>'+rdata.TMessagestype.messagestypeName+'<b style="color:#000000">]-</b></div>'
				     +'<div style="border-bottom:1px solid;border-bottom-color:#B2DFEE;font-size:13px;padding-left: 5px;"><a href="'+fileUrl+'" >'+datatitle+'</a></div>');

				     $("#dmsgid3").html($("#dmsgid3").html()+'<div style="border-bottom:1px solid;border-bottom-color:#B2DFEE;font-size:13px;">'+rdata.messagesTime+'</div>');  
				     $("#dmsgid4").html($("#dmsgid4").html()+'<div style="border-bottom:1px solid;border-bottom-color:#B2DFEE;width:100px;">'
				     +'<a onclick="changediv(1)" href="updatatype.jsp?mid='+rdata.messagesId+'" target="tvv">'+"移动"+'</a>&nbsp;'				 
				     +'<a onclick="doUpdate('+rdata.messagesId+')" href="">'+"删除"+'</a></div>');			          				     			      
				     }else if(data3.length>0 & rdata.TMessagestype.messagestypeId>1){}
				     else{
				     $("#dmsgid7").html('<div style="width:100%;text-align: center;height:50px;color:#EE7600;padding-top:10px;">0数据记录~</div>');
				     }				    
				     }); 			                                              
			    } 
			    });
			    }
       function doUpdate1(a){
               alert(a);
               
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
				                 if(d!=null){
				                 Search1();
				                 }                                                      
			                    }	                                  		           		                  	     		     
		
				       });
  
         }
         }	
       function changediv(a){

            if(a==1){
	        document.getElementById("dvif2").style.display="block";
            }else{
	        document.getElementById("dvif2").style.display="none";	   
	        } 
	    } 		    		
    </script>
  </head>
  
  <body>
   <% 
    String title=request.getParameter("title"); 
    title=new String(title.getBytes("iso-8859-1"),"UTF-8");
   %>
   <input id="title2" type="hidden" name="messagesImgsrcs" value="<%=title %>"> 	
   <input id="nid" type="hidden" value="1">
   <input id="hid" type="hidden" value="1">
   <div id="dvmsgid">
    <table   border="1" bordercolor="#B2DFEE" align="center" style="border-collapse: collapse;width:100%;line-height: 25px;font-size:15px;" cellpadding="0" cellspacing="0">   
       <tr>     
          <td colspan="4" >
	       <div id="dvif2" style="display: none;width:100%;">
	       	<div style="font-size:15px;width:100%;">
               <div  style="margin-top: 0px;margin-left: 0px;padding:0;pxtext-align: right;width:100%;"> 
                  <ul style="padding: 0px;margin-top:0px;list-style-type: none;float: right;width:100%;background:#FFFFF0;border-bottom:1px solid;border-bottom-color:#B2DFEE;">
                   <li style="margin-right: 0px;margin-top: 0px;margin-right:1px;float: right;">
                     <img width="22px" onclick="changediv()"  alt="" src="images/gb.jpg">
                   </li>
                   <li style="margin-left:12px;color:#5B5B5B"><b>文件移动</b></li>
                  </ul>             
	          </div>
              <iframe frameborder="0" name="tvv" style="width:100%;height:150px;margin-top:0px;" ></iframe>         
             </div>     
	       </div>
          </td>   
      </tr>  
      <tr>     
          <td colspan="5">
               <div  style="margin-top: 0px;margin-left: 0px;padding0pxtext-align: right;width:100%;"> 
                  <ul style="padding: 0px;margin-top:0px;list-style-type: none;float: right;width:100%;background:#F8F8FF;border-bottom:1px solid;border-bottom-color:#B2DFEE;">
                   <li style="margin-right: 0px;margin-top: 0px;margin-right:1px;float: right;">
                     <img width="22px" onclick="changeif()"  alt="" src="images/gb.jpg">
                   </li>
                   <li style="float: left;color:#5B5B5B;margin-left: 12px"><b>搜索结果</b></li>
                  </ul>             
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
     <td align="left"><div id="dmsgid2"></div></td>
     <td><div id="dmsgid3"></div></td>
     <td><div id="dmsgid4"></div></td>     
     </tr>	
     <tr align="center">
     <td colspan="4">
 	     <div style="width:100%">
		     <ul style="float: left;list-style-type: none;margin-left:45%;">
			     <li style="float: left;" id="dmsgid7"></li>
			     <li style="float: left;margin-left:3px;" id="dmsgid8"></li>
		     </ul>
	     </div>    
     </td>
     </tr>
  </table>
</div>
  </body>
</html>
