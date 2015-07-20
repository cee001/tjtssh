package com.tjt.action;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.tjt.entity.TCompany;
import com.tjt.service.CompanyService;
import com.tjt.util.TimeUtil;
import com.tjt.common.Pager;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CompanyAction extends ActionSupport {
	private TCompany cy;
	private CompanyService cys;


	public TCompany getCy() {
		return cy;
	}


	public void setCy(TCompany cy) {
		this.cy = cy;
	}



	public CompanyService getCys() {
		return cys;
	}


	public void setCys(CompanyService cys) {
		this.cys = cys;
	}


	public String doAdd(){
        String ptime = TimeUtil.dateToStrLong(new Date());
		cy.setCompanyTime(ptime);	
		if(cys.addTCompany(cy)){

			return "success";		
		}else{
			
			return "fail";
		}	
	}

	
	//��ʾ�޸�
	public String showUpdate(){

		cy=cys.getTCompanyById(cy.getCompanyId());		

			return "showUpdate";		
	
	}
		
	//�޸�
	public String doUpdate(){
        String ptime = TimeUtil.dateToStrLong(new Date());
		cy.setCompanyTime(ptime);			
		if(cys.updateTCompany(cy)){

			return this.showlist();		
		}else{

			return "fail";
		}	
	}
	public String doUpdate1(){
   	    HttpServletRequest request=ServletActionContext.getRequest();   	 
        int cid=Integer.parseInt(request.getParameter("cid"));
        int para=Integer.parseInt(request.getParameter("companyStatus"));		
		cy=cys.getTCompanyById(cid);        
        String ptime = TimeUtil.dateToStrLong(new Date());
		cy.setCompanyTime(ptime);
		cy.setCompanyStatus((short) para);
		if(cys.updateTCompany(cy)){

			return this.showlist();		
		}else{

			return "fail";
		}	
	}

	public String showDetail(){

		cy=cys.getTCompanyById(cy.getCompanyId());		
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
	   int aid=Integer.parseInt(request.getParameter("aid"));
	   ArrayList<TCompany> al=cys.getTCompanyByPageNum1(pageNum, pageSize,aid);
	   request.setAttribute("al", al);
	   
	   int count= cys.getcount1(aid);
	   String pager=Pager.getPaging(pageNum, pageSize, count, "any!showlist");
	   request.setAttribute("pager", pager);
	   return "showlist";
	}

	

	}
