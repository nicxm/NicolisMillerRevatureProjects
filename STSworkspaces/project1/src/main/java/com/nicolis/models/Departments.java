package com.nicolis.models;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Departments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private int deptId;
	private String DName;
	private String DHead;

	public Departments() {
	}

	public Departments(int deptId, String DName, String DHead) {
		this.deptId = deptId;
		this.DName = DName;
		this.DHead = DHead;
	}

	public Departments(String dName, String dHead) {
		super();
		DName = dName;
		DHead = dHead;
	}

	public Departments(int deptId, String DName, String DHead, Set<?> employeeses) {
		this.deptId = deptId;
		this.DName = DName;
		this.DHead = DHead;
	}

	@JsonIgnore
	public int getDeptId() {
		return this.deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDName() {
		return this.DName;
	}

	public void setDName(String DName) {
		this.DName = DName;
	}

	public String getDHead() {
		return this.DHead;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setDHead(String DHead) {
		this.DHead = DHead;
	}

	@Override
	public String toString() {
		return "Departments [deptId=" + deptId + ", DName=" + DName + ", DHead=" + DHead + "]";
	}

}
