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
			    "messagestypeId":1,
			    "pn":1,
			    "ps":5,
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
                     var strtitle=rdata.messagesTitle;
                     var datatitle=strtitle;
                     if(datatitle.length>14){
                       datatitle=datatitle.substring(0,15);
                     }	
				     $("#supdem1").html($("#supdem1").html()+'<div><ul style="float: left;padding:0px;width:318px"><li style="float: left;padding:0px;width:5px;text-align: left;"><b style="color:#7F7F7F;">·</b></li><li title="'+strtitle+'"  style="float: right;padding:0px;width:300px;"><a style="font-weight: 200;font-size:13px;" href="msgcon.jsp?mid='+rdata.messagesId+'" >'+datatitle+'</a></li></ul></div>');
 		          				     			      
			          				     			      
				      });         
			    }
			    });
			   
		});	   
			    		       
    </script>
  </head>
  
  <body >

    <div id="supdem">
	    <table style="width:100%;line-height: 25px;font-size:15px;">            
	
	     <tr align="left">
	       <td colspan="2" style="padding-left: 10px;height:30px;background:url(images/TJT/dht.png);font-size:15px;"><b>供求信息</b></td>
	     </tr>
	     <tr align="center">	 
	       <td align="left"><div id="supdem1" style="padding-top: 10px;"></div></td>  
	     </tr>	
	
	    </table>
	</div>
  </body>
</html>