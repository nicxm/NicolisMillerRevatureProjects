package com.nicolis.services;

import java.util.List;

import com.nicolis.models.EventTypes;

public interface EventTypesService {
	public EventTypes getEventTypes(int etId);

	public List<EventTypes> getAllEventTypes();

	public EventTypes addEventTypes(EventTypes evt);

	public EventTypes updateEventTypes(EventTypes change);

	public EventTypes deleteEventTypes(int etId);

}
