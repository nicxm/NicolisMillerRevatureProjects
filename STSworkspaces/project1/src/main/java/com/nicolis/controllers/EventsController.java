package com.nicolis.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nicolis.app.HibernateProxyTypeAdapter;
import com.nicolis.models.Events;
import com.nicolis.services.EventsService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EventsController {

	Gson gson = new Gson();
	EventsService evs;

	public EventsController(EventsService evs) {
		this.evs = evs;
	}

	public Handler getEventsById = (context) -> {

		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Events e = evs.getEvents(id);

		populateResult(context, e);
	};

	public Handler addEvents = (context) -> {

		Events e = gson.fromJson(context.body(), Events.class);

		e = evs.addEvents(e);

		populateResult(context, e);
	};

	public Handler getAllEvents = (context) -> {

		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		String name = context.queryParam("name", "");

		if (name == "") {

			List<Events> Events = evs.getAllEvents();
			if (Events != null) {
				context.result(gson.toJson(Events));
			} else {
				context.result("[]");
			}
		}
	};

	public Handler updateEvents = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		Events e = gson.fromJson(context.body(), Events.class);
		e.setEvId(Integer.parseInt(context.pathParam("id")));

		e = evs.updateEvents(e);

		populateResult(context, e);
	};

	public Handler deleteEvents = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Events e = evs.deleteEvents(id);

		populateResult(context, e);
	};

	// Helper Method
	private void populateResult(Context context, Events e) {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		if (e != null) {
			context.result(gson.toJson(e));
		} else {
			context.result("{}");
		}

	}

}
