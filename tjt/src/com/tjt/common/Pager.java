package com.tjt.common;

public class Pager {
	
	public static String getPaging(int pageNum,int pageSize,int count,String url){
		String pager="";
		
    	if(pageNum<=1){
    		pager+="上一页";
    	}else{
    		pager+="<a href='"+url+"?p="+(pageNum-1)+"'>上一页</a> ";
    	}    	
    	//���һҳҳ��
    	int lastPager=count/pageSize;
    	lastPager=(int) Math.ceil(count/pageSize);
    	if(count%pageSize!=0){
    		lastPager++;
    	}
    	if(pageNum>=lastPager){
    		pager+="下一页("+pageNum+"/"+lastPager+")";
    	}else{
    		pager+="<a href='"+url+"?p="+(pageNum+1)+"'>下一页</a>("+pageNum+"/"+lastPager+")";
    	} 
    	return pager;
	}
	public static String getPaging1(int pageNum,int pageSize,int count,String url,int sid){
		String pager="";
    	if(pageNum<=1){
    		pager+="上一页";
    	}else{
    		pager+="<a href='"+url+"?p="+(pageNum-1)+"&sid="+sid+"'>上一页</a> ";
    	}    	
    	//���һҳҳ��
    	int lastPager=count/pageSize;
    	lastPager=(int) Math.ceil(count/pageSize);
    	if(count%pageSize!=0){
    		lastPager++;
    	}
    	if(pageNum>=lastPager){
    		pager+="下一页("+pageNum+"/"+lastPager+")";
    	}else{
    		pager+="<a href='"+url+"?p="+(pageNum+1)+"&sid="+sid+"'>下一页</a>("+pageNum+"/"+lastPager+")";
    	} 
    	return pager;
	}
	public static String getPaging(int pageNum,int pageSize,int count,String url,int id){
		String pager="";
    	if(pageNum<=1){
    		pager+="上一页";
    	}else{
    		pager+="<a href='"+url+"!showlistd.action?p="+(pageNum-1)+"&u.id="+id+"'>上一页</a> ";
    	}    	
    	//���һҳҳ��
    	int lastPager=count/pageSize;
    	lastPager=(int) Math.ceil(count/pageSize);
    	if(count%pageSize!=0){
    		lastPager++;
    	}
    	if(pageNum>=lastPager){
    		pager+="下一页("+pageNum+"/"+lastPager+")";
    	}else{
    		pager+="<a href='"+url+"!showlistd.action?p="+(pageNum+1)+"&u.id="+id+"'>下一页</a>("+pageNum+"/"+lastPager+")";
    	} 
    	return pager;
	}
	/*public static String getPaging(int pageNum,int pageSize,int count,String url,int tid){
		String pager="";
    	if(pageNum<=1){
    		pager+="��һҳ";
    	}else{
    		pager+="<a href='"+url+"?t=list&p="+(pageNum-1)+"&tid="+tid+"'>��һҳ</a> ";
    	}    	
    	//���һҳҳ��
    	int lastPager=count/pageSize;
    	if(count%pageSize!=0){
    		lastPager++;
    	}
    	if(pageNum>=lastPager){
    		pager+=" ��һҳ";
    	}else{
    		pager+="<a href='"+url+"?t=list&p="+(pageNum+1)+"&tid="+tid+"'>��һҳ</a>";
    	} 
    	return pager;
	}*/
}
