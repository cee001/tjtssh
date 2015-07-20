package com.tjt.action;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.struts2.ServletActionContext;

import com.tjt.entity.TMessages;
import com.tjt.entity.TMessagestype;
import com.tjt.entity.TUser;
import com.tjt.service.MessagesService;
import com.tjt.util.TextUtility;


public class UploadAction
{
    private File Filedata;

    private String FiledataFileName;

    private String FiledataContentType;
	private MessagesService messagesService;
    // 文件夹目录
    private static final String basePath = "data";

    public String execute()
    {
    	

		@SuppressWarnings("unused")
		String s = (String)ServletActionContext.getRequest().getParameter("god");
		@SuppressWarnings("unused")
		String s2 = (String)ServletActionContext.getRequest().getParameter("uid");		 
		int typeid = Integer.parseInt(ServletActionContext.getRequest().getParameter("typeid"));
		System.out.println(typeid +"---typeid ");
    	if (Filedata != null && Filedata.length() > 0)
        {
        	// 群组名字作为最后的文件夹
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
        	String groupFileName = sdf.format(new Date());
    		String fileName=FiledataFileName;        	      	
            String uploadPath = "/home/default/TJT/data/"+groupFileName;
            File path = new File(uploadPath);
            
            if (!path.exists())
            {
                path.mkdirs();
            }else{
            	//文件已存在
            	//FiledataFileName 
            }
            //取得扩展名
            String fileExt = FiledataFileName.substring(FiledataFileName.lastIndexOf(".") + 1).toLowerCase();
            //重构上传的名称 
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            FiledataFileName = df.format(new Date()) + "_"
                             + new Random().nextInt(1000) + "." + fileExt;           
            
            String newPath = uploadPath +"/"+FiledataFileName;
            Filedata.renameTo(new File(newPath));
			System.out.println(newPath);
            // 保存到数据库中的路径    
			@SuppressWarnings("unused")
			String savePath = basePath+"\\"+groupFileName+"\\"+FiledataFileName;
	
			TMessagestype mt=new TMessagestype();
            mt.setMessagestypeId(typeid);
            TUser u=new TUser();
            u.setUserId(1);
    		String ptime = TextUtility.formatDate(new Date());
        	String url="http://xheyou.com/TJT/downfile!downMsgdata.action?fileUrl="+FiledataFileName+"&fileName="+fileName+"#!!"+fileName+"";	
			TMessages msg=new TMessages();
    		msg.setMessagesTime(ptime);	   		
    		msg.setMessagesIslink(false);
    		msg.setMessagesStatus((short) 0);
    		msg.setMessagesCollectnum(0);    		
    		msg.setTMessagestype(mt);   		
    		msg.setTUser(u);
			msg.setMessagesAnnex(url);
			msg.setMessagesTitle(fileName);
		    messagesService.addTMessages(msg);   

        }

        return null;
    }

    // 上传文件
    @SuppressWarnings("unused")
	private String pathSplit(String timeStr, String o, String n)
    {
        StringBuffer sb = new StringBuffer();
        for (String a : timeStr.split(o))
        {
        	System.out.println("1000");
        	System.out.println(FiledataFileName);            
        	sb.append(a);
            sb.append(n);
            
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String format(Date date, String parttern)
    {
        DateFormat df = new SimpleDateFormat(parttern);
        return df.format(date);
    }    
    
    public File getFiledata()
    {
        return Filedata;
    }

    public void setFiledata(File filedata)
    {
        Filedata = filedata;
    }

    public String getFiledataFileName()
    {
        return FiledataFileName;
    }

    public void setFiledataFileName(String filedataFileName)
    {
        FiledataFileName = filedataFileName;
    }

    public String getFiledataContentType()
    {
        return FiledataContentType;
    }

    public void setFiledataContentType(String filedataContentType)
    {
        FiledataContentType = filedataContentType;
    }
    
    public static void main(String[] args) {
		System.out.println(0.444<1);
	}

	public MessagesService getMessagesService() {
		return messagesService;
	}

	public void setMessagesService(MessagesService messagesService) {
		this.messagesService = messagesService;
	}
    
}
