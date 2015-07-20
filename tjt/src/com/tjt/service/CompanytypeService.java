package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TCompanytype;


public class CompanytypeService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TCompanytype checkLogin(String loginId,String loginPwd){
		TCompanytype u=null;
		
		String hql="from TCompanytype where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TCompanytype)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	//���
	public boolean addTCompanytype(TCompanytype u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTCompanytype(TCompanytype u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTCompanytype(TCompanytype u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TCompanytype getTCompanytypeById(int id){

    	return (TCompanytype)cd.getObject(TCompanytype.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TCompanytype> getTCompanytypes(){
		String hql="from TCompanytype";
		return (ArrayList<TCompanytype>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TCompanytype";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TCompanytype";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TCompanytype> getTCompanytypeByPageNum(int pageNum,int pageSize){
		String hql="from TCompanytype";
		return (ArrayList<TCompanytype>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
}
