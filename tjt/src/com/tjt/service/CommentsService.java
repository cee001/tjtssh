package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TComments;


public class CommentsService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TComments checkLogin(String loginId,String loginPwd){
		TComments u=null;
		
		String hql="from TComments where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TComments)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	//���
	public boolean addTComments(TComments u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTComments(TComments u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTComments(TComments u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TComments getTCommentsById(int id){

    	return (TComments)cd.getObject(TComments.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TComments> getTCommentss(){
		String hql="from TComments";
		return (ArrayList<TComments>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TComments";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TComments where  comments_infostatus = '0'";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	public int getMidcount(int mid){
		String hql="select count(*) from TComments where comments_infostatus != '1' and  messages_id = '"+ mid +"'";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TComments> getTCommentsByPageNum(int pageNum,int pageSize){
		String hql="from TComments ";
		return (ArrayList<TComments>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	public int getcount1(int sid){
		String hql="select count(*) from TComments where  comments_infostatus ='"+sid+"'";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}	
	@SuppressWarnings("unchecked")
	public ArrayList<TComments> getTCommentsByPageNum(int pageNum,int pageSize,int sid){
		String hql="from TComments where commentsInfostatus  ='"+sid+"'";
		return (ArrayList<TComments>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TComments> getTCommentsUIDByPageNum(int mid, int pageNum,int pageSize){
		String hql="from TComments where  comments_infostatus != '1' and  messages_id = '"+ mid +"' ORDER by comments_time desc";
		return (ArrayList<TComments>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
}
