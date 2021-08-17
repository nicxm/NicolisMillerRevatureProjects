package com.nicolis.app;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nicolis.proj0.Client;
import com.nicolis.service.ClientService;

import io.javalin.http.Handler;

public class ClientController {
	final static Logger log = Logger.getLogger(ClientController.class);

	public ClientService cs;
	Gson gson = new Gson();

	public ClientController(ClientService cs) {
		this.cs = cs;
	}

	public Handler getAllClients = (context) -> {
		List<Client> clients = cs.GetAllClients();
		if (clients != null) {
			context.result(gson.toJson(clients));
			context.status(200);

		} else {
			log.error("404");
			context.status(404);
		}
	};

	public Handler getClient = (ctx) -> {
		int id = Integer.parseInt(ctx.pathParam("id"));
		Client c = cs.getClient(id);
		ctx.result(gson.toJson(c));
	};

	public Handler addClient = (context) -> {
		Client c = gson.fromJson(context.body(), Client.class);

		c = cs.createClient(c);
		if (c != null) {
			context.result(gson.toJson(c));
			context.status(201);
		} else {
			log.error("404");
			context.status(404);
		}
	};

	public Handler deleteClient = (context) -> {
		int id = Integer.parseInt(context.pathParam("id"));
		Client c = cs.deleteClient(id);
		if (c != null) {
			context.result(gson.toJson(c));
			context.status(204);
			log.info("Client: " + id + " has been deleted");
		} else {
			log.error("404");
			context.status(404);
		}
	};

	public Handler updateClient = (context) -> {
		Client c = gson.fromJson(context.body(), Client.class);

		c = cs.updateClient(c);
		if (c != null) {
			context.result((c != null) ? gson.toJson(c) : "{}");
		} else {
			log.error("404");
			context.status(404);
		}
	};

}
