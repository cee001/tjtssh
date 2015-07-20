package com.tjt.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * TMessages entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class TMessages implements java.io.Serializable {

	// Fields

	@Expose
	private Integer messagesId;
	@Expose
	private TUser TUser;
	@Expose
	private TMessagestype TMessagestype;
	@Expose
	private String messagesTitle;
	@Expose
	private String messagesInfo;
	@Expose
	private String messagesTime;
	@Expose
	private String messagesAnnex;
	@Expose
	private String messagesImgsrcs;
	@Expose
	private String messagesLink;
	@Expose
	private Short messagesStatus;
	@Expose
	private Boolean messagesIslink;
	@Expose
	private Integer messagesCollectnum;
	@Expose
	private Integer messagesTouchnum;
	private Set TCollectionses = new HashSet(0);
	private Set TCommentses = new HashSet(0);
	private Set TDownloads = new HashSet(0);

	// Constructors

	/** default constructor */
	public TMessages() {
	}

	/** minimal constructor */
	public TMessages(TUser TUser, TMessagestype TMessagestype,
			String messagesTitle, String messagesInfo, String messagesTime,
			Boolean messagesIslink, Integer messagesCollectnum,Integer messagesTouchnum,
			Short messagesStatus) {
		this.TUser = TUser;
		this.TMessagestype = TMessagestype;
		this.messagesTitle = messagesTitle;
		this.messagesInfo = messagesInfo;
		this.messagesTime = messagesTime;
		this.messagesIslink = messagesIslink;
		this.messagesCollectnum = messagesCollectnum;
		this.messagesTouchnum= messagesTouchnum;
		this.messagesStatus = messagesStatus;
	}

	/** full constructor */
	public TMessages(TUser TUser, TMessagestype TMessagestype,
			String messagesTitle, String messagesInfo, String messagesTime,
			String messagesAnnex, String messagesImgsrcs, String messagesLink,
			Boolean messagesIslink, Integer messagesCollectnum,Integer messagesTouchnum,
			Short messagesStatus, Set TCommentses, Set TDownloads,
			Set TCollectionses) {
		this.TUser = TUser;
		this.TMessagestype = TMessagestype;
		this.messagesTitle = messagesTitle;
		this.messagesInfo = messagesInfo;
		this.messagesTime = messagesTime;
		this.messagesAnnex = messagesAnnex;
		this.messagesImgsrcs = messagesImgsrcs;
		this.messagesLink = messagesLink;
		this.messagesIslink = messagesIslink;
		this.messagesCollectnum = messagesCollectnum;
		this.messagesTouchnum = messagesTouchnum ;
		this.messagesStatus = messagesStatus;
		this.TCommentses = TCommentses;
		this.TDownloads = TDownloads;
		this.TCollectionses = TCollectionses;
	}

	// Property accessors

	public Integer getMessagesId() {
		return this.messagesId;
	}

	public void setMessagesId(Integer messagesId) {
		this.messagesId = messagesId;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public TMessagestype getTMessagestype() {
		return this.TMessagestype;
	}

	public void setTMessagestype(TMessagestype TMessagestype) {
		this.TMessagestype = TMessagestype;
	}

	public String getMessagesTitle() {
		return this.messagesTitle;
	}

	public void setMessagesTitle(String messagesTitle) {
		this.messagesTitle = messagesTitle;
	}

	public String getMessagesInfo() {
		return this.messagesInfo;
	}

	public void setMessagesInfo(String messagesInfo) {
		this.messagesInfo = messagesInfo;
	}

	public String getMessagesTime() {
		return this.messagesTime;
	}

	public void setMessagesTime(String messagesTime) {
		this.messagesTime = messagesTime;
	}

	public String getMessagesAnnex() {
		return this.messagesAnnex;
	}

	public void setMessagesAnnex(String messagesAnnex) {
		this.messagesAnnex = messagesAnnex;
	}

	public String getMessagesImgsrcs() {
		return this.messagesImgsrcs;
	}

	public void setMessagesImgsrcs(String messagesImgsrcs) {
		this.messagesImgsrcs = messagesImgsrcs;
	}

	public String getMessagesLink() {
		return this.messagesLink;
	}

	public void setMessagesLink(String messagesLink) {
		this.messagesLink = messagesLink;
	}

	public Boolean getMessagesIslink() {
		return this.messagesIslink;
	}

	public void setMessagesIslink(Boolean messagesIslink) {
		this.messagesIslink = messagesIslink;
	}

	public Integer getMessagesCollectnum() {
		return this.messagesCollectnum;
	}

	public void setMessagesCollectnum(Integer messagesCollectnum) {
		this.messagesCollectnum = messagesCollectnum;
	}

	public Short getMessagesStatus() {
		return this.messagesStatus;
	}

	public void setMessagesStatus(Short messagesStatus) {
		this.messagesStatus = messagesStatus;
	}

	public Integer getMessagesTouchnum() {
		return messagesTouchnum;
	}

	public void setMessagesTouchnum(Integer messagesTouchnum) {
		this.messagesTouchnum = messagesTouchnum;
	}

	public Set getTCommentses() {
		return this.TCommentses;
	}

	public void setTCommentses(Set TCommentses) {
		this.TCommentses = TCommentses;
	}

	public Set getTDownloads() {
		return this.TDownloads;
	}

	public void setTDownloads(Set TDownloads) {
		this.TDownloads = TDownloads;
	}

	public Set getTCollectionses() {
		return this.TCollectionses;
	}

	public void setTCollectionses(Set TCollectionses) {
		this.TCollectionses = TCollectionses;
	}

}