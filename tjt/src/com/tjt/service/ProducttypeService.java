package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TProducttype;


public class ProducttypeService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TProducttype checkLogin(String loginId,String loginPwd){
		TProducttype u=null;
		
		String hql="from TProducttype where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TProducttype)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	
	//���
	public TProducttype findTProducttypeByPhone(String phone){
		TProducttype u=null;
		
		String hql="from TProducttype where user_phone='"+phone+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TProducttype)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;
		
	}
	
	//���
	public boolean addTProducttype(TProducttype u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTProducttype(TProducttype u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTProducttype(TProducttype u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TProducttype getTProducttypeById(int id){

    	return (TProducttype)cd.getObject(TProducttype.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TProducttype> getTProducttypes(){
		String hql="from TProducttype";
		return (ArrayList<TProducttype>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TProducttype";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TProducttype";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TProducttype> getTProducttypeByPageNum(int pageNum,int pageSize){
		String hql="from TProducttype";
		return (ArrayList<TProducttype>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	public int getcount1(int usid){
		String hql="select count(*) from TProducttype where userStatus  ='"+usid+"'";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TProducttype> getTProducttypeByPageNum1(int pageNum,int pageSize,int usid){
		String hql="from TProducttype where userStatus  ='"+usid+"'";
		return (ArrayList<TProducttype>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
		
}
