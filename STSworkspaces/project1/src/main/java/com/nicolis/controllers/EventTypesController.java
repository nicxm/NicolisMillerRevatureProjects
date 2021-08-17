package com.nicolis.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nicolis.app.HibernateProxyTypeAdapter;
import com.nicolis.models.EventTypes;
import com.nicolis.services.EventTypesService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EventTypesController {

	Gson gson = new Gson();
	EventTypesService evts;

	public EventTypesController(EventTypesService evts) {
		this.evts = evts;
	}

	public Handler getEventTypesById = (context) -> {

		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		EventTypes evt = evts.getEventTypes(id);

		populateResult(context, evt);
	};

	public Handler addEventTypes = (context) -> {

		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		EventTypes evt = gson.fromJson(context.body(), EventTypes.class);

		evt = evts.addEventTypes(evt);

		populateResult(context, evt);
	};

	public Handler getAllEventTypes = (context) -> {

		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		String name = context.queryParam("name", "");

		if (name == "") {

			List<EventTypes> EventTypes = evts.getAllEventTypes();
			if (EventTypes != null) {
				context.result(gson.toJson(EventTypes));
			} else {
				context.result("[]");
			}
		}
	};

	public Handler updateEventTypes = (context) -> {

		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();
		EventTypes evt = gson.fromJson(context.body(), EventTypes.class);
		evt.setEtId(Integer.parseInt(context.pathParam("id")));

		evt = evts.updateEventTypes(evt);

		populateResult(context, evt);
	};

	public Handler deleteEventTypes = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		EventTypes evt = evts.deleteEventTypes(id);

		populateResult(context, evt);
	};

	// Helper Method
	private void populateResult(Context context, EventTypes evt) {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		if (evt != null) {
			context.result(gson.toJson(evt));
		} else {
			context.result("{}");
		}

	}

}
