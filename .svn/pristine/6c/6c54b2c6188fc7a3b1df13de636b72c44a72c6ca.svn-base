
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>发布消息</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript" src="js/jquery.js"></script>

    <style type="text/css">

		.bt10{
			background-image:url(images/fb2.jpg);
		}
		.bt11{
			background-image:url(images/fb.png);
		} 
	  
	   #ulp1{margin-left:10px;width:660px;margin-top:26px;height:370px;text-align:left;
	         border: 1px solid;border-color:#A8A8A8;background:#F0F8FF;padding-left: 21px}
	   #ulp1 li{list-style:none;margin-top:15px;}    
	   a:link{text-decoration : none ;color :red ;} 
	   a:visited {text-decoration : none ;color : #525252 ;} 
	   a:hover {text-decoration : underline ;color :#CD0000 ;} 
	   a:active {text-decoration : none ;color :#212121 ;}	  
    </style>
    <script type="text/javascript">
    function openhref(){   
     		     		     		     	 
		  $.ajax({
		       type:"post",                         
		       url:"mobile!mobile.action",	 
  
		       dataType:"json",   
      		   data:"&para="+JSON.stringify(GetJsonData5()), 
		       success:function(d){	
		                if(d !=null){
		                			
				     var data1=d;				
				     var data2=data1.data;
				     var data3=data2.meg;	
                         $("#l1").html(data3.productName);      
                         $("#l2").html(data3.productPrice+" 元"); 
                         $("#l3").html(data3.productTime); 
                         $("#l4").html(data3.TCompany.companyName);                                           
                         $("#l5").html('<div style="font-size:15px;width:720px;word-wrap:break-word;"><pre>'+data3.productInfo+'</pre><br><br></div>');
                         $("#l6").html('<div style="width:720px;word-wrap:break-word;"><img alt="" src='+data3.productImgsrcs+'></div>');
                        
	                  
                     }	                                                         
	                    }	                                  		           		                  	     
		       });

		       }
       	function GetJsonData5() {
	      var pid=document.getElementById("ippid").value;  
	                 
	      var json = {
	        "sendtype":40021,
	        "data":{
	        "productId":pid,			  				        			        			        
	      }}; 
			    return json;
			} 		          
	</script>

  </head>
  
  <body onload="openhref()">
         
      <input id="ippid" type="hidden" value="<%=request.getParameter("pid") %>">
      <table  align="center" style="border-collapse: collapse;width:100%;line-height: 25px;font-size:15px;" cellpadding="0" cellspacing="0">   
	      <tr >  
	      <td style="border-right-color: #ffffff;">&nbsp;</td>
	      <td align="center" width="750px" style="border-right-color: #ffffff;">
	       <div id="dv10" style="padding: 0px;width:720px;overflow:hidden;margin-top: 0px;height:100%;">                              
            <ul style="list-style-type: none;padding: 0px;margin-top: 0px;">                    
              <li id="l1" style="height:30px;font-size:22px;widht:100%;">                            		           	           	                               
              </li>  
              <li style="font-size:14px;text-align: left;padding: 0px;widht:100%;margin-top: 3px;">      
                <div style="float: left;margin-left: 0px;">商品价格:</div><div id="l2" style="float: left;margin-left: 3px;"></div>         		           	           	                               
              </li> 
              <li style="font-size:14px;text-align: left;padding: 0px;widht:100%;margin-top: 30px;">    
                <div style="float: left;margin-left: 0px;"> 上架时间:</div><div id="l3" style="float: left;margin-left: 3px;"></div>           		           	           	                               
              </li>   
              <li style="font-size:14px;padding: 0px;text-align: left;widht:100%;margin-top: 60px;">     
                <div style="float: left;margin-left: 0px;">发布公司:</div><div id="l4" style="float: left;margin-left: 3px;"></div>          		           	           	                               
              </li>  
              <li id="l5" style="font-size:14px;widht:100%;margin-top: 90px;">               		           	           	                               
              </li>  
              <li id="l6" style="font-size:14px;widht:100%;">               		           	           	                               
              </li>                                                                             
            </ul>		                                                                 	        
	       </div>	
          </td>      
       	  <td >&nbsp;</td>
          </tr>
      </table>

  </body>
</html>
