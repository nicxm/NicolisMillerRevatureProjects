package com.nicolis.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nicolis.app.HibernateProxyTypeAdapter;
import com.nicolis.models.Reimbursements;
import com.nicolis.services.ReimbursementsService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ReimbursementsController {

	Gson gson = new Gson();
	ReimbursementsService rs;

	public ReimbursementsController(ReimbursementsService rs) {
		this.rs = rs;
	}

	public Handler getReimbursementsById = (context) -> {

		String input = context.pathParam("id");
		int RId;
		try {
			RId = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			RId = -1;
		}

		Reimbursements r = rs.getReimbursements(RId);

		populateResult(context, r);
	};

	public Handler addReimbursements = (context) -> {

		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		Reimbursements r = gson.fromJson(context.body(), Reimbursements.class);

		r = rs.addReimbursements(r);

		populateResult(context, r);
	};

	public Handler getAllReimbursements = (context) -> {

		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		String name = context.queryParam("name", "");

		if (name == "") {

			List<Reimbursements> Reimbursements = rs.getAllReimbursements();
			if (Reimbursements != null) {
				context.result(gson.toJson(Reimbursements));
			} else {
				context.result("[]");
			}
		}
	};

	public Handler updateReimbursements = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		Reimbursements r = gson.fromJson(context.body(), Reimbursements.class);
		r.setRId(Integer.parseInt(context.pathParam("id")));

		r = rs.updateReimbursements(r);

		populateResult(context, r);
	};

	public Handler deleteReimbursements = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Reimbursements r = rs.deleteReimbursements(id);

		populateResult(context, r);
	};

	// Helper Method
	private void populateResult(Context context, Reimbursements r) {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		if (r != null) {
			context.result(gson.toJson(r));
		} else {
			context.result("{}");
		}

	}

}
