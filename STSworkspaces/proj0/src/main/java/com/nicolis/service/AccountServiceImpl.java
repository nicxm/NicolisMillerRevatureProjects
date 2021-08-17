package com.nicolis.service;

import java.util.List;

import com.nicolis.dao.AccountDAO;
import com.nicolis.proj0.Account;

public class AccountServiceImpl implements AccountService {

	public AccountDAO ad;

	public AccountServiceImpl(AccountDAO ad) {
		super();
		this.ad = ad;
	}

	@Override
	public Account createAccount(Account a) {
		return ad.createAccount(a);
	}

	@Override
	public Account getAccount(int id) {
		return ad.getAccount(id);
	}

	@Override
	public List<Account> getAllAccounts() {
		return ad.getAllAccounts();
	}

	@Override
	public Account updateAccount(Account change) {
		return ad.updateAccount(change);
	}

	@Override
	public Account deleteAccount(int id) {
		return ad.deleteAccount(id);
	}

	@Override
	public Account transferFunds(int funds) {
		return ad.transferFunds(funds);
	}

	@Override
	public Account withdrawFunds(Account a, int funds) {
		return ad.withdrawFunds(a, funds);
	}

	@Override
	public Account depositFunds(Account a, int funds) {
		return ad.depositFunds(a, funds);
	}

	@Override
	public Account withdrawFunds(int funds) {
		return ad.withdrawFunds(null, funds);
	}

	@Override
	public Account depositFunds(int funds) {
		return ad.depositFunds(null, funds);
	}

	@Override
	public List<Account> getAllAccounts(int id) {
		return ad.getAllAccounts(id);
	}

	@Override
	public List<Account> getAllAccounts(int id, int funds, int funds1) {
		return ad.getAllAccounts(id, funds, funds1);
	}

	@Override
	public Account getAccount(int a_id, int id) {
		return ad.getAccount(id, a_id);
	}

	@Override
	public Account createAccount(Account a, int client_id) {
		return ad.createAccount(a, client_id);
	}

	@Override
	public Account withdrawFunds(Account a, int x, int id, int a_id) {
		return ad.withdrawFunds(a, x, id, a_id);
	}

	@Override
	public Account depositFunds(Account a, int x, int id, int a_id) {
		return ad.depositFunds(a, x, id, a_id);
	}

}