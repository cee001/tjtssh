
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
       $(function(){   
   		     		     		     	 
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
                         $("#dl1").html(rdata.recruitmentTittle);      
                         $("#dl2").html(rdata.recruitmentSalary); 
                         $("#dl3").html(rdata.recruitmentPeoplenum); 
                         $("#dl4").html(rdata.recruitmentCity);                           
                         $("#dl5").html(rdata.recruitmentTime); 
                         $("#dl7").html(rdata.recruitmentAge);  
                         $("#dl8").html(a);   
                         $("#dl9").html(rdata.recruitmentWorkexperience); 
                         $("#dl10").html(rdata.recruitmentEducation);  
                         $("#dl12").html(rdata.recruitmentTittle);
                         $("#dl13").html(rdata.TUser.userCompany);  
                         $("#dl14").html(rdata.TUser.userNikename); 
                         $("#dl15").html("联系电话："+rdata.TUser.userPhone);                
                         $("#dl16").html("公司地址："+rdata.TUser.userAddress);                     
                         $("#dv10").html('<div style="font-size:15px;width:50%;word-wrap:break-word;text-align: left;"><pre>'+rdata.recruitmentInfo+'</pre><br><br></div>');                                           
	                  
                     }	                                                         
	                 }	                                  		           		                  	     
		    });
		});
		       
       	function GetJsonData5() {
 		     var rid=document.getElementById("iprid1").value;  
		     var json ={
				       "sendtype":40022,
				       "data":{
				       "recruitmentId":rid,			  				        			        			        
		     }};  
			return json;
	    } 		          
	</script>

  </head>
  
  <body onload="openhref()">
         
      <input id="iprid1" type="hidden" value="<%=request.getParameter("rid") %>">
      <table  align="left" style="border-collapse: collapse;width:100%;line-height: 35px;font-size:15px;" cellpadding="0" cellspacing="0">
          <tr>
          <td style="width:20px;">&nbsp;</td>
          <td style="" colspan="2"><b>职位信息</b></td>
          </tr> 
          <tr>  
          <tr>
          <td>&nbsp;</td>
          <td style="width:45%;"><div style="float: left;margin-left: 0px;"> 招聘职位:</div><div id="dl1" style="float: left;margin-left: 3px;"></div></td>
          <td><div style="float: left;margin-left: 0px;"> 薪资水平:</div><div id="dl2" style="float: left;margin-left: 3px;"></div></td>
          </tr> 
          <tr>
          <td>&nbsp;</td>
          <td><div style="float: left;margin-left: 0px;"> 招聘人数:</div><div id="dl3" style="float: left;margin-left: 3px;"></div></td>
          <td><div style="float: left;margin-left: 0px;"> 工作地区:</div><div id="dl4" style="float: left;margin-left: 3px;"></div></td>
          </tr>
          <tr>
          <td>&nbsp;</td>
          <td><div style="float: left;margin-left: 0px;"> 发布时间:</div><div id="dl5" style="float: left;margin-left: 3px;"></div></td>
          <td><div style="float: left;margin-left: 0px;"> </div><div id="dl6" style="float: left;margin-left: 3px;"></div></td>
          </tr>
          <tr>
          <td>&nbsp;</td>
          <td colspan="2"><br><b>职位要求</b></td>
          </tr>  
          <tr>
          <td style="border-right-color: #ffffff;">&nbsp;</td>
          <td><div style="float: left;margin-left: 0px;"> 年龄:</div><div id="dl7" style="float: left;margin-left: 3px;"></div></td>
          <td><div style="float: left;margin-left: 0px;"> 性别:</div><div id="dl8" style="float: left;margin-left: 3px;"></div></td>
          </tr> 
          <tr>
          <td>&nbsp;</td>
          <td><div style="float: left;margin-left: 0px;"> 工龄要求:</div><div id="dl9" style="float: left;margin-left: 3px;"></div></td>
          <td><div style="float: left;margin-left: 0px;"> 学历要求:</div><div id="dl10" style="float: left;margin-left: 3px;"></div></td>
          </tr>
          <tr>
          <td colspan="3" valign="bottom">
           <br>
           <div style="text-align:center;width:180px;height:30px;background:#3A5FCD;color: #fff"><b>职位描述与公司情况</b></div>
          </td>
          </tr>  
	      <tr style="border: 1px solid;border-color:#EAEAEA;border-top: 2px solid;border-top-color:#3A5FCD;">  
	      <td>&nbsp;</td>
		  <td colspan="2"  >
		    <div id="dv10" style="padding: 0px;overflow:hidden;margin-top: 0px;height:100%;"></div>	
		    <div style="width:100%;height:200px;">&nbsp;</div>
	      </td>     	    
          </tr>

      </table>

  </body>
</html>
