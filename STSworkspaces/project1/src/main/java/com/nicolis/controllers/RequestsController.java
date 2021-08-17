package com.nicolis.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nicolis.app.HibernateProxyTypeAdapter;
import com.nicolis.models.Requests;
import com.nicolis.services.RequestsService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class RequestsController {

	Gson gson = new Gson();
	RequestsService rqs;

	public RequestsController(RequestsService rqs) {
		this.rqs = rqs;
	}

	public Handler getRequestsById = (context) -> {

		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Requests rq = rqs.getRequests(id);

		populateResult(context, rq);
	};

	public Handler addRequests = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		Requests rq = gson.fromJson(context.body(), Requests.class);

		rq = rqs.addRequests(rq);

		populateResult(context, rq);
	};

	public Handler getAllRequests = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		String name = context.queryParam("name", "");

		if (name == "") {

			List<Requests> Requests = rqs.getAllRequests();
			if (Requests != null) {
				context.result(gson.toJson(Requests));
			} else {
				context.result("[]");
			}
		}
	};

	public Handler updateRequests = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();
		Requests rq = gson.fromJson(context.body(), Requests.class);
		rq.setReqId(Integer.parseInt(context.pathParam("id")));

		rq = rqs.updateRequests(rq);

		populateResult(context, rq);
	};

	public Handler deleteRequests = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Requests rq = rqs.deleteRequests(id);

		populateResult(context, rq);
	};

	// Helper Method
	private void populateResult(Context context, Requests rq) {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();
		if (rq != null) {
			context.result(gson.toJson(rq));
		} else {
			context.result("{}");
		}

	}

}
