package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TCollections;
import com.tjt.entity.TDownload;
import com.tjt.entity.TDownload;


public class DownloadService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TDownload checkDownload(int user_id,int messages_id){
		TDownload u=null;
		
		String hql="from TDownload where user_id='"+user_id+"'and messages_id='"+messages_id+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TDownload)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;		
	}
	
	//���
	public TDownload findTDownloadByPhone(String phone){
		TDownload u=null;
		
		String hql="from TDownload where user_phone='"+phone+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TDownload)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;
		
	}
	
	//���
	public boolean addTDownload(TDownload u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTDownload(TDownload u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTDownload(TDownload u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TDownload getTDownloadById(int id){

    	return (TDownload)cd.getObject(TDownload.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TDownload> getTDownloads(){
		String hql="from TDownload";
		return (ArrayList<TDownload>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TDownload";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TDownload";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TDownload> getTDownloadByPageNum(int pageNum,int pageSize){
		String hql="from TDownload where download_status =0";
		return (ArrayList<TDownload>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	public int getcount1(int usid){
		String hql="select count(*) from TDownload where download_status  ='"+usid+"'";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	@SuppressWarnings("unchecked")
	public ArrayList<TDownload> getTDownloadUIDByPageNum(int uid, int pageNum,int pageSize){
		String hql="from TDownload where  download_status = '0' and user_id = '"+ uid +"'";
		return (ArrayList<TDownload>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}

		
}
