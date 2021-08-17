package com.nicolis.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nicolis.app.HibernateProxyTypeAdapter;
import com.nicolis.models.Presentations;
import com.nicolis.services.PresentationsService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class PresentationsController {

	Gson gson = new Gson();
	PresentationsService ps;

	public PresentationsController(PresentationsService ps) {
		this.ps = ps;
	}

	public Handler getPresentationsById = (context) -> {

		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Presentations p = ps.getPresentations(id);

		populateResult(context, p);
	};

	public Handler addPresentations = (context) -> {

		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		Presentations p = gson.fromJson(context.body(), Presentations.class);

		p = ps.addPresentations(p);

		populateResult(context, p);
	};

	public Handler getAllPresentations = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		String name = context.queryParam("name", "");

		if (name == "") {

			List<Presentations> Presentations = ps.getAllPresentations();
			if (Presentations != null) {
				context.result(gson.toJson(Presentations));
			} else {
				context.result("[]");
			}
		}
	};

	public Handler updatePresentations = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();
		Presentations p = gson.fromJson(context.body(), Presentations.class);
		p.setPresId(Integer.parseInt(context.pathParam("id")));

		p = ps.updatePresentations(p);

		populateResult(context, p);
	};

	public Handler deletePresentations = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Presentations p = ps.deletePresentations(id);

		populateResult(context, p);
	};

	// Helper Method
	private void populateResult(Context context, Presentations p) {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();
		if (p != null) {
			context.result(gson.toJson(p));
		} else {
			context.result("{}");
		}

	}

}
