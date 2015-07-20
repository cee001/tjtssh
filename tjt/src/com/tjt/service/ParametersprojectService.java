package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TParametersproject;


public class ParametersprojectService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TParametersproject checkLogin(String loginId,String loginPwd){
		TParametersproject u=null;
		
		String hql="from TParametersproject where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TParametersproject)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	//���
	public boolean addTParametersproject(TParametersproject u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTParametersproject(TParametersproject u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTParametersproject(TParametersproject u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TParametersproject getTParametersprojectById(int id){

    	return (TParametersproject)cd.getObject(TParametersproject.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TParametersproject> getTParametersprojects(){
		String hql="from TParametersproject";
		return (ArrayList<TParametersproject>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TParametersproject";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TParametersproject";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TParametersproject> getTParametersprojectByPageNum(int pageNum,int pageSize){
		String hql="from TParametersproject";
		return (ArrayList<TParametersproject>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TParametersproject> getTParametersprojectforUserByPageNum(int type ,int pageNum,int pageSize){
		String hql="from TParametersproject  where parameters_project_status = '0'";
		if(type != -1){
			hql += "and user_id = '" + type+"'";
		}
		return (ArrayList<TParametersproject>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
}
