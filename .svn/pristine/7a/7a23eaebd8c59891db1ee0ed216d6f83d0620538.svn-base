package com.tjt.action;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.tjt.entity.TUsercompanytype;
import com.tjt.service.UsercompanytypeService;
import com.tjt.util.TimeUtil;
import com.tjt.common.Pager;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UsercompanytypeAction extends ActionSupport {
	private TUsercompanytype ct;
	private UsercompanytypeService cts;



	public TUsercompanytype getCt() {
		return ct;
	}


	public void setCt(TUsercompanytype ct) {
		this.ct = ct;
	}


	public UsercompanytypeService getCts() {
		return cts;
	}


	public void setCts(UsercompanytypeService cts) {
		this.cts = cts;
	}


	public String doAdd(){
        String ptime = TimeUtil.dateToStrLong(new Date());
		ct.setUsercompanytypeTime(ptime);	
		if(cts.addTUsercompanytype(ct)){

			return "success";		
		}else{
			
			return "fail";
		}	
	}

	
	//��ʾ�޸�
	public String showUpdate(){

		ct=cts.getTUsercompanytypeById(ct.getUsercompanytypeId());		

			return "showUpdate";		
	
	}
		
	//�޸�
	public String doUpdate(){
        String ptime = TimeUtil.dateToStrLong(new Date());
		ct.setUsercompanytypeTime(ptime);			
		if(cts.updateTUsercompanytype(ct)){

			return this.showlist();		
		}else{

			return "fail";
		}	
	}


	public String showDetail(){

		ct=cts.getTUsercompanytypeById(ct.getUsercompanytypeId());		
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
	   int tid=Integer.parseInt(request.getParameter("ctid"));
	   ArrayList<TUsercompanytype> al=cts.getTUsercompanytypeByPageNum1(pageNum, pageSize,tid);
	   request.setAttribute("al", al);
	   
	   int count= cts.getcount1(tid);
	   String pager=Pager.getPaging(pageNum, pageSize, count, "cut!showlist");
	   request.setAttribute("pager", pager);
	   return "showlist";
	}

	

	}
