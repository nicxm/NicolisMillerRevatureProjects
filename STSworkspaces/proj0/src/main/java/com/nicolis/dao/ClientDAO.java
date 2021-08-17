package com.nicolis.dao;

import java.util.List;

import com.nicolis.proj0.Client;

public interface ClientDAO {

	public Client createClient(Client c);

	public Client getClient(int id);

	public List<Client> getAllClients();

	public Client updateClient(Client change);

	public Client deleteClient(int id);

	public Client isAvailable(boolean available);

}
