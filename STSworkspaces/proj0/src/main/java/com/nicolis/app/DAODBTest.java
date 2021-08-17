package com.nicolis.app;

import com.nicolis.dao.AccountDAO;
import com.nicolis.dao.AccountDAODBImpl;
import com.nicolis.proj0.Account;

public class DAODBTest {

	public static void main(String[] args) {
		AccountDAO ad = new AccountDAODBImpl();

//		works get account using a_id and client id
//		Account a = ad.getAccount(2, 2);
//		System.out.println(a);

//		works get all accounts + get all with specific funds
//		System.out.println(ad.getAllAccounts(2));
//		System.out.println(ad.getAllAccounts(2, 600, 100));

//		works
//		System.out.println(ad.deleteAccount(1));

//		works
//		Account newAccount = new Account(300, "new account type", 2);
//		newAccount = ad.createAccount(newAccount);
//		System.out.println(newAccount);

		Account newAccount = new Account(2, 300, "new account type", 2);
//		works with account id
//		newAccount = ad.updateAccount(newAccount);

		// newAccount = ad.depositFunds(newAccount, 1000);
		// newAccount = ad.withdrawFunds(newAccount, 100);

		System.out.println(newAccount);
	}

}
