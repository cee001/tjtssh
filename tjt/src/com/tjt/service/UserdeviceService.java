package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TUserdevice;


public class UserdeviceService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TUserdevice checkLogin(String loginId,String loginPwd){
		TUserdevice u=null;
		
		String hql="from TUserdevice where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TUserdevice)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	//���
	public boolean addTUserdevice(TUserdevice u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTUserdevice(TUserdevice u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTUserdevice(TUserdevice u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TUserdevice getTUserdeviceById(int id){

    	return (TUserdevice)cd.getObject(TUserdevice.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TUserdevice> getTUserdevices(){
		String hql="from TUserdevice";
		return (ArrayList<TUserdevice>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TUserdevice";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TUserdevice";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TUserdevice> getTUserdeviceByPageNum(int pageNum,int pageSize){
		String hql="from TUserdevice";
		return (ArrayList<TUserdevice>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	@SuppressWarnings("unchecked")
	public ArrayList<TUserdevice> getTUserdeviceforTypeByPageNum(int uid, int touid ,int pageNum,int pageSize){
		String hql="from TUserdevice where userdevice_status != '-1'";
		if(uid != -1){
			hql += "and userto_id = '" + uid+"'";
		}
		if(touid != -1){
			hql += "and touser_id = '"+touid +"'";
		}
		hql += " order by userdevice_time";
		return (ArrayList<TUserdevice>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
}
