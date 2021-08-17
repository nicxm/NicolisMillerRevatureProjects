package com.nicolis.dao;

import java.util.List;

import com.nicolis.proj0.Account;

public interface AccountDAO {
	public Account createAccount(Account a);

	public Account getAccount(int id);

	public List<Account> getAllAccounts();

	public Account updateAccount(Account change);

	public Account deleteAccount(int id);

	public Account transferFunds(int funds);

	List<Account> getAllAccounts(int client_id);

	List<Account> getAllAccounts(int client_id, int funds);

	List<Account> getAllAccounts(int client_id, int funds, int funds1);

	Account getAccount(int id, int client_id);

	Account depositFunds(Account deposit, int x);

	Account withdrawFunds(Account withdraw, int x);

	Account createAccount(Account a, int client_id);

	Account withdrawFunds(Account withdraw, int x, int id, int client_id);

	Account depositFunds(Account deposit, int x, int id, int client_id);
}
