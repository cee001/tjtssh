package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TUserparametersroject;


public class UserparametersprojectService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TUserparametersroject checkLogin(String loginId,String loginPwd){
		TUserparametersroject u=null;
		
		String hql="from TUserparametersroject where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TUserparametersroject)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	//���
	public boolean addTUserparameters(TUserparametersroject u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTUserparameters(TUserparametersroject u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTUserparameters(TUserparametersroject u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TUserparametersroject getTUserparametersById(int id){

    	return (TUserparametersroject)cd.getObject(TUserparametersroject.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TUserparametersroject> getTUserparameterss(){
		String hql="from TUserparametersroject";
		return (ArrayList<TUserparametersroject>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TUserparametersroject";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TUserparametersroject";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TUserparametersroject> getTUserparametersByPageNum(int pageNum,int pageSize){
		String hql="from TUserparametersroject";
		return (ArrayList<TUserparametersroject>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TUserparametersroject> getTUserparametersforUserByPageNum(int type ,int projectid ,int pageNum,int pageSize){
		String hql="from TUserparametersroject  where userparameters_status = '0'";
		if(type != -1){
			hql += "and user_id = '" + type+"'";
		}
		if(projectid != -1){
			hql += "and parametersproject_id = '" + projectid+"'";
		}
		return (ArrayList<TUserparametersroject>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
}
