<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showup.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/jquery.js"></script>	


<script type="text/javascript">
       function doUpdate(cid,aid){
       if(aid==1){

                $.ajax({
                       async:false,                
				       type:"post",                         
				       url:"any!doUpdate.action",	 
                         
				       data:"cy.companyId="+cid
				           +"&cy.companyStatus="+aid,	    
				       success:function(d){

			                                                                         
			                    }	                                  		           		                  	     		     
		
				       });

	       		      alert("ok");  	
                      window.location.href="any!showlist.action?aid="+0+"&tRandStr="+Math.random();
           }else{

                $.ajax({
                       async:false,                
				       type:"post",                         
				       url:"any!doUpdate.action",	                         
				       data:"cy.companyId="+cid
				           +"&cy.companyStatus="+aid	
				           +"&cy.companyStatusdetil="+$("#t10").val(),	    
				       success:function(d){	

			                                                                         
			                    }	                                  		           		                  	     		     
		
				       });

				       alert("ok");     
		               window.location.href="any!showlist.action?aid="+0+"&tRandStr="+Math.random();           
           
           }      
         
         }
 
</script>
  </head>
  
 <body bgcolor="#ffffff">



    <table border="1" bordercolor="#B2DFEE" align="center" style="border-collapse: collapse;width:100%;line-height: 25px;font-size:15px;" cellpadding="0" cellspacing="0">
   
    <tr>
       <td align="right" width="48%" bgcolor="#F8F8FF">用户ID:</td>
       <td style="padding-left: 20px;">${cy.TUser.userId}</td>
    </tr>

     <tr>
        <td align="right"  bgcolor="#F8F8FF">公司名称:</td>
        <td style="padding-left: 20px;">${cy.companyName}</td>
     </tr>
     <tr>
        <td  align="right" bgcolor="#F8F8FF" >联系电话:</td>
        <td style="padding-left: 20px;">${cy.companyPhone}</td>
     </tr>
     <tr>
        <td  align="right" bgcolor="#F8F8FF" >执照编号:</td>
        <td style="padding-left: 20px;">${cy.companyCode}</td>
     </tr>


     <tr>
        <td  align="right" bgcolor="#F8F8FF" >公司地址:</td>
        <td style="padding-left: 20px;">${cy.companyAddr }</td>
     </tr>
     <tr>
        <td  align="right" bgcolor="#F8F8FF" >公司类型:</td>
        <td style="padding-left: 20px;" >${cy.TCompanytype.companytypeId}</td>
     </tr>
     <tr>
        <td  align="right" bgcolor="#F8F8FF" >申请时间:</td>
        <td style="padding-left: 20px;" >${cy.companyTime}</td>
     </tr>
     <tr>        
        <td colspan="2" align="center"><img src="${cy.companyFaceimg }"></td>
     </tr>                 		  
     <tr>        
        <td colspan="2" align="left">
         <c:if test="${cy.companyStatus==0}">
          <input type="button" value="通 过" onclick="doUpdate(${cy.companyId},1)"
	           onmouseover="this.style.background='url(images/lan1.jpg)'" onmouseout="this.style.background='url(images/lan.jpg)'"
               style="margin-left: 12px; border:none;width:80px; height:25px;
               font-size:15px;color:#ffffff; background:url(images/lan.jpg)" /> 
   		 </c:if>
         
        </td>
     </tr>   
     <tr>        
        <td colspan="2" align="left">
          <c:if test="${cy.companyStatus==0}">        
           <input type="button" value="未通过" onclick="doUpdate(${cy.companyId},2)"
	           onmouseover="this.style.background='url(images/lan1.jpg)'" onmouseout="this.style.background='url(images/lan.jpg)'"
               style="margin-left: 12px; border:none;width:80px; height:25px;
               font-size:15px;color:#ffffff; background:url(images/lan.jpg)" />
               &nbsp;<font style="color:red;">原因：</font><input id="t10" type="text" style="width:500px;">    
           </c:if>              
        </td>
     </tr>  
            
    </table>
 
    
  </body>
</html>
