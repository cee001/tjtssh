package com.tjt.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//import android.util.Log;

public class JsoupDataGet {
	
	public static List<Map<String, Object>> getItemBox(String _url) 
			throws IOException{
//		Log.e("wangxing", "wangxing _url :" + _url);
//		_url = "http://news.baidu.com/ns?word=%C2%C3%D3%CE&tn=news&from=news&cl=2&rn=20&ct=1";
		List<Map<String, Object>> addData = new ArrayList<Map<String, Object>>();
		Document doc = Jsoup.connect(_url).timeout(30000).get();
		Element content_left = doc.getElementById("content_left");
		
		Elements es = null;
		if(content_left.select("ul").size()>0){
			es = content_left.select("ul").get(0).select("li");
//			Log.e("wangxing", "wangxing es :" + es.toString());
		}
	
		if(es == null){
			return addData;
		}	
		for (Element e : es) {
			String id = e.attr("id");
			Element eli = e.select("h3").get(0);
			Element ea = eli.select("a").get(0);
			String title = ea.text();
			String url = ea.attr("href");
			String auther = e.getElementsByClass("c-author").get(0).text();
			String iconUrl = null;
			if(e.getElementsByClass("c_photo").size() > 0){
				iconUrl = e.getElementsByClass("c_photo").get(0).select("img").get(0).attr("src");
			}


			Map<String, Object> m = new HashMap<String, Object>();
			
			m.put("id", id);
			m.put("url", url);
			m.put("title", title);
			m.put("auther", auther);
			if(iconUrl != null){
				m.put("iconUrl", iconUrl);
			}

			addData.add(m);
		}
		
		return addData;
	}
	public static List<Map<String, Object>> getContentImageList(String content) 
			throws IOException{
//		Log.e("wangxing", "wangxing _url :" + _url);
		List<Map<String, Object>> addData = new ArrayList<Map<String, Object>>();
		Document doc = Jsoup.parse(content);//����HTML�ַ���һ��Documentʵ��
		
		Elements es = doc.select("img"); ;
		for (Element e : es) {
			String iconUrl = e.attr("src");
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("iconUrl", iconUrl);
			addData.add(m);
		}
		
		return addData;
	}

}
