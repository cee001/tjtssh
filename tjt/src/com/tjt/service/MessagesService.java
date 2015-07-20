package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TMessages;


public class MessagesService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TMessages checkLogin(String loginId,String loginPwd){
		TMessages u=null;
		
		String hql="from TMessages where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TMessages)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	//���
	public boolean addTMessages(TMessages u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	public boolean addTMessages1(TMessages u){
		String r="";
		String t="";
		
        if(u.getMessagesTitle()!=null && u.getMessagesTitle().length()>1){
        	String title=u.getMessagesTitle();
            r=title.split("#!!")[0];
            t=title.split("#!!")[1];

        }	
        String url="http://xheyou.com/TJT/downfile!downMsgdata.action?fileUrl="+r+"&fileName="+t+"#!!"+t+"";
        u.setMessagesAnnex(url);
        u.setMessagesTitle(t);
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}

	}
	   //�޸ġ�
    public boolean updateTMessages(TMessages u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTMessages(TMessages u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TMessages getTMessagesById(int id){

    	return (TMessages)cd.getObject(TMessages.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TMessages> getTMessagess(){
		String hql="from TMessages";
		return (ArrayList<TMessages>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TMessages";
		return cd.getObjects(hql).size();
		
	}
	public int getCounts1(){
		String hql="from TMessages m where m.TMessagestype.messagestypeId>5000 ";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TMessages";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TMessages> getTMessagesByPageNum(int pageNum,int pageSize){
		String hql="from TMessages";
		return (ArrayList<TMessages>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	public int getCount2(int uid ,String key, int type ){
		String hql="from TMessages where messages_status != '1'";
		if(type != -1){
			hql += "and messagestype_id = '" + type+"'";
		}
		if(key != null){
			hql += "and messages_title like '%"+key +"%'";
		}
		if (uid != -1) {
			hql = hql + "and messages_user = " + uid;
		}
		hql += " order by messages_id desc";
		return cd.getObjects(hql).size();
		
	}	
	@SuppressWarnings("unchecked")
	public ArrayList<TMessages> getTMessagesforTypeByPageNum(int uid ,String key, int type ,int pageNum,int pageSize){
		String hql="from TMessages where messages_status != '1'";
		if(type != -1){
			hql += "and messagestype_id = '" + type+"'";
		}
		if(key != null){
			hql += "and messages_title like '%"+key +"%'";
		}
		if (uid != -1) {
			hql = hql + "and messages_user = " + uid;
		}
		hql += " order by messages_id desc";
		return (ArrayList<TMessages>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}

	
	public int getCount3(String key,int type ){
		System.out.println(key);
		String hql="from TMessages where messages_status != '1'";
		if(key != null){
			hql += "and messages_title like '%"+key +"%'";
		}
		if(type != -1){			
		
		if(type == 2150){
			hql += "and messagestype_id >4000 and messagestype_id <5010";
		}else if(type == 2151){
			hql += "and messagestype_id >4000 and messagestype_id <4010 ";
		}else if(type == 2152){
			hql += "and messagestype_id >5000 and messagestype_id <5010 ";		
		}else{
		    hql += "and messagestype_id = '" + type+"'";			
		}	
		}		
		hql += " order by messages_id desc";
		return cd.getObjects(hql).size();
		
	}	
	@SuppressWarnings("unchecked")
	public ArrayList<TMessages> getTMessagesforType_forum(String key,int type ,int pageNum,int pageSize){
		System.out.println(type);
		String hql="from TMessages where messages_status != '1'";
		if(key != null){
			hql += "and messages_title like '%"+key +"%'";
		}
		if(type != -1){			
		
		if(type == 2150){
			hql += "and messagestype_id >4000 and messagestype_id <5010";
		}else if(type == 2151){
			hql += "and messagestype_id >4000 and messagestype_id <4010 ";
		}else if(type == 2152){
			hql += "and messagestype_id >5000 and messagestype_id <5010 ";		
		}else{
		    hql += "and messagestype_id = '" + type+"'";			
		}	
		}
		hql += " order by messages_status desc,messages_id desc";
		return (ArrayList<TMessages>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}	
}
