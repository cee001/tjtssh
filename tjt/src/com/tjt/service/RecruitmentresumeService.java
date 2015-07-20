package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TRecruitmentresume;


public class RecruitmentresumeService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TRecruitmentresume checkLogin(String loginId,String loginPwd){
		TRecruitmentresume u=null;
		
		String hql="from TRecruitmentresume where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TRecruitmentresume)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	
	//���
	public TRecruitmentresume findTRecruitmentresumeByPhone(String phone){
		TRecruitmentresume u=null;
		
		String hql="from TRecruitmentresume where user_phone='"+phone+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TRecruitmentresume)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;
		
	}
	
	//���
	public boolean addTRecruitmentresume(TRecruitmentresume u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTRecruitmentresume(TRecruitmentresume u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTRecruitmentresume(TRecruitmentresume u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TRecruitmentresume getTRecruitmentresumeById(int id){

    	return (TRecruitmentresume)cd.getObject(TRecruitmentresume.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TRecruitmentresume> getTRecruitmentresumes(){
		String hql="from TRecruitmentresume";
		return (ArrayList<TRecruitmentresume>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TRecruitmentresume";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TRecruitmentresume";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TRecruitmentresume> getTRecruitmentresumeByPageNum(int pageNum,int pageSize){
		String hql="from TRecruitmentresume";
		return (ArrayList<TRecruitmentresume>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	public int getcount1(int usid){
		String hql="select count(*) from TRecruitmentresume where userStatus  ='"+usid+"'";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TRecruitmentresume> getTRecruitmentresumeByPageNum1(int pageNum,int pageSize,int rid){
		String hql="from TRecruitmentresume where recruitment_id  ='"+rid+"'";
		return (ArrayList<TRecruitmentresume>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
		
}
