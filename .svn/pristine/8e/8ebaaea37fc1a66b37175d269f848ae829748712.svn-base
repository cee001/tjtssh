
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
    
		      var fid=document.getElementById("ipfid").value;  	   
    
		      var json = {
		        "sendtype":40025,
		        "data":{
		        "forjobId":fid,			  				        			        			        
		      }};     		     		     		     	 
		  $.ajax({
			   async:false, 		  
		       type:"post",                         
		       url:"mobile!mobile.action",	  
		       dataType:"json",   
      		   data:"&para="+JSON.stringify(json), 
		       success:function(d){	
		                if(d !=null){
		                			
				     var data1=d;				
				     var data2=data1.data;
				     var rdata=data2.meg;	
				     var a="" ;
				     if(rdata.TResume.TUser.userSex==false){
				        a="男";				        
				     }else{
				        a="女";
				     }		
				     //var myDate = new Date();
                     //var Y=myDate.getFullYear(); 
                     //var X=rdata.TResume.resumeBirthday;
                     //var b=Y-X;	
                         $("#fl1").html(rdata.forjobTittle);      
                         $("#fl2").html(rdata.forjobTime); 
                         $("#fl3").html(rdata.forjobInfo); 
                         $("#fl4").html(rdata.TResume.TUser.userNikename);  
                         $("#fl5").html(rdata.TResume.resumeAge); 
                         $("#fl6").html(a); 
                         $("#fl7").html(rdata.TResume.resumePhone);
                         $("#fl8").html(rdata.TResume.resumeEducation); 
                         $("#fl9").html(rdata.TResume.resumeSalary);   
                         $("#fl10").html(rdata.TResume.resumeWork);                         
                         $("#fl11").html(rdata.TResume.resumeCity);                                       
                         $("#fl12").html('<div style="font-size:15px;width:50%;word-wrap:break-word;text-align: left;"><pre>'+rdata.TResume.resumeInfo+'</pre><br><br></div>');
                                           
	                  
                     }	                                                         
	                 }	                                  		           		                  	     
		       });
		});
		          
	</script>

  </head>
  
  <body onload="openhref()">
         
      <input id="ipfid" type="hidden" value="<%=request.getParameter("fid") %>">
      <table  align="left" style="border-collapse: collapse;width:100%;line-height: 25px;font-size:15px;" cellpadding="0" cellspacing="0">
          <tr style="background:#F8F8FF;border-top: 1px solid;border-color:#3A5FCD;" >
          <td style="width:20px;">&nbsp;</td>
          <td style="" colspan="2"><b style="color:#104E8B">应聘信息</b></td>
          </tr> 
          <tr>  
          <tr>
          <td>&nbsp;</td>
          <td><div style="float: left;margin-left: 0px;"> 求聘意向:</div><div id="fl1" style="float: left;margin-left: 3px;"></div></td>
          <td>&nbsp;</td>
          </tr> 
          <tr>
          <td>&nbsp;</td>
          <td><div style="float: left;margin-left: 0px;"> 发布时间:</div><div id="fl2" style="float: left;margin-left: 3px;"></div></td>
          <td>&nbsp;</td>
          </tr> 
          <tr>
          <td>&nbsp;</td>
          <td colspan="2"><div style="float: left;margin-left: 0px;"> 描述信息:</div><div id="fl3" style="float: left;margin-left: 3px;width:580px;"></div></td>        
          </tr>
          <tr height="30px"><td colspan="3">&nbsp;</td></tr>
          
          <tr style="background:#F8F8FF;border-top: 1px solid;border-color:#3A5FCD;" >
          <td>&nbsp;</td>
          <td colspan="2" ><div style="width:75%;"><b style="color:#104E8B">简历信息</b></div></td>
          </tr>
          <tr height="10px"><td colspan="3">&nbsp;</td></tr>
          
          <tr > 
          <td>&nbsp;</td>
          <td style="" colspan="2"><b>基本资料</b></td>
          </tr> 
          <tr>
          <td>&nbsp;</td>
          <td style="width:51%;"><div style="float: left;margin-left: 0px;"> 姓名:</div><div id="fl4" style="float: left;margin-left: 3px;"></div></td>
          <td><div style="float: left;margin-left: 0px;"> 年龄:</div><div id="fl5" style="float: left;margin-left: 3px;"></div></td>
          </tr>

          <tr>
          <td>&nbsp;</td>
          <td><div style="float: left;margin-left: 0px;"> 性别:</div><div id="l6" style="float: left;margin-left: 3px;"></div></td>
          <td><div style="float: left;margin-left: 0px;"> 电话:</div><div id="fl7" style="float: left;margin-left: 3px;"></div></td>
          </tr> 
          <tr>
          <td>&nbsp;</td>
          <td><div style="float: left;margin-left: 0px;"> 学历:</div><div id="fl8" style="float: left;margin-left: 3px;"></div></td>
          <td><div style="float: left;margin-left: 0px;"> 薪资要求:</div><div id="fl9" style="float: left;margin-left: 3px;"></div></td>
          </tr>
          <tr>
          <td>&nbsp;</td>
          <td><div style="float: left;margin-left: 0px;"> 工龄:</div><div id="fl10" style="float: left;margin-left: 3px;"></div></td>
          <td><div style="float: left;margin-left: 0px;"> 所在地区:</div><div id="fl11" style="float: left;margin-left: 3px;"></div></td>
          </tr>
          <tr height="30px"><td colspan="3">&nbsp;</td></tr>       
                       
          <tr>
          <td>&nbsp;</td>
          <td colspan="2"><b>工作经历与教育经历等描述</b></td>
          </tr>  
	      <tr >  
	      <td>&nbsp;</td>
	      <td colspan="2">
	        <div id="fl12" style="padding: 0px;overflow:hidden;margin-top: 0px;height:100%;"></div>	
          </td>      	    
          </tr>
      </table>

  </body>
</html>
