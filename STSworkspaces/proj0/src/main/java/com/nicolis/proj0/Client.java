package com.nicolis.proj0;

public class Client {

	private int id;
	private String phone;
	private String user;
	private String pass;
	private String email;
	private boolean available;

	// no-args constructor
	public Client() {
		super();
	}

	// full-args constructor
	public Client(String phone, String user, String pass, String email, int id) {
		super();
		this.user = user;
		this.phone = phone;
		this.pass = pass;
		this.email = email;
		this.id = id;
	}

	// id-less constructor
	public Client(String phone, String user, String pass, String email) {
		super();
		this.phone = phone;
		this.user = user;
		this.pass = pass;
		this.email = email;
	}
	// gets and sets

	public int getId() {
		return id;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", phone=" + phone + ", user=" + user + ", pass=" + pass + ", email=" + email
				+ ", available=" + available + "]";
	}

}
