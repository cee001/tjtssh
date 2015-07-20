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
    <script type="text/javascript">

	     $(function(){   
	     
			    var json5 ={
			    "sendtype":40002,
			    "data":{
			    "producttypeId":5,
			    "pn":1,
			    "ps":5,
			    }};
	           $.ajax({   	       		
				     type:"post",
		             url:"mobile!mobile.action",	 				      
				     dataType:"json",
      		         data:"para="+JSON.stringify(json5), 
				     success:function(d){
				     var data1=d;				
				     var data2=data1.data;
				     var data3=data2.productlist;				     
				     $(data3).each(function(index,rdata){
				     $("#pt5").html($("#pt5").html()+'<div style="width:199px;height:260px;float: left;overflow:hidden;">'	   
			           +'<table width="100%"><tr><td align="center" style="height:180px;"><img width="170px" height="170px" src="'+rdata.productImgsrcs+'"></td></tr>'
			           +'<tr><td style="height:40px;padding-top:1px;padding-left:10px;word-wrap:break-word;font-size:13px;">'
			           +'<a style="font-weight: 200;font-size:13px;"href="productdetail.jsp?pid='+rdata.productId+'" target="tvc">'+rdata.productName+'</a></td></tr>'
			           +'<tr><td style="height:25px;word-wrap:break-word;font-size:13px;padding-left:10px;">'+rdata.TCompany.companyName+'</td></tr></table></div>');			
  		          				     			      
				     });         
				                                              
			    } 
			    });
			    });
			    		       

   
    </script>
  </head>
  
  <body>
 
   <div>
    <table border="1" bordercolor="#4A708B" align="center" style="border-collapse: collapse;width:100%;" cellpadding="0" cellspacing="0">   
      <tr>     
          <td>
            <div style="font-size:15px;border-bottom:1px solid;border-bottom-color: #4A708B;">
                <ul style="float: left;height:35px;">
                  <li style="float: left;margin-top: 5px;margin-left: 12px;font-size: 23px;"><b>5F</b></li>
                  <li style="float: left;margin-top: 10px;margin-left: 5px;font-size: 15px"><b>测量计量仪表</b></li>
                </ul>
            </div>
          </td>   
      </tr>    
      <tr align="center">
        <td>
          <div id="pt5" style="font-size:15px;padding-top: 5px;"></div>
        </td>     
      </tr>		
     </table>
    </div>
		
				     
  </body>
</html>
