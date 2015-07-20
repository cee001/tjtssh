package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TResume;


public class ResumeService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TResume checkLogin(String loginId,String loginPwd){
		TResume u=null;
		
		String hql="from TResume where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TResume)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	
	//���
	public TResume findTResumeByPhone(String phone){
		TResume u=null;
		
		String hql="from TResume where user_phone='"+phone+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TResume)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;
		
	}
	
	//���
	public boolean addTResume(TResume u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTResume(TResume u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTResume(TResume u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TResume getTResumeById(int id){

    	return (TResume)cd.getObject(TResume.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TResume> getTResumes(){
		String hql="from TResume";
		return (ArrayList<TResume>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TResume";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TResume";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TResume> getTResumeByPageNum(int pageNum,int pageSize){
		String hql="from TResume";
		return (ArrayList<TResume>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	public int getcount1(int usid){
		String hql="select count(*) from TResume where userStatus  ='"+usid+"'";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TResume> getTResumeByPageNum1(int pageNum,int pageSize,int usid){
		String hql="from TResume where resume_user  ='"+usid+"'";
		return (ArrayList<TResume>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
		
}
