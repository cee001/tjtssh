package com.tjt.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * TCompanytype entity. @author MyEclipse Persistence Tools
 */

public class TCompanytype implements java.io.Serializable {

	// Fields

	@Expose
	private Integer companytypeId;	
	@Expose
	private String companytypeName;
	@Expose
	private String companytypeTime;
	@Expose
	private Integer companytypeSequnce;
	@Expose
	private String companytypeImg;
	private Set TCompanies = new HashSet(0);
	private Set TCompanyusertypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public TCompanytype() {
	}

	/** minimal constructor */
	public TCompanytype(String companytypeName, String companytypeTime,
			Integer companytypeSequnce) {
		this.companytypeName = companytypeName;
		this.companytypeTime = companytypeTime;
		this.companytypeSequnce = companytypeSequnce;
	}

	/** full constructor */
	public TCompanytype(String companytypeName, String companytypeTime,
			Integer companytypeSequnce, String companytypeImg, Set TCompanies,
			Set TCompanyusertypes) {
		this.companytypeName = companytypeName;
		this.companytypeTime = companytypeTime;
		this.companytypeSequnce = companytypeSequnce;
		this.companytypeImg = companytypeImg;
		this.TCompanies = TCompanies;
		this.TCompanyusertypes = TCompanyusertypes;
	}

	// Property accessors

	public Integer getCompanytypeId() {
		return this.companytypeId;
	}

	public void setCompanytypeId(Integer companytypeId) {
		this.companytypeId = companytypeId;
	}

	public String getCompanytypeName() {
		return this.companytypeName;
	}

	public void setCompanytypeName(String companytypeName) {
		this.companytypeName = companytypeName;
	}

	public String getCompanytypeTime() {
		return this.companytypeTime;
	}

	public void setCompanytypeTime(String companytypeTime) {
		this.companytypeTime = companytypeTime;
	}

	public Integer getCompanytypeSequnce() {
		return this.companytypeSequnce;
	}

	public void setCompanytypeSequnce(Integer companytypeSequnce) {
		this.companytypeSequnce = companytypeSequnce;
	}

	public String getCompanytypeImg() {
		return this.companytypeImg;
	}

	public void setCompanytypeImg(String companytypeImg) {
		this.companytypeImg = companytypeImg;
	}

	public Set getTCompanies() {
		return this.TCompanies;
	}

	public void setTCompanies(Set TCompanies) {
		this.TCompanies = TCompanies;
	}

	public Set getTCompanyusertypes() {
		return this.TCompanyusertypes;
	}

	public void setTCompanyusertypes(Set TCompanyusertypes) {
		this.TCompanyusertypes = TCompanyusertypes;
	}

}