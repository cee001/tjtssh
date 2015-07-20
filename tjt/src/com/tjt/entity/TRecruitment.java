package com.tjt.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * TRecruitment entity. @author MyEclipse Persistence Tools
 */

public class TRecruitment implements java.io.Serializable {

	// Fields

	@Expose
	private Integer recruitmentId;
	@Expose
	private TUser TUser;
	@Expose
	private String recruitmentTittle;
	@Expose
	private Integer recruitmentPeoplenum;
	@Expose
	private String recruitmentEducation;
	@Expose
	private String recruitmentWorkexperience;
	@Expose
	private Boolean recruitmentSex;
	@Expose
	private String recruitmentAge;
	@Expose
	private String recruitmentSalary;
	@Expose
	private String recruitmentInfo;
	@Expose
	private String recruitmentPosition;
	@Expose
	private Short recruitmentStatus;
	@Expose
	private Integer recruitmentCollectnum;
	@Expose
	private String recruitmentTime;
	@Expose
	private String recruitmentCity;
	@Expose
	private String recruitmentArea;	
	private Set TRecruitmentresumes = new HashSet(0);

	// Constructors

	/** default constructor */
	public TRecruitment() {
	}

	/** minimal constructor */
	public TRecruitment(TUser TUser, String recruitmentTittle,
			Integer recruitmentPeoplenum, String recruitmentEducation,
			String recruitmentWorkexperience, Boolean recruitmentSex,
			String recruitmentAge, String recruitmentSalary,
			String recruitmentInfo, String recruitmentPosition,
			Short recruitmentStatus, Integer recruitmentCollectnum,
			String recruitmentTime, String recruitmentCity,String recruitmentArea) {
		this.TUser = TUser;
		this.recruitmentTittle = recruitmentTittle;
		this.recruitmentPeoplenum = recruitmentPeoplenum;
		this.recruitmentEducation = recruitmentEducation;
		this.recruitmentWorkexperience = recruitmentWorkexperience;
		this.recruitmentSex = recruitmentSex;
		this.recruitmentAge = recruitmentAge;
		this.recruitmentSalary = recruitmentSalary;
		this.recruitmentInfo = recruitmentInfo;
		this.recruitmentPosition = recruitmentPosition;
		this.recruitmentStatus = recruitmentStatus;
		this.recruitmentCollectnum = recruitmentCollectnum;
		this.recruitmentTime = recruitmentTime;
		this.recruitmentCity = recruitmentCity;
		this.recruitmentArea= recruitmentArea;		
	}

	/** full constructor */
	public TRecruitment(TUser TUser, String recruitmentTittle,
			Integer recruitmentPeoplenum, String recruitmentEducation,
			String recruitmentWorkexperience, Boolean recruitmentSex,
			String recruitmentAge, String recruitmentSalary,
			String recruitmentInfo, String recruitmentPosition,
			Short recruitmentStatus, Integer recruitmentCollectnum,
			String recruitmentTime, String recruitmentCity,String recruitmentArea,
			Set TRecruitmentresumes) {
		this.TUser = TUser;
		this.recruitmentTittle = recruitmentTittle;
		this.recruitmentPeoplenum = recruitmentPeoplenum;
		this.recruitmentEducation = recruitmentEducation;
		this.recruitmentWorkexperience = recruitmentWorkexperience;
		this.recruitmentSex = recruitmentSex;
		this.recruitmentAge = recruitmentAge;
		this.recruitmentSalary = recruitmentSalary;
		this.recruitmentInfo = recruitmentInfo;
		this.recruitmentPosition = recruitmentPosition;
		this.recruitmentStatus = recruitmentStatus;
		this.recruitmentCollectnum = recruitmentCollectnum;
		this.recruitmentTime = recruitmentTime;
		this.recruitmentCity = recruitmentCity;
		this.recruitmentArea= recruitmentArea;
		this.TRecruitmentresumes = TRecruitmentresumes;
	}

	// Property accessors

	public Integer getRecruitmentId() {
		return this.recruitmentId;
	}

	public void setRecruitmentId(Integer recruitmentId) {
		this.recruitmentId = recruitmentId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public String getRecruitmentTittle() {
		return this.recruitmentTittle;
	}

	public void setRecruitmentTittle(String recruitmentTittle) {
		this.recruitmentTittle = recruitmentTittle;
	}

	public Integer getRecruitmentPeoplenum() {
		return this.recruitmentPeoplenum;
	}

	public void setRecruitmentPeoplenum(Integer recruitmentPeoplenum) {
		this.recruitmentPeoplenum = recruitmentPeoplenum;
	}

	public String getRecruitmentEducation() {
		return this.recruitmentEducation;
	}

	public void setRecruitmentEducation(String recruitmentEducation) {
		this.recruitmentEducation = recruitmentEducation;
	}

	public String getRecruitmentWorkexperience() {
		return this.recruitmentWorkexperience;
	}

	public void setRecruitmentWorkexperience(String recruitmentWorkexperience) {
		this.recruitmentWorkexperience = recruitmentWorkexperience;
	}

	public Boolean getRecruitmentSex() {
		return this.recruitmentSex;
	}

	public void setRecruitmentSex(Boolean recruitmentSex) {
		this.recruitmentSex = recruitmentSex;
	}

	public String getRecruitmentAge() {
		return this.recruitmentAge;
	}

	public void setRecruitmentAge(String recruitmentAge) {
		this.recruitmentAge = recruitmentAge;
	}

	public String getRecruitmentSalary() {
		return this.recruitmentSalary;
	}

	public void setRecruitmentSalary(String recruitmentSalary) {
		this.recruitmentSalary = recruitmentSalary;
	}

	public String getRecruitmentInfo() {
		return this.recruitmentInfo;
	}

	public void setRecruitmentInfo(String recruitmentInfo) {
		this.recruitmentInfo = recruitmentInfo;
	}

	public String getRecruitmentPosition() {
		return this.recruitmentPosition;
	}

	public void setRecruitmentPosition(String recruitmentPosition) {
		this.recruitmentPosition = recruitmentPosition;
	}

	public Short getRecruitmentStatus() {
		return this.recruitmentStatus;
	}

	public void setRecruitmentStatus(Short recruitmentStatus) {
		this.recruitmentStatus = recruitmentStatus;
	}

	public Integer getRecruitmentCollectnum() {
		return this.recruitmentCollectnum;
	}

	public void setRecruitmentCollectnum(Integer recruitmentCollectnum) {
		this.recruitmentCollectnum = recruitmentCollectnum;
	}

	public String getRecruitmentTime() {
		return this.recruitmentTime;
	}

	public void setRecruitmentTime(String recruitmentTime) {
		this.recruitmentTime = recruitmentTime;
	}

	public String getRecruitmentCity() {
		return this.recruitmentCity;
	}

	public void setRecruitmentCity(String recruitmentCity) {
		this.recruitmentCity = recruitmentCity;
	}

	public Set getTRecruitmentresumes() {
		return this.TRecruitmentresumes;
	}

	public void setTRecruitmentresumes(Set TRecruitmentresumes) {
		this.TRecruitmentresumes = TRecruitmentresumes;
	}

	public String getRecruitmentArea() {
		return recruitmentArea;
	}

	public void setRecruitmentArea(String recruitmentArea) {
		this.recruitmentArea = recruitmentArea;
	}

}