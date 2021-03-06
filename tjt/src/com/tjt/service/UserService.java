package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TUser;
import com.tjt.util.Md5;


public class UserService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TUser checkLogin(String loginId,String loginPwd){
		TUser u=null;

        Md5 md5 = new Md5(loginPwd);
        md5.processString();
        String strEncrypto = md5.getStringDigest();
		String hql="from TUser where user_phone='"+loginId+"'and user_password='"+strEncrypto+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("ok");
			u=(TUser)ls.get(0);
		}else{
			System.out.println("no``");
		}
		return u;				
	}
	
	//���
	public TUser findTUserByPhone(String phone){
		TUser u=null;
		String hql="from TUser where user_phone='"+phone+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("ok");
			u=(TUser)ls.get(0);
		}else{
			System.out.println("no``");
		}
		return u;
		
	}
	
	//���
	public TUser findTUserByUid(int uid){
		TUser u=null;
		
		String hql="from TUser where user_id='"+uid+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("ok");
			u=(TUser)ls.get(0);
		}else{
			System.out.println("no``");
		}
		return u;
		
	}
	
	//���
	public boolean addTUser(TUser u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTUser(TUser u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTUser(TUser u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TUser getTUserById(int id){

    	return (TUser)cd.getObject(TUser.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TUser> getTUsers(){
		String hql="from TUser";
		return (ArrayList<TUser>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TUser";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TUser";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TUser> getTUserByPageNum(int pageNum,int pageSize){
		String hql="from TUser";
		return (ArrayList<TUser>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	public int getcount1(int usid){
		String hql="select count(*) from TUser where userStatus  ='"+usid+"'";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TUser> getTUserByPageNum1(int pageNum,int pageSize,int usid){
		String hql="from TUser where userStatus  ='"+usid+"'";
		return (ArrayList<TUser>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
		
}
