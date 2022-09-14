package com.recouvrement.projet.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.*;

import com.recouvrement.projet.Services.ClientServiceImplement;
import com.recouvrement.projet.Models.Client;

@CrossOrigin(origins = "http://localhost:4200")

@RestController

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
@GetMapping(path = "clients")

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
