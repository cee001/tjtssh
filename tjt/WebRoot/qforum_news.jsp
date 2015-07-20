<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 	<script type="text/javascript" src="js/jquery.js"></script>   
	<link href="css/linkStyle.css" rel="stylesheet" type="text/css" />
	<link href="css/tjtmallStyle.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
	
		.b1t1{
			background:#CD9B1D;
		}
		.b1t2{
			background:#EEE685;
		}	
    	.bf1{
		background-image:url(images/fb.jpg);
		}
		.bf2{
			background-image:url(images/fb2.jpg);
		}
	</style>
    <script type="text/javascript">  
         $(function(){   
                        
              $("#divp1").load("qhead_forum.jsp?RandStr="+Math.random()); 	  
              $("#divf2a_new ").load("qdh_forum.jsp"); 
              $("#divp21").load("qfoot_new.jsp"); 
              var mid=$("#ipmid2").val();	           
				 $.ajax({ 
            	     async:false,   			          	       		
				     type:"get",
				     url:"qforum_news1.jsp?mid="+mid, 
				     success:function(d){				                 
				            $("#l2150").html(d); 
                            $("#divp21").load("qfoot_new.jsp"); 				                  
				     }              			
				   }); 	
          });             

		function changed(id){
			document.getElementById("l"+id).style.background="#FFB90F";
			document.getElementById("l"+id).style.color="#ffffff";
				
		}
		function rechanged(a){		
			var outid=document.getElementById("outid").value;	   
			if(a==outid){

			document.getElementById("l"+a).style.background="#FFB90F";
            document.getElementById("l"+a).style.color="#ffffff";
			}else{	     
		     
		    document.getElementById("l"+a).style.background="none";
		    document.getElementById("l"+a).style.color="#0A0A0A";
		    }

			}	

        function openhref(src){
        
              window.open(src,target="_blank");
               
        }          
    </script>      
  

  </head>
  
  <body>
		<%			             
         //分割新闻列表页传递来的ip地址参数，取得新闻id
  	     String a = request.getParameter("dd");
         String[] ln=a.split("=");	
         String ids="";
         for(int i=0;i<ln.length;i++){	
         ids=ln[1];
         System.out.println(ids+"------");
         }
	 
       %> 
       <input id="ipmid2" type="hidden" value="<%=ids %>">  
    <input id="outid" type="hidden" value="2150">
    <div id="indexdiv"> 
       <div id="divp1">
         
       </div>
       <div id="divp2" onmouseover="rechangex1()">
           <div id="divf2a_new" onmouseover="rechangex1()"  >                  
  
           </div> 
           <div id="divf2b_new">                  
             <table style="font-size:15px">
	          <tr>
		          <td><img alt="" src="images/home/new_03.png">&nbsp;当前位置：</td>
		          <td>首页&nbsp;<img alt="" src="images/jt07.png">&nbsp;论坛&nbsp;<img alt="" src="images/jt07.png">&nbsp;帖子详情</td>
	          </tr>
             </table>	  
           </div>            
           <div id="divf2c_new">  
              <div id="">
                <ul>
                  <li id="l2150" style="margin-top: 0px;margin-left: 0px;">
                    
                  </li>                                  
                </ul>
              </div>  
              <div id="">
                <ul>                  
                   <li>
                   
                   </li>
                </ul> 
              </div>                    
           </div> 

           <div id="#divp21">  
           
           </div> 
                  
       </div>    

    </div>
  </body>
</html>


