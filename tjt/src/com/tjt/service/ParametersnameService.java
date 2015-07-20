package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TParametersname;


public class ParametersnameService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TParametersname checkLogin(String loginId,String loginPwd){
		TParametersname u=null;
		
		String hql="from TParametersname where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TParametersname)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	//���
	public boolean addTParametersname(TParametersname u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTParametersname(TParametersname u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTParametersname(TParametersname u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TParametersname getTParametersnameById(int id){

    	return (TParametersname)cd.getObject(TParametersname.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TParametersname> getTParametersnames(){
		String hql="from TParametersname";
		return (ArrayList<TParametersname>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TParametersname";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TParametersname";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TParametersname> getTParametersnameByPageNum(int pageNum,int pageSize){
		String hql="from TParametersname";
		return (ArrayList<TParametersname>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
}
