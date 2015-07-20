package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TIntegral;


public class IntegralService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TIntegral checkLogin(String loginId,String loginPwd){
		TIntegral u=null;
		
		String hql="from TIntegral where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TIntegral)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	//���
	public boolean addTIntegral(TIntegral u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTIntegral(TIntegral u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTIntegral(TIntegral u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TIntegral getTIntegralById(int id){

    	return (TIntegral)cd.getObject(TIntegral.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TIntegral> getTIntegrals(){
		String hql="from TIntegral";
		return (ArrayList<TIntegral>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TIntegral";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TIntegral";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TIntegral> getTIntegralByPageNum(int pageNum,int pageSize){
		String hql="from TIntegral";
		return (ArrayList<TIntegral>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
}
