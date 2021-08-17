package com.nicolis.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nicolis.app.HibernateProxyTypeAdapter;
import com.nicolis.models.Departments;
import com.nicolis.services.DepartmentsService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DepartmentsController {

	Gson gson = new Gson();
	DepartmentsService ds;

	public DepartmentsController(DepartmentsService ds) {
		this.ds = ds;
	}

	public Handler getDepartmentsById = (context) -> {

		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Departments d = ds.getDepartments(id);

		populateResult(context, d);
	};

	public Handler addDepartments = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		Departments d = gson.fromJson(context.body(), Departments.class);

		d = ds.addDepartments(d);

		populateResult(context, d);
	};

	public Handler getAllDepartments = (context) -> {

		String name = context.queryParam("name", "");

		if (name == "") {

			List<Departments> Departments = ds.getAllDepartments();
			if (Departments != null) {
				context.result(gson.toJson(Departments));
			} else {
				context.result("[]");
			}
		}
	};

	public Handler updateDepartments = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		Departments d = gson.fromJson(context.body(), Departments.class);
		d.setDeptId(Integer.parseInt(context.pathParam("id")));

		d = ds.updateDepartments(d);

		populateResult(context, d);
	};

	public Handler deleteDepartments = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Departments d = ds.deleteDepartments(id);

		populateResult(context, d);
	};

	// Helper Method
	private void populateResult(Context context, Departments d) {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		if (d != null) {
			context.result(gson.toJson(d));
		} else {
			context.result("{}");
		}

	}

}
