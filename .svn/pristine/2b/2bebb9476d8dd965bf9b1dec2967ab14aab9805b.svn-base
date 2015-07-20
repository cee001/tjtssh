<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'qr_zpSearch.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page"> 
	<script type="text/javascript">
        function Search(pr){ 
       
			  //根据地区码查询地区名
              var areaID1=document.getElementById("seachprov").value;
			  var areaName1 = area_array[areaID1];
			  var areaNamea =areaName1;
             // alert(areaName1);
		      var areaID2=document.getElementById("seachcity").value;
              var  areaName2=""; 
              var  areaName3="";
              var areaIDx="";
			  if(areaID1==11 || areaID1==12 || areaID1==31 || areaID1==81 || areaID1==82 ){
				  areaName1=""; 			 
				  areaName2= areaNamea.substring(0, (areaNamea.length-1));	
				  if(areaID2!=0){
					  areaIDx=areaID2;
					  areaName3=sub_array[index1][areaID2];		
					  //alert(areaName3);	  
				  }		 			 			  			 
			 }else{	 
	 		      if(areaID2==0){
					 return false;				 	      
			      }
				  var index1 = areaID2.substring(0, 2);
				  areaName2=sub_array[index1][areaID2];
				  areaName2 = areaName2.substring(0, (areaName2.length-1));			  	      
		          var areaID3=document.getElementById("seachdistrict").value;  
		          if(areaID3!=0){  
			          areaIDx=areaID3;  		   			 
					  var index2 = areaID3.substring(0, 4);
					  areaName3 = sub_arr[index2][areaID3]; 
			      }
			  }
		
			  //alert(areaName2);	
			  //alert(areaName3);	
			  document.getElementById("city1").value=areaName2;
			  document.getElementById("area1").value=areaName3;
			  document.getElementById("nid").value=1;
			 if(areaIDx==0 & pr==1){	
			   document.getElementById("x100").value=1;		   
			   getdata(1); 
			   
			 }else if(areaIDx!=0 & pr==1){	
			   document.getElementById("x100").value=2;			   
			   getdata(1); 
			   
			 }else if(areaIDx==0 & pr==0){
			   document.getElementById("x100").value=3;	
			   getdata(1); 
			   
			 }else if(areaIDx!=0 & pr==0){
			   document.getElementById("x100").value=4;	
			   getdata(1); 
			   
			 } 
			  
		 }		
			  			  				
	
	</script>
  </head>
  
  <body>
    <input id="city1" type="hidden" value="1">
    <input id="area1" type="hidden" value="1">
    <input id="x100" type="hidden" value="0"> 
        <table style="width:100%;height:100%;valign:center;">
         <tr>
          <td style="padding-left: 10px">
            <img alt="" onmousemove="this.src='images/home/zp_031.png'" onmouseout="this.src='images/home/zp_03.png'" src="images/home/zp_03.png">
          </td>
          <td align="right">
            <%@include file="qssq.html" %>
            <input onclick="Search(1)" onmousemove="this.style.background='#436EEE'" onmouseout="this.style.background='#3A5FCD'" type="button" value="go➭"
                   style="border:0px;width:40px;height:20px;font-size:15px;color:#FFFFFF;background:#3A5FCD;">
          </td>
          <td width="270px">
		 	  <div style="width:100%;text-align:right;">
		        <ul style="padding:0px;float: right;margin-right: 10px">
		           		        <!--------  搜索         ------->	
		          <li id="sou1" class="b1t1" onclick="Search(0)"onmousemove="this.style.background='#436EEE'" onmouseout="this.style.background='#3A5FCD'"
		              style="float: right;text-align: center;width:50px;height:20px;font-size:16px;">	
		              <img alt="" src="images/home/sosuo.png" style="margin-top: 2px">			        				            			              				                      			                		           
		          </li>       	           		        
		          <li style="float: right;">
		              <input id="title10" style="padding-left:2px;width:200px;height: 20px;border: 1px solid;border-color:#3A5FCD;background:url(images/home/zp_08.png); "
		                     onfocus="this.style.background='#ffffff'" onblur="this.style.background='url(images/home/zp_08.png)'" type="text" name="title" value="" >						
		          </li>		        	            	        	
		        </ul>	             
		      </div>   		            
          </td>
         </tr>
        </table>
  </body>
</html>
