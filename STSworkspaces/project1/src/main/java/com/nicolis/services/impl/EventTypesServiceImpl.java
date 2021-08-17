package com.nicolis.services.impl;

import java.util.List;

import com.nicolis.models.EventTypes;
import com.nicolis.repositories.EventTypesRepo;

public class EventTypesServiceImpl implements com.nicolis.services.EventTypesService {
	public EventTypesRepo evtr;

	public EventTypesServiceImpl(EventTypesRepo evtr) {
		super();
		this.evtr = evtr;
	}

	@Override
	public EventTypes getEventTypes(int etId) {
		return evtr.getEventTypes(etId);
	}

	@Override
	public List<EventTypes> getAllEventTypes() {
		return evtr.getAllEventTypes();
	}

	@Override
	public EventTypes addEventTypes(EventTypes evt) {
		return evtr.addEventTypes(evt);
	}

	@Override
	public EventTypes updateEventTypes(EventTypes change) {
		return evtr.updateEventTypes(change);
	}

	@Override
	public EventTypes deleteEventTypes(int etId) {
		return evtr.deleteEventTypes(etId);
	}

}
