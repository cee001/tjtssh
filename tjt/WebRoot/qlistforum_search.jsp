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
   
    a:link{text-decoration : none ;color :#191970;} 
	a:visited {text-decoration : none ;color : #27408B ;} 
	a:hover {text-decoration : underline ;color :#CD0000 ;} 
	a:active {text-decoration : none ;color :#27408B ;}	  
	</style>
    <script>

 
  	     function getdate1(){  
	              
	     		  document.getElementById("nid").value="1";  
	     		  var m=1;	           
		          getdata(m);  
	
		             } 
     
 	     function gogetdate(){   
 	     	            
	          var n = document.getElementById("gopage").value;
	          n=parseInt(n)+2;
	     	  document.getElementById("nid").value=n;  
	     	  var m=1;	           
		      getdata(m);  	
		 }   
		                    	  		                       
         $(function(){    
             var m=1;	           
             getdata(m);                        
           });

	     function getdata(m){  

    	     var n= document.getElementById("nid").value;  
    		 var name= document.getElementById("ipnid2").value; 
             if(m==1 & n!=1){
             n=n-2;
             }   

		    var json ={
		    "sendtype":20100,
		    "data":{
		    "key":name,
		    "pn":n,
		    "ps":30,
		    }};	
			     
           $.ajax({   
		         async:false,  	           	       		
			     type:"post",
	             url:"mobile!mobile.action",	 				      
			     dataType:"json",
     		     data:"para="+JSON.stringify(json), 
			     success:function(d){
	             $("#xchange1").html("");
                 document.getElementById("l2150").style.background="#FFB90F"; 
                 
			     var data1=d;				
			     var data2=data1.data;
			     var data3=data2.messagelist;
                 var idx=100;
			     $(data3).each(function(index,rdata){		
                              
                    idx =parseInt(idx)+1;

		 		    var json ={
				    "sendtype":20013,
				    "data":{
				    "mid":rdata.messagesId,				
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
  		     
			        imgsrc="luntan_40.png";  
                    if(rdata.TMessagestype.messagestypeId>5000 & rdata.TMessagestype.messagestypeId<5010){
                      imgsrc="luntan_32.png";
                    }			          
                    if(rdata.messagesStatus>7){
                      imgsrc="luntan_30.png";
                    }  
                    if(rdata.messagesStatus>4 & rdata.messagesStatus<8){
                       imgsrc="luntan_37.png";
                    }                    
                    imgsrc1=""; 
                    if(rdata.messagesImgsrcs!=null&rdata.messagesImgsrcs!=""){
                       imgsrc1="images/home/luntan_17.png";
                    }
                    if(rdata.messagesStatus>4 & rdata.TMessagestype.messagestypeId>5000 & rdata.TMessagestype.messagestypeId<5010){
                       imgsrc1="images/home/luntan_32.png";
                    }
			         var strtitle=rdata.messagesTitle;                                   
				     var t1=strtitle;
				     var datatitle=t1;	
				     if(t1.length>28){
                         t1=t1.substring(0, 29);                    				                    
	                     var x=t1.length;               
	                     re=/[\u4E00-\u9FA5]/g;  //测试中文字符的正则
	                     if(re.test(strtitle)){            
		                     var y=t1.match(/[\u4E00-\u9FA5]/g).length;                           
		                     var z=x+(x-y)/2-2; 
		                     z=parseInt(z);                                     
		                     if(strtitle.length>z){
		                       t2=strtitle.substring(0, z);
		                       datatitle=t2+"..";                         
		                     } 
		                                                        
                          }else if(strtitle.length>50){
                             datatitle=datatitle.substring(0, 51)+"...";
                          }
                        }else{ }
                    
                    
                    var userNikename=rdata.TUser.userNikename;	
                    if(userNikename.length>6){
                       userNikename=userNikename.substring(0,7)+"...";
                    } 
                    
                    var msgtime=rdata.messagesTime;   
                    msgtime=msgtime.substring(0,16);      
  
					     
					     
					 var pn=data1.pn;	
			         n=pn+1;						 
			         document.getElementById("nid").value=n;
				     var count=data1.count;
				     lastPager=Math.ceil(count/30);				     
	                 if(n==2){									       
				  	    $("#dmsgid7").html('<div>上一页 </div>');  				     
				     }else{						
				  	    $("#dmsgid7").html('<div><a onclick="getdate1()" href="#">首页</a>&nbsp;<a onclick="getdata(1)" href="#">'+"上一页"+'</a></div>');  				     
				     }
				     if(n<=lastPager){
								      			     
				  	   $("#dmsgid8").html('<div><a onclick="getdata(0)" href="#">'+"下一页"+'</a>('+pn+'/'+lastPager+')</div>');  				     
				     }else{						       
				  	   $("#dmsgid8").html('<div>下一页('+pn+'/'+lastPager+')</div>');  				     
				     }	  
 				                    
			     $("#xchange1").html($("#xchange1").html()+'<div ><ul id="'+idx+'"style="float: left;padding:0px;width:808px;border:1px dashed #C1C1C1;color:#3B3B3B;height:35px">'
			     +'<li style="float: left;margin-left:10px;padding-top:5px;"><img alt="" src="images/home/'+imgsrc+'" ></li>'
			     +'<li style="float: left;padding-top:5px;"><img src="'+imgsrc1+'" ></li>'
			     +'<li title="'+strtitle+'"  style="float: left;margin-top:5px;margin-left:5px;padding:0px;"><a style="font-weight: 200;font-size:15px;"'
			     +'href="qnews.jsp?dd=qnews1.jsp?mid='+rdata.messagesId+'" target="blank">'+datatitle+'</a></li>'
			     +'<li style="visibility: visible;position:absolute;float: left;margin-left:500px;padding-top:0px;font-size:12px;height:35px">'
			     +'<div style="height:16px;margin-top:0px;">'+userNikename+'</div><div style="height:16px;">'+msgtime+'</div></li>'
			     +'<li style="visibility: visible;position:absolute;float: left;height:40px;margin-left:620px;padding-top:5px;font-size:15px;color:#191970;width:100px;text-align: center;">'+num+'/'+rdata.messagesTouchnum+'</li>'
			     +'<li style="visibility: visible;position:absolute;float: left;margin-left:730px;padding-top:5px;font-size:15px;">'+rdata.TMessagestype.messagestypeName+'</li>'			     
			     +'</ul></div>');
                    // 奇数行
			        if( Math.ceil( idx) % 2 ){
			            document.getElementById(idx).style.backgroundColor='#F7F7F7';				            
			        // 偶数行
			        }else{
			            document.getElementById(idx).style.backgroundColor='#FFFFFF';	
			            document.getElementById(idx).style.border='0px';	     			      
     			    }  
  
				     });         
				                                              
			    } 
			    });
			    }      

    </script>
  </head>
  
  <body>
    
    <input id="nid" type="hidden" value="1">

    <%                
      request.setCharacterEncoding("GBK");    
      String name=request.getParameter("key");  
      name=new String(name.getBytes("iso-8859-1"),"GBK"); 
    %>
    <input id="ipnid2" type="hidden" value="<%=name %>">
    <div id="xchange">
	    <table style="width:100%;line-height: 25px;font-size:15px;color:#CD9B1D;">            
	  
	     <tr align="left">
	       <td colspan="4" style="padding-left: 10px;font-size:16px;"><b>&nbsp;</b></td>
	     </tr>
	     <tr align="left" >
	       <td style="width:480px">&nbsp;</td>
	       <td align="center" style="width:140px">作者/发表时间</td>
	       <td align="center" style="width:102px">回复/查看&nbsp;</td>
	       <td style="">&nbsp;所属板块</td>
	     </tr>
	     <tr style="border-top:1px solid;border-top-color:#CD9B1D;">	 
	       <td align="left" colspan="4"><div id="xchange1" style="padding-top: 10px;"></div></td>  
	     </tr>	
	     <tr  style="border-top:1px solid;border-top-color:#CD9B1D;">	 
	       <td colspan="4">
	 	     <div style="width:99%;text-align: right">
			     <ul style="float: right;list-style-type: none;">
				     <li style="float: left;" id="dmsgid7"></li>
				     <li style="float: left;margin-left:3px;" id="dmsgid8"></li>
				     <li style="float: left;margin-left:3px;" >
				                              到第<input id="gopage" type="text" style="border:1px solid;border-color:#CD9B1D;width:35px">页
				         <input onclick="gogetdate()" type="button" value="确定" style="margin-left: 2px; border:none;width:50px; height:20px;
			                    font-size:15px;color:#ffffff; background:#CD9B1D;">				         
				     </li>
			     </ul>
		     </div>  
           </td> 
            
	     </tr>		
	    </table>
	</div>
  </body>
</html>
