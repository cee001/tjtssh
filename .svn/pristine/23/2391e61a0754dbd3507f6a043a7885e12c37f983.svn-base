package com.tjt.entity;

import com.google.gson.annotations.Expose;

/**
 * TUserdevice entity. @author MyEclipse Persistence Tools
 */

public class TUserdevice implements java.io.Serializable {

	// Fields

	@Expose
	private Integer userdeviceId;
	@Expose
	private TDevice TDevice;
	@Expose
	private TUser TUserByUsertoId;
	@Expose
	private TUser TUserByTouserId;
	@Expose
	private String userdeviceTime;
	@Expose
	private Short userdeviceStatus;

	// Constructors

	/** default constructor */
	public TUserdevice() {
	}

	/** full constructor */
	public TUserdevice(TDevice TDevice, TUser TUserByUsertoId,
			TUser TUserByTouserId, String userdeviceTime, Short userdeviceStatus) {
		this.TDevice = TDevice;
		this.TUserByUsertoId = TUserByUsertoId;
		this.TUserByTouserId = TUserByTouserId;
		this.userdeviceTime = userdeviceTime;
		this.userdeviceStatus = userdeviceStatus;
	}

	// Property accessors

	public Integer getUserdeviceId() {
		return this.userdeviceId;
	}

	public void setUserdeviceId(Integer userdeviceId) {
		this.userdeviceId = userdeviceId;
	}

	public TDevice getTDevice() {
		return this.TDevice;
	}

	public void setTDevice(TDevice TDevice) {
		this.TDevice = TDevice;
	}

	public TUser getTUserByUsertoId() {
		return this.TUserByUsertoId;
	}

	public void setTUserByUsertoId(TUser TUserByUsertoId) {
		this.TUserByUsertoId = TUserByUsertoId;
	}

	public TUser getTUserByTouserId() {
		return this.TUserByTouserId;
	}

	public void setTUserByTouserId(TUser TUserByTouserId) {
		this.TUserByTouserId = TUserByTouserId;
	}

	public String getUserdeviceTime() {
		return this.userdeviceTime;
	}

	public void setUserdeviceTime(String userdeviceTime) {
		this.userdeviceTime = userdeviceTime;
	}

	public Short getUserdeviceStatus() {
		return this.userdeviceStatus;
	}

	public void setUserdeviceStatus(Short userdeviceStatus) {
		this.userdeviceStatus = userdeviceStatus;
	}

}