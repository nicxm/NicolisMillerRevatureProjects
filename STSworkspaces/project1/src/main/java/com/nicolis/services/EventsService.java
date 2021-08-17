package com.nicolis.services;

import java.util.List;

import com.nicolis.models.Events;

public interface EventsService {
	public Events getEvents(int evId);

	public List<Events> getAllEvents();

	public Events addEvents(Events ev);

	public Events updateEvents(Events change);

	public Events deleteEvents(int evId);

}
