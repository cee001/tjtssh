package com.tjt.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * TParametersname entity. @author MyEclipse Persistence Tools
 */

public class TParametersname implements java.io.Serializable {

	// Fields

	@Expose
	private Integer parametersnameId;
	@Expose
	private String parametersnameName;
	@Expose
	private String parametersnameTime;
	@Expose
	private Integer parametersnameType;
	@Expose
	private Integer parametersnameSequnce;
	private Set TParametersdatas = new HashSet(0);

	// Constructors

	/** default constructor */
	public TParametersname() {
	}

	/** minimal constructor */
	public TParametersname(String parametersnameName,
			String parametersnameTime, Integer parametersnameType,
			Integer parametersnameSequnce) {
		this.parametersnameName = parametersnameName;
		this.parametersnameTime = parametersnameTime;
		this.parametersnameType = parametersnameType;
		this.parametersnameSequnce = parametersnameSequnce;
	}

	/** full constructor */
	public TParametersname(String parametersnameName,
			String parametersnameTime, Integer parametersnameType,
			Integer parametersnameSequnce, Set TParametersdatas) {
		this.parametersnameName = parametersnameName;
		this.parametersnameTime = parametersnameTime;
		this.parametersnameType = parametersnameType;
		this.parametersnameSequnce = parametersnameSequnce;
		this.TParametersdatas = TParametersdatas;
	}

	// Property accessors

	public Integer getParametersnameId() {
		return this.parametersnameId;
	}

	public void setParametersnameId(Integer parametersnameId) {
		this.parametersnameId = parametersnameId;
	}

	public String getParametersnameName() {
		return this.parametersnameName;
	}

	public void setParametersnameName(String parametersnameName) {
		this.parametersnameName = parametersnameName;
	}

	public String getParametersnameTime() {
		return this.parametersnameTime;
	}

	public void setParametersnameTime(String parametersnameTime) {
		this.parametersnameTime = parametersnameTime;
	}

	public Integer getParametersnameType() {
		return this.parametersnameType;
	}

	public void setParametersnameType(Integer parametersnameType) {
		this.parametersnameType = parametersnameType;
	}

	public Integer getParametersnameSequnce() {
		return this.parametersnameSequnce;
	}

	public void setParametersnameSequnce(Integer parametersnameSequnce) {
		this.parametersnameSequnce = parametersnameSequnce;
	}

	public Set getTParametersdatas() {
		return this.TParametersdatas;
	}

	public void setTParametersdatas(Set TParametersdatas) {
		this.TParametersdatas = TParametersdatas;
	}

}