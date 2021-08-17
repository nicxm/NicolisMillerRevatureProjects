package com.nicolis.models;

import java.io.Serializable;

public class Presentations implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int presId;
	private Reimbursements reimbursements;
	private String description;

	public Presentations() {
		super();
	}

	public Presentations(Reimbursements reimbursements, String description) {
		super();
		this.reimbursements = reimbursements;
		this.description = description;
	}

	public Presentations(int presId, Reimbursements reimbursements, String description) {
		this.presId = presId;
		this.reimbursements = reimbursements;
		this.description = description;
	}

	public int getPresId() {
		return this.presId;
	}

	public void setPresId(int presId) {
		this.presId = presId;
	}

	public Reimbursements getReimbursements() {
		return this.reimbursements;
	}

	public void setReimbursements(Reimbursements reimbursements) {
		this.reimbursements = reimbursements;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Presentations [presId=" + presId + ", reimbursements=" + reimbursements + ", description=" + description
				+ "]";
	}

}
