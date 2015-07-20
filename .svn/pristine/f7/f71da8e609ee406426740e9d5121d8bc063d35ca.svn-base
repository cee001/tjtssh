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
   
    a:link{text-decoration : none ;color :#212121;} 
	a:visited {text-decoration : none ;color : #525252 ;} 
	a:hover {text-decoration : underline ;color :#CD0000 ;} 
	a:active {text-decoration : none ;color :#212121 ;}	  
	</style>
    <script>

         function doUpdate(pid){
   
			    var json = {
			        "sendtype":40020,
			        "data":{
			        "productId":pid,			  				        			        			        
			     }
			     };
             if(confirm("确定删除吗？")){
                $.ajax({
			           async:false,                   
				       type:"post",                         
				       url:"mobile!mobile.action",	 
				       dataType:"json",   
		      		   data:"&para="+JSON.stringify(json),
				       success:function(d){	
				                
		                          window.location.href="listekspecial.jsp";
			                                                                            
			                    }	                                  		           		                  	     		     
		
				       });
         }
         }
       
         $(function(){    
	               	var m=1;	           
		            getdata(m);                        
                   });

	     function getdata(m){  
	    
	     			 var n= document.getElementById("nid").value;  
		             if(m==1 & n!=1){
		             n=n-2;
		             }
  			    var json ={
			    "sendtype":40002,
			    "data":{
			    "producttypeId":6,
			    "pn":n,
			    "ps":15,
			    }}; 				     
	           $.ajax({   	       		
				     type:"post",
		             url:"mobile!mobile.action",	 				      
				     dataType:"json",
      		         data:"para="+JSON.stringify(json), 
				     success:function(d){
	                 $("#dmsgid1").html("");
	                 $("#dmsgid2").html("");
	                 $("#dmsgid3").html("");
	                 $("#dmsgid4").html("");	
	                 $("#dmsgid5").html("");
	                 $("#dmsgid6").html("");				                 			     
				     var data1=d;				
				     var data2=data1.data;
				     var data3=data2.productlist;	
				     var pn=data1.pn;	
			         n=pn+1;						 
			         document.getElementById("nid").value=n;
				     var count=data1.count;
				     lastPager=Math.ceil(count/15);				     
	                 if(n==2){									       
				  	   $("#dmsgid7").html('<div>上一页 </div>');  				     
				     }else{						
				  	    $("#dmsgid7").html('<div><a onclick="getdata(1)" href="#">'+"上一页"+'</a></div>');  				     
				     }
				     if(n<=lastPager){
								      			     
				  	   $("#dmsgid8").html('<div><a onclick="getdata(0)" href="#">'+"下一页"+'</a>('+pn+'/'+lastPager+')</div>');  				     
				     }else{		
				       
				  	   $("#dmsgid8").html('<div>下一页('+pn+'/'+lastPager+')</div>');  				     
				     }							     		     
				     $(data3).each(function(index,rdata){
				     $("#dmsgid1").html($("#dmsgid1").html()+'<div style="border-bottom:1px solid;border-bottom-color:#B2DFEE;width:80px;">'+rdata.productId+'</div>');
				     $("#dmsgid2").html($("#dmsgid2").html()+'<div style="padding-left:3px;border-bottom:1px solid;border-bottom-color:#B2DFEE;"><a onclick="changeif(1)" href="productdetail.jsp?pid='+rdata.productId+'" target="tvc">'+rdata.productName+'</a></div>');
				     $("#dmsgid3").html($("#dmsgid3").html()+'<div style="border-bottom:1px solid;border-bottom-color:#B2DFEE;">'+rdata.productPrice+'</div>');
				     $("#dmsgid4").html($("#dmsgid4").html()+'<div style="border-bottom:1px solid;border-bottom-color:#B2DFEE;">'+rdata.productTime+'</div>');
				     $("#dmsgid5").html($("#dmsgid5").html()+'<div style="border-bottom:1px solid;border-bottom-color:#B2DFEE;">'+rdata.TCompany.companyName+'</div>');
				     $("#dmsgid6").html($("#dmsgid6").html()+'<div style="border-bottom:1px solid;border-bottom-color:#B2DFEE;width:60px;"><a onclick="doUpdate('+rdata.productId+')" href="">'+"删除"+'</a></div>');   
				     });         
				                                              
			    } 
			    });
			    }       
       	   function GetJsonData() {
       
			    var json ={
			    "sendtype":40002,
			    "data":{
			    "producttypeId":6,
			    "pn":1,
			    "ps":15,
			    }};
			    return json;
			}
  	    function changeif(a){

            if(a==1){
	        document.getElementById("dvif1").style.display="block";
            }else{
	        document.getElementById("dvif1").style.display="none";	   
	        } 
	    }    
    </script>
  </head>
  
  <body>
 
   <input id="nid" type="hidden" value="1">
   <div id="dvmsgid">
    <table   border="1" bordercolor="#B2DFEE" align="center" style="border-collapse: collapse;width:100%;line-height: 25px;font-size:13px;" cellpadding="0" cellspacing="0">   
      <tr>     
          <td colspan="6" bgcolor="#F0F8FF">
            <div style="font-size:15px;border-bottom:1px solid;border-bottom-color:#B2DFEE;">
                 <div  style="margin-top: 5px;margin-left: 12px"> 
                 <b>特种设备实训考核设备</b> 
                 </div>
            </div>
          </td>   
      </tr> 
       <tr>     
          <td colspan="6" >
	       <div id="dvif1" style="display: none;width:100%;">
	       	<div style="font-size:15px;width:100%;">
               <div  style="margin-top: 0px;margin-left: 0px;padding0pxtext-align: right;width:100%;"> 
                  <ul style="padding: 0px;margin-top:0px;list-style-type: none;float: right;width:100%;background:#F8F8FF;border-bottom:1px solid;border-bottom-color:#B2DFEE;">
                   <li style="margin-right: 0px;margin-top: 0px;margin-right:1px;float: right;">
                     <img width="22px" onclick="changeif()"  alt="" src="images/gb.jpg">
                   </li>
                   <li style="margin-right: 47%;float: right;color:#5B5B5B"><b>产品详情</b></li>
                  </ul>             
	          </div>
              <iframe frameborder="0" name="tvc" style="width:100%;height:550px;margin-top:0px;" ></iframe>         
             </div>     
	       </div>
          </td>   
      </tr>       
      <tr align="center">     
          <td width="80px">ID</td>
          <td>商品名称</td>  
          <td>商品价格</td>   
          <td>上架时间</td>
          <td>发布公司</td>
          <td width="60px">审核</td>

      </tr >   

     <tr align="center">
     <td><div id="dmsgid1"></div></td>
     <td  align="left"><div id="dmsgid2"></div></td>
     <td><div id="dmsgid3"></div></td>
     <td><div id="dmsgid4"></div></td>
     <td><div id="dmsgid5"></div></td>
     <td><div id="dmsgid6"></div></td>     
     </tr>		
     <tr align="center">
     <td colspan="6">
 	     <div style="width:100%">
		     <ul style="float: left;list-style-type: none;margin-left:45%;">
			     <li style="float: left;" id="dmsgid7"></li>
			     <li style="float: left;margin-left:3px;" id="dmsgid8"></li>
		     </ul>
	     </div>        
     </td>
     </tr>
  </table>
</div>
  </body>
</html>
