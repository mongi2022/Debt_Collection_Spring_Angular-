package com.recouvrement.projet.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.recouvrement.projet.Models.Client;
import com.recouvrement.projet.Repositories.ClientRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;


@Service
@Transactional
public class ClientServiceImplement implements ClientInterfaceService {
private ClientRepository clientRepository;

	public ClientServiceImplement(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public Client addOneClient(Client client) {
		// TODO Auto-generated method stub
		return clientRepository.save(client);
	}

	@Override
	public List<Client> findClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Optional<Client> findOneClient(String id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(id);
	}

	@Override
	public void deleteClient(String id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);
	}

}

