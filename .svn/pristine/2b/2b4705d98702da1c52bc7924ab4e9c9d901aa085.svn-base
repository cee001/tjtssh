package com.tjt.service;

import java.util.ArrayList;

import com.tjt.dao.CommonDAO;

import com.tjt.entity.TMessagepush;


public class MessagepushService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}

	public boolean addTMessagepush(TMessagepush me){
		try{
			cd.addObject(me);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	
    public boolean updateTMessagepush(TMessagepush me){
        try{
        	cd.updateObject(me);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTMessagepush(TMessagepush me){
        try{
        	cd.delObject(me);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TMessagepush getTMessagepushById(int id){

    	return (TMessagepush)cd.getObject(TMessagepush.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TMessagepush> getTMessagepushs(){
		String hql="from TMessagepush";
		return (ArrayList<TMessagepush>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TMessagepush";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TMessagepush";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TMessagepush> getTMessagepushByPageNum(int pageNum,int pageSize){
		String hql="from TMessagepush";
		return (ArrayList<TMessagepush>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TMessagepush> getTMessagepushUIDByPageNum(int uid, int pageNum,int pageSize){
		String hql="from TMessagepush where  messagepush_status = '0' and user_id = '"+ uid +"'";
		return (ArrayList<TMessagepush>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
}
