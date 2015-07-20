package com.tjt.service;

import java.util.ArrayList;


import com.tjt.dao.CommonDAO;
import com.tjt.entity.Menu;
import com.tjt.entity.Power;
import com.tjt.entity.RoleInfo;

public class PowerServeice {
	private CommonDAO cd;

	public CommonDAO getCd() {
		return cd;
	}

	public void setCd(CommonDAO cd) {
		this.cd = cd;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Power> getPowerByRoleId(int rid){
		String hql="from Power p where p.roleInfo.roleId='"+rid+"'";
		return (ArrayList<Power>)cd.getObjects(hql); 
	}
	
	public void doUpdatePower(int rid,String[] mids){
		//��ɾ��˽�ɫ�µ�˵��Ȩ�����¼ӽ�ɫ
		String sql="delete from powers where rid="+rid;
		cd.delobjBySQL(sql);
		RoleInfo ri=new RoleInfo();
		ri.setRoleId(rid);
		for(String s:mids){
			Menu m=new Menu();
			m.setMid(Integer.parseInt(s));
		    Power p=new Power();
		    p.setMenu(m);
		    p.setRoleInfo(ri);
		    cd.addObject(p);
		}
	}

}
