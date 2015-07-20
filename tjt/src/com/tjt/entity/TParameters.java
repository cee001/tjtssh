package com.tjt.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * TParameters entity. @author MyEclipse Persistence Tools
 */

public class TParameters implements java.io.Serializable {

	// Fields

	@Expose
	private Integer parametersId;
	@Expose
	private TUser TUser;
	@Expose
	private TParametersproject TParametersproject;
	@Expose
	private String parametersTime;
	@Expose
	private Short parametersStatus;
	private Set TParametersdatas = new HashSet(0);

	// Constructors

	/** default constructor */
	public TParameters() {
	}

	/** minimal constructor */
	public TParameters(TUser TUser, TParametersproject TParametersproject,
			String parametersTime, Short parametersStatus) {
		this.TUser = TUser;
		this.TParametersproject = TParametersproject;
		this.parametersTime = parametersTime;
		this.parametersStatus = parametersStatus;
	}

	/** full constructor */
	public TParameters(TUser TUser, TParametersproject TParametersproject,
			String parametersTime, Short parametersStatus, Set TParametersdatas) {
		this.TUser = TUser;
		this.TParametersproject = TParametersproject;
		this.parametersTime = parametersTime;
		this.parametersStatus = parametersStatus;
		this.TParametersdatas = TParametersdatas;
	}

	// Property accessors

	public Integer getParametersId() {
		return this.parametersId;
	}

	public void setParametersId(Integer parametersId) {
		this.parametersId = parametersId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public TParametersproject getTParametersproject() {
		return this.TParametersproject;
	}

	public void setTParametersproject(TParametersproject TParametersproject) {
		this.TParametersproject = TParametersproject;
	}

	public String getParametersTime() {
		return this.parametersTime;
	}

	public void setParametersTime(String parametersTime) {
		this.parametersTime = parametersTime;
	}

	public Short getParametersStatus() {
		return this.parametersStatus;
	}

	public void setParametersStatus(Short parametersStatus) {
		this.parametersStatus = parametersStatus;
	}

	public Set getTParametersdatas() {
		return this.TParametersdatas;
	}

	public void setTParametersdatas(Set TParametersdatas) {
		this.TParametersdatas = TParametersdatas;
	}

}