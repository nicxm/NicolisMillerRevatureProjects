package com.nicolis.models;

import java.io.Serializable;

public class Attachments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int attachId;
	private Reimbursements reimbursements;
	private String url;

	public Attachments() {
	}

	public Attachments(int attachId, Reimbursements reimbursements, String url) {
		this.attachId = attachId;
		this.reimbursements = reimbursements;
		this.url = url;
	}

	public Attachments(Reimbursements reimbursements, String url) {
		super();
		this.reimbursements = reimbursements;
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getAttachId() {
		return this.attachId;
	}

	public void setAttachId(int attachId) {
		this.attachId = attachId;
	}

	public Reimbursements getReimbursements() {
		return this.reimbursements;
	}

	public void setReimbursements(Reimbursements reimbursements) {
		this.reimbursements = reimbursements;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Attachments [attachId=" + attachId + ", reimbursements=" + reimbursements + ", url=" + url + "]";
	}

}
