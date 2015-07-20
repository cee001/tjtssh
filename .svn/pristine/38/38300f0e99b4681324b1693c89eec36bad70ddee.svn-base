package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TCompanyusertype;


public class CompanyusertypeService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TCompanyusertype checkLogin(String loginId,String loginPwd){
		TCompanyusertype u=null;
		
		String hql="from TCompanyusertype where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TCompanyusertype)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	//���
	public boolean addTCompanyusertype(TCompanyusertype u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTCompanyusertype(TCompanyusertype u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTCompanyusertype(TCompanyusertype u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TCompanyusertype getTCompanyusertypeById(int id){

    	return (TCompanyusertype)cd.getObject(TCompanyusertype.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TCompanyusertype> getTCompanyusertypes(){
		String hql="from TCompanyusertype";
		return (ArrayList<TCompanyusertype>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TCompanyusertype";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TCompanyusertype";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TCompanyusertype> getTCompanyusertypeByPageNum(int pageNum,int pageSize){
		String hql="from TCompanyusertype";
		return (ArrayList<TCompanyusertype>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}

}
