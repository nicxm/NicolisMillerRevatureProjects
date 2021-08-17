package com.nicolis.service;

import java.util.List;

import com.nicolis.proj0.Client;

public interface ClientService {

	public Client getClient(int id);

	public List<Client> GetAllClients();

	public Client createClient(Client c);

	public Client updateClient(Client change);

	public Client deleteClient(int id);
}
