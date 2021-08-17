package com.nicolis.app;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.nicolis.proj0.Account;
import com.nicolis.service.AccountService;

import io.javalin.http.Handler;

public class AccountController {
	final static Logger log = Logger.getLogger(AccountController.class);

	public AccountService as;
	Gson gson = new Gson();

	public AccountController(AccountService as) {
		this.as = as;
	}

	public Handler getAllAccounts = (context) -> {
		int id = Integer.parseInt(context.pathParam("id"));
		int amountLessThan = context.queryParam("amountLessThan", Integer.class, "1000000").get();
		int amountGreaterThan = context.queryParam("amountGreaterThan", Integer.class, "0").get();

		List<Account> accounts = as.getAllAccounts(id, amountLessThan, amountGreaterThan);
		if (accounts != null) {
			context.result(gson.toJson(accounts));
		} else {
			log.error("404");
			context.status(404);
		}
	};

	public Handler getAccount = (ctx) -> {
		int id = Integer.parseInt(ctx.pathParam("id"));
		int a_id = Integer.parseInt(ctx.pathParam("a_id"));
		Account a = as.getAccount(id, a_id);
		if (a != null) {
			ctx.result(gson.toJson(a));
		} else {
			log.error("404");
			ctx.status(404);
		}

	};

	public Handler getAccountsByFunds = (ctx) -> {
		int id = Integer.parseInt(ctx.pathParam("id"));
		int amountLessThan = ctx.queryParam("amountLessThan", Integer.class, "0").get();
		int amountGreaterThan = ctx.queryParam("amountGreaterThan", Integer.class, "1000000").get();
		log.info(amountLessThan);
		log.info(amountGreaterThan);

		List<Account> accounts = as.getAllAccounts(id, amountLessThan, amountGreaterThan);
		if (accounts != null) {
			ctx.result(gson.toJson(accounts));
		} else {
			log.error("404");
			ctx.status(404);
		}
	};

	public Handler addAccount = (context) -> {
		Account a = gson.fromJson(context.body(), Account.class);

		a = as.createAccount(a);
		context.result(gson.toJson(a));
		context.status(201);
	};

	public Handler deleteAccount = (context) -> {
		int a_id = Integer.parseInt(context.pathParam("a_id"));
		Account a = as.deleteAccount(a_id);
		if (a != null) {
			context.status(204);
			context.result(gson.toJson(a));
		} else {
			log.error("404");
			context.status(404);
		}
	};

	public Handler updateAccount = (context) -> {
		Account a = gson.fromJson(context.body(), Account.class);

		a = as.updateAccount(a);
		if (a != null) {
			context.result(gson.toJson(a));
		} else {
			log.error("404");
			context.status(404);
		}
	};

	public Handler withdrawAccount = (context) -> {
		Account a = gson.fromJson(context.body(), Account.class);
		int x = Integer.parseInt(context.pathParam("funds"));
		int id = Integer.parseInt(context.pathParam("id"));
		int a_id = Integer.parseInt(context.pathParam("a_id"));

		a = as.withdrawFunds(a, x, a_id, id);
		if (a != null) {
			context.result(gson.toJson(a));
		} else {
			log.error("404");
			context.status(404);
		}
	};

	public Handler depositAccount = (context) -> {
		Account a = gson.fromJson(context.body(), Account.class);
		int x = Integer.parseInt(context.pathParam("funds"));
		int id = Integer.parseInt(context.pathParam("id"));
		int a_id = Integer.parseInt(context.pathParam("a_id"));

		a = as.depositFunds(a, x, a_id, id);
		if (a != null) {
			context.result(gson.toJson(a));
		} else {
			log.error("404");
			context.status(404);
		}
	};

	public Handler transferAccount = (context) -> {
		Account a = gson.fromJson(context.body(), Account.class);
		Account b = gson.fromJson(context.body(), Account.class);
		int x = Integer.parseInt(context.pathParam("funds"));
		int id = Integer.parseInt(context.pathParam("id"));
		int a_id = Integer.parseInt(context.pathParam("a_id"));
		int a_id2 = Integer.parseInt(context.pathParam("a_id2"));

		a = as.withdrawFunds(a, x, a_id, id);
		b = as.depositFunds(a, x, a_id2, id);
		if (a != null) {
			context.result(gson.toJson(a));
			context.result(gson.toJson(b));
			log.info(a.toString());
			log.info(b.toString());
			log.info("Funds: " + x + " from account: " + a_id + " have been transferred to account: " + a_id2);
		} else {
			log.error("404");
			context.status(404);
		}
	};

}
