package com.tjt.service;

import java.util.ArrayList;
import java.util.List;



import com.tjt.util.Md5;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.Admin;

public class AdminService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public Admin checkLogin(String loginId,String loginPwd){
		Admin am=null;
        Md5 md5 = new Md5(loginPwd);
        md5.processString();
        String strEncrypto = md5.getStringDigest();		
		String hql="from Admin where loginId='"+loginId+"'and loginPwd='"+strEncrypto+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			am=(Admin)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return am;				
	}
	//���
	public boolean addUser(Admin am){
		try{
			cd.addObject(am);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateUser(Admin am){
        try{
        	cd.updateObject(am);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delUser(Admin am){
        try{
        	cd.delObject(am);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public Admin getUserById(int id){

    	return (Admin)cd.getObject(Admin.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<Admin> getUsers(){
		String hql="from Admin";
		return (ArrayList<Admin>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from Admin";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from Admin";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Admin> getUserByPageNum(int pageNum,int pageSize){
		String hql="from Admin";
		return (ArrayList<Admin>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
}
