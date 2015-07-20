package com.tjt.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class TUser implements java.io.Serializable {

	// Fields

	@Expose
	private Integer userId;
	@Expose
	private String userPhone;
	private String userPassword;
	@Expose
	private String userNikename;
	@Expose
	private String userTime;
	@Expose
	private Short userStatus;
	@Expose
	private String userImgface;
	@Expose
	private String userTruename;
	@Expose
	private String userAddress;
	@Expose
	private String userCity;
	@Expose
	private Boolean userSex;
	@Expose
	private String userProfession;
	@Expose
	private String userWork;
	@Expose
	private String userCompany;
	@Expose
	private Short userCompanyStatus;
	private Set TCommentses = new HashSet(0);
	private Set TUsercompanytypes = new HashSet(0);
	private Set TDevicegpses = new HashSet(0);
	private Set TCompanies = new HashSet(0);
	private Set TParameterses = new HashSet(0);
	private Set TUserparametersrojects = new HashSet(0);
	private Set TDevicesForUserId = new HashSet(0);
	private Set TUserdevicesForUsertoId = new HashSet(0);
	private Set TUserdevicesForTouserId = new HashSet(0);
	private Set TResumes = new HashSet(0);
	private Set TMessagepushs = new HashSet(0);
	private Set TDevicesForCreateuserId = new HashSet(0);
	private Set TMessageses = new HashSet(0);
	private Set TParametersdatas = new HashSet(0);
	private Set TIntegrals = new HashSet(0);
	private Set TRecruitments = new HashSet(0);
	private Set TParametersprojects = new HashSet(0);
	private Set TUsergpses = new HashSet(0);
	private Set TDownloads = new HashSet(0);
	private Set TCollectionses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(String userPhone, String userPassword, String userNikename,
			String userTime, Short userStatus, Short userCompanyStatus) {
		this.userPhone = userPhone;
		this.userPassword = userPassword;
		this.userNikename = userNikename;
		this.userTime = userTime;
		this.userStatus = userStatus;
		this.userCompanyStatus = userCompanyStatus;
	}

	/** full constructor */
	public TUser(String userPhone, String userPassword, String userNikename,
			String userTime, Short userStatus, String userImgface,
			String userTruename, String userAddress, String userCity,
			Boolean userSex, String userProfession, String userWork,
			String userCompany, Short userCompanyStatus, Set TCommentses,
			Set TUsercompanytypes, Set TDevicegpses, Set TCompanies,
			Set TParameterses, Set TUserparametersrojects,
			Set TDevicesForUserId, Set TUserdevicesForUsertoId,
			Set TUserdevicesForTouserId, Set TResumes, Set TMessagepushs,
			Set TDevicesForCreateuserId, Set TMessageses, Set TParametersdatas,
			Set TRecruitments, Set TIntegrals, Set TParametersprojects,
			Set TUsergpses, Set TDownloads, Set TCollectionses) {
		this.userPhone = userPhone;
		this.userPassword = userPassword;
		this.userNikename = userNikename;
		this.userTime = userTime;
		this.userStatus = userStatus;
		this.userImgface = userImgface;
		this.userTruename = userTruename;
		this.userAddress = userAddress;
		this.userCity = userCity;
		this.userSex = userSex;
		this.userProfession = userProfession;
		this.userWork = userWork;
		this.userCompany = userCompany;
		this.userCompanyStatus = userCompanyStatus;
		this.TCommentses = TCommentses;
		this.TUsercompanytypes = TUsercompanytypes;
		this.TDevicegpses = TDevicegpses;
		this.TCompanies = TCompanies;
		this.TParameterses = TParameterses;
		this.TUserparametersrojects = TUserparametersrojects;
		this.TDevicesForUserId = TDevicesForUserId;
		this.TUserdevicesForUsertoId = TUserdevicesForUsertoId;
		this.TUserdevicesForTouserId = TUserdevicesForTouserId;
		this.TResumes = TResumes;
		this.TMessagepushs = TMessagepushs;
		this.TDevicesForCreateuserId = TDevicesForCreateuserId;
		this.TMessageses = TMessageses;
		this.TParametersdatas = TParametersdatas;
		this.TRecruitments = TRecruitments;
		this.TIntegrals = TIntegrals;
		this.TParametersprojects = TParametersprojects;
		this.TUsergpses = TUsergpses;
		this.TDownloads = TDownloads;
		this.TCollectionses = TCollectionses;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserNikename() {
		return this.userNikename;
	}

	public void setUserNikename(String userNikename) {
		this.userNikename = userNikename;
	}

	public String getUserTime() {
		return this.userTime;
	}

	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}

	public Short getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Short userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserImgface() {
		return this.userImgface;
	}

	public void setUserImgface(String userImgface) {
		this.userImgface = userImgface;
	}

	public String getUserTruename() {
		return this.userTruename;
	}

	public void setUserTruename(String userTruename) {
		this.userTruename = userTruename;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserCity() {
		return this.userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public Boolean getUserSex() {
		return this.userSex;
	}

	public void setUserSex(Boolean userSex) {
		this.userSex = userSex;
	}

	public String getUserProfession() {
		return this.userProfession;
	}

	public void setUserProfession(String userProfession) {
		this.userProfession = userProfession;
	}

	public String getUserWork() {
		return this.userWork;
	}

	public void setUserWork(String userWork) {
		this.userWork = userWork;
	}

	public String getUserCompany() {
		return this.userCompany;
	}

	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}

	public Short getUserCompanyStatus() {
		return this.userCompanyStatus;
	}

	public void setUserCompanyStatus(Short userCompanyStatus) {
		this.userCompanyStatus = userCompanyStatus;
	}

	public Set getTCommentses() {
		return this.TCommentses;
	}

	public void setTCommentses(Set TCommentses) {
		this.TCommentses = TCommentses;
	}

	public Set getTUsercompanytypes() {
		return this.TUsercompanytypes;
	}

	public void setTUsercompanytypes(Set TUsercompanytypes) {
		this.TUsercompanytypes = TUsercompanytypes;
	}

	public Set getTDevicegpses() {
		return this.TDevicegpses;
	}

	public void setTDevicegpses(Set TDevicegpses) {
		this.TDevicegpses = TDevicegpses;
	}

	public Set getTCompanies() {
		return this.TCompanies;
	}

	public void setTCompanies(Set TCompanies) {
		this.TCompanies = TCompanies;
	}

	public Set getTParameterses() {
		return this.TParameterses;
	}

	public void setTParameterses(Set TParameterses) {
		this.TParameterses = TParameterses;
	}

	public Set getTUserparametersrojects() {
		return this.TUserparametersrojects;
	}

	public void setTUserparametersrojects(Set TUserparametersrojects) {
		this.TUserparametersrojects = TUserparametersrojects;
	}

	public Set getTDevicesForUserId() {
		return this.TDevicesForUserId;
	}

	public void setTDevicesForUserId(Set TDevicesForUserId) {
		this.TDevicesForUserId = TDevicesForUserId;
	}

	public Set getTUserdevicesForUsertoId() {
		return this.TUserdevicesForUsertoId;
	}

	public void setTUserdevicesForUsertoId(Set TUserdevicesForUsertoId) {
		this.TUserdevicesForUsertoId = TUserdevicesForUsertoId;
	}

	public Set getTUserdevicesForTouserId() {
		return this.TUserdevicesForTouserId;
	}

	public void setTUserdevicesForTouserId(Set TUserdevicesForTouserId) {
		this.TUserdevicesForTouserId = TUserdevicesForTouserId;
	}

	public Set getTMessagepushs() {
		return this.TMessagepushs;
	}

	public void setTMessagepushs(Set TMessagepushs) {
		this.TMessagepushs = TMessagepushs;
	}

	public Set getTResumes() {
		return this.TResumes;
	}

	public void setTResumes(Set TResumes) {
		this.TResumes = TResumes;
	}

	public Set getTDevicesForCreateuserId() {
		return this.TDevicesForCreateuserId;
	}

	public void setTDevicesForCreateuserId(Set TDevicesForCreateuserId) {
		this.TDevicesForCreateuserId = TDevicesForCreateuserId;
	}

	public Set getTMessageses() {
		return this.TMessageses;
	}

	public void setTMessageses(Set TMessageses) {
		this.TMessageses = TMessageses;
	}

	public Set getTParametersdatas() {
		return this.TParametersdatas;
	}

	public void setTParametersdatas(Set TParametersdatas) {
		this.TParametersdatas = TParametersdatas;
	}

	public Set getTIntegrals() {
		return this.TIntegrals;
	}

	public void setTIntegrals(Set TIntegrals) {
		this.TIntegrals = TIntegrals;
	}

	public Set getTRecruitments() {
		return this.TRecruitments;
	}

	public void setTRecruitments(Set TRecruitments) {
		this.TRecruitments = TRecruitments;
	}

	public Set getTParametersprojects() {
		return this.TParametersprojects;
	}

	public void setTParametersprojects(Set TParametersprojects) {
		this.TParametersprojects = TParametersprojects;
	}

	public Set getTUsergpses() {
		return this.TUsergpses;
	}

	public void setTUsergpses(Set TUsergpses) {
		this.TUsergpses = TUsergpses;
	}

	public Set getTDownloads() {
		return this.TDownloads;
	}

	public void setTDownloads(Set TDownloads) {
		this.TDownloads = TDownloads;
	}

	public Set getTCollectionses() {
		return this.TCollectionses;
	}

	public void setTCollectionses(Set TCollectionses) {
		this.TCollectionses = TCollectionses;
	}

}