package com.tjt.entity;

import com.google.gson.annotations.Expose;

/**
 * TCollections entity. @author MyEclipse Persistence Tools
 */

public class TCollections implements java.io.Serializable {

	// Fields

	@Expose
	private Integer collectionsId;
	@Expose
	private TUser TUser;
	@Expose
	private TMessages TMessages;
	@Expose
	private String collectionsTime;
	@Expose
	private Boolean collectionsStatus;

	// Constructors

	/** default constructor */
	public TCollections() {
	}

	/** full constructor */
	public TCollections(TUser TUser, TMessages TMessages,
			String collectionsTime, Boolean collectionsStatus) {
		this.TUser = TUser;
		this.TMessages = TMessages;
		this.collectionsTime = collectionsTime;
		this.collectionsStatus = collectionsStatus;
	}

	// Property accessors

	public Integer getCollectionsId() {
		return this.collectionsId;
	}

	public void setCollectionsId(Integer collectionsId) {
		this.collectionsId = collectionsId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public TMessages getTMessages() {
		return this.TMessages;
	}

	public void setTMessages(TMessages TMessages) {
		this.TMessages = TMessages;
	}

	public String getCollectionsTime() {
		return this.collectionsTime;
	}

	public void setCollectionsTime(String collectionsTime) {
		this.collectionsTime = collectionsTime;
	}

	public Boolean getCollectionsStatus() {
		return this.collectionsStatus;
	}

	public void setCollectionsStatus(Boolean collectionsStatus) {
		this.collectionsStatus = collectionsStatus;
	}

}