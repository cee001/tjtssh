package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TParametersdata;


public class ParametersdataService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TParametersdata checkLogin(String loginId,String loginPwd){
		TParametersdata u=null;
		
		String hql="from TParametersdata where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TParametersdata)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	//���
	public boolean addTParametersdata(TParametersdata u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTParametersdata(TParametersdata u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTParametersdata(TParametersdata u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TParametersdata getTParametersdataById(int id){

    	return (TParametersdata)cd.getObject(TParametersdata.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TParametersdata> getTParametersdatas(){
		String hql="from TParametersdata";
		return (ArrayList<TParametersdata>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TParametersdata";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TParametersdata";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TParametersdata> getTParametersdataByPageNum(int pageNum,int pageSize){
		String hql="from TParametersdata";
		return (ArrayList<TParametersdata>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TParametersdata> getTParametersdata2ByPageNum(int type ,int pageNum,int pageSize){
		String hql="from TParametersdata  where parametersdata_status = '0'";
		if(type != -1){
			hql += "and parameters_id = '" + type+"'";
		}
		return (ArrayList<TParametersdata>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
	
}
