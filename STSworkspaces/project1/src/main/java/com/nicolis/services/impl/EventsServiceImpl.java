package com.nicolis.services.impl;

import java.util.List;

import com.nicolis.models.Events;
import com.nicolis.repositories.EventsRepo;
import com.nicolis.services.EventsService;

public class EventsServiceImpl implements EventsService {

	public EventsRepo evr;

	public EventsServiceImpl(EventsRepo evr) {
		super();
		this.evr = evr;
	}

	@Override
	public Events getEvents(int evId) {
		return evr.getEvents(evId);
	}

	@Override
	public List<Events> getAllEvents() {
		return evr.getAllEvents();
	}

	@Override
	public Events addEvents(Events ev) {
		return evr.addEvents(ev);
	}

	@Override
	public Events updateEvents(Events change) {
		return evr.updateEvents(change);
	}

	@Override
	public Events deleteEvents(int evId) {
		return evr.deleteEvents(evId);
	}

}
