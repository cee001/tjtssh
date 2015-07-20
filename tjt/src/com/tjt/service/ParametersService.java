package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TParameters;


public class ParametersService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TParameters checkLogin(String loginId,String loginPwd){
		TParameters u=null;
		
		String hql="from TParameters where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TParameters)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	//���
	public boolean addTParameters(TParameters u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTParameters(TParameters u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTParameters(TParameters u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TParameters getTParametersById(int id){

    	return (TParameters)cd.getObject(TParameters.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TParameters> getTParameterss(){
		String hql="from TParameters";
		return (ArrayList<TParameters>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TParameters";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TParameters";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TParameters> getTParametersByPageNum(int pageNum,int pageSize){
		String hql="from TParameters";
		return (ArrayList<TParameters>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TParameters> getTParametersForProjectByPageNum(int type ,int pageNum,int pageSize){
		String hql="from TParameters  where parameters_status = '0'";

		if(type != -1){
			hql += "and parametersproject_id = '" + type+"'";
		}
		return (ArrayList<TParameters>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
}
