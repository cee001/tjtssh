package com.tjt.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * TDevice entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class TDevice implements java.io.Serializable {

	// Fields

	@Expose
	private Integer deviceId;
	@Expose
	private TUser TUserByUserId;
	@Expose
	private TCompany TCompany;
	@Expose
	private TUser TUserByCreateuserId;
	@Expose
	private String deviceName;
	@Expose
	private String deviceTime;
	@Expose
	private Short deviceStatus;
	@Expose
	private String deviceFirsttime;
	@Expose
	private Short deviceUsing;
	
	@Expose
	private String deviceFaceimg;
	private Set TDevicegpses = new HashSet(0);
	private Set TUserdevices = new HashSet(0);

	// Constructors

	/** default constructor */
	public TDevice() {
	}

	/** minimal constructor */
	public TDevice(TUser TUserByUserId, TCompany TCompany,
			TUser TUserByCreateuserId, String deviceName, String deviceTime,
			Short deviceStatus, String deviceFirsttime, Short deviceUsing,
			String deviceFaceimg) {
		this.TUserByUserId = TUserByUserId;
		this.TCompany = TCompany;
		this.TUserByCreateuserId = TUserByCreateuserId;
		this.deviceName = deviceName;
		this.deviceTime = deviceTime;
		this.deviceStatus = deviceStatus;
		this.deviceFirsttime = deviceFirsttime;
		this.deviceUsing = deviceUsing;
		this.deviceFaceimg = deviceFaceimg;

	}

	/** full constructor */
	public TDevice(TUser TUserByUserId, TCompany TCompany,
			TUser TUserByCreateuserId, String deviceName, String deviceTime,
			Short deviceStatus, String deviceFirsttime, Short deviceUsing,
			String deviceFaceimg,Set TDevicegpses, Set TUserdevices) {
		this.TUserByUserId = TUserByUserId;
		this.TCompany = TCompany;
		this.TUserByCreateuserId = TUserByCreateuserId;
		this.deviceName = deviceName;
		this.deviceTime = deviceTime;
		this.deviceStatus = deviceStatus;
		this.deviceFirsttime = deviceFirsttime;
		this.deviceUsing = deviceUsing;
		this.deviceFaceimg = deviceFaceimg;

		this.TDevicegpses = TDevicegpses;
		this.TUserdevices = TUserdevices;
	}

	// Property accessors

	public Integer getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public TUser getTUserByUserId() {
		return this.TUserByUserId;
	}

	public void setTUserByUserId(TUser TUserByUserId) {
		this.TUserByUserId = TUserByUserId;
	}

	public TCompany getTCompany() {
		return this.TCompany;
	}

	public void setTCompany(TCompany TCompany) {
		this.TCompany = TCompany;
	}

	public TUser getTUserByCreateuserId() {
		return this.TUserByCreateuserId;
	}

	public void setTUserByCreateuserId(TUser TUserByCreateuserId) {
		this.TUserByCreateuserId = TUserByCreateuserId;
	}

	public String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceTime() {
		return this.deviceTime;
	}

	public void setDeviceTime(String deviceTime) {
		this.deviceTime = deviceTime;
	}

	public Short getDeviceStatus() {
		return this.deviceStatus;
	}

	public void setDeviceStatus(Short deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public String getDeviceFirsttime() {
		return this.deviceFirsttime;
	}

	public void setDeviceFirsttime(String deviceFirsttime) {
		this.deviceFirsttime = deviceFirsttime;
	}

	public Short getDeviceUsing() {
		return this.deviceUsing;
	}

	public void setDeviceUsing(Short deviceUsing) {
		this.deviceUsing = deviceUsing;
	}

	public String getDeviceFaceimg() {
		return this.deviceFaceimg;
	}

	public void setDeviceFaceimg(String deviceFaceimg) {
		this.deviceFaceimg = deviceFaceimg;
	}

	public Set getTDevicegpses() {
		return this.TDevicegpses;
	}

	public void setTDevicegpses(Set TDevicegpses) {
		this.TDevicegpses = TDevicegpses;
	}

	public Set getTUserdevices() {
		return this.TUserdevices;
	}

	public void setTUserdevices(Set TUserdevices) {
		this.TUserdevices = TUserdevices;
	}


}