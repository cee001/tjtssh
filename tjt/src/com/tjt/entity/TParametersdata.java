package com.tjt.entity;

import com.google.gson.annotations.Expose;

/**
 * TParametersdata entity. @author MyEclipse Persistence Tools
 */

public class TParametersdata implements java.io.Serializable {

	// Fields

	@Expose
	private Integer parametersdataId;
	@Expose
	private TParameters TParameters;
	@Expose
	private TUser TUser;
	@Expose
	private TParametersname TParametersname;
	@Expose
	private String parametersdataInfo;
	@Expose
	private String parametersdataTime;
	@Expose
	private Short parametersdataStatus;

	// Constructors

	/** default constructor */
	public TParametersdata() {
	}

	/** full constructor */
	public TParametersdata(TParameters TParameters, TUser TUser,
			TParametersname TParametersname, String parametersdataInfo,
			String parametersdataTime, Short parametersdataStatus) {
		this.TParameters = TParameters;
		this.TUser = TUser;
		this.TParametersname = TParametersname;
		this.parametersdataInfo = parametersdataInfo;
		this.parametersdataTime = parametersdataTime;
		this.parametersdataStatus = parametersdataStatus;
	}

	// Property accessors

	public Integer getParametersdataId() {
		return this.parametersdataId;
	}

	public void setParametersdataId(Integer parametersdataId) {
		this.parametersdataId = parametersdataId;
	}

	public TParameters getTParameters() {
		return this.TParameters;
	}

	public void setTParameters(TParameters TParameters) {
		this.TParameters = TParameters;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public TParametersname getTParametersname() {
		return this.TParametersname;
	}

	public void setTParametersname(TParametersname TParametersname) {
		this.TParametersname = TParametersname;
	}

	public String getParametersdataInfo() {
		return this.parametersdataInfo;
	}

	public void setParametersdataInfo(String parametersdataInfo) {
		this.parametersdataInfo = parametersdataInfo;
	}

	public String getParametersdataTime() {
		return this.parametersdataTime;
	}

	public void setParametersdataTime(String parametersdataTime) {
		this.parametersdataTime = parametersdataTime;
	}

	public Short getParametersdataStatus() {
		return this.parametersdataStatus;
	}

	public void setParametersdataStatus(Short parametersdataStatus) {
		this.parametersdataStatus = parametersdataStatus;
	}

}