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
   
    a:link{text-decoration : none ;color :#3A5FCD;;} 
	a:visited {text-decoration : none ;color : #525252 ;} 
	a:hover {text-decoration : underline ;color :#CD0000 ;} 
	a:active {text-decoration : none ;color :#212121 ;}	  

	</style>
    <script>
        
         
 	     function gogetdate(){   
 	     	            
	          var n = document.getElementById("gopage").value;
	          n=parseInt(n)+2;
	     	  document.getElementById("nid").value=n;  	           
		      getdata(1);  	
		 }  
		           	  
        $(function(){    
	              	           
		            getdata(1);                        
                   });

	     function getdata(m){  
	                
	            var x= document.getElementById("x100").value;
	     	    var n= document.getElementById("nid").value;  
		        if(m==1 & n!=1){
		               n=n-2;
		        }
		        var json="";  

   				if(x==0){    
				    json ={
					    "sendtype":40004,
					    "data":{
					    "pn":n,
					    "ps":2,
					    }};
			    }else{

				    var title=document.getElementById("title10").value; 

				    json ={
					    "sendtype":40004,
					    "data":{
					    "key":title,
					    "pn":n,
					    "ps":2,
					    }};			    			    			    
			    }
			
	           $.ajax({   	       		
				     type:"post",
		             url:"mobile!mobile.action",	 				      
				     dataType:"json",
      		         data:"para="+JSON.stringify(json), 
				     success:function(d){
			     			 $("#xchange1").html("");
		                 
				     var data1=d;				
				     var data2=data1.data;
				     var data3=data2.list;				     
	                 
	                 var pn=data1.pn;
			
			         n=pn+1;					 
			         document.getElementById("nid").value=n;
			         
				

                     var count=data1.count;
	                 lastPager=Math.ceil(count/2);	
	                 if(n==2){									       
				  	    $("#dmsgid12").html('<div>上一页 </div>');  				     
				     }else{						
				  	    $("#dmsgid12").html('<div><a onclick="getdata(1)" href="#">'+"上一页"+'</a></div>');  				     
				     }
				     if(n<=lastPager){
								      			     
				  	   $("#dmsgid10").html('<div><a onclick="getdata(0)" href="#">'+"下一页"+'</a>('+pn+'/'+lastPager+')</div>');  				     
				     }else{		
				       
				  	   $("#dmsgid10").html('<div>下一页('+pn+'/'+lastPager+')</div>');  				     
				     }	
				  	var idx=100;     			         
			        $(data3).each(function(index,rdata){		

                     idx =parseInt(idx)+1;                            
				     
                     var a="" ;
				     if(rdata.TResume.TUser.userSex==false){
				        a="男";				        
				     }else{
				        a="女";
				     }	
				     $("#xchange1").html($("#xchange1").html()+'<div id="divjob"><ul id="'+idx+'"style="">'
				     +'<li style="float: left;text-align:left;margin-top:5px;padding-left:10px;width:150px;"><a onclick="changeif(1)"'
					 +'href="qr_qzdetail.jsp?fid='+rdata.forjobId+'" target="_blank">'+rdata.forjobTittle+'</a></li>'
				     +'<li style="margin-left:150px;padding-top:0px;width:60px">'+a+'</li>'
				     +'<li style="margin-left:210px;padding-top:0px;width:120px;font-size:15px;color:#3A5FCD;">'+rdata.TResume.resumeAge+'</li>'
				     +'<li style="margin-left:330px;padding-top:0px;width:200px;">'+rdata.TResume.resumeEducation+'</li>'
				     +'<li style="height:40px;margin-left:530px;padding-top:5px;font-size:15px;color:#3A5FCD;width:100px;text-align: center;">'+rdata.TResume.resumeWork+'</li>'
				     +'<li style="margin-left:630px;padding-top:5px;width:168px;font-size:15px;">'+rdata.forjobTime+'</li>'			     
				     +'</ul></div>');	
				   // 奇数行
			        if( Math.ceil( idx) % 2 ){
			            document.getElementById(idx).style.backgroundColor='#FFFFFF';	
			            document.getElementById(idx).style.border='0px';			            
			        // 偶数行
			        }else{
			            document.getElementById(idx).style.backgroundColor='#F7F7F7';				            	     			      
     			    }  
  		     			      
				     });         
				                                              
			    } 
			    });
			    }
  
    </script>
  </head>
  
  <body>
   <input id="nid" type="hidden" value="1">
   <input id="hid" type="hidden" value="1">
   <div id="dvmsgid">
    <table   align="center" style="border-collapse: collapse;width:100%;line-height: 25px;font-size:15px;" cellpadding="0" cellspacing="0">   
      
      <tr align="center" style="border-bottom: 1px solid;border-color:#A8A8A8;">     

          <td width="150" align="left">&nbsp;&nbsp;职位信息</td>  
          <td width="60">性别</td>   
          <td width="120">年龄</td>
          <td width="200">学历</td>
          <td width="100">工龄</td>
          <td>发布时间</td>
      </tr >     

     <tr align="center" style="font-size:13px;">
       <td align="left" colspan="6"><div id="xchange1" style="padding-top: 10px;">&nbsp;数据加载中。。。</div></td> 
     </tr>		
     <tr>
	     <td colspan="6">	    
	 	     <div>
			     <ul style="width:800px;margin-top:15px;list-style-type: none;border-top: 1px solid;border-color:#A8A8A8;">
				     <li style="margin-left:515px;float: left;" id="dmsgid12"></li>
				     <li style="float: left;margin-left:3px;" id="dmsgid10"></li>
				     <li style="float: left;margin-left:3px;" >
				                              到第<input id="gopage" type="text" style="border:1px solid;border-color:#3A5FCD;width:35px">页
				         <input onclick="gogetdate()" onmousemove="this.style.background='#436EEE'" onmouseout="this.style.background='#3A5FCD'" type="button" value="确定"
				         style="margin-left: 2px; border:none;width:50px; height:20px;font-size:15px;color:#ffffff; background:#3A5FCD;">				         
				     </li>
			     </ul>
		     </div>    
	     </td>
     </tr>
  </table>
</div>
  </body>
</html>
