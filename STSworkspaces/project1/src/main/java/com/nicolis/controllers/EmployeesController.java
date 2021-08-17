package com.nicolis.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nicolis.app.HibernateProxyTypeAdapter;
import com.nicolis.models.Employees;
import com.nicolis.services.EmployeesService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EmployeesController {

	EmployeesService es;

	Gson gson = new Gson();

	public EmployeesController(EmployeesService es) {
		this.es = es;
	}

	public Handler getEmployeesById = (context) -> {

		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Employees e = es.getEmployees(id);

		populateResult(context, e);
	};

	public Handler addEmployees = (context) -> {

		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		Employees e = gson.fromJson(context.body(), Employees.class);

		e = es.addEmployees(e);

		populateResult(context, e);
	};

	public Handler getAllEmployees = (context) -> {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		String username = context.queryParam("username", "");

		if (username == "") {
			List<Employees> employees = es.getAllEmployees();
			if (employees != null) {
				context.result(gson.toJson(employees));
			} else {
				context.result("[]");
			}

		} else {
			getEmployeesByName(context);
		}
	};

	public Handler updateEmployees = (context) -> {

		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		Employees e = gson.fromJson(context.body(), Employees.class);
		e.setEId(Integer.parseInt(context.pathParam("id")));

		e = es.updateEmployees(e);

		populateResult(context, e);
	};

	public Handler deleteEmployees = (context) -> {

		int id = Integer.parseInt(context.pathParam("id"));

		Employees e = es.deleteEmployees(id);

		populateResult(context, e);
	};

	// Helper Method
	private void populateResult(Context context, Employees e) {
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
		Gson gson = b.create();

		if (e != null) {
			context.result(gson.toJson(e));
		} else {
			context.result("{}");
		}

	}

	private void getEmployeesByName(Context context) {
		String username = context.queryParam("username");
		String password = context.queryParam("password");

		Employees e = es.getEmployees(username, password);

		populateResult(context, e);
	};

}
