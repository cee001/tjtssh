package com.tjt.action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.PutPolicy;
import com.tjt.entity.TCollections;
import com.tjt.entity.TComments;
import com.tjt.entity.TCompany;
import com.tjt.entity.TCompanytype;
import com.tjt.entity.TDevice;
import com.tjt.entity.TDownload;
import com.tjt.entity.TForjob;
import com.tjt.entity.TMessagepush;
import com.tjt.entity.TMessages;
import com.tjt.entity.TMessagestype;
import com.tjt.entity.TParameters;
import com.tjt.entity.TParametersAndData;
import com.tjt.entity.TParametersdata;
import com.tjt.entity.TParametersname;
import com.tjt.entity.TParametersproject;
import com.tjt.entity.TProduct;
import com.tjt.entity.TProducttype;
import com.tjt.entity.TRecruitment;
import com.tjt.entity.TRecruitmentresume;
import com.tjt.entity.TResume;
import com.tjt.entity.TUser;
import com.tjt.entity.TUserdevice;
import com.tjt.entity.TUserparametersroject;
import com.tjt.service.CollectionsService;
import com.tjt.service.CommentsService;
import com.tjt.service.CompanyService;
import com.tjt.service.CompanytypeService;
import com.tjt.service.CompanyusertypeService;
import com.tjt.service.DeviceService;
import com.tjt.service.DevicegpsService;
import com.tjt.service.DownloadService;
import com.tjt.service.ForjobService;
import com.tjt.service.IntegralService;
import com.tjt.service.MessagepushService;
import com.tjt.service.MessagesService;
import com.tjt.service.MessagestypeService;
import com.tjt.service.ParametersService;
import com.tjt.service.ParametersdataService;
import com.tjt.service.ParametersnameService;
import com.tjt.service.ParametersprojectService;
import com.tjt.service.ProductService;
import com.tjt.service.ProducttypeService;
import com.tjt.service.RecruitmentService;
import com.tjt.service.RecruitmentresumeService;
import com.tjt.service.ResumeService;
import com.tjt.service.UserService;
import com.tjt.service.UsercompanytypeService;
import com.tjt.service.UserdeviceService;
import com.tjt.service.UserparametersprojectService;
import com.tjt.util.Md5;
import com.tjt.util.ResultUtils;
import com.tjt.util.TextUtility;

@SuppressWarnings("serial")
public class MobileAction extends ActionSupport {

	private Map<String, Object> jsonResult;
	private CollectionsService collectionsService;
	private CommentsService commentsService;
	private CompanyService companyService;
	private CompanytypeService companytypeService;
	private CompanyusertypeService companyusertypeService;
	private DevicegpsService devicegpsService;
	private DeviceService deviceService;
	private IntegralService integralService;
	private MessagepushService messagepushService;
	private MessagesService messagesService;
	private MessagestypeService messagestypeService;
	private ParametersService parametersService;
	private ParametersnameService parametersnameService;
	private ParametersdataService parametersdataService;
	private ParametersprojectService parametersprojectService;
	private UsercompanytypeService usercompanytypeService;
	private UserdeviceService userdeviceService;
	private UserparametersprojectService userparametersprojectService;
	private UserService userService;
	private ProductService productService;
	private ProducttypeService producttypeService;
	private RecruitmentresumeService recruitmentresumeService;
	private RecruitmentService recruitmentService;
	private ResumeService resumeService;
	private ForjobService forjobService;
	private DownloadService downloadService;



	public DownloadService getDownloadService() {
		return downloadService;
	}

	public void setDownloadService(DownloadService downloadService) {
		this.downloadService = downloadService;
	}

	// 闁谎冾煼濡撅拷
	public String mobile() throws JSONException, IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		String para = request.getParameter("para");
		JSONObject jb = new JSONObject(para);
		int type = jb.getInt("sendtype");
		JSONObject data = jb.getJSONObject("data");

		switch (type) {
		case 10001:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":10001,"data":{"phone":"18858294600","password":"123456"}}
			loginUser(data);
			break;
		case 10002:
			updateUser(data);
			break;
		case 10003:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":10003,"data":{"userPhone":"18858294600","userPassword":"123456","userNikename":"sss"}}
			addUser(data);
			break;
		case 10004:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":10001,"data":{"id":1}}
			getUser(data);
			break;
		case 10005:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":10005,"data":{"phone":"18858294600"}}
			checkPhone(data);
			break;
		case 10006:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":10006,"data":{"pn":1,"ps":10}}
			getUserList(data);
			break;
		case 10007:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":10007,"data":{"para":1}}
			getUsersCount(data);
			break;
		case 10010:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":10010,"data":{"truename":1,"uid":1}}
			doupdateUser(data);
			
			break;			
		case 10101:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":10101,"data":{"uid":1}}
			getCompany(data);
			break;
		case 10102:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":10101,"data":{"uid":1}}
			updateCompany(data);
			break;
		case 20001:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20001,"data":{"key":"l","messagestypeId":0,"pn":1,"ps":10}}
			getMessages(data);
			break;
		case 20100:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20100,"data":{"key":"l","messagestypeId":0,"pn":1,"ps":10}}
			getMessages_forum(data);
			break;			
		case 20002:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20002,"data":{"acesstoken":"","messagesInfo":"123456","messagesType":"sss","SLiving":{"livingId":6}}}
			addMessages(data);
			break;

		case 20003:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20003,"data":{"messagesId":0}}
			getMsgcon(data);
			break;
		case 20004:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20004,"data":{"acesstoken":"","messagesInfo":"123456","messagesType":"sss","SLiving":{"livingId":6}}}
			updateMessages(data);
			break;
		case 20005:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20005,"data":{"messagesId":0}}
			delMessages(data);
			break;
		case 20006:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20006,"data":{"pn":1,"ps":10}}
			getAllMessages(data);
			break;
		case 20007:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20007,"data":{"para":1}}
			getMessagesCount(data);

			break;	
			
		case 20011:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20011,"data":{"mid":1,"pn":1,"ps":10}}
			getComments(data);
			break;
		case 20012:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20012,"data":{"mid":1,"pn":1,"ps":10}}
			addComments(data);
			break;
		case 20013:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20013,"data":{"mid":1}}
			getCommentsCount(data);
			break;
		case 20014:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20014,"data":{"para":1}}
			getCommentCount(data);
			break;
		case 20015:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20015,"data":{"acesstoken":"","messagesInfo":"123456","messagesType":"sss","SLiving":{"livingId":6}}}
			addMessages1(data);
			break;
		case 20050:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20050,"data":{"para":1}}
			getCompaniesCount(data);
			break;
		case 20021:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20021,"data":{"uid":1,"pn":1,"ps":10}}
			getCollections(data);
			break;
		case 20022:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20022,"data":{"uid":1,"mid":1}}
			setCollections(data);
			break;
		case 20023:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20022,"data":{"uid":1,"mid":1}}
			checkCollections(data);
			break;
		case 20024:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20022,"data":{"uid":1,"mid":1}}
			delCollections(data);
			break;
			
		case 20031:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20031,"data":{"para":1}}
			getDownload(data);

			break;	
		case 20032:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20032,"data":{"para":1}}
			addDownload(data);
			break;
		case 20035:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":20005,"data":{"messagesId":0}}
			upMsgtype(data);
			break;
			
		case 30001:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":30001,"data":{"uid":1,"companyid":1,"pn":1,"ps":10}}
			getDevice(data);
			break;

		case 30002:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":30002,"data":{"uid":1,"touid":1,"pn":1,"ps":10}}
			getUserDevice(data);
			break;

		case 30003:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":30003,"data":{"userdeviceid":1,"status":1}}
			setUserDevice(data);
			break;
			
		case 30005:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":30003,"data":{"userdeviceid":1,"status":1}}
			addUserDevice(data);
			break;
			
		case 30004:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":30003,"data":{"userdeviceid":1,"status":1}}
			toUserDevice(data);
			break;
		case 40001:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40001,"data":{"pn":1,"ps":100}}
			getProductTypes(data);
			break;
		case 40002:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40002,"data":{"key":"l","producttypeId":1,"pn":1,"ps":10}}
			getProducts(data);
			break;
		case 40003:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40003,"data":{"pn":1,"ps":10}}
			getRecruitments(data);
			break;
		case 40004:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40004,"data":{"pn":1,"ps":10}}
			getForJobs(data);
			break;
		case 40005:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40005,"data":{"recruitmentId":1,"pn":1,"ps":10}}
			getRecruitmentResumes(data);
			break;
		case 40006:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40006,"data":{"uid":1,"pn":1,"ps":10}}
			getResumes(data);
			break;
		case 40007:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40007,"data":{"uid":1,"pn":1,"ps":10}}
			addProduct(data);
			break;
		case 40008:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40008,"data":{"uid":1,"pn":1,"ps":10}}
			addRecruitment(data);
			break;
		case 40009:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40008,"data":{"uid":1,"pn":1,"ps":10}}
			addForJob(data);
			break;
		case 40010:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40008,"data":{"uid":1,"pn":1,"ps":10}}
			addResume(data);
			break;
		case 40011:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40008,"data":{"uid":1,"pn":1,"ps":10}}
			upResume(data);
			break;

			
		case 40020:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40020,"data":{"pid":1}}
			delProducts(data);
		case 40021:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40021,"data":{"pid":1}}
			getProductdetail(data);			
			break;
		case 40022:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40022,"data":{"rid":1}}
			getRecruitmentdetail(data);			
			break;	
		case 40023:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40023,"data":{"pn":1,"ps":15}}
			getAllResumes(data);
			break;	
		case 40024:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40024,"data":{"rid":1}}
			delRecruitment(data);
			break;	
		case 40025:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40025,"data":{"rid":1}}
			getForjobdetail(data);			
			break;
		case 40026:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40026,"data":{"rid":1}}
			delForjob(data);
			break;	
		case 40027:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40027,"data":{"para":1}}
			getRecruitmentCount(data);
			break;	
		case 40028:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40028,"data":{"para":1}}
			getProductCount(data);
			break;	
		case 40029:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40029,"data":{"para":1}}
			getForjobCount(data);
			break;	
		case 40030:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":40030,"data":{"para":1}}
			getDataCount(data);
			break;			
		case 50001:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":50001,"data":{"parametersproject_id":1,"pn":1,"ps":10}}
			getParameters(data);
			break;
		case 50002:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":50002,"data":{"parameters_id":1,"pn":1,"ps":10}}
			getParametersData(data);
			break;
		case 50003:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":50003,"data":{"user_id":1,"pn":1,"ps":10}}
			getParametersProject(data);
			break;
		case 50004:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":50004,"data":{"user_id":1,"pn":1,"ps":10}}
			getUserParametersProject(data);
			break;
			
		case 50005:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":50004,"data":{"user_id":1,"pn":1,"ps":10}}
			addUserParametersProject(data);
			break;
		case 50006:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":50004,"data":{"user_id":1,"pn":1,"ps":10}}
			delUserParametersProject(data);
			break;
		case 50007:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":50004,"data":{"user_id":1,"pn":1,"ps":10}}
			addParametersProject(data);
			break;
		case 50008:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":50008,"data":{"pn":1,"ps":10}}
			getParametersname(data);
			break;
		case 50009:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":50008,"data":{"pn":1,"ps":10}}
			addParametersData(data);
			break;
		case 90001:
			// http://127.0.0.1:8080/SunHome/mobile!mobile.action?para={"sendtype":90001,"data":{}}
			getQiNiu();
			break;
		case 90002:
			// http://127.0.0.1:8080/TJT/mobile!mobile.action?para={"sendtype":90002,"data":{"uid":1,"pn":1,"ps":10}}
			getMessagepush(data);
			break;
		default:
			senddefault();
			// http://127.0.0.1:8080/SunHome/mobile!mobile.action?para={"sendtype":-1,"data":{}}
			break;
		}

		return null;
	}

	private void loginUser(JSONObject data) throws JSONException {
		String loginId = data.getString("phone");
		String loginPwd = data.getString("password");
		TUser u = userService.checkLogin(loginId, loginPwd);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("user", u);
		map.put("data", map2);
		int status = 0;
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getUser(JSONObject data) throws JSONException {
		int id = data.getInt("id");
		TUser u = userService.getTUserById(id);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("user", u);
		map.put("data", map2);
		int status = 0;
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getUserList(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");

		ArrayList<TUser> ms = userService.getTUserByPageNum(pn, ps);

		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("userlist", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void checkPhone(JSONObject data) throws JSONException {

		try {

			int status = 0;
			String loginId = data.getString("phone");
			TUser u = userService.findTUserByPhone(loginId);
			if (u == null) {
				status = 1;
			} else {
				status = 0;
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("data", "");
			map.put("ret", status);
			map.put("msg", "");
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void updateUser(JSONObject data) {
		GsonBuilder builder = new GsonBuilder();
		// 婵炴垶鎼幏鐑藉级閻戝洦瀚归柨鐔告灮閹风兘濮�敍鍕挄闁跨喐鏋婚幏鐑芥晸閿熺捶Expose
		// 濠电偛顦归崝蹇氼暰闁跨喐鏋婚幏鐑芥晸閻ｅ矉鎷烽柨鐔绘閳绘捇鏁撻敓锟�//
		// builder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = builder.create();
		String s = data.toString();
		TUser u = gson.fromJson(s, new TypeToken<TUser>() {
		}.getType());
		TUser u1 = null;
		boolean b = false;
		if(u.getUserId() != null){
			u1 = userService.findTUserByUid(u.getUserId());
			if(u.getUserPassword() == null){
				u.setUserPassword(u1.getUserPassword());
			}else{
				String strpassword=u.getUserPassword();
		        Md5 md5 = new Md5(strpassword);
		        md5.processString();
		        String strEncrypto = md5.getStringDigest();
		        u.setUserPassword(strEncrypto);
			}
			u.setUserStatus(u1.getUserStatus());
			b = userService.updateTUser(u);
		}else{
			u1 = userService.findTUserByPhone(u.getUserPhone());
			String strpassword=u.getUserPassword();
	        Md5 md5 = new Md5(strpassword);
	        md5.processString();
	        String strEncrypto = md5.getStringDigest();
	        u1.setUserPassword(strEncrypto);
			b = userService.updateTUser(u1);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
		} else {
			status = 1;
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void doupdateUser(JSONObject data) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String s = data.toString();
		TUser u = gson.fromJson(s, new TypeToken<TUser>() {
		}.getType());
		TUser u1 = null;
		boolean b = false;
		if(u.getUserId() != null){
			u1 = userService.findTUserByUid(u.getUserId());
			u1.setUserTruename(u.getUserTruename());
			b = userService.updateTUser(u1);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
		} else {
			status = 1;
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void addUser(JSONObject data) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String s = data.toString();
		TUser u = gson.fromJson(s, new TypeToken<TUser>() {
		}.getType());
		String password=u.getUserPassword();
        Md5 md5 = new Md5(password);
        md5.processString();
        String strEncrypto = md5.getStringDigest();
        u.setUserPassword(strEncrypto);
		String ptime = TextUtility.formatDate(new Date());
		u.setUserTime(ptime);
		u.setUserStatus((short)0);;
		u.setUserCompanyStatus((short)0);
		boolean b = userService.addTUser(u);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
			map.put("msg", "");
		} else {
			status = 1;
			map.put("msg", "");
		}
		map.put("ret", status);
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void getUsersCount(JSONObject data) throws JSONException {
		int para = data.getInt("para");
		int num = userService.getCounts();
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		map.put("data", num);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getCompany(JSONObject data) throws JSONException {
		int id = data.getInt("uid");
		TCompany u = companyService.getTCompanyByUid(id);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		if(u == null){
			map2.put("staus",1);
		}else{
			map2.put("staus",0);
		}
		map2.put("company", u);
		map.put("data", map2);
		int status = 0;
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void updateCompany(JSONObject data) throws JSONException {
		
		GsonBuilder builder = new GsonBuilder();
		// 婵炴垶鎼幏鐑藉级閻戝洦瀚归柨鐔告灮閹风兘濮�敍鍕挄闁跨喐鏋婚幏鐑芥晸閿熺捶Expose
		// 濠电偛顦归崝蹇氼暰闁跨喐鏋婚幏鐑芥晸閻ｅ矉鎷烽柨鐔绘閳绘捇鏁撻敓锟�//
		// builder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = builder.create();
		String s = data.toString();
		TCompany u = gson.fromJson(s, new TypeToken<TCompany>() {
		}.getType());
		boolean b = false;
		String ptime = TextUtility.formatDate(new Date());
		u.setCompanyTime(ptime);
		if(u.getCompanyStatus() == null || u.getCompanyStatus() == 3){
			u.setCompanyStatus((short)1);
		}
		if(u.getTCompanytype()==null){
			TCompanytype t = new TCompanytype();
			t.setCompanytypeId(1);
			u.setTCompanytype(t);
		}
		
		if(u.getCompanyId() == null){
			b = companyService.addTCompany(u);
		}else{
			b = companyService.updateTCompany(u);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		if(!b){
			status = 1;
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void getCompaniesCount(JSONObject data) throws JSONException {
		int para = data.getInt("para");
		int num = companyService.getCounts();
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		map.put("data", num);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void getMessagesCount(JSONObject data) throws JSONException {
		int para = data.getInt("para");
		int num = messagesService.getCounts();
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		map.put("data", num);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void getCommentCount(JSONObject data) throws JSONException {
		int para = data.getInt("para");
		int num = commentsService.getCounts();
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		map.put("data", num);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private void getRecruitmentCount(JSONObject data) throws JSONException {
		@SuppressWarnings("unused")
		int para = data.getInt("para");
		int num = recruitmentService.getCounts();
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		map.put("data", num);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getProductCount(JSONObject data) throws JSONException {
		@SuppressWarnings("unused")
		int para = data.getInt("para");
		int num = productService.getCounts();
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		map.put("data", num);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getForjobCount(JSONObject data) throws JSONException {
		@SuppressWarnings("unused")
		int para = data.getInt("para");
		int num = forjobService.getCounts();
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		map.put("data", num);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getDataCount(JSONObject data) throws JSONException {
		@SuppressWarnings("unused")
		int para = data.getInt("para");
		int num = messagesService.getCounts1();
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		map.put("data", num);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getMessages(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int messagestypeId = -1;
		if (data.has("messagestypeId")) {
			messagestypeId = data.getInt("messagestypeId");
		}
		String key = null;
		if (data.has("key")) {
			key = data.get("key").toString();
		}
		int uid = -1;
		if (data.has("uid")) {
			uid = data.getInt("uid");
		}
		ArrayList<TMessages> ms = messagesService.getTMessagesforTypeByPageNum(
				uid,key, messagestypeId, pn, ps);
		int count= messagesService.getCount2(uid, key, messagestypeId);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("messagelist", ms);
			map.put("data", map2);
		} else {
			
			
			
			status = 1;
			map.put("data", "");
		}
		map.put("count", count);
		map.put("pn", pn);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getMessages_forum(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int messagestypeId = -1;
		if (data.has("messagestypeId")) {
			messagestypeId = data.getInt("messagestypeId");
		}
		String key = null;
		if (data.has("key")) {
			key = data.get("key").toString();
		}
		ArrayList<TMessages> ms = messagesService.getTMessagesforType_forum(key,messagestypeId, pn, ps);
		int count= messagesService.getCount3(key,messagestypeId);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("messagelist", ms);
			map.put("data", map2);
		} else {
							
			status = 1;
			map.put("data", "");
		}
		map.put("count", count);
		map.put("pn", pn);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @param data
	 * @throws JSONException
	 */
	private void getAllMessages(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");

		ArrayList<TMessages> ms = messagesService.getTMessagesByPageNum(pn, ps);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("messagelist", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addMessages(JSONObject data) throws JSONException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String s = data.toString();
		// s = TextUtility.toUTF8(s);
		TMessages u = gson.fromJson(s, new TypeToken<TMessages>() {
		}.getType());

		String ptime = TextUtility.formatDate(new Date());
		u.setMessagesTime(ptime);
		u.setMessagesIslink(false);
		u.setMessagesStatus((short) 0);
		u.setMessagesCollectnum(0);
		boolean b = messagesService.addTMessages(u);

		ArrayList<TUser> al = userService.getTUsers();
		if (u.getTMessagestype().getMessagestypeId() == 400) {
			String img = "";
			String a = u.getMessagesImgsrcs();
			img = a.split(",")[0];
	
			for (TUser ur : al) {
				TUser ue = new TUser();
				ue.setUserId(ur.getUserId());
				TMessagepush me = new TMessagepush();
				me.setMessagepushTime(ptime);
				me.setTUser(ue);
				me.setMessagepushInfo(u.getMessagesTitle());
				me.setMessagepushOtherId(400);
				me.setMessagepushType(0);
				me.setMessagepushStatus((short) 0);
				me.setMessagepushFace(img);

				messagepushService.addTMessagepush(me);

			}
		} else {
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
			map.put("msg", "");
		} else {
			status = 1;
			map.put("msg", "");
		}
		map.put("ret", status);
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addMessages1(JSONObject data) throws JSONException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String s = data.toString();
		// s = TextUtility.toUTF8(s);
		TMessages u = gson.fromJson(s, new TypeToken<TMessages>(){			
		}.getType());
		String ptime = TextUtility.formatDate(new Date());
		u.setMessagesTime(ptime);
		u.setMessagesIslink(false);
		u.setMessagesStatus((short) 0);
		u.setMessagesCollectnum(0);

		if (u.getMessagesAnnex() != null && u.getMessagesAnnex().length() > 1) {
			String url = u.getMessagesAnnex();
			String[] urlpara = url.split("##");
			String strurl = "";
			for (int i = 0; i < urlpara.length; i++) {
				strurl = urlpara[i];
				u.setMessagesAnnex(strurl);
				u.setMessagesTitle(strurl);
				boolean b = messagesService.addTMessages1(u);
				Map<String, Object> map = new HashMap<String, Object>();
				int status = 1;
				if (b) {
					status = 0;
					map.put("msg", "");
				} else {
					status = 1;
					map.put("msg", "");
				}
				map.put("ret", status);
				try {
					ResultUtils.toJson(ServletActionContext.getResponse(), map);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void getMsgcon(JSONObject data) throws JSONException {
		int mid = data.getInt("messagesId");

		TMessages mg = messagesService.getTMessagesById(mid);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("meg", mg);
		map.put("data", map2);
		int status = 0;
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void updateMessages(JSONObject data) {
		GsonBuilder builder = new GsonBuilder();
		// 婵炴垶鎼幏鐑藉级閻戝洦瀚归柨鐔告灮閹风兘濮�敍鍕挄闁跨喐鏋婚幏鐑芥晸閿熺捶Expose
		// 濠电偛顦归崝蹇氼暰闁跨喐鏋婚幏鐑芥晸閻ｅ矉鎷烽柨鐔绘閳绘捇鏁撻敓锟�//
		// builder.excludeFieldsWithoutExposeAnnotation();
		Gson gson = builder.create();
		String s = data.toString();
		TMessages u = gson.fromJson(s, new TypeToken<TMessages>() {
		}.getType());
		boolean b = messagesService.updateTMessages(u);
		System.out.println(u.getTMessagestype().getMessagestypeName());
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
		} else {
			status = 1;
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void delMessages(JSONObject data) throws JSONException {
		int mid = data.getInt("messagesId");
		TMessages mg = messagesService.getTMessagesById(mid);
		mg.setMessagesStatus((short) 1);
	    boolean b = messagesService.updateTMessages(mg);
		
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
		} else {
			status = 1;
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void upMsgtype(JSONObject data) throws JSONException {
		int mid = data.getInt("messagesId");
		int tid = data.getInt("messagestypeId");
		TMessages mg = messagesService.getTMessagesById(mid);
		TMessagestype mt=new TMessagestype();
		mt.setMessagestypeId(tid);
		mg.setTMessagestype(mt);
		boolean b = messagesService.updateTMessages(mg);
	
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
		} else {
			status = 1;
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getComments(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int MId = -1;
		if (data.has("mid")) {
			MId = data.getInt("mid");
		}
		ArrayList<TComments> ms = commentsService.getTCommentsUIDByPageNum(MId,pn, ps);
		int count= commentsService.getMidcount(MId);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("Commentslist", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("count", count);
		map.put("pn", pn);		
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void addComments(JSONObject data) throws JSONException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String s = data.toString();
		TComments u = gson.fromJson(s, new TypeToken<TComments>() {
		}.getType());

		String ptime = TextUtility.formatDate(new Date());
		u.setCommentsTime(ptime);
		u.setCommentsInfostatus(0);
		boolean b = commentsService.addTComments(u);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
			map.put("msg", "");
		} else {
			status = 1;
			map.put("msg", "");
		}
		map.put("ret", status);
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getCommentsCount(JSONObject data) throws JSONException {
		int MId = -1;
		if (data.has("mid")) {
			MId = data.getInt("mid");
		}
		int num = commentsService.getMidcount(MId);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 0;
		map.put("data", num);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getCollections(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int UId = -1;
		if (data.has("uid")) {
			UId = data.getInt("uid");
		}
		ArrayList<TCollections> ms = collectionsService
				.getTCollectionsUIDByPageNum(UId, pn, ps);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("Collectionslist", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setCollections(JSONObject data) throws JSONException {

		int uid = -1;
		if (data.has("uid")) {
			uid = data.getInt("uid");
		}
		int mid = -1;
		if (data.has("mid")) {
			mid = data.getInt("mid");
		}

		int status1 = 0;
		TCollections collection = collectionsService.checkCollections(uid, mid);
		if (collection == null) {
			collection = new TCollections();
			TMessages t = new TMessages();
			t.setMessagesId(mid);
			collection.setTMessages(t);
			TUser user = new TUser();
			user.setUserId(uid);
			collection.setTUser(user);
			collection.setCollectionsStatus(true);
			String ptime = TextUtility.formatDate(new Date());
			collection.setCollectionsTime(ptime);
			collectionsService.addTCollections(collection);
			status1 = 0;
		} else {
			collection.setCollectionsStatus(!collection.getCollectionsStatus());
			collectionsService.updateTCollections(collection);
			if (collection.getCollectionsStatus()) {
				status1 = 0;
			} else {
				status1 = 1;
			}

		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ret", status1);
		map.put("data", "");
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void delCollections(JSONObject data) throws JSONException {

		int uid = -1;
		if (data.has("uid")) {
			uid = data.getInt("uid");
		}
		int mid = -1;
		if (data.has("mid")) {
			mid = data.getInt("mid");
		}

		int status1 = 0;
		TCollections collection = collectionsService.checkCollections(uid, mid);
		if (collection == null) {
		} else {
			collection.setCollectionsStatus(false);
			collectionsService.updateTCollections(collection);
		}
		status1 = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ret", status1);
		map.put("data", "");
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void checkCollections(JSONObject data) throws JSONException {

		int uid = -1;
		if (data.has("uid")) {
			uid = data.getInt("uid");
		}
		int mid = -1;
		if (data.has("mid")) {
			mid = data.getInt("mid");
		}

		int status1 = 0;
		TCollections collection = collectionsService.checkCollections(uid, mid);
		if (collection == null) {
			status1 = 1;
		} else {
			if (collection.getCollectionsStatus()) {
				status1 = 0;
			} else {
				status1 = 1;
			}

		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ret", status1);
		map.put("data", "");
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getDownload(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int UId = -1;
		if (data.has("uid")) {
			UId = data.getInt("uid");
		}
		ArrayList<TDownload> ms = downloadService
				.getTDownloadUIDByPageNum(UId, pn, ps);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("list", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private void addDownload(JSONObject data) throws JSONException {

		int uid = -1;
		if (data.has("uid")) {
			uid = data.getInt("uid");
		}
		int mid = -1;
		if (data.has("mid")) {
			mid = data.getInt("mid");
		}

		int status1 = 0;
		TDownload download = downloadService.checkDownload(uid, mid);
		if (download == null) {
			download = new TDownload();
			TMessages t = new TMessages();
			t.setMessagesId(mid);
			download.setTMessages(t);
			TUser user = new TUser();
			user.setUserId(uid);
			download.setTUser(user);
			download.setDownloadStatus((short)0);
			String ptime = TextUtility.formatDate(new Date());
			download.setDownloadTime(ptime);
			downloadService.addTDownload(download);
			status1 = 0;
		} else {
//			collection.setCollectionsStatus(!collection.getCollectionsStatus());
//			collectionsService.updateTCollections(collection);
//			if (collection.getCollectionsStatus()) {
//				status1 = 0;
//			} else {
//				status1 = 1;
//			}
			status1 = 2;
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ret", status1);
		map.put("data", "");
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getMessagepush(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int UId = -1;
		if (data.has("uid")) {
			UId = data.getInt("uid");
		}
		ArrayList<TMessagepush> ms = messagepushService
				.getTMessagepushUIDByPageNum(UId, pn, ps);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("Messagepushlist", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getDevice(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int UId = -1;
		if (data.has("uid")) {
			UId = data.getInt("uid");
		}
		int CUId = -1;
		if (data.has("createuser_id")) {
			CUId = data.getInt("createuser_id");
		}
		int companyid = -1;
		if (data.has("companyid")) {
			companyid = data.getInt("companyid");
		}
		ArrayList<TDevice> ms = deviceService.getTDeviceforTypeByPageNum(UId,CUId,
				companyid, pn, ps);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("Devicelist", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getUserDevice(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int UId = -1;
		if (data.has("uid")) {
			UId = data.getInt("uid");
		}
		int touid = -1;
		if (data.has("touid")) {
			touid = data.getInt("touid");
		}
		ArrayList<TUserdevice> ms = userdeviceService
				.getTUserdeviceforTypeByPageNum(UId, touid, pn, ps);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("userdevicelist", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setUserDevice(JSONObject data) throws JSONException {

		int userdeviceid = -1;
		if (data.has("userdeviceid")) {
			userdeviceid = data.getInt("userdeviceid");
		}
		String statusStr = "-1";
		if (data.has("status")) {
			statusStr = data.get("status").toString();
		}
		Short status = Short.parseShort(statusStr);

		TUserdevice userdevice = userdeviceService
				.getTUserdeviceById(userdeviceid);
		userdevice.setUserdeviceStatus(status);
		userdeviceService.updateTUserdevice(userdevice);
		if (status == 1) {
			TDevice device = deviceService.getTDeviceById(userdevice
					.getTDevice().getDeviceId());
			device.setTUserByUserId(userdevice.getTUserByTouserId());
			String ptime = TextUtility.formatDate(new Date());
			userdevice.setUserdeviceTime(ptime);
			deviceService.updateTDevice(device);
		}
		if (status != 0){
			TDevice device = deviceService.getTDeviceById(userdevice
					.getTDevice().getDeviceId());
			device.setDeviceUsing((short)0);
			deviceService.updateTDevice(device);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		int status1 = 0;
		map.put("ret", status1);
		map.put("data", "");
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void toUserDevice(JSONObject data) throws JSONException {

		int userid = -1;
		if (data.has("uid")) {
			userid = data.getInt("uid");
		}
		int deviceId = -1;
		if (data.has("deviceId")) {
			deviceId = data.getInt("deviceId");
		}
		String phone = "";
		if (data.has("phone")) {
			phone = data.get("phone").toString();
		}

		int status1 = 0;
		
		TUser user = userService.findTUserByPhone(phone);
		if(user == null){
			status1 = 2;
		}
		
		TUser user2 = userService.findTUserByUid(userid);
		if(user2 == null){
			status1 = 3;
		}
		
		TDevice device = deviceService.getTDeviceById(deviceId);
		if(device == null){
			status1 = 4;
		}
		
		TUserdevice userdevice = new TUserdevice();
		userdevice.setTUserByTouserId(user);
		userdevice.setTUserByUsertoId(user2);
		userdevice.setTDevice(device);
		userdevice.setUserdeviceStatus((short)0);
		String ptime = TextUtility.formatDate(new Date());
		userdevice.setUserdeviceTime(ptime);
		userdeviceService.addTUserdevice(userdevice);
		device.setDeviceUsing((short)1);
		deviceService.updateTDevice(device);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ret", status1);
		map.put("data", "");
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addUserDevice(JSONObject data) throws JSONException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String s = data.toString();
		// s = TextUtility.toUTF8(s);
		TDevice u = gson.fromJson(s, new TypeToken<TDevice>() {
		}.getType());

		String ptime = TextUtility.formatDate(new Date());
		u.setDeviceFirsttime(ptime);
		u.setDeviceTime(ptime);
		u.setDeviceStatus((short)0);
		u.setDeviceUsing((short)0);
		TCompany c = new TCompany();
		c.setCompanyId(1);
		u.setTCompany(c);
		boolean b = deviceService.addTDevice(u);

		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
			map.put("msg", "");
		} else {
			status = 1;
			map.put("msg", "");
		}
		map.put("ret", status);
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getProductTypes(JSONObject data) throws JSONException {
		ArrayList<TProducttype> ms = producttypeService.getTProducttypes();
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("producttypelist", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void delProducts(JSONObject data) throws JSONException {
		int pid = data.getInt("productId");
		TProduct p= productService.getTProductById(pid);
		p.setProductStatus((short) 1);
		boolean b = productService.updateTProduct(p);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
		} else {
			status = 1;
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getProducts(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int producttypeId = -1;
		int companyId = -1;
		if (data.has("producttypeId")) {
			producttypeId = data.getInt("producttypeId");
		}
		if (data.has("companyId")) {
			companyId = data.getInt("companyId");
		}
		String key = null;
		if (data.has("key")) {
			key = data.getString("key");
		}
		ArrayList<TProduct> ms = productService.getTProductforTypeByPageNum(
				key, producttypeId, companyId, pn, ps);
		int count= productService.getCount2( key, producttypeId);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("productlist", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("count", count);
		map.put("pn", pn);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getProductdetail(JSONObject data) throws JSONException {
		int pid = data.getInt("productId");

		TProduct pt = productService.getTProductById(pid);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("meg",pt);
		map.put("data", map2);
		int status = 0;
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getRecruitments(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int uid = -1;
		if(data.has("uid")){
			uid = data.getInt("uid");
		}		
		String city=null;
		if (data.has("city")) {
			city= data.getString("city");

		}
		String area=null;
		if (data.has("area")) {
			area= data.getString("area");

		}
		String title=null;
		if (data.has("title")) {
			title= data.getString("title");

		}		

		ArrayList<TRecruitment> ms = recruitmentService
				.getTRecruitmentForUserByPageNum(uid,city,area,title,pn, ps);
		int count= recruitmentService.getCount2(uid,city,area,title);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("list", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("count", count);
		map.put("pn", pn);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getRecruitmentdetail(JSONObject data) throws JSONException {
		int rid = data.getInt("recruitmentId");

		TRecruitment tt = recruitmentService.getTRecruitmentById(rid);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("meg",tt);
		map.put("data", map2);
		int status = 0;
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void delRecruitment(JSONObject data) throws JSONException {
		int rid = data.getInt("recruitmentId");
		TRecruitment r= recruitmentService.getTRecruitmentById(rid);
		r.setRecruitmentStatus((short) 1);
		boolean b = recruitmentService.updateTRecruitment(r);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
		} else {
			status = 1;
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void delForjob(JSONObject data) throws JSONException {
		int jid = data.getInt("forjobId");
		TForjob j= forjobService.getTForjobById(jid);
		j.setForjobStatus((short) 1);
		boolean b = forjobService.updateTForjob(j);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
		} else {
			status = 1;
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getForJobs(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int uid = -1;
		int rid = -1;
		ArrayList<TForjob> msJob = null;
		String key=null;
		if (data.has("key")) {
			key= data.getString("key");
			
		}
		if(data.has("uid")){
			uid = data.getInt("uid");
			ArrayList<TResume> ms = resumeService.getTResumeByPageNum1(pn, ps, uid);
			if(ms.size()>0){
				rid = (int)ms.get(0).getResumeId().intValue();
				msJob = forjobService.getTForjobForUserByPageNum(rid,key,pn, ps);
			}else{
				
			}
		}else{
			msJob = forjobService.getTForjobForUserByPageNum(rid,key,pn, ps);
			
		}
		int count= forjobService.getcount(rid,key);

		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (msJob != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("list", msJob);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("count", count);
		map.put("pn", pn);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getRecruitmentResumes(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int recruitmentId = -1;
		if (data.has("recruitmentId")) {
			recruitmentId = data.getInt("recruitmentId");
		}
		ArrayList<TRecruitmentresume> ms = recruitmentresumeService
				.getTRecruitmentresumeByPageNum1(pn, ps, recruitmentId);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("list", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getResumes(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int uId = -1;
		if (data.has("uid")) {
			uId = data.getInt("uid");
		}
		ArrayList<TResume> ms = resumeService
				.getTResumeByPageNum1(pn, ps, uId);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		System.out.println(ms);
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("list", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getAllResumes(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");

		ArrayList<TResume> ms = resumeService.getTResumeByPageNum(pn, ps);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("list", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	private void addProduct(JSONObject data) throws JSONException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String s = data.toString();
		// s = TextUtility.toUTF8(s);
		TProduct u = gson.fromJson(s, new TypeToken<TProduct>() {
		}.getType());

		String ptime = TextUtility.formatDate(new Date());
		u.setProductTime(ptime);
		u.setProductStatus((short) 0);
		boolean b = productService.addTProduct(u);

		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
			map.put("msg", "");
		} else {
			status = 1;
			map.put("msg", "");
		}
		map.put("ret", status);
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addRecruitment(JSONObject data) throws JSONException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String s = data.toString();
		// s = TextUtility.toUTF8(s);
		TRecruitment u = gson.fromJson(s, new TypeToken<TRecruitment>() {
		}.getType());

		String ptime = TextUtility.formatDate(new Date());
		u.setRecruitmentTime(ptime);
		u.setRecruitmentCollectnum(0);
		u.setRecruitmentStatus((short)0);
		boolean b = recruitmentService.addTRecruitment(u);

		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
			map.put("msg", "");
		} else {
			status = 1;
			map.put("msg", "");
		}
		map.put("ret", status);
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addForJob(JSONObject data) throws JSONException {
		
		int userId = data.getInt("userId");
		String forjobTittle = data.getString("forjobTittle");
		String forjobInfo = data.getString("forjobInfo");
		System.out.println(forjobInfo);
		System.out.println(forjobTittle);
		ArrayList<TResume> resumes = resumeService.getTResumeByPageNum1(1, 100,
				userId);
		Map<String, Object> map = new HashMap<String, Object>();
		if (resumes.size() > 0) {
			TForjob u = new TForjob();
			u.setForjobInfo(forjobInfo);
			u.setForjobStatus((short) 0);
			u.setForjobTittle(forjobTittle);
			u.setTResume(resumes.get(0));
			String ptime = TextUtility.formatDate(new Date());
			u.setForjobTime(ptime);
			boolean b = forjobService.addTForjob(u);

			int status = 1;
			if (b) {
				status = 0;
				map.put("msg", "");
			} else {
				status = 1;
				map.put("msg", "");
			}
			map.put("ret", status);
		} else {
			int status = 2;
			map.put("msg", "");
			map.put("ret", status);
		}
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getForjobdetail(JSONObject data) throws JSONException {

		TForjob fj = forjobService.getTForjobById(data.getInt("forjobId"));
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("meg",fj);
		map.put("data", map2);
		int status = 0;
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	private void addResume(JSONObject data) throws JSONException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String s = data.toString();
		// s = TextUtility.toUTF8(s);
		TResume u = gson.fromJson(s, new TypeToken<TResume>() {
		}.getType());

		String ptime = TextUtility.formatDate(new Date());
		u.setResumeTime(ptime);
		boolean b = resumeService.addTResume(u);

		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
			map.put("msg", "");
		} else {
			status = 1;
			map.put("msg", "");
		}
		map.put("ret", status);
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void upResume(JSONObject data) throws JSONException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String s = data.toString();
		// s = TextUtility.toUTF8(s);
		TResume u = gson.fromJson(s, new TypeToken<TResume>() {
		}.getType());

		String ptime = TextUtility.formatDate(new Date());
		u.setResumeTime(ptime);
		boolean b;
		if(u.getResumeId() == null){
			b = resumeService.addTResume(u);
		}else{
			b = resumeService.updateTResume(u);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
			map.put("msg", "");
		} else {
			status = 1;
			map.put("msg", "");
		}
		map.put("ret", status);
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private void getParameters(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int parametersproject_id = -1;
		if (data.has("parametersproject_id")) {
			parametersproject_id = data.getInt("parametersproject_id");
		}
//		String key = null;
//		if (data.has("key")) {
//			key = data.getString("key");
//		}
		ArrayList<TParameters> ms = parametersService.getTParametersForProjectByPageNum(parametersproject_id,pn, ps);
		ArrayList<Map<String, Object>> maplist = new ArrayList<Map<String,Object>>();
		for(int i=0; i<ms.size();i++){
			Map<String, Object> map11 = new HashMap<String, Object>();
			map11.put("parameter", ms.get(i));
			map11.put("parameterlist", parametersdataService.getTParametersdata2ByPageNum(ms.get(i).getParametersId(),1,1000));
			maplist.add(map11);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("list", maplist);
			map.put("data", map2);
		}else{
			status = 1;
			map.put("data","  ");
		}
	
		map.put("pn", pn);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getParametersData(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int parameters_id = -1;
		if (data.has("parameters_id")) {
			parameters_id = data.getInt("parameters_id");
		}
//		String key = null;
//		if (data.has("key")) {
//			key = data.getString("key");
//		}
		ArrayList<TParametersdata> ms = parametersdataService.getTParametersdata2ByPageNum(parameters_id,pn, ps);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("list", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("pn", pn);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getParametersProject(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int user_id = -1;
		if (data.has("user_id")) {
			user_id = data.getInt("user_id");
		}
//		String key = null;
//		if (data.has("key")) {
//			key = data.getString("key");
//		}
		ArrayList<TParametersproject> ms = parametersprojectService.getTParametersprojectforUserByPageNum(user_id,pn, ps);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("list", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("pn", pn);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getUserParametersProject(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
		int user_id = -1;
		if (data.has("user_id")) {
			user_id = data.getInt("user_id");
		}
		int projectid = -1;
		if (data.has("projectid")) {
			projectid = data.getInt("projectid");
		}
//		String key = null;
//		if (data.has("key")) {
//			key = data.getString("key");
//		}
		ArrayList<TUserparametersroject> ms = userparametersprojectService.getTUserparametersforUserByPageNum(user_id,projectid,pn, ps);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("list", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("pn", pn);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getParametersname(JSONObject data) throws JSONException {
		int pn = data.getInt("pn");
		int ps = data.getInt("ps");
//		int user_id = -1;
//		if (data.has("user_id")) {
//			user_id = data.getInt("user_id");
//		}
//		int projectid = -1;
//		if (data.has("projectid")) {
//			projectid = data.getInt("projectid");
//		}
//		String key = null;
//		if (data.has("key")) {
//			key = data.getString("key");
//		}
		ArrayList<TParametersname> ms = parametersnameService.getTParametersnameByPageNum(pn, ps);
		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (ms != null) {
			status = 0;
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("list", ms);
			map.put("data", map2);
		} else {
			status = 1;
			map.put("data", "");
		}
		map.put("pn", pn);
		map.put("ret", status);
		map.put("msg", "");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addUserParametersProject(JSONObject data) throws JSONException {

		String phone = "";
		if (data.has("phone")) {
			phone = data.get("phone").toString();
		}
		int ParametersprojectId = -1;
		if (data.has("ParametersprojectId")) {
			ParametersprojectId = data.getInt("ParametersprojectId");
		}
		int status = 1;
		boolean b = false;
		TUser user = userService.findTUserByPhone(phone);
		if(user == null){
			status = 2;
		}else{
			ArrayList<TUserparametersroject> us= userparametersprojectService.getTUserparametersforUserByPageNum(user.getUserId(), -1, 1, 100);
			if(us.size()>0){
				status = 3;
			}else{
			TParametersproject p = parametersprojectService.getTParametersprojectById(ParametersprojectId);
			TUserparametersroject u = new TUserparametersroject();
			u.setTUser(user);
			u.setTParametersproject(p);
			String ptime = TextUtility.formatDate(new Date());
			u.setUserparametersTime(ptime);
			u.setUserparametersStatus((short)0);
			b = userparametersprojectService.addTUserparameters(u);
			}
		}
		
		

		Map<String, Object> map = new HashMap<String, Object>();
		if (b) {
			status = 0;
			map.put("msg", "");
		} else {
			status = 1;
			map.put("msg", "");
		}
		map.put("ret", status);
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void delUserParametersProject(JSONObject data) throws JSONException {

		int userParametersprojectId = -1;
		if (data.has("userParametersprojectId")) {
			userParametersprojectId = data.getInt("userParametersprojectId");
		}
		int status = 1;
		boolean b = false;
		TUserparametersroject tuserp = userparametersprojectService.getTUserparametersById(userParametersprojectId);
		tuserp.setUserparametersStatus((short)1);
		b = userparametersprojectService.updateTUserparameters(tuserp);	
		

		Map<String, Object> map = new HashMap<String, Object>();
		if (b) {
			status = 0;
			map.put("msg", "");
		} else {
			status = 1;
			map.put("msg", "");
		}
		map.put("ret", status);
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addParametersProject(JSONObject data) throws JSONException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String s = data.toString();
		// s = TextUtility.toUTF8(s);
		TParametersproject u = gson.fromJson(s, new TypeToken<TParametersproject>() {
		}.getType());

		String ptime = TextUtility.formatDate(new Date());
		u.setParametersprojectTime(ptime);
		u.setParametersProjectStatus((short)0);
		boolean b = false;
		if (u.getParametersprojectId() == null) {
			b = parametersprojectService.addTParametersproject(u);
			TUserparametersroject u1 = new TUserparametersroject();
			u1.setTUser(u.getTUser());
			u1.setTParametersproject(u);
			u1.setUserparametersTime(ptime);
			u1.setUserparametersStatus((short) 0);
			b = userparametersprojectService.addTUserparameters(u1);
		} else {
			b = parametersprojectService.updateTParametersproject(u);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		int status = 1;
		if (b) {
			status = 0;
			map.put("msg", "");
		} else {
			status = 1;
			map.put("msg", "");
		}
		map.put("ret", status);
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addParametersData(JSONObject data) throws JSONException {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String s = data.toString();
		// s = TextUtility.toUTF8(s);
		TParametersAndData mTParametersAndData = gson.fromJson(s, new TypeToken<TParametersAndData>() {
		}.getType());
		List<TParametersdata> ulist= mTParametersAndData.getParameterlist();
		boolean b = false;
		@SuppressWarnings("unused")
		TParameters mTParameters = null;
		Map<String, Object> map = new HashMap<String, Object>();
		String ptime = TextUtility.formatDate(new Date());
		if(ulist == null || ulist.size() == 0){
			int status = 1;
			map.put("msg", "no data");
			map.put("ret", status);
		}else{
			if (mTParametersAndData.getParameter().getParametersId() == null) {
				mTParametersAndData.getParameter().setParametersTime(ptime);
				mTParametersAndData.getParameter().setParametersStatus(
						(short) 0);
				parametersService.addTParameters(mTParametersAndData
						.getParameter());
			}else{
				mTParametersAndData.getParameter().setParametersTime(ptime);
				parametersService.updateTParameters(mTParametersAndData
						.getParameter());
			}
			for (int i = 0; i < ulist.size(); i++) {
				TParametersdata u = ulist.get(i);
				u.setParametersdataTime(ptime);
				u.setParametersdataStatus((short) 0);
				if(u.getTParameters() ==null || u.getTParameters().getParametersId() == null){
					u.setTParameters(mTParametersAndData.getParameter());
				}
				if (u.getParametersdataId() == null) {
					b = parametersdataService.addTParametersdata(u);
				} else {
					b = parametersdataService.updateTParametersdata(u);
				}
			}

		int status = 1;
		if (b) {
			status = 0;
			map.put("msg", "");
		} else {
			status = 1;
			map.put("msg", "");
		}
		map.put("ret", status);
		}
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getQiNiu() {
		Map<String, Object> map = new HashMap<String, Object>();
		Config.ACCESS_KEY = "Vqr-78lW8vFdxG3YzjtwUM2AtaUSIwWL2COwH170";
		Config.SECRET_KEY = "xlKhu1U0zlKSeEg4S35lwZ6EHakJinfOgV8RAfrW";
		try {
			Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
			// 请确保该bucket已经存在
			String bucketName = "xchange";
			PutPolicy putPolicy = new PutPolicy(bucketName);
			String uptoken = putPolicy.token(mac);
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("uptoken", uptoken);
			map.put("data", map2);
			map.put("ret", 0);
			map.put("msg", "");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("ret", 1);
			map.put("msg", e.getMessage());
			map.put("data", "");
		}
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void senddefault() {
		Map<String, Object> map = new HashMap<String, Object>();
		String status = null;
		status = "1";
		map.put("data", "");
		map.put("ret", status);
		map.put("msg", "senddefault");
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CollectionsService getCollectionsService() {
		return collectionsService;
	}

	public void setCollectionsService(CollectionsService collectionsService) {
		this.collectionsService = collectionsService;
	}

	public CommentsService getCommentsService() {
		return commentsService;
	}

	public void setCommentsService(CommentsService commentsService) {
		this.commentsService = commentsService;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public CompanytypeService getCompanytypeService() {
		return companytypeService;
	}

	public void setCompanytypeService(CompanytypeService companytypeService) {
		this.companytypeService = companytypeService;
	}

	public CompanyusertypeService getCompanyusertypeService() {
		return companyusertypeService;
	}

	public void setCompanyusertypeService(
			CompanyusertypeService companyusertypeService) {
		this.companyusertypeService = companyusertypeService;
	}

	public DevicegpsService getDevicegpsService() {
		return devicegpsService;
	}

	public void setDevicegpsService(DevicegpsService devicegpsService) {
		this.devicegpsService = devicegpsService;
	}

	public DeviceService getDeviceService() {
		return deviceService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public IntegralService getIntegralService() {
		return integralService;
	}

	public void setIntegralService(IntegralService integralService) {
		this.integralService = integralService;
	}

	public MessagepushService getMessagepushService() {
		return messagepushService;
	}

	public void setMessagepushService(MessagepushService messagepushService) {
		this.messagepushService = messagepushService;
	}

	public MessagesService getMessagesService() {
		return messagesService;
	}

	public void setMessagesService(MessagesService messagesService) {
		this.messagesService = messagesService;
	}

	public MessagestypeService getMessagestypeService() {
		return messagestypeService;
	}

	public void setMessagestypeService(MessagestypeService messagestypeService) {
		this.messagestypeService = messagestypeService;
	}

	public ParametersService getParametersService() {
		return parametersService;
	}

	public void setParametersService(ParametersService parametersService) {
		this.parametersService = parametersService;
	}

	public UsercompanytypeService getUsercompanytypeService() {
		return usercompanytypeService;
	}

	public void setUsercompanytypeService(
			UsercompanytypeService usercompanytypeService) {
		this.usercompanytypeService = usercompanytypeService;
	}

	public UserdeviceService getUserdeviceService() {
		return userdeviceService;
	}

	public void setUserdeviceService(UserdeviceService userdeviceService) {
		this.userdeviceService = userdeviceService;
	}

	

	public UserparametersprojectService getUserparametersprojectService() {
		return userparametersprojectService;
	}

	public void setUserparametersprojectService(
			UserparametersprojectService userparametersprojectService) {
		this.userparametersprojectService = userparametersprojectService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Map<String, Object> getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(Map<String, Object> jsonResult) {
		this.jsonResult = jsonResult;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public ProducttypeService getProducttypeService() {
		return producttypeService;
	}

	public void setProducttypeService(ProducttypeService producttypeService) {
		this.producttypeService = producttypeService;
	}

	public RecruitmentresumeService getRecruitmentresumeService() {
		return recruitmentresumeService;
	}

	public void setRecruitmentresumeService(
			RecruitmentresumeService recruitmentresumeService) {
		this.recruitmentresumeService = recruitmentresumeService;
	}

	public RecruitmentService getRecruitmentService() {
		return recruitmentService;
	}

	public void setRecruitmentService(RecruitmentService recruitmentService) {
		this.recruitmentService = recruitmentService;
	}

	public ResumeService getResumeService() {
		return resumeService;
	}

	public void setResumeService(ResumeService resumeService) {
		this.resumeService = resumeService;
	}

	public ForjobService getForjobService() {
		return forjobService;
	}

	public void setForjobService(ForjobService forjobService) {
		this.forjobService = forjobService;
	}

	public ParametersnameService getParametersnameService() {
		return parametersnameService;
	}

	public void setParametersnameService(ParametersnameService parametersnameService) {
		this.parametersnameService = parametersnameService;
	}

	public ParametersdataService getParametersdataService() {
		return parametersdataService;
	}

	public void setParametersdataService(ParametersdataService parametersdataService) {
		this.parametersdataService = parametersdataService;
	}

	public ParametersprojectService getParametersprojectService() {
		return parametersprojectService;
	}

	public void setParametersprojectService(
			ParametersprojectService parametersprojectService) {
		this.parametersprojectService = parametersprojectService;
	}

}
