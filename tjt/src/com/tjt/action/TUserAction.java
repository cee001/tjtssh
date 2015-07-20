package com.tjt.action;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tjt.common.Pager;
import com.tjt.entity.TUser;
import com.tjt.service.UserService;
import com.tjt.util.TimeUtil;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class TUserAction extends ActionSupport {

	private TUser u;
	private UserService us;

	public TUser getU() {
		return u;
	}
	public void setU(TUser u) {
		this.u = u;
	}
	public UserService getUs() {
		return us;
	}
	public void setUs(UserService us) {
		this.us = us;
	}
	//��½
	public String doLogin() throws UnsupportedEncodingException{
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		 String userPhone=request.getParameter("userPhone");
	     String userPassword=request.getParameter("userPassword");	
		 u=us.checkLogin(userPhone,userPassword);	    
	     if(u!=null){

	         String pti= TimeUtil.dateToStrLong(new Date());
	 		 u.setUserTime(pti);
	 		 us.updateTUser(u);
	         int uid=u.getUserId();
	         u.setUserId(uid);
	         //request.setCharacterEncoding("utf-8");
	         //String usernikename=URLEncoder.encode(request.getParameter("usernikename"),"utf-8");
	         String name= URLEncoder.encode(u.getUserNikename(), "utf-8");
             Cookie cookie=new Cookie("mrCookie",uid+"#"+userPhone+"#"+name+"#"+u.getUserImgface());  
             cookie.setMaxAge(60*60*24*30);
             cookie.setPath("/");
             response.addCookie(cookie);
	    	 //HttpSession session=request.getSession();
	    	 //session.setAttribute("login", u);        
				return "success";		
			}else{		
				return "fail";
			}	


	}
	public String dologinout(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
		Cookie cookie = cookies[i];
		// 销毁
		cookie.setMaxAge(0);
        cookie.setPath("/");
		response.addCookie(cookie);
		}
		return "loginout";
		}else{
		return "loginout";	
		}
		
		}

	//���
	public String doAdd(){
        String ptime = TimeUtil.dateToStrLong(new Date());
		u.setUserTime(ptime);		
		if(us.addTUser(u)){
			return this.showlist();		
		}else{
			
			return "fail";
		}	
	}
	
	//��ʾ�޸�
	public String showUpdate(){
   	    HttpServletRequest request=ServletActionContext.getRequest();   	 
        HttpSession session=request.getSession();		
        if(session.getAttribute("login")==null){
        	 return "input";	
        }else{
        	
        }
		u=us.getTUserById(u.getUserId());		

			return "showUpdate";		
	
	}
	
	//ǰ����ʾ�������޸�
	public String showUpdate3(){
   	    HttpServletRequest request=ServletActionContext.getRequest();   	 
        HttpSession session=request.getSession();		
        if(session.getAttribute("login")==null){
        	 return "input";	
        }else{
        	
        }
		u=us.getTUserById(u.getUserId());		

			return "showUpdate3";		
	
	}
	//ǰ�������޸���ʾ
	public String showUpdate1(){
   	    HttpServletRequest request=ServletActionContext.getRequest();   	 
        HttpSession session=request.getSession();		
        if(session.getAttribute("login")==null){
        	 return "input";	
        }else{
        	
        }
		u=us.getTUserById(u.getUserId());		

			return "showUpdate1";		
	
	}
	
	//��ʾɾ���޸�
	public String showUpdate2(){
   	    HttpServletRequest request=ServletActionContext.getRequest();   	 
        HttpSession session=request.getSession();		
        if(session.getAttribute("login")==null){
        	 return "input";	
        }else{
        	
        }
		u=us.getTUserById(u.getUserId());		

			return "showUpdate2";		
	
	}
		
	//�޸�
	public String doUpdate(){
   	    HttpServletRequest request=ServletActionContext.getRequest();   	 
        HttpSession session=request.getSession();		
        
        if(session.getAttribute("login")==null){
        	 return "input";	
        }else{
        	
        }
	        
		if(us.updateTUser(u)){
			return this.showlist();		
		}else{
			
			return "fail";
		}	
	}
	
	//用户修改密码
	public String doUpdate1(){
   	    HttpServletRequest request=ServletActionContext.getRequest();   	 
   	    String phone=request.getParameter("userPhone");
   	    phone=phone.substring(0, 11);
        String userPwd=request.getParameter("userPwd");
        u=us.findTUserByPhone(phone);
		u.setUserPassword(userPwd);
		if(us.updateTUser(u)){
			return this.showlist();		
		}else{
			
			return this.showlist();		
		}	
	}
	
	//后台修改用户状态
	public String doUpdate2(){
   	    HttpServletRequest request=ServletActionContext.getRequest();   	 
        int uid=Integer.parseInt(request.getParameter("uid"));
        int para=Integer.parseInt(request.getParameter("userStatus"));
        u=us.getTUserById(uid);

		u.setUserStatus((short) para);
		if(us.updateTUser(u)){
			return this.showlist();		
		}else{
			
			return this.showlist();		
		}	
		
	}


	public String doDel(){
   	    HttpServletRequest request=ServletActionContext.getRequest();   	 
        HttpSession session=request.getSession();		
        if(session.getAttribute("login")==null){
        	 return "input";	
        }else{
        	
        }
		if(us.delTUser(u)){
			return this.showlist();		
		}else{
			
			return this.showlist();
		}	
	}
	//��ϸ
	public String showDetail(){

		u=us.getTUserById(u.getUserId());		
			return "showDetail";		
	
	}
	
	//ǰ����ϸ
	public String showDetail1(){
   	    HttpServletRequest request=ServletActionContext.getRequest();   	 
        int uid=Integer.parseInt(request.getParameter("uid"));		
		u=us.getTUserById(uid);		
		return "showDetail1";		

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

	   ArrayList<TUser> al=us.getTUserByPageNum(pageNum, pageSize);
	   request.setAttribute("al", al);
	   
	   int count= us.getcount();
	   String pager=Pager.getPaging(pageNum, pageSize, count, "ur!showlist");
	   request.setAttribute("pager", pager);
	   return "showlist";
	}
	//ǰ�˻�ȡ����ע���û�
	public String showlist1(){
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
	   
	   ArrayList<TUser> al=us.getTUserByPageNum(pageNum, pageSize);
	   request.setAttribute("al", al);
	  
	   int count= us.getcount();
	   String pager=Pager.getPaging(pageNum, pageSize, count, "ur!showlist1");
	   request.setAttribute("pager", pager);
	   return "showlist1";
	}
	
}