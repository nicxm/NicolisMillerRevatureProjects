package com.nicolis.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nicolis.app.HibernateProxyTypeAdapter;
import com.nicolis.models.Attachments;
import com.nicolis.services.AttachmentsService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class AttachmentsController {

	Gson gson = new Gson();
	AttachmentsService as;

	public AttachmentsController(AttachmentsService as) {
		this.as = as;
	}

	public Handler getAttachmentsById = (context) -> {

		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Attachments a = as.getAttachments(id);

		populateResult(context, a);
	};

	public Handler addAttachments = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		Attachments a = gson.fromJson(context.body(), Attachments.class);

		a = as.addAttachments(a);

		populateResult(context, a);
	};

	public Handler getAllAttachments = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		String name = context.queryParam("name", "");

		if (name == "") {

			List<Attachments> Attachments = as.getAllAttachments();
			if (Attachments != null) {
				context.result(gson.toJson(Attachments));
			} else {
				context.result("[]");
			}
		}
	};

	public Handler updateAttachments = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		Attachments a = gson.fromJson(context.body(), Attachments.class);
		a.setAttachId(Integer.parseInt(context.pathParam("id")));

		a = as.updateAttachments(a);

		populateResult(context, a);
	};

	public Handler deleteAttachments = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Attachments a = as.deleteAttachments(id);

		populateResult(context, a);
	};

	// Helper Method
	private void populateResult(Context context, Attachments a) {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();
		if (a != null) {
			context.result(gson.toJson(a));
		} else {
			context.result("{}");
		}

	}
}
