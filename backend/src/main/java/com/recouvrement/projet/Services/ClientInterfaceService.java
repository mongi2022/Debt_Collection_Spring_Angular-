package com.recouvrement.projet.Services;

import java.util.List;
import java.util.Optional;

import com.recouvrement.projet.Models.Client;

public interface ClientInterfaceService {
	public Client addOneClient(Client client);
	public List<Client> findClients();
	public Optional<Client> findOneClient(String id);
	public void deleteClient(String id);
	

}
