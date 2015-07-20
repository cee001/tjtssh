package com.tjt.action;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.tjt.entity.TDevice;
import com.tjt.service.DeviceService;
import com.tjt.util.TimeUtil;
import com.tjt.common.Pager;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeviceAction extends ActionSupport {
	private TDevice de;
	private DeviceService des;

	public TDevice getDe() {
		return de;
	}


	public void setDe(TDevice de) {
		this.de = de;
	}


	public DeviceService getDes() {
		return des;
	}


	public void setDes(DeviceService des) {
		this.des = des;
	}


	public String doAdd(){
        String ptime = TimeUtil.dateToStrLong(new Date());
		de.setDeviceTime(ptime);	
		if(des.addTDevice(de)){

			return "success";		
		}else{
			
			return "fail";
		}	
	}

	
	//��ʾ�޸�
	public String showUpdate(){

		de=des.getTDeviceById(de.getDeviceId());		

			return "showUpdate";		
	
	}
		
	//�޸�
	public String doUpdate(){
        String ptime = TimeUtil.dateToStrLong(new Date());
		de.setDeviceTime(ptime);			
		if(des.updateTDevice(de)){

			return this.showlist();		
		}else{

			return "fail";
		}	
	}


	public String showDetail(){

		de=des.getTDeviceById(de.getDeviceId());		
			return "showDetail";		
	
	}
	public String showlist(){
		//����ҳ��
	   HttpServletRequest request=ServletActionContext.getRequest();
	   int pageNum=1;
	   int pageSize=15;
	   
	   if(request.getParameter("p") != null &&! request.getParameter("p").equals("")){
	       try{
	           pageNum=Integer.parseInt(request.getParameter("p"));
	           
	       }catch(Exception ex){

	       }
	   }
	   int did=Integer.parseInt(request.getParameter("did"));	
	   ArrayList<TDevice> al=des.getTDeviceByPageNum1(pageNum, pageSize,did);
	   request.setAttribute("al", al);
	   
	   int count= des.getcount1(did);
	   String pager=Pager.getPaging(pageNum, pageSize, count, "dev!showlist");
	   request.setAttribute("pager", pager);
	   return "showlist";
	}

	

	}
