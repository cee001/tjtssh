package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TRecruitment;


public class RecruitmentService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TRecruitment checkLogin(String loginId,String loginPwd){
		TRecruitment u=null;
		
		String hql="from TRecruitment where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TRecruitment)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	
	//���
	public TRecruitment findTRecruitmentByPhone(String phone){
		TRecruitment u=null;
		
		String hql="from TRecruitment where user_phone='"+phone+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TRecruitment)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;
		
	}
	
	//���
	public boolean addTRecruitment(TRecruitment u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTRecruitment(TRecruitment u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTRecruitment(TRecruitment u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TRecruitment getTRecruitmentById(int id){

    	return (TRecruitment)cd.getObject(TRecruitment.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TRecruitment> getTRecruitments(){
		String hql="from TRecruitment";
		return (ArrayList<TRecruitment>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TRecruitment";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TRecruitment";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TRecruitment> getTRecruitmentByPageNum(int pageNum,int pageSize){
		String hql="from TRecruitment where recruitmentStatus =0";
		return (ArrayList<TRecruitment>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	public int getcount1(int usid){
		String hql="select count(*) from TRecruitment where userStatus  ='"+usid+"'";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TRecruitment> getTRecruitmentByPageNum1(int pageNum,int pageSize,int usid){
		String hql="from TRecruitment where userStatus  ='"+usid+"'";
		return (ArrayList<TRecruitment>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
	public int getCount2(int uid,String city,String area,String title){
		String hql="select count(*) from TRecruitment where recruitment_status =0";
		if (uid != -1) {
			hql = hql + "and recruitment_user = " + uid;
		}
		if (city != null) {
			hql = hql + "and recruitment_city like '%"+city+"%' ";
		}
		if (area != null) {
			hql = hql + "and recruitment_area like '%"+area+"%' ";
		}	
		if (title != null) {
			hql = hql + "and recruitment_tittle like '%"+title+"%'";
		}	
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TRecruitment> getTRecruitmentForUserByPageNum(int uid,String city,String area,String title, int pageNum,int pageSize){
		String hql="from TRecruitment where recruitment_status =0";
		if (uid != -1) {
			hql = hql + "and recruitment_user = " + uid;
		}
		if (city != null) {
			hql = hql + "and recruitment_city like '%"+city+"%' ";
		}
		if (area != null) {
			hql = hql + "and recruitment_area like '%"+area+"%' ";
		}	
		if (title != null) {
			hql = hql + "and recruitment_tittle like '%"+title+"%'";
		}		
		return (ArrayList<TRecruitment>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
		
}
