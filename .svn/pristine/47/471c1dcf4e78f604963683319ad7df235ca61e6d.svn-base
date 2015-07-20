package com.tjt.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * TProducttype entity. @author MyEclipse Persistence Tools
 */

public class TProducttype implements java.io.Serializable {

	// Fields
	@Expose
	private Integer producttypeId;
	@Expose
	private String producttypeName;
	@Expose
	private String producttypeTime;
	private Set TProducts = new HashSet(0);

	// Constructors

	/** default constructor */
	public TProducttype() {
	}

	/** minimal constructor */
	public TProducttype(String producttypeName, String producttypeTime) {
		this.producttypeName = producttypeName;
		this.producttypeTime = producttypeTime;
	}

	/** full constructor */
	public TProducttype(String producttypeName, String producttypeTime,
			Set TProducts) {
		this.producttypeName = producttypeName;
		this.producttypeTime = producttypeTime;
		this.TProducts = TProducts;
	}

	// Property accessors

	public Integer getProducttypeId() {
		return this.producttypeId;
	}

	public void setProducttypeId(Integer producttypeId) {
		this.producttypeId = producttypeId;
	}

	public String getProducttypeName() {
		return this.producttypeName;
	}

	public void setProducttypeName(String producttypeName) {
		this.producttypeName = producttypeName;
	}

	public String getProducttypeTime() {
		return this.producttypeTime;
	}

	public void setProducttypeTime(String producttypeTime) {
		this.producttypeTime = producttypeTime;
	}

	public Set getTProducts() {
		return this.TProducts;
	}

	public void setTProducts(Set TProducts) {
		this.TProducts = TProducts;
	}

}