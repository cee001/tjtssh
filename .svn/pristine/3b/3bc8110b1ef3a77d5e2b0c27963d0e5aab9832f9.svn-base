package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TMessagestype;


public class MessagestypeService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TMessagestype checkLogin(String loginId,String loginPwd){
		TMessagestype u=null;
		
		String hql="from TMessagestype where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TMessagestype)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	//���
	public boolean addTMessagestype(TMessagestype u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTMessagestype(TMessagestype u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTMessagestype(TMessagestype u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TMessagestype getTMessagestypeById(int id){

    	return (TMessagestype)cd.getObject(TMessagestype.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TMessagestype> getTMessagestypes(){
		String hql="from TMessagestype";
		return (ArrayList<TMessagestype>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TMessagestype";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TMessagestype";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TMessagestype> getTMessagestypeByPageNum(int pageNum,int pageSize){
		String hql="from TMessagestype";
		return (ArrayList<TMessagestype>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
}
