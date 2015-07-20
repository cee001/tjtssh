package com.tjt.entity;

import com.google.gson.annotations.Expose;

/**
 * TIntegral entity. @author MyEclipse Persistence Tools
 */

public class TIntegral implements java.io.Serializable {

	// Fields

	private Integer integralId;
	@Expose
	private TUser TUser;
	@Expose
	private String integralInfo;
	@Expose
	private Integer integralSroce;
	@Expose
	private String integralTime;

	// Constructors

	/** default constructor */
	public TIntegral() {
	}

	/** full constructor */
	public TIntegral(TUser TUser, String integralInfo, Integer integralSroce,
			String integralTime) {
		this.TUser = TUser;
		this.integralInfo = integralInfo;
		this.integralSroce = integralSroce;
		this.integralTime = integralTime;
	}

	// Property accessors

	public Integer getIntegralId() {
		return this.integralId;
	}

	public void setIntegralId(Integer integralId) {
		this.integralId = integralId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public String getIntegralInfo() {
		return this.integralInfo;
	}

	public void setIntegralInfo(String integralInfo) {
		this.integralInfo = integralInfo;
	}

	public Integer getIntegralSroce() {
		return this.integralSroce;
	}

	public void setIntegralSroce(Integer integralSroce) {
		this.integralSroce = integralSroce;
	}

	public String getIntegralTime() {
		return this.integralTime;
	}

	public void setIntegralTime(String integralTime) {
		this.integralTime = integralTime;
	}

}