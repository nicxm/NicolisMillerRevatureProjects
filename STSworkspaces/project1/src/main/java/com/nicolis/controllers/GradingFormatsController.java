package com.nicolis.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nicolis.app.HibernateProxyTypeAdapter;
import com.nicolis.models.GradingFormats;
import com.nicolis.services.GradingFormatsService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class GradingFormatsController {

	Gson gson = new Gson();
	GradingFormatsService gfs;

	public GradingFormatsController(GradingFormatsService gfs) {
		this.gfs = gfs;
	}

	public Handler getGradingFormatsById = (context) -> {

		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		GradingFormats gf = gfs.getGradingFormats(id);

		populateResult(context, gf);
	};

	public Handler addGradingFormats = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		GradingFormats gf = gson.fromJson(context.body(), GradingFormats.class);

		gf = gfs.addGradingFormats(gf);

		populateResult(context, gf);
	};

	public Handler getAllGradingFormats = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		String name = context.queryParam("name", "");

		if (name == "") {

			List<GradingFormats> GradingFormats = gfs.getAllGradingFormats();
			if (GradingFormats != null) {
				context.result(gson.toJson(GradingFormats));
			} else {
				context.result("[]");
			}
		}
	};

	public Handler updateGradingFormats = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		GradingFormats gf = gson.fromJson(context.body(), GradingFormats.class);
		gf.setGfId(Integer.parseInt(context.pathParam("id")));

		gf = gfs.updateGradingFormats(gf);

		populateResult(context, gf);
	};

	public Handler deleteGradingFormats = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		GradingFormats gf = gfs.deleteGradingFormats(id);

		populateResult(context, gf);
	};

	// Helper Method
	private void populateResult(Context context, GradingFormats gf) {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		if (gf != null) {
			context.result(gson.toJson(gf));
		} else {
			context.result("{}");
		}

	}

}
