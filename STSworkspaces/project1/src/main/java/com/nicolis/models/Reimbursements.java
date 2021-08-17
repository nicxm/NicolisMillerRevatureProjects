package com.nicolis.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public class Reimbursements implements Serializable {

	private static final long serialVersionUID = 1L;
	private int RId;
	private Employees employees;
	private Events events;
	private BigDecimal claim;
	private String grade;
	private String reason;
	private boolean SApproved;
	private boolean depHeadApproved;
	private boolean benCoApproved;

	public Reimbursements() {
		super();
	}

	public Reimbursements(Employees employees, Events events, BigDecimal claim, String grade, String reason,
			boolean sApproved, boolean depHeadApproved, boolean benCoApproved) {
		super();
		this.employees = employees;
		this.events = events;
		this.claim = claim;
		this.grade = grade;
		this.reason = reason;
		SApproved = sApproved;
		this.depHeadApproved = depHeadApproved;
		this.benCoApproved = benCoApproved;
	}

	public Reimbursements(int RId, Employees employees, Events events, BigDecimal claim, String grade, String reason,
			boolean SApproved, boolean depHeadApproved, boolean benCoApproved) {
		this.RId = RId;
		this.employees = employees;
		this.events = events;
		this.claim = claim;
		this.grade = grade;
		this.reason = reason;
		this.SApproved = SApproved;
		this.depHeadApproved = depHeadApproved;
		this.benCoApproved = benCoApproved;
	}

	public Reimbursements(int RId, Employees employees, Events events, BigDecimal claim, String grade, String reason,
			boolean SApproved, boolean depHeadApproved, boolean benCoApproved, Set<?> presentationses,
			Set<?> requestses, Set<?> attachmentses) {
		this.RId = RId;
		this.employees = employees;
		this.events = events;
		this.claim = claim;
		this.grade = grade;
		this.reason = reason;
		this.SApproved = SApproved;
		this.depHeadApproved = depHeadApproved;
		this.benCoApproved = benCoApproved;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getRId() {
		return this.RId;
	}

	public void setRId(int RId) {
		this.RId = RId;
	}

	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Events getEvents() {
		return this.events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}

	public BigDecimal getClaim() {
		return this.claim;
	}

	public void setClaim(BigDecimal claim) {
		this.claim = claim;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public boolean isSApproved() {
		return this.SApproved;
	}

	public void setSApproved(boolean SApproved) {
		this.SApproved = SApproved;
	}

	public boolean isDepHeadApproved() {
		return this.depHeadApproved;
	}

	public void setDepHeadApproved(boolean depHeadApproved) {
		this.depHeadApproved = depHeadApproved;
	}

	public boolean isBenCoApproved() {
		return this.benCoApproved;
	}

	public void setBenCoApproved(boolean benCoApproved) {
		this.benCoApproved = benCoApproved;
	}

	@Override
	public String toString() {
		return "Reimbursements [RId=" + RId + ", employees=" + employees + ", events=" + events + ", claim=" + claim
				+ ", grade=" + grade + ", reason=" + reason + ", SApproved=" + SApproved + ", depHeadApproved="
				+ depHeadApproved + ", benCoApproved=" + benCoApproved + "]";
	}

}
