package com.tjt.action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.tjt.util.TimeUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.tjt.entity.Admin;
import com.tjt.entity.RoleInfo;
import com.tjt.service.AdminService;
import com.tjt.service.RoleInfoService;

@SuppressWarnings("serial")
public class AdminAction extends ActionSupport{
	private Admin am;
	private AdminService as;
	private RoleInfoService ris;
	
	public RoleInfoService getRis() {
		return ris;
	}

	public void setRis(RoleInfoService ris) {
		this.ris = ris;
	}


	public AdminService getAs() {
		return as;
	}

	public void setAs(AdminService as) {
		this.as = as;
	}


	public Admin getAm() {
		return am;
	}

	public void setAm(Admin am) {
		this.am = am;
	}

	//��½
	public String dologin(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String loginId=request.getParameter("loginId");
		String loginPwd=request.getParameter("loginPwd");
		am=as.checkLogin(loginId, loginPwd);
		if(am!=null){
			HttpSession session=request.getSession();
			session.setAttribute("tlogin", am);
			return "success";
		}else{
			return "fail";
		}
	}
	
	//退出
	public String dologinout(){
		 HttpServletRequest request=ServletActionContext.getRequest();
			
			HttpSession session=request.getSession();
			if(session.getAttribute("tlogin")==null){
		    return "suc";	
			}else{
			session.removeAttribute("tlogin");
			return "fail";
			}
	}	
	//��ȡ���н�ɫ
	public void requestSetRoles(){
		//��ȡ���н�ɫ����

		ArrayList<RoleInfo> al=ris.getAllRoleInfos();

		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("al", al);
		
	}
	//���
	public String doAdd(){
        String pt = TimeUtil.dateToStrLong(new Date());
		am.setRegDate(pt);
		RoleInfo role=new RoleInfo();
		role.setRoleId(6);
		am.setRoleInfo(role);
		if(as.addUser(am)){
		  return this.showList();		
		}else{
			
			return "fail";
		}	
		}
	//��ʾ�޸�
	public String showUpdate(){

		am=as.getUserById(am.getId());		
        this.requestSetRoles();
			return "showUpdate";		
	
	}
	
	//�޸�
	public String doUpdate(){

		if(as.updateUser(am)){
			return this.showList();		
		}else{
			
			return "fail";
		}	
	}
	//ɾ��
	public String doDel(){

		if(as.delUser(am)){
			return this.showList();		
		}else{
			
			return this.showList();
		}	
	}
	//��ϸ
	public String showDetail(){

		am=as.getUserById(am.getId());	
	    this.requestSetRoles();
		return "showDetail";		
	
	}
	//��ȡ����
	public String showList(){
		HttpServletRequest request=ServletActionContext.getRequest();
		ArrayList<Admin> al=as.getUsers();
		request.setAttribute("al",al);
		return "showList";
		
		
		
	}


}
