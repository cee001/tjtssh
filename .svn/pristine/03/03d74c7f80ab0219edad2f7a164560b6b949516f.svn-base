package com.tjt.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * TCompanyusertype entity. @author MyEclipse Persistence Tools
 */

public class TCompanyusertype implements java.io.Serializable {

	// Fields

	private Integer companyusertypeId;
	@Expose
	private TCompanytype TCompanytype;
	@Expose
	private String companyusertypeName;
	@Expose
	private String companyusertypeTime;
	@Expose
	private Integer companyusertypeAuthority;
	private Set TUsercompanytypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public TCompanyusertype() {
	}

	/** minimal constructor */
	public TCompanyusertype(TCompanytype TCompanytype,
			String companyusertypeName, String companyusertypeTime,
			Integer companyusertypeAuthority) {
		this.TCompanytype = TCompanytype;
		this.companyusertypeName = companyusertypeName;
		this.companyusertypeTime = companyusertypeTime;
		this.companyusertypeAuthority = companyusertypeAuthority;
	}

	/** full constructor */
	public TCompanyusertype(TCompanytype TCompanytype,
			String companyusertypeName, String companyusertypeTime,
			Integer companyusertypeAuthority, Set TUsercompanytypes) {
		this.TCompanytype = TCompanytype;
		this.companyusertypeName = companyusertypeName;
		this.companyusertypeTime = companyusertypeTime;
		this.companyusertypeAuthority = companyusertypeAuthority;
		this.TUsercompanytypes = TUsercompanytypes;
	}

	// Property accessors

	public Integer getCompanyusertypeId() {
		return this.companyusertypeId;
	}

	public void setCompanyusertypeId(Integer companyusertypeId) {
		this.companyusertypeId = companyusertypeId;
	}

	public TCompanytype getTCompanytype() {
		return this.TCompanytype;
	}

	public void setTCompanytype(TCompanytype TCompanytype) {
		this.TCompanytype = TCompanytype;
	}

	public String getCompanyusertypeName() {
		return this.companyusertypeName;
	}

	public void setCompanyusertypeName(String companyusertypeName) {
		this.companyusertypeName = companyusertypeName;
	}

	public String getCompanyusertypeTime() {
		return this.companyusertypeTime;
	}

	public void setCompanyusertypeTime(String companyusertypeTime) {
		this.companyusertypeTime = companyusertypeTime;
	}

	public Integer getCompanyusertypeAuthority() {
		return this.companyusertypeAuthority;
	}

	public void setCompanyusertypeAuthority(Integer companyusertypeAuthority) {
		this.companyusertypeAuthority = companyusertypeAuthority;
	}

	public Set getTUsercompanytypes() {
		return this.TUsercompanytypes;
	}

	public void setTUsercompanytypes(Set TUsercompanytypes) {
		this.TUsercompanytypes = TUsercompanytypes;
	}

}