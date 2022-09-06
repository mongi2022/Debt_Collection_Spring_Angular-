package com.recouvrement.projet.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recouvrement.projet.Services.ContratServiceImplement;
import com.recouvrement.projet.Models.Contrat;

@RestController
@RequestMapping("Contrat")
public class ContratController {
@Autowired
ContratServiceImplement contratServiceImplement;
@PostMapping
public Contrat AjoutContrat(@RequestBody @Valid Contrat contrat)
{
return contratServiceImplement.addOneContrat(contrat);	
}
@GetMapping
public List<Contrat> getAllContrat()
{
return contratServiceImplement.findContrats();	
}
@GetMapping("/{id}")
public Optional<Contrat> getMyContrat(@PathVariable String id)
{
return contratServiceImplement.findOneContrat(id);	
}
@DeleteMapping("/{id}")
public void deleteOne(@PathVariable String id)
{
	contratServiceImplement.deleteContrat(id);	

}

}
