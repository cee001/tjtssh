package com.tjt.service;

import java.util.ArrayList;
import java.util.List;

import com.tjt.dao.CommonDAO;
import com.tjt.entity.TProduct;


public class ProductService {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	//��½
	public TProduct checkLogin(String loginId,String loginPwd){
		TProduct u=null;
		
		String hql="from TProduct where user_phone='"+loginId+"'and user_password='"+loginPwd+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TProduct)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;				
	}
	
	//���
	public TProduct findTProductByPhone(String phone){
		TProduct u=null;
		
		String hql="from TProduct where user_phone='"+phone+"'";
		@SuppressWarnings("rawtypes")
		List ls=cd.getObjects(hql);
		if(ls!=null&&ls.size()>0){
			System.out.println("��½�ɹ���");
			u=(TProduct)ls.get(0);
		}else{
			System.out.println("��½���ɹ���");
		}
		return u;
		
	}
	
	//���
	public boolean addTProduct(TProduct u){
		try{
			cd.addObject(u);
			return true;
			
		}catch(Exception ex){
			return false;
		}
		
	}
	   //�޸ġ�
    public boolean updateTProduct(TProduct u){
        try{
        	cd.updateObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }
    }
    
    //ɾ��
    public boolean delTProduct(TProduct u){
        try{
        	cd.delObject(u);
        	return true;
        }catch(Exception ex){
        	return false;
        }    

    }
    
    //��ȡ����
    public TProduct getTProductById(int id){

    	return (TProduct)cd.getObject(TProduct.class, id);
    }
    
    
	//��ȡ����
	@SuppressWarnings("unchecked")
	public ArrayList<TProduct> getTProducts(){
		String hql="from TProduct";
		return (ArrayList<TProduct>)cd.getObjects(hql);
	}
	
	//��ҳ��ȡ����
	public int getCounts(){
		String hql="from TProduct";
		return cd.getObjects(hql).size();
		
	}
	public int getcount(){
		String hql="select count(*) from TProduct";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TProduct> getTProductByPageNum(int pageNum,int pageSize){
		String hql="from TProduct";
		return (ArrayList<TProduct>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	public int getcount1(int usid){
		String hql="select count(*) from TProduct where userStatus  ='"+usid+"'";
		return Integer.parseInt(cd.getObjects(hql).get(0).toString());
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TProduct> getTProductByPageNum1(int pageNum,int pageSize,int usid){
		String hql="from TProduct where userStatus  ='"+usid+"'";
		return (ArrayList<TProduct>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
	
	public int getCount2(String key, int type ){
		String hql="from TProduct where product_status = '0'";
		if(type != -1){
			hql += "and producttype_id = '" + type+"'";
		}
		if(key != null){
			hql += "and product_name like '%"+key +"%'";
		}
		hql += " order by product_time desc";
		return cd.getObjects(hql).size();
		
	}		
	@SuppressWarnings("unchecked")
	public ArrayList<TProduct> getTProductforTypeByPageNum(String key, int type ,int company ,int pageNum,int pageSize){
		String hql="from TProduct where product_status = '0'";
		if(type != -1){
			hql += "and producttype_id = '" + type+"'";
		}
		if(company != -1){
			hql += "and company_id = '" + company+"'";
		}
		if(key != null){
			hql += "and product_name like '%"+key +"%'";
		}
		hql += " order by product_time desc";
		return (ArrayList<TProduct>)cd.getObjectByPageNum(hql, pageNum, pageSize);
	}
		
}
