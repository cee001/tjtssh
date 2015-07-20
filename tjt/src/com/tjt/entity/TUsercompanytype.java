package com.tjt.entity;

import com.google.gson.annotations.Expose;

/**
 * TUsercompanytype entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class TUsercompanytype implements java.io.Serializable {

	// Fields

	@Expose
	private Integer usercompanytypeId;
	@Expose
	private TCompany TCompany;
	@Expose
	private TCompanyusertype TCompanyusertype;
	@Expose
	private TUser TUser;	
	@Expose
	private String usercompanytypeTime;

	// Constructors

	/** default constructor */
	public TUsercompanytype() {
	}

	/** full constructor */
	public TUsercompanytype(TCompany TCompany,
			TCompanyusertype TCompanyusertype,TUser TUser,String usercompanytypeTime) {
		this.TCompany = TCompany;
		this.TCompanyusertype = TCompanyusertype;
		this.TUser = TUser;		
		this.usercompanytypeTime = usercompanytypeTime;
	}

	// Property accessors

	public Integer getUsercompanytypeId() {
		return this.usercompanytypeId;
	}

	public void setUsercompanytypeId(Integer usercompanytypeId) {
		this.usercompanytypeId = usercompanytypeId;
	}

	public TCompany getTCompany() {
		return this.TCompany;
	}

	public void setTCompany(TCompany TCompany) {
		this.TCompany = TCompany;
	}

	public TCompanyusertype getTCompanyusertype() {
		return this.TCompanyusertype;
	}

	public void setTCompanyusertype(TCompanyusertype TCompanyusertype) {
		this.TCompanyusertype = TCompanyusertype;
	}

	public TUser getTUser() {
		return TUser;
	}

	public void setTUser(TUser tUser) {
		TUser = tUser;
	}

	public String getUsercompanytypeTime() {
		return this.usercompanytypeTime;
	}

	public void setUsercompanytypeTime(String usercompanytypeTime) {
		this.usercompanytypeTime = usercompanytypeTime;
	}

}