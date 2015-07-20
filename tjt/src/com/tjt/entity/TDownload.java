package com.tjt.entity;

import com.google.gson.annotations.Expose;

/**
 * TDownload entity. @author MyEclipse Persistence Tools
 */

public class TDownload implements java.io.Serializable {

	// Fields

	@Expose
	private Integer downloadId;
	private TUser TUser;
	@Expose
	private TMessages TMessages;
	@Expose
	private String downloadTime;
	private Short downloadStatus;

	// Constructors

	/** default constructor */
	public TDownload() {
	}

	/** full constructor */
	public TDownload(TUser TUser, TMessages TMessages, String downloadTime,
			Short downloadStatus) {
		this.TUser = TUser;
		this.TMessages = TMessages;
		this.downloadTime = downloadTime;
		this.downloadStatus = downloadStatus;
	}

	// Property accessors

	public Integer getDownloadId() {
		return this.downloadId;
	}

	public void setDownloadId(Integer downloadId) {
		this.downloadId = downloadId;
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

	public String getDownloadTime() {
		return this.downloadTime;
	}

	public void setDownloadTime(String downloadTime) {
		this.downloadTime = downloadTime;
	}

	public Short getDownloadStatus() {
		return this.downloadStatus;
	}

	public void setDownloadStatus(Short downloadStatus) {
		this.downloadStatus = downloadStatus;
	}

}