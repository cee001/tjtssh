package com.tjt.action;


import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.tjt.entity.TComments;
import com.tjt.service.CommentsService;
import com.tjt.util.TimeUtil;
import com.tjt.common.Pager;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class CommentsAction extends ActionSupport {
	private TComments tc;
	private CommentsService cms;

	public CommentsService getCms() {
		return cms;
	}

	public void setCms(CommentsService cms) {
		this.cms = cms;
	}

	public String showadd(){

		return "showadd";
	}
	
	//���
	public String doAdd(){
        String ptime = TimeUtil.dateToStrLong(new Date());
		tc.setCommentsTime(ptime);	
		if(cms.addTComments(tc)){

			return "success";		
		}else{
			
			return "fail";
		}	
	}

	
	//��ʾ�޸�
	public String showUpdate(){

		tc=cms.getTCommentsById(tc.getCommentsId());		

			return "showUpdate";		
	
	}
		
	//�޸�
	public String doUpdate(){
		//HttpServletRequest request=ServletActionContext.getRequest();
		//int comid=Integer.parseInt(request.getParameter("comid"));
        String ptime = TimeUtil.dateToStrLong(new Date());
		tc.setCommentsTime(ptime);			
		if(cms.updateTComments(tc)){
			System.out.println("ok");
			return this.showlist();		
		}else{
			System.out.println("on```````");
			return "fail";
		}	
	}

	public String doUpdate1(){
		HttpServletRequest request=ServletActionContext.getRequest();
		int comid=Integer.parseInt(request.getParameter("comid"));
		int sid=Integer.parseInt(request.getParameter("commentsInfostatus"));		
		tc=cms.getTCommentsById(comid);	
		tc.setCommentsInfostatus(sid);
		
		if(cms.updateTComments(tc)){
			
			return this.showlist();		
		}else{
			System.out.println("on```````");
			return this.showlist();
		}	
	}	
	//ɾ��
	public String doDel(){

		if(cms.delTComments(tc)){
			return this.showlist();		
		}else{
			
			return this.showlist();
		}	
	}
	//��ϸ
	public String showDetail(){

		tc=cms.getTCommentsById(tc.getCommentsId());		
			return "showDetail";		
	
	}

	public String showlist(){
		//����ҳ��
	   HttpServletRequest request=ServletActionContext.getRequest();
	   int pageNum=1;
	   int pageSize=5;
	   
	   if(request.getParameter("p") != null &&! request.getParameter("p").equals("")){
	       try{
	           pageNum=Integer.parseInt(request.getParameter("p"));
	           
	       }catch(Exception ex){

	       }
	   }
       int sid=Integer.parseInt(request.getParameter("sid"));
	   ArrayList<TComments> al=cms.getTCommentsByPageNum(pageNum, pageSize, sid);
	   request.setAttribute("al", al);
	   
	   int count= cms.getcount1(sid);
	   String pager=Pager.getPaging1(pageNum, pageSize, count, "com!showlist.action",sid);
	   request.setAttribute("pager", pager);
	   return "showlist";
	}
		

	}
