package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TForjob;


public class ForjobService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TForjob checkLogin(String loginId,String loginPwd){
		TForjob u=null;
		
		String hql="from TForjob where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TForjob)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	
	//���
	public TForjob findTForjobByPhone(String phone){
		TForjob u=null;
		
		String hql="from TForjob where user_phone='"+phone+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TForjob)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;
		
	}
	
	//���
	public boolean addTForjob(TForjob u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTForjob(TForjob u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTForjob(TForjob u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TForjob getTForjobById(int id){

    	return (TForjob)cd.getObject(TForjob.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TForjob> getTForjobs(){
		String hql="from TForjob";
		return (ArrayList<TForjob>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TForjob ";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(int resumeid,String key){
		String hql="select count(*) from TForjob where forjob_status =0";
		if (resumeid != -1) {
			hql = hql + "and resume_id = " + resumeid;
		}
		if (key != null) {
			hql = hql + "and forjob_tittle like '%"+key+"%' ";
		}
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TForjob> getTForjobByPageNum(int pageNum,int pageSize){
		String hql="from TForjob where forjobStatus =0";
		return (ArrayList<TForjob>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	public int getcount1(int usid){
		String hql="select count(*) from TForjob where userStatus  ='"+usid+"'";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TForjob> getTForjobByPageNum1(int pageNum,int pageSize,int rid){
		String hql="from TForjob where resume_id  ='"+rid+"'";
		return (ArrayList<TForjob>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TForjob> getTForjobForUserByPageNum(int resumeid,String key,int pageNum, int pageSize) {
		System.out.println(key);
		String hql = "from TForjob where forjob_status =0";
		if (resumeid != -1) {
			hql = hql + "and resume_id = " + resumeid;
		}
		if (key != null) {
			hql = hql + "and forjob_tittle like '%"+key+"%' ";
		}	
		return (ArrayList<TForjob>) cd.getObjectByPageNum(hql, pageNum,pageSize);
	}
		
}
