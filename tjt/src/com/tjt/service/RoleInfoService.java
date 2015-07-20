package com.tjt.service;

import java.util.ArrayList;


import com.tjt.dao.CommonDAO;
import com.tjt.entity.RoleInfo;


public class RoleInfoService {
	private CommonDAO cd;
	private RoleInfo ri;
	public RoleInfo getRi() {
		return ri;
	}

	public void setRi(RoleInfo ri) {
		this.ri = ri;
	}

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//���
	public boolean addRole(RoleInfo ri){
		try{
			cd.addObject(ri);
			return true;
		}catch (Exception ex){
			return false;
		}
	}
    
    //�޸ġ�
    public boolean updateRole(RoleInfo ri){
        try{
        	cd.updateObject(ri);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    //ɾ��
    public boolean delRole(RoleInfo ri){
        try{
        	cd.delObject(ri);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
	public RoleInfo getRoleInfoById(int roleId){

		return (RoleInfo)cd.getObject(RoleInfo.class,roleId);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<RoleInfo> getAllRoleInfos(){
		String hql="from RoleInfo";

		return (ArrayList<RoleInfo>)cd.getObjects(hql);		
	}

}



