package com.nicolis.service;

import java.util.List;

import com.nicolis.dao.ClientDAO;
import com.nicolis.proj0.Client;

public class ClientServiceImpl implements ClientService {

	public ClientDAO cd;

	public ClientServiceImpl(ClientDAO cd) {
		super();
		this.cd = cd;
	}

	@Override
	public Client getClient(int id) {
		return cd.getClient(id);
	}

	@Override
	public List<Client> GetAllClients() {
		return cd.getAllClients();
	}

	@Override
	public Client createClient(Client c) {
		return cd.createClient(c);
	}

	@Override
	public Client updateClient(Client change) {
		return cd.updateClient(change);
	}

	@Override
	public Client deleteClient(int id) {
		return cd.deleteClient(id);
	}

	public Object getAllClients() {
		return cd.getAllClients();
	}

}
