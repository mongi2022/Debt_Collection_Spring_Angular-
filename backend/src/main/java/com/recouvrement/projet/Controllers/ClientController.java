package com.recouvrement.projet.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recouvrement.projet.Services.ClientServiceImplement;
import com.recouvrement.projet.Models.Client;

@RestController
@RequestMapping("Client")
public class ClientController {
private ClientServiceImplement clientServiceImplement;

	public ClientController(ClientServiceImplement clientServiceImplement) {
		this.clientServiceImplement = clientServiceImplement;
	}

	@PostMapping
public Client AjoutClient(@RequestBody @Valid Client client)
{
return clientServiceImplement.addOneClient(client);	
}
@GetMapping
public List<Client> getAllClient()
{
return clientServiceImplement.findClients();	
}
@GetMapping("/{id}")
public Optional<Client> getMyClient(@PathVariable String id)
{
return clientServiceImplement.findOneClient(id);	
}
@DeleteMapping("/{id}")
public void deleteOne(@PathVariable String id)
{
	clientServiceImplement.deleteClient(id);	

}

}
