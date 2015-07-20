package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TDevicegps;


public class DevicegpsService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TDevicegps checkLogin(String loginId,String loginPwd){
		TDevicegps u=null;
		
		String hql="from TDevicegps where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TDevicegps)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	//���
	public boolean addTDevicegps(TDevicegps u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTDevicegps(TDevicegps u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTDevicegps(TDevicegps u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TDevicegps getTDevicegpsById(int id){

    	return (TDevicegps)cd.getObject(TDevicegps.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TDevicegps> getTDevicegpss(){
		String hql="from TDevicegps";
		return (ArrayList<TDevicegps>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TDevicegps";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TDevicegps";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TDevicegps> getTDevicegpsByPageNum(int pageNum,int pageSize){
		String hql="from TDevicegps";
		return (ArrayList<TDevicegps>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
}
