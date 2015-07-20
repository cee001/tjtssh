package com.tjt.entity;

import com.google.gson.annotations.Expose;

/**
 * TUserparametersroject entity. @author MyEclipse Persistence Tools
 */

public class TUserparametersroject implements java.io.Serializable {

	// Fields

	@Expose
	private Integer userparametersId;
	@Expose
	private TUser TUser;
	@Expose
	private TParametersproject TParametersproject;
	@Expose
	private String userparametersTime;
	private Short userparametersStatus;

	// Constructors

	/** default constructor */
	public TUserparametersroject() {
	}

	/** full constructor */
	public TUserparametersroject(TUser TUser,
			TParametersproject TParametersproject, String userparametersTime,
			Short userparametersStatus) {
		this.TUser = TUser;
		this.TParametersproject = TParametersproject;
		this.userparametersTime = userparametersTime;
		this.userparametersStatus = userparametersStatus;
	}

	// Property accessors

	public Integer getUserparametersId() {
		return this.userparametersId;
	}

	public void setUserparametersId(Integer userparametersId) {
		this.userparametersId = userparametersId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public TParametersproject getTParametersproject() {
		return this.TParametersproject;
	}

	public void setTParametersproject(TParametersproject TParametersproject) {
		this.TParametersproject = TParametersproject;
	}

	public String getUserparametersTime() {
		return this.userparametersTime;
	}

	public void setUserparametersTime(String userparametersTime) {
		this.userparametersTime = userparametersTime;
	}

	public Short getUserparametersStatus() {
		return this.userparametersStatus;
	}

	public void setUserparametersStatus(Short userparametersStatus) {
		this.userparametersStatus = userparametersStatus;
	}

}