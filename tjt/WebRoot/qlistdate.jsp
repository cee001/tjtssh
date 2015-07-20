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
    <script>

	     $(function(){  

			   var json ={
					   "sendtype":20001,
					   "data":{
					   "messagestypeId":5002,
					   "pn":1,
					   "ps":16,
					   }};	
				     
	           $.ajax({   
			         async:false,  	           	       		
				     type:"post",
		             url:"mobile!mobile.action",	 				      
				     dataType:"json",
      		         data:"para="+JSON.stringify(json), 
				     success:function(d){
							     var data1=d;				
							     var data2=data1.data;
							     var data3=data2.messagelist;														 
							     							     
				     $(data3).each(function(index,rdata){			
				     var url=rdata.messagesAnnex;				     
				     fileUrl=url.split('#!!')[0]; 	
				     var strtitle=rdata.messagesTitle;
				     var t1=strtitle;
				     var datatitle=t1;	
				     if(t1.length>26){
                       t1=t1.substring(0, 26);
                     } 				                    
                     var x=t1.length;
               
                     re=/[\u4E00-\u9FA5]/g;  //测试中文字符的正则
                     if(re.test(strtitle)){            
                     var y=t1.match(/[\u4E00-\u9FA5]/g).length;                           
                     var z=x+(x-y)/2-2; 
                     z=parseInt(z);                                     
                     if(strtitle.length>z){
                       t2=strtitle.substring(0, z);
                       datatitle=t2+"...";                         
                     } 
                                                        
                     }else{
                       datatitle=datatitle.substring(0, 51)+"...";
                     }
             		              		 
				     $("#dmsgid2").html($("#dmsgid2").html()+'<div  style="padding-left: 1px;width:360px;"><ul style="float: left;padding:0px;width:360px"><li  style="float: left;padding:0px;width:5px;text-align: left;"><b style="color:#7F7F7F;">·</b></li><li title="'+strtitle+'" style="float: right;padding:0px;width:340px;"><a style="font-weight: 200;font-size:13px;" href="'+fileUrl+'" >'+datatitle+'</a></li></ul></div>');
			          				     			      
				      });         
			    }
			    });
			   
		});
 		
    </script>
  </head>
  
  <body>

   <div id="dvmsgid">
    <table style="width:100%;line-height: 23px;font-size:15px;">            

     <tr align="left">
     <td style="padding-left: 10px;font-size:16px;"><b>文件下载</b></td>
     </tr>
     <tr align="center" style="border-top:1px solid;border-bottom-color:#B2DFEE;">
      <td align="left"><div id="dmsgid2" style="padding-top: 10px;"></div></td>  
     </tr>	

  </table>
</div>
  </body>
</html>
