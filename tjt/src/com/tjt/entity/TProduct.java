package com.tjt.entity;

import com.google.gson.annotations.Expose;

/**
 * TProduct entity. @author MyEclipse Persistence Tools
 */

public class TProduct implements java.io.Serializable {

	// Fields
	@Expose
	private Integer productId;
	@Expose
	private TCompany TCompany;
	@Expose
	private TProducttype TProducttype;
	@Expose
	private String productName;
	@Expose
	private String productInfo;
	@Expose
	private String productImgsrcs;
	@Expose
	private String productUrl;
	@Expose
	private Float productPrice;
	@Expose
	private String productTime;
	@Expose
	private Short productStatus;

	// Constructors

	/** default constructor */
	public TProduct() {
	}

	/** minimal constructor */
	public TProduct(TCompany TCompany, TProducttype TProducttype,
			String productName, String productInfo, String productImgsrcs,
			Float productPrice, String productTime, Short productStatus) {
		this.TCompany = TCompany;
		this.TProducttype = TProducttype;
		this.productName = productName;
		this.productInfo = productInfo;
		this.productImgsrcs = productImgsrcs;
		this.productPrice = productPrice;
		this.productTime = productTime;
		this.productStatus = productStatus;
	}

	/** full constructor */
	public TProduct(TCompany TCompany, TProducttype TProducttype,
			String productName, String productInfo, String productImgsrcs,
			String productUrl, Float productPrice, String productTime,
			Short productStatus) {
		this.TCompany = TCompany;
		this.TProducttype = TProducttype;
		this.productName = productName;
		this.productInfo = productInfo;
		this.productImgsrcs = productImgsrcs;
		this.productUrl = productUrl;
		this.productPrice = productPrice;
		this.productTime = productTime;
		this.productStatus = productStatus;
	}

	// Property accessors

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public TCompany getTCompany() {
		return this.TCompany;
	}

	public void setTCompany(TCompany TCompany) {
		this.TCompany = TCompany;
	}

	public TProducttype getTProducttype() {
		return this.TProducttype;
	}

	public void setTProducttype(TProducttype TProducttype) {
		this.TProducttype = TProducttype;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductInfo() {
		return this.productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public String getProductImgsrcs() {
		return this.productImgsrcs;
	}

	public void setProductImgsrcs(String productImgsrcs) {
		this.productImgsrcs = productImgsrcs;
	}

	public String getProductUrl() {
		return this.productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public Float getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductTime() {
		return this.productTime;
	}

	public void setProductTime(String productTime) {
		this.productTime = productTime;
	}

	public Short getProductStatus() {
		return this.productStatus;
	}

	public void setProductStatus(Short productStatus) {
		this.productStatus = productStatus;
	}

}