package com.tjt.service;
import java.util.ArrayList;

import com.tjt.entity.Menu;



public class MenuService extends BaseService{


	@SuppressWarnings("unchecked")
	public ArrayList<Menu> getAllMenus() {
		String hql="from Menu";
		return (ArrayList<Menu>)super.getCd().getObjects(hql);
	}
	
	public void addMenu(Menu m){
		super.getCd().addObject(m);
		
	}

}
