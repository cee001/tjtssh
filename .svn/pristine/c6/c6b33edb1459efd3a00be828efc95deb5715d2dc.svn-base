package com.tjt.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

/**
 * TMessagestype entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class TMessagestype implements java.io.Serializable {

	// Fields

	@Expose
	private Integer messagestypeId;
	@Expose
	private String messagestypeName;
	@Expose
	private String messagestypeTime;
	private Integer messagestypepId;
	private Set TMessageses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TMessagestype() {
	}

	/** minimal constructor */
	public TMessagestype(String messagestypeName, String messagestypeTime,
			Integer messagestypepId) {
		this.messagestypeName = messagestypeName;
		this.messagestypeTime = messagestypeTime;
		this.messagestypepId = messagestypepId;
	}

	/** full constructor */
	public TMessagestype(String messagestypeName, String messagestypeTime,
			Integer messagestypepId, Set TMessageses) {
		this.messagestypeName = messagestypeName;
		this.messagestypeTime = messagestypeTime;
		this.messagestypepId = messagestypepId;
		this.TMessageses = TMessageses;
	}

	// Property accessors

	public Integer getMessagestypeId() {
		return this.messagestypeId;
	}

	public void setMessagestypeId(Integer messagestypeId) {
		this.messagestypeId = messagestypeId;
	}

	public String getMessagestypeName() {
		return this.messagestypeName;
	}

	public void setMessagestypeName(String messagestypeName) {
		this.messagestypeName = messagestypeName;
	}

	public String getMessagestypeTime() {
		return this.messagestypeTime;
	}

	public void setMessagestypeTime(String messagestypeTime) {
		this.messagestypeTime = messagestypeTime;
	}

	public Integer getMessagestypepId() {
		return this.messagestypepId;
	}

	public void setMessagestypepId(Integer messagestypepId) {
		this.messagestypepId = messagestypepId;
	}

	public Set getTMessageses() {
		return this.TMessageses;
	}

	public void setTMessageses(Set TMessageses) {
		this.TMessageses = TMessageses;
	}

}