package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TDevice;

public class DeviceService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TDevice checkLogin(String loginId,String loginPwd){
		TDevice u=null;
		
		String hql="from TDevice where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TDevice)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	//���
	public boolean addTDevice(TDevice u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTDevice(TDevice u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTDevice(TDevice u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TDevice getTDeviceById(int id){

    	return (TDevice)cd.getObject(TDevice.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TDevice> getTDevices(){
		String hql="from TDevice";
		return (ArrayList<TDevice>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TDevice";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TDevice";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TDevice> getTDeviceByPageNum(int pageNum,int pageSize){
		String hql="from TDevice";
		return (ArrayList<TDevice>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	public int getcount1(int did){
		String hql="select count(*) from TDevice d where d.TCompany.companyId='"+did+"' and device_status = '0'";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TDevice> getTDeviceByPageNum1(int pageNum,int pageSize,int did){
		String hql="from TDevice d where d.TCompany.companyId='"+did+"' and device_status = '0'";
		return (ArrayList<TDevice>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}	
	@SuppressWarnings("unchecked")
	public ArrayList<TDevice> getTDeviceforTypeByPageNum(int uid, int cid, int companyid ,int pageNum,int pageSize){
		String hql="from TDevice where device_status = '0'";
		if(uid != -1){
			hql += "and user_id = '" + uid+"'";
		}
		if(cid != -1){
			hql += "and createuser_id = '" + cid+"'";
		}
		if(companyid != -1){
			hql += "and company_id = '"+companyid +"'";
		}
		hql += " order by device_time";
		return (ArrayList<TDevice>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
}
