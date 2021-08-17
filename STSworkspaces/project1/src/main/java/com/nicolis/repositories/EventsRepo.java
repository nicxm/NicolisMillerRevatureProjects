package com.nicolis.repositories;

import java.util.List;

import com.nicolis.models.Events;

public interface EventsRepo {
	public Events getEvents(int evId);

	public List<Events> getAllEvents();

	public Events addEvents(Events ev);

	public Events updateEvents(Events change);

	public Events deleteEvents(int evId);

}
