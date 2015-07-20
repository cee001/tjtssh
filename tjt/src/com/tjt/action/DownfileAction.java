package com.tjt.action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DownfileAction extends ActionSupport {
	public void downMsgdata() throws FileNotFoundException{
		   HttpServletRequest request=ServletActionContext.getRequest();		
		   String fileUrl = request.getParameter("fileUrl");
		   String fileName  =request.getParameter("fileName");		
		   String groupFileName=fileUrl.substring(0,8);
		   HttpServletResponse response = ServletActionContext.getResponse();		
		        // 下载本地文件
            // 文件的默认保存名
		        // 读到流中
		        InputStream inStream = new FileInputStream("/home/default/TJT/data/"+groupFileName+"/"+fileUrl);// 文件的存放路径
		        // 设置输出的格式
		        response.reset();
		        response.setContentType("bin");
		        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		        // 循环取出流中的数据
		        byte[] b = new byte[100];
		        int len;
		        try {
		            while ((len = inStream.read(b)) > 0)
		            response.getOutputStream().write(b, 0, len);
		            response.setContentType("text/html;charset=UTF-8");  
		           // PrintWriter out = response.getWriter();  
		           // out.print("上传成功！上传文件为:"+fileName+"");  
				              
		            //response.sendRedirect("listStandard.jsp");      
		            inStream.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }	

	}
