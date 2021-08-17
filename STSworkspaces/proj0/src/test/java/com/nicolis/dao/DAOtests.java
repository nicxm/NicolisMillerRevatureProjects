package com.nicolis.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.nicolis.proj0.Account;
import com.nicolis.proj0.Client;
import com.nicolis.service.AccountServiceImpl;
import com.nicolis.service.ClientServiceImpl;

public class DAOtests {

	@Test
	public void test() {
		AccountDAODBImpl test = new AccountDAODBImpl();
		Account newAccount = new Account(300, "new account type", 2);
		Account updateAccount = new Account(2, 300, "updated account type", 2);

		assertNotNull("Testing that getAllAccounts is not null", test.getAllAccounts(2));
		assertNotNull("Testing that getAllAccounts (by funds) is not null", test.getAllAccounts(2, 900, 100));
		assertNotNull("Testing that getAccount is not null", test.getAccount(2, 2));
		assertNotNull("Testing that withdrawFunds is not null", test.withdrawFunds(newAccount, 100, 2, 2));
		assertNotNull("Testing that depositFunds is not null", test.depositFunds(newAccount, 100, 2, 2));

		newAccount = test.createAccount(newAccount);
		assertNotNull("Testing that the created account is not null", newAccount);
		updateAccount = test.updateAccount(updateAccount);
		assertNotNull("Testing that that the updated account is not null", updateAccount);
		int x = newAccount.getId();
		assertNotNull("Testing that delete account is not null", test.deleteAccount(x));

		// CLIENT DAO TESTS

		ClientDAODBImpl testcd = new ClientDAODBImpl();
		Client createc = new Client("phone", "user", "pass", "email", 11);
		assertNotNull("Testing that CreateClient is not null", testcd.createClient(createc));
		assertNotNull("Testing that getClient is not null", testcd.getClient(2));
		assertNotNull("Testing that getallClient is not null", testcd.getAllClients());
		assertNotNull("Testing that updateClient is not null", testcd.updateClient(createc));
		x = createc.getId();
		assertNotNull("Testing that deleteClient is not null", testcd.deleteClient(x));

		// account services

		AccountServiceImpl testac = new AccountServiceImpl(test);

		assertNotNull("Testing that getAllAccounts is not null", testac.getAllAccounts(2));
		assertNotNull("Testing that getAllAccounts (by funds) is not null", testac.getAllAccounts(2, 900, 100));
		assertNotNull("Testing that getAccount is not null", testac.getAccount(2, 2));
		assertNotNull("Testing that withdrawFunds is not null", testac.withdrawFunds(newAccount, 100, 2, 2));
		assertNotNull("Testing that depositFunds is not null", testac.depositFunds(newAccount, 100, 2, 2));

		newAccount = testac.createAccount(newAccount);
		assertNotNull("Testing that the created account is not null", newAccount);
		updateAccount = testac.updateAccount(updateAccount);
		// assertNotNull("Testing that that the updated account is not null",
		// updateAccount);
		x = newAccount.getId();
		assertNotNull("Testing that delete account is not null", testac.deleteAccount(x));

		// Client service

		ClientServiceImpl testcs = new ClientServiceImpl(testcd);

		Client createcs = new Client("phone", "user", "pass", "email", 12);
		assertNotNull("Testing that CreateClient is not null", testcs.createClient(createcs));
		assertNotNull("Testing that getClient is not null", testcs.getClient(2));
		assertNotNull("Testing that getallClient is not null", testcs.getAllClients());
		assertNotNull("Testing that updateClient is not null", testcs.updateClient(createcs));
		x = createcs.getId();
		assertNotNull("Testing that deleteClient is not null", testcs.deleteClient(x));

	}

}
