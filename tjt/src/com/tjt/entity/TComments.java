package com.tjt.entity;

import com.google.gson.annotations.Expose;

/**
 * TComments entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class TComments implements java.io.Serializable {

	// Fields

	@Expose
	private Integer commentsId;
	@Expose
	private TUser TUser;
	@Expose	
	private TMessages TMessages;
	@Expose
	private String commentsInfo;
	@Expose
	private Integer commentsInfostatus;
	@Expose
	private String commentsTime;
	private Integer ruserId;
	// Constructors

	/** default constructor */
	public TComments() {
	}

	/** full constructor */
	public TComments(TUser TUser, TMessages TMessages, String commentsInfo,
			Integer commentsInfostatus, String commentsTime,Integer ruserId) {
		this.TUser = TUser;
		this.TMessages = TMessages;
		this.commentsInfo = commentsInfo;
		this.commentsInfostatus = commentsInfostatus;
		this.commentsTime = commentsTime;
		this.ruserId = ruserId;		
	}

	// Property accessors

	public Integer getCommentsId() {
		return this.commentsId;
	}

	public void setCommentsId(Integer commentsId) {
		this.commentsId = commentsId;
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

	public String getCommentsInfo() {
		return this.commentsInfo;
	}

	public void setCommentsInfo(String commentsInfo) {
		this.commentsInfo = commentsInfo;
	}

	public Integer getCommentsInfostatus() {
		return this.commentsInfostatus;
	}

	public void setCommentsInfostatus(Integer commentsInfostatus) {
		this.commentsInfostatus = commentsInfostatus;
	}

	public String getCommentsTime() {
		return this.commentsTime;
	}

	public void setCommentsTime(String commentsTime) {
		this.commentsTime = commentsTime;
	}

	public Integer getRuserId() {
		return ruserId;
	}

	public void setRuserId(Integer ruserId) {
		this.ruserId = ruserId;
	}

}