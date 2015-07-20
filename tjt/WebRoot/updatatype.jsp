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
      		   data:"&para="+JSON.stringify(GetJsonData()), 
		       success:function(d){	
		                if(d !=null){		                			
				     var data1=d;				
				     var data2=data1.data;
				     var data3=data2.meg;	
                         $("#l1").html('<b style="color:#FF7F24">[</b>'+data3.TMessagestype.messagestypeName+'<b style="color:#FF7F24">]--</b>');                        
                         $("#l2").html(data3.messagesTitle);			                                                                                                                  
	                    }	                                                         
	                    }	                                  		           		                  	     
		       });

		       });
		       
		       
       	   function GetJsonData() {
                var mid=document.getElementById("ipmid").value;                                
			    var json = {
			        "sendtype":20003,
			        "data":{
			        "messagesId":mid,			  				        			        			        
			     }};
			    return json;
			} 
       function doUpdate1(){
                var tid=document.getElementById("meg100").value; 
                var mid=document.getElementById("ipmid").value;  

                if(tid==0){
                   $("#dt10").html(">请选择文件类别");
                }
			    var json = {
			        "sendtype":20035,
			        "data":{
			        "messagesId":mid,
			        "messagestypeId":tid,		  				        			        			        
			     }
			     };

                $.ajax({
			           async:false,                
				       type:"post",                         
				       url:"mobile!mobile.action",	 
				       dataType:"json",   
		      		   data:"&para="+JSON.stringify(json),
				       success:function(d){					                
		                          $("#dv10").html('<div style="color:#FF7F24;font-size:15px">文件移动成功！</div>');
                                               
			                    }	                                  		           		                  	     		     
		
				       });          
         }		
         function clear2(){
			 dt10.innerHTML = "&nbsp;";
			
		 }	 	   
	</script>

  </head>
  
  <body>
         
      <input id="ipmid" type="hidden" value="<%=request.getParameter("mid") %>">
      <table style="border-collapse: collapse;width:100%;height:120px;line-height: 25px;font-size:15px;" cellpadding="0" cellspacing="0">   

	      <tr>  
	      <td style="border-right-color: #ffffff;">&nbsp;</td>
	      <td align="left" width="750px" style="border-right-color: #ffffff;">
	       <div id="dv10" style="padding: 0px;width:720px;overflow:hidden;margin-top: 0px;">                              
            <ul style="list-style-type: none;padding: 0px;margin-top: 0px;width:100%;font-size:15px;">                    
              <li id="l1" style="height:30px;float: left"></li>  
              <li id="l2" style="height:30px;"></li>
	          <li id="l3">
		           <div style="float: left">
		            <b style="color:#FF7F24;">*</b>资料类别：  
		            <select id="meg100" name="messagestypeId" onclick="clear2()">	
			           <option value="0" >--请选择--</option>            									           
			           <option value="5001">专业知识</option>
			           <option value="5002">行业标准</option>
			           <option value="5003">政策法规</option>
			           <option value="5004">工艺资料</option>
			           <option value="5005">工程案例</option>	           	           
		            </select>
		           </div> 
                   <div id="dt10" style="color:#FF7F24;font-size:15px;">&nbsp;</div>              
	          </li>  
	          <li id="l2" style="height:30px;">
		      <input type="button" value="提 交" onclick="doUpdate1()"
		             onmouseover="this.style.background='#FFC125'" onmouseout="this.style.background='#FF7F00'"
                     style="border:none;width:80px; height:22px;
                     font-size:15px;color:#ffffff; background:#FF7F00" />	          
	          </li>                                           
            </ul>		                                                                 	        
	       </div>	
          </td>      
       	  <td >&nbsp;</td>
          </tr>
      </table>
  </body>
</html>
