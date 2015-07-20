package com.tjt.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * TCompany entity. @author MyEclipse Persistence Tools
 */

public class TCompany implements java.io.Serializable {

	// Fields

	@Expose
	private Integer companyId;
	@Expose
	private TUser TUser;
	@Expose
	private TCompanytype TCompanytype;
	@Expose
	private String companyName;
	@Expose
	private String companyAddr;
	@Expose
	private String companyPhone;
	@Expose
	private String companyImg;
	@Expose
	private String companyCode;
	@Expose
	private String companyLicence;
	@Expose
	private String companyFaceimg;
	@Expose
	private String companyTime;
	@Expose
	private Short companyStatus;
	@Expose
	private String companyStatusdetil;
	private Set TDevices = new HashSet(0);
	private Set TProducts = new HashSet(0);
	private Set TUsercompanytypes = new HashSet(0);
	private Set TParameterses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TCompany() {
	}

	/** minimal constructor */
	public TCompany(TUser TUser, TCompanytype TCompanytype, String companyName,
			String companyAddr, String companyPhone, String companyImg,
			String companyCode, String companyLicence, String companyTime,
			Short companyStatus) {
		this.TUser = TUser;
		this.TCompanytype = TCompanytype;
		this.companyName = companyName;
		this.companyAddr = companyAddr;
		this.companyPhone = companyPhone;
		this.companyImg = companyImg;
		this.companyCode = companyCode;
		this.companyLicence = companyLicence;
		this.companyTime = companyTime;
		this.companyStatus = companyStatus;
	}

	/** full constructor */
	public TCompany(TUser TUser, TCompanytype TCompanytype, String companyName,
			String companyAddr, String companyPhone, String companyImg,
			String companyCode, String companyLicence, String companyFaceimg,
			String companyTime, Short companyStatus, String companyStatusdetil,
			Set TDevices, Set TProducts, Set TUsercompanytypes,
			Set TParameterses) {
		this.TUser = TUser;
		this.TCompanytype = TCompanytype;
		this.companyName = companyName;
		this.companyAddr = companyAddr;
		this.companyPhone = companyPhone;
		this.companyImg = companyImg;
		this.companyCode = companyCode;
		this.companyLicence = companyLicence;
		this.companyFaceimg = companyFaceimg;
		this.companyTime = companyTime;
		this.companyStatus = companyStatus;
		this.companyStatusdetil = companyStatusdetil;
		this.TDevices = TDevices;
		this.TProducts = TProducts;
		this.TUsercompanytypes = TUsercompanytypes;
		this.TParameterses = TParameterses;
	}

	// Property accessors

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public TCompanytype getTCompanytype() {
		return this.TCompanytype;
	}

	public void setTCompanytype(TCompanytype TCompanytype) {
		this.TCompanytype = TCompanytype;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddr() {
		return this.companyAddr;
	}

	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}

	public String getCompanyPhone() {
		return this.companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getCompanyImg() {
		return this.companyImg;
	}

	public void setCompanyImg(String companyImg) {
		this.companyImg = companyImg;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyLicence() {
		return this.companyLicence;
	}

	public void setCompanyLicence(String companyLicence) {
		this.companyLicence = companyLicence;
	}

	public String getCompanyFaceimg() {
		return this.companyFaceimg;
	}

	public void setCompanyFaceimg(String companyFaceimg) {
		this.companyFaceimg = companyFaceimg;
	}

	public String getCompanyTime() {
		return this.companyTime;
	}

	public void setCompanyTime(String companyTime) {
		this.companyTime = companyTime;
	}

	public Short getCompanyStatus() {
		return this.companyStatus;
	}

	public void setCompanyStatus(Short companyStatus) {
		this.companyStatus = companyStatus;
	}

	public String getCompanyStatusdetil() {
		return this.companyStatusdetil;
	}

	public void setCompanyStatusdetil(String companyStatusdetil) {
		this.companyStatusdetil = companyStatusdetil;
	}

	public Set getTDevices() {
		return this.TDevices;
	}

	public void setTDevices(Set TDevices) {
		this.TDevices = TDevices;
	}

	public Set getTProducts() {
		return this.TProducts;
	}

	public void setTProducts(Set TProducts) {
		this.TProducts = TProducts;
	}

	public Set getTUsercompanytypes() {
		return this.TUsercompanytypes;
	}

	public void setTUsercompanytypes(Set TUsercompanytypes) {
		this.TUsercompanytypes = TUsercompanytypes;
	}

	public Set getTParameterses() {
		return this.TParameterses;
	}

	public void setTParameterses(Set TParameterses) {
		this.TParameterses = TParameterses;
	}

}