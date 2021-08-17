package com.nicolis.models;

import java.io.Serializable;
import java.util.Set;

public class EventTypes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int etId;
	private String eventType;
	private byte percent;

	public EventTypes() {
		super();
	}

	public EventTypes(String eventType, byte percent, Set<?> eventses) {
		super();
		this.eventType = eventType;
		this.percent = percent;
	}

	public EventTypes(int etId, String eventType, byte percent) {
		this.etId = etId;
		this.eventType = eventType;
		this.percent = percent;
	}

	public EventTypes(String eventType, byte percent) {
		this.eventType = eventType;
		this.percent = percent;
	}

	public int getEtId() {
		return this.etId;
	}

	public void setEtId(int etId) {
		this.etId = etId;
	}

	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public byte getPercent() {
		return this.percent;
	}

	public void setPercent(byte percent) {
		this.percent = percent;
	}

	@Override
	public String toString() {
		return "EventTypes [etId=" + etId + ", eventType=" + eventType + ", percent=" + percent + "]";
	}

}
