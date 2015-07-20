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
			    "sendtype":40003,
			    "data":{
			    "pn":1,
			    "ps":15,
			    }};
			    
	           $.ajax({   	       		
				     type:"post",
		             url:"mobile!mobile.action",	 				      
				     dataType:"json",
      		         data:"para="+JSON.stringify(json), 
				     success:function(d){
			                 
				     var data1=d;				
				     var data2=data1.data;
				     var data3=data2.list;				     
				     $(data3).each(function(index,rdata){
				     var time=rdata.recruitmentTime;
                     time=time.substring(0, 11); 
				     $("#jop1").html($("#jop1").html()+'<div><ul style="float: right;padding:0px;width:318px"><li style="float:right;font-size:13px;margin-left:15px;margin-right:10px;">'+time+'</li>'
				     +'<li style="float: left;padding:0px;width:5px;text-align: left;"><b style="color:#7F7F7F;">·</b></li>'
				     +'<li style="padding:0px;width:300px;margin-left:15px;"><a href="recruitmentdetail.jsp?rid='+rdata.recruitmentId+'" target="tvc">'+rdata.recruitmentTittle+'</a></li>'							     
				     +'<li style="float:left;font-size:13px;margin-left:15px">招聘'+rdata.recruitmentPeoplenum+'人</li>'
				     +'<li style="float:left;font-size:13px;margin-left:5px">'+rdata.TUser.userNikename+'</li></ul></div>');
 
				      });         
			    }
			    });
			   
		});	    
			    		       

    </script>
  </head>
  
  <body>
    <div id="jop">
	    <table style="width:100%;line-height: 25px;font-size:15px;">            
	
	     <tr align="left">
	       <td colspan="2" height="27px" style="padding-left: 10px;padding-top: 10px;background:url(images/TJT/dht.png);;font-size:16px;"><b>企业招聘</b></td>
	     </tr>
	     <tr align="center">	 
	       <td align="left"><div id="jop1" style="padding-top: 10px; "></div></td>  
	     </tr>	
	
	    </table>
	</div>
  </body>
</html>
