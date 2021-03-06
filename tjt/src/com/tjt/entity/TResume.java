package com.tjt.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * TResume entity. @author MyEclipse Persistence Tools
 */

public class TResume implements java.io.Serializable {

	// Fields

	@Expose
	private Integer resumeId;
	@Expose
	private TUser TUser;
	@Expose
	private Boolean resumeSex;
	@Expose
	private Integer resumeBirthday;
	@Expose
	private String resumeWork;
	@Expose
	private String resumePhone;
	@Expose
	private String resumeCity;
	@Expose
	private String resumeInfo;
	@Expose
	private String resumeAnnex;
	@Expose
	private String resumeTime;
	@Expose
	private String resumeSalary;
	@Expose
	private String resumeEducation;
	@Expose
	private String resumeAge;
	private Set TRecruitmentresumes = new HashSet(0);
	private Set TForjobs = new HashSet(0);

	// Constructors

	/** default constructor */
	public TResume() {
	}

	/** minimal constructor */
	public TResume(TUser TUser, String resumeTime) {
		this.TUser = TUser;
		this.resumeTime = resumeTime;
	}

	/** full constructor */
	public TResume(TUser TUser, Boolean resumeSex, Integer resumeBirthday,
			String resumeWork, String resumePhone, String resumeCity,
			String resumeInfo, String resumeAnnex, String resumeTime,
			String resumeSalary, String resumeEducation, String resumeAge,
			Set TRecruitmentresumes, Set TForjobs) {
		this.TUser = TUser;
		this.resumeSex = resumeSex;
		this.resumeBirthday = resumeBirthday;
		this.resumeWork = resumeWork;
		this.resumePhone = resumePhone;
		this.resumeCity = resumeCity;
		this.resumeInfo = resumeInfo;
		this.resumeAnnex = resumeAnnex;
		this.resumeTime = resumeTime;
		this.resumeSalary = resumeSalary;
		this.resumeEducation = resumeEducation;
		this.resumeAge = resumeAge;
		this.TRecruitmentresumes = TRecruitmentresumes;
		this.TForjobs = TForjobs;
	}

	// Property accessors

	public Integer getResumeId() {
		return this.resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public Boolean getResumeSex() {
		return this.resumeSex;
	}

	public void setResumeSex(Boolean resumeSex) {
		this.resumeSex = resumeSex;
	}

	public Integer getResumeBirthday() {
		return this.resumeBirthday;
	}

	public void setResumeBirthday(Integer resumeBirthday) {
		this.resumeBirthday = resumeBirthday;
	}

	public String getResumeWork() {
		return this.resumeWork;
	}

	public void setResumeWork(String resumeWork) {
		this.resumeWork = resumeWork;
	}

	public String getResumePhone() {
		return this.resumePhone;
	}

	public void setResumePhone(String resumePhone) {
		this.resumePhone = resumePhone;
	}

	public String getResumeCity() {
		return this.resumeCity;
	}

	public void setResumeCity(String resumeCity) {
		this.resumeCity = resumeCity;
	}

	public String getResumeInfo() {
		return this.resumeInfo;
	}

	public void setResumeInfo(String resumeInfo) {
		this.resumeInfo = resumeInfo;
	}

	public String getResumeAnnex() {
		return this.resumeAnnex;
	}

	public void setResumeAnnex(String resumeAnnex) {
		this.resumeAnnex = resumeAnnex;
	}

	public String getResumeTime() {
		return this.resumeTime;
	}

	public void setResumeTime(String resumeTime) {
		this.resumeTime = resumeTime;
	}

	public String getResumeSalary() {
		return this.resumeSalary;
	}

	public void setResumeSalary(String resumeSalary) {
		this.resumeSalary = resumeSalary;
	}

	public String getResumeEducation() {
		return this.resumeEducation;
	}

	public void setResumeEducation(String resumeEducation) {
		this.resumeEducation = resumeEducation;
	}

	public String getResumeAge() {
		return this.resumeAge;
	}

	public void setResumeAge(String resumeAge) {
		this.resumeAge = resumeAge;
	}

	public Set getTRecruitmentresumes() {
		return this.TRecruitmentresumes;
	}

	public void setTRecruitmentresumes(Set TRecruitmentresumes) {
		this.TRecruitmentresumes = TRecruitmentresumes;
	}

	public Set getTForjobs() {
		return this.TForjobs;
	}

	public void setTForjobs(Set TForjobs) {
		this.TForjobs = TForjobs;
	}

}