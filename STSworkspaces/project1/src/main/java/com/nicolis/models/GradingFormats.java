package com.nicolis.models;

import java.io.Serializable;
import java.util.Set;

public class GradingFormats implements Serializable {

	private static final long serialVersionUID = 1L;
	private int gfId;
	private String gradingFormat;
	private String description;

	public GradingFormats() {
		super();
	}

	public GradingFormats(String gradingFormat, String description) {
		super();
		this.gradingFormat = gradingFormat;
		this.description = description;
	}

	public GradingFormats(int gfId, String gradingFormat, String description) {
		this.gfId = gfId;
		this.gradingFormat = gradingFormat;
		this.description = description;
	}

	public GradingFormats(int gfId, String gradingFormat, String description, Set<?> eventses) {
		this.gfId = gfId;
		this.gradingFormat = gradingFormat;
		this.description = description;
	}

	public int getGfId() {
		return this.gfId;
	}

	public void setGfId(int gfId) {
		this.gfId = gfId;
	}

	public String getGradingFormat() {
		return this.gradingFormat;
	}

	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
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
		return "GradingFormats [gfId=" + gfId + ", gradingFormat=" + gradingFormat + ", description=" + description
				+ "]";
	}

}
