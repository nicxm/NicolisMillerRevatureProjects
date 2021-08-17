package com.nicolis.repositories;

import java.util.List;

import com.nicolis.models.EventTypes;

public interface EventTypesRepo {
	public EventTypes getEventTypes(int etId);

	public List<EventTypes> getAllEventTypes();

	public EventTypes addEventTypes(EventTypes evt);

	public EventTypes updateEventTypes(EventTypes change);

	public EventTypes deleteEventTypes(int etId);

}
