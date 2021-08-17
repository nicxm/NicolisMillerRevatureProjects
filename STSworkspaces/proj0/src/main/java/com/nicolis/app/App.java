package com.nicolis.app;

import org.apache.log4j.Logger;

import com.nicolis.dao.AccountDAO;
import com.nicolis.dao.AccountDAODBImpl;
import com.nicolis.dao.ClientDAO;
import com.nicolis.dao.ClientDAODBImpl;
import com.nicolis.service.AccountService;
import com.nicolis.service.AccountServiceImpl;
import com.nicolis.service.ClientService;
import com.nicolis.service.ClientServiceImpl;

import io.javalin.Javalin;

public class App {
	final static Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {
		Javalin app = Javalin.create();

		establishRoutes(app);

		app.start(7000);
		log.info("Javalin started");
	}

	private static void establishRoutes(Javalin app) {

		ClientDAO cd = new ClientDAODBImpl();
		ClientService cs = new ClientServiceImpl(cd);
		ClientController cc = new ClientController(cs);

		AccountDAO ad = new AccountDAODBImpl();
		AccountService as = new AccountServiceImpl(ad);
		AccountController ac = new AccountController(as);

		app.get("/", (ctx) -> ctx.result("this is our homepage"));
		app.get("/clients", cc.getAllClients);
		app.get("/clients/:id", cc.getClient);

		app.post("/clients", cc.addClient);

		app.put("/clients/:id", cc.updateClient);

		app.delete("/clients/:id", cc.deleteClient);

		app.get("/clients/:id/accounts/", ac.getAllAccounts);

		app.get("/clients/:id/accounts/:a_id", ac.getAccount);

		app.post("/clients/:id/accounts/", ac.addAccount);

		app.put("/clients/:id/accounts/:a_id", ac.updateAccount);

		app.delete("/clients/:id/accounts/:a_id", ac.deleteAccount);

		app.patch("/clients/:id/accounts/:a_id/withdraw/:funds", ac.withdrawAccount);

		app.patch("/clients/:id/accounts/:a_id/deposit/:funds", ac.depositAccount);

		app.patch("/clients/:id/accounts/:a_id/transfer/:a_id2/:funds", ac.transferAccount);
	}

}
