package com.tjt.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.tjt.common.JsoupDataGet;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class GetnewsAction extends ActionSupport {
	//抓取新闻
	public String showlist1(){
		//处理页码
	   HttpServletRequest request=ServletActionContext.getRequest();
	   int num=Integer.parseInt(request.getParameter("num"));
//	   List<Map<String, Object>> addData = new ArrayList<Map<String, Object>>();
	   List<Map<String, Object>> al=  new ArrayList<Map<String, Object>>();
		try {
			al = JsoupDataGet.getItemBox("http://news.baidu.com/ns?word=%E6%97%A0%E6%8D%9F%E6%A3%80%E6%B5%8B%20%E7%89%B9%E6%A3%80&pn='"+num+"'&cl=2&ct=1&tn=news&rn=20&ie=utf-8&bt=0&et=0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   request.setAttribute("al", al);
	   

	   return "showlist1";
	}	
	//抓取新闻
	public String showlist2(){
		//处理页码
	   HttpServletRequest request=ServletActionContext.getRequest();
	   int num=Integer.parseInt(request.getParameter("num"));
//	   List<Map<String, Object>> addData = new ArrayList<Map<String, Object>>();
	   List<Map<String, Object>> al=  new ArrayList<Map<String, Object>>();
		try {
			al = JsoupDataGet.getItemBox("http://news.baidu.com/ns?word=%E6%97%A0%E6%8D%9F%E6%A3%80%E6%B5%8B%20%E7%89%B9%E6%A3%80&pn='"+num+"'&cl=2&ct=1&tn=news&rn=12&ie=utf-8&bt=0&et=0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   request.setAttribute("al", al);

	   return "showlist2";
	}		

	}
