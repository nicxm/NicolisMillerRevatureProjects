package com.nicolis.models;

import java.io.Serializable;

public class Requests implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int reqId;
	private Employees employees;
	private Reimbursements reimbursements;
	private String message;
	private boolean approve;

	public Requests() {
		super();
	}

	public Requests(int reqId, Employees employees, Reimbursements reimbursements, String message, boolean approve) {
		this.reqId = reqId;
		this.employees = employees;
		this.reimbursements = reimbursements;
		this.message = message;
		this.approve = approve;
	}

	public Requests(Employees employees, Reimbursements reimbursements, String message, boolean approve) {
		super();
		this.employees = employees;
		this.reimbursements = reimbursements;
		this.message = message;
		this.approve = approve;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getReqId() {
		return this.reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Reimbursements getReimbursements() {
		return this.reimbursements;
	}

	public void setReimbursements(Reimbursements reimbursements) {
		this.reimbursements = reimbursements;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isApprove() {
		return this.approve;
	}

	public void setApprove(boolean approve) {
		this.approve = approve;
	}

	@Override
	public String toString() {
		return "Requests [reqId=" + reqId + ", employees=" + employees + ", reimbursements=" + reimbursements
				+ ", message=" + message + ", approve=" + approve + "]";
	}

}
