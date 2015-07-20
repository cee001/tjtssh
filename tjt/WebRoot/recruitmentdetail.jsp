
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
				     var rdata=data2.meg;	
				     var a="" ;
				     if(rdata.recruitmentSex=false){
				        a="男";				        
				     }else{
				        a="女";
				     }
                         $("#l1").html(rdata.recruitmentTittle);      
                         $("#l2").html(rdata.recruitmentSalary); 
                         $("#l3").html(rdata.recruitmentPeoplenum); 
                         $("#l4").html(rdata.recruitmentCity);  
                         $("#l5").html(rdata.TUser.userNikename); 
                         $("#l6").html(rdata.recruitmentTime); 
                         $("#l7").html(rdata.recruitmentAge);  
                         $("#l8").html(a);   
                         $("#l9").html(rdata.recruitmentWorkexperience); 
                         $("#l10").html(rdata.recruitmentEducation);                                       
                         $("#dv10").html('<div style="font-size:15px;width:50%;word-wrap:break-word;text-align: left;"><pre>'+rdata.recruitmentInfo+'</pre><br><br></div>');
                    
                        
	                  
                     }	                                                         
	                    }	                                  		           		                  	     
		       });

		       }
       	function GetJsonData5() {
	      var rid=document.getElementById("iprid").value;  
         
	      var json = {
	        "sendtype":40022,
	        "data":{
	        "recruitmentId":rid,			  				        			        			        
	      }}; 
			    return json;
			} 		          
	</script>

  </head>
  
  <body onload="openhref()">
         
      <input id="iprid" type="hidden" value="<%=request.getParameter("rid") %>">
      <table  align="left" style="border-collapse: collapse;width:100%;line-height: 25px;font-size:15px;" cellpadding="0" cellspacing="0">
          <tr>
          <td style="width:25%;">&nbsp;</td>
          <td style="" colspan="2"><b>职位信息</b></td>
          </tr> 
          <tr>  
          <tr>
          <td style="border-right-color: #ffffff;width:25%;">&nbsp;</td>
          <td style="width:35%;"><div style="float: left;margin-left: 0px;"> 招聘职位:</div><div id="l1" style="float: left;margin-left: 3px;"></div></td>
          <td><div style="float: left;margin-left: 0px;"> 薪资水平:</div><div id="l2" style="float: left;margin-left: 3px;"></div></td>
          </tr> 
          <tr>
          <td style="border-right-color: #ffffff;">&nbsp;</td>
          <td><div style="float: left;margin-left: 0px;"> 招聘人数:</div><div id="l3" style="float: left;margin-left: 3px;"></div></td>
          <td><div style="float: left;margin-left: 0px;"> 工作地区:</div><div id="l4" style="float: left;margin-left: 3px;"></div></td>
          </tr>
          <tr>
          <td style="border-right-color: #ffffff;">&nbsp;</td>
          <td><div style="float: left;margin-left: 0px;"> 发布单位:</div><div id="l5" style="float: left;margin-left: 3px;"></div></td>
          <td><div style="float: left;margin-left: 0px;"> 发布时间:</div><div id="l6" style="float: left;margin-left: 3px;"></div></td>
          </tr>
          <tr>
          <td style="width:25%;">&nbsp;</td>
          <td style="" colspan="2"><b>职位要求</b></td>
          </tr>  
          <tr>
          <td style="border-right-color: #ffffff;">&nbsp;</td>
          <td><div style="float: left;margin-left: 0px;"> 年龄:</div><div id="l7" style="float: left;margin-left: 3px;"></div></td>
          <td><div style="float: left;margin-left: 0px;"> 性别:</div><div id="l8" style="float: left;margin-left: 3px;"></div></td>
          </tr> 
          <tr>
          <td style="border-right-color: #ffffff;">&nbsp;</td>
          <td><div style="float: left;margin-left: 0px;"> 工龄要求:</div><div id="l9" style="float: left;margin-left: 3px;"></div></td>
          <td><div style="float: left;margin-left: 0px;"> 学历要求:</div><div id="l10" style="float: left;margin-left: 3px;"></div></td>
          </tr>
          <tr>
          <td style="width:25%;">&nbsp;</td>
          <td style="" colspan="2"><b>职位描述与公司情况</b></td>
          </tr>  
	      <tr >  
		 
		      <td align="center" colspan="3" style="border-right-color: #ffffff;">
		       <div id="dv10" style="padding: 0px;overflow:hidden;margin-top: 0px;height:100%;"></div>	
	          </td>      
	    
          </tr>
      </table>

  </body>
</html>
