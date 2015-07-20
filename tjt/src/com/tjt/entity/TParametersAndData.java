package com.tjt.entity;

import java.util.ArrayList;

/**
 * TParameters entity. @author MyEclipse Persistence Tools
 */

public class TParametersAndData implements java.io.Serializable {

	// Fields

	TParameters parameter;
	ArrayList<TParametersdata>  parameterlist;
	
	
	public TParameters getParameter() {
		return parameter;
	}
	public void setParameter(TParameters parameter) {
		this.parameter = parameter;
	}
	public ArrayList<TParametersdata> getParameterlist() {
		return parameterlist;
	}
	public void setParameterlist(ArrayList<TParametersdata> parameterlist) {
		this.parameterlist = parameterlist;
	}
	
	
	
}