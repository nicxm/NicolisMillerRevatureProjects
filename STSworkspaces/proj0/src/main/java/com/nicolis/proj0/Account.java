package com.nicolis.proj0;

public class Account {

	private int id;
	private int funds;
	private String accountType;
	private int client_id;

	public Account() {
		super();
	}

	public Account(int id, int funds, String accountType, int client_id) {
		super();
		this.id = id;
		this.funds = funds;
		this.accountType = accountType;
		this.client_id = client_id;
	}

	public Account(int id, int funds, String accountType) {
		super();
		this.id = id;
		this.funds = funds;
		this.accountType = accountType;
	}

	public Account(int funds, String accountType) {
		super();
		this.funds = funds;
		this.accountType = accountType;
	}

	public Account(int funds, String accountType, int client_id) {
		super();
		this.funds = funds;
		this.accountType = accountType;
		this.client_id = client_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFunds() {
		return funds;
	}

	public void setFunds(int funds) {
		this.funds = funds;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", funds=" + funds + ", accountType=" + accountType + ", client_id=" + client_id
				+ "]";
	}
}
