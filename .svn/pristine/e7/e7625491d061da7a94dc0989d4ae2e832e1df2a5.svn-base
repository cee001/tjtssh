
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'listbook.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style type="text/css">

	#ull{ float: left;padding: 0px;line-height: 27px;width:400px;}
    #ull li{ float:left;margin-left:2px;width:100%;font-size:15px;font-family:宋体;text-align: left;}	
	</style>

  </head>
  
  <body>
    <div>

     <div style="margin-top: 0px;background:url(images/home/new_02.png)">

	     <table width="100%">
		     <tr align="left">
		       <td style="padding-left: 10px;height:27px;font-size: 15px;background:url(images/home/new_02.png);">
			      <img src="images/home/new_07.png">&nbsp;<b>同类资讯</b>
		       </td>
		       <td align="right" style="background:url(images/home/new_02.png);font-size:13px;">
				       更多<img src="images/home/new_10.png">&nbsp;
		       </td>
		     </tr>	     
	     </table>
     </div> 
    <%
     List<Map<String, Object>> al=(List<Map<String, Object>>)request.getAttribute("al");

     %>
      <div>  
        <ul id="ull">
      <%
      for(Map<String, Object> cn:al){
           	     String a=cn.get("auther").toString();
	             String[] ln=a.split("");	
	             String ids="";
	             String ids2="";
		         for(int i=0;i<ln.length;i++){	
		         ids=ln[0];
		         ids2=ln[1];
		         }
			   String title=cn.get("title").toString();
			   String title1=title;
	           if(title1.length()>20){
	           title1=title1.substring(0, 18)+"...";
	           }
      %>  


        <li title=<%=title %> style="height:25px;font-size: 14px">
          <a onmouseover="this.style.color='#CD0000'" onmouseout="this.style.color='#36648B'" style="color:#36648B;font-weight: 200;"
             href="<%=cn.get("url").toString()%>" target="_blank" >
           <b style="color:#7F7F7F;">·</b><%=title1 %>
          </a>              
        </li>

      <% 
      }    
      %>
        </ul>    
     </div>
   </div> 
   

<!-----Attribute 属性 归属 把…归于---->
  </body>
</html>
