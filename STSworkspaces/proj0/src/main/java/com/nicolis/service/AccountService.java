package com.nicolis.service;

import java.util.List;

import com.nicolis.proj0.Account;

public interface AccountService {
	public Account createAccount(Account a);

	public Account getAccount(int id);

	public List<Account> getAllAccounts();

	public Account updateAccount(Account change);

	public Account deleteAccount(int id);

	public Account transferFunds(int funds);

	public Account withdrawFunds(int funds);

	public Account depositFunds(int funds);

	Account withdrawFunds(Account a, int funds);

	Account depositFunds(Account a, int funds);

	public List<Account> getAllAccounts(int id);

	public List<Account> getAllAccounts(int id, int funds, int funds1);

	public Account getAccount(int a_id, int id);

	public Account createAccount(Account a, int client_id);

	public Account withdrawFunds(Account a, int x, int id, int a_id);

	public Account depositFunds(Account a, int x, int id, int a_id);
}