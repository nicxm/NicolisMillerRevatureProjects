package com.nicolis.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

public class Events implements Serializable {

	private static final long serialVersionUID = 1L;
	private int evId;
	private EventTypes eventTypes;
	private GradingFormats gradingFormats;
	private long startTime;
	private long endTime;
	private BigDecimal cost;
	private String location;
	private String description;

	public Events() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Events(EventTypes eventTypes, GradingFormats gradingFormats, long startTime, long endTime, BigDecimal cost,
			String location, String description) {
		super();
		this.eventTypes = eventTypes;
		this.gradingFormats = gradingFormats;
		this.startTime = startTime;
		this.endTime = endTime;
		this.cost = cost;
		this.location = location;
		this.description = description;
	}

	public Events(int evId, EventTypes eventTypes, GradingFormats gradingFormats, long startTime, long endTime,
			BigDecimal cost, String location, String description) {
		this.evId = evId;
		this.eventTypes = eventTypes;
		this.gradingFormats = gradingFormats;
		this.startTime = startTime;
		this.endTime = endTime;
		this.cost = cost;
		this.location = location;
		this.description = description;
	}

	public Events(int evId, EventTypes eventTypes, GradingFormats gradingFormats, long startTime, long endTime,
			BigDecimal cost, String location, String description, Set<?> reimbursementses) {
		this.evId = evId;
		this.eventTypes = eventTypes;
		this.gradingFormats = gradingFormats;
		this.startTime = startTime;
		this.endTime = endTime;
		this.cost = cost;
		this.location = location;
		this.description = description;
	}

	public int getEvId() {
		return this.evId;
	}

	public void setEvId(int evId) {
		this.evId = evId;
	}

	public EventTypes getEventTypes() {
		return this.eventTypes;
	}

	public void setEventTypes(EventTypes eventTypes) {
		this.eventTypes = eventTypes;
	}

	public GradingFormats getGradingFormats() {
		return this.gradingFormats;
	}

	public void setGradingFormats(GradingFormats gradingFormats) {
		this.gradingFormats = gradingFormats;
	}

	public long getStartTime() {
		return this.startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return this.endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Events [evId=" + evId + ", eventTypes=" + eventTypes + ", gradingFormats=" + gradingFormats
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", cost=" + cost + ", location=" + location
				+ ", description=" + description + "]";
	}

}
