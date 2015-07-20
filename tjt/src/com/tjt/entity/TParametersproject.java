package com.tjt.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * TParametersproject entity. @author MyEclipse Persistence Tools
 */

public class TParametersproject implements java.io.Serializable {

	// Fields

	@Expose
	private Integer parametersprojectId;
	@Expose
	private TUser TUser;
	@Expose
	private String parametersprojectTime;
	@Expose
	private String parametersprojectDevelopmentOrganization;
	@Expose
	private String parametersprojectCommissionedUnits;
	@Expose
	private String parametersprojectContractor;
	@Expose
	private String parametersprojectSupervisionUnits;
	@Expose
	private String parametersprojectDetectionUnit;
	@Expose
	private String parametersProjectName;
	@Expose
	private String parametersProjectNumber;
	@Expose
	private Short parametersProjectStatus;
	private Set TUserparametersrojects = new HashSet(0);
	private Set TParameterses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TParametersproject() {
	}

	/** minimal constructor */
	public TParametersproject(TUser TUser, String parametersprojectTime,
			String parametersprojectDevelopmentOrganization,
			Short parametersProjectStatus) {
		this.TUser = TUser;
		this.parametersprojectTime = parametersprojectTime;
		this.parametersprojectDevelopmentOrganization = parametersprojectDevelopmentOrganization;
		this.parametersProjectStatus = parametersProjectStatus;
	}

	/** full constructor */
	public TParametersproject(TUser TUser, String parametersprojectTime,
			String parametersprojectDevelopmentOrganization,
			String parametersprojectCommissionedUnits,
			String parametersprojectContractor,
			String parametersprojectSupervisionUnits,
			String parametersprojectDetectionUnit,
			String parametersProjectName, String parametersProjectNumber,
			Short parametersProjectStatus, Set TUserparametersrojects,
			Set TParameterses) {
		this.TUser = TUser;
		this.parametersprojectTime = parametersprojectTime;
		this.parametersprojectDevelopmentOrganization = parametersprojectDevelopmentOrganization;
		this.parametersprojectCommissionedUnits = parametersprojectCommissionedUnits;
		this.parametersprojectContractor = parametersprojectContractor;
		this.parametersprojectSupervisionUnits = parametersprojectSupervisionUnits;
		this.parametersprojectDetectionUnit = parametersprojectDetectionUnit;
		this.parametersProjectName = parametersProjectName;
		this.parametersProjectNumber = parametersProjectNumber;
		this.parametersProjectStatus = parametersProjectStatus;
		this.TUserparametersrojects = TUserparametersrojects;
		this.TParameterses = TParameterses;
	}

	// Property accessors

	public Integer getParametersprojectId() {
		return this.parametersprojectId;
	}

	public void setParametersprojectId(Integer parametersprojectId) {
		this.parametersprojectId = parametersprojectId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public String getParametersprojectTime() {
		return this.parametersprojectTime;
	}

	public void setParametersprojectTime(String parametersprojectTime) {
		this.parametersprojectTime = parametersprojectTime;
	}

	public String getParametersprojectDevelopmentOrganization() {
		return this.parametersprojectDevelopmentOrganization;
	}

	public void setParametersprojectDevelopmentOrganization(
			String parametersprojectDevelopmentOrganization) {
		this.parametersprojectDevelopmentOrganization = parametersprojectDevelopmentOrganization;
	}

	public String getParametersprojectCommissionedUnits() {
		return this.parametersprojectCommissionedUnits;
	}

	public void setParametersprojectCommissionedUnits(
			String parametersprojectCommissionedUnits) {
		this.parametersprojectCommissionedUnits = parametersprojectCommissionedUnits;
	}

	public String getParametersprojectContractor() {
		return this.parametersprojectContractor;
	}

	public void setParametersprojectContractor(
			String parametersprojectContractor) {
		this.parametersprojectContractor = parametersprojectContractor;
	}

	public String getParametersprojectSupervisionUnits() {
		return this.parametersprojectSupervisionUnits;
	}

	public void setParametersprojectSupervisionUnits(
			String parametersprojectSupervisionUnits) {
		this.parametersprojectSupervisionUnits = parametersprojectSupervisionUnits;
	}

	public String getParametersprojectDetectionUnit() {
		return this.parametersprojectDetectionUnit;
	}

	public void setParametersprojectDetectionUnit(
			String parametersprojectDetectionUnit) {
		this.parametersprojectDetectionUnit = parametersprojectDetectionUnit;
	}

	public String getParametersProjectName() {
		return this.parametersProjectName;
	}

	public void setParametersProjectName(String parametersProjectName) {
		this.parametersProjectName = parametersProjectName;
	}

	public String getParametersProjectNumber() {
		return this.parametersProjectNumber;
	}

	public void setParametersProjectNumber(String parametersProjectNumber) {
		this.parametersProjectNumber = parametersProjectNumber;
	}

	public Short getParametersProjectStatus() {
		return this.parametersProjectStatus;
	}

	public void setParametersProjectStatus(Short parametersProjectStatus) {
		this.parametersProjectStatus = parametersProjectStatus;
	}

	public Set getTUserparametersrojects() {
		return this.TUserparametersrojects;
	}

	public void setTUserparametersrojects(Set TUserparametersrojects) {
		this.TUserparametersrojects = TUserparametersrojects;
	}

	public Set getTParameterses() {
		return this.TParameterses;
	}

	public void setTParameterses(Set TParameterses) {
		this.TParameterses = TParameterses;
	}

}