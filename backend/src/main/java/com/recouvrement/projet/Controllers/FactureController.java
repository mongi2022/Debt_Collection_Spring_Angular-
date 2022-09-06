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

import com.recouvrement.projet.Services.FactureServiceImplement;
import com.recouvrement.projet.Models.Facture;

@RestController
@RequestMapping("Facture")
public class FactureController {
@Autowired
FactureServiceImplement factureServiceImplement;
@PostMapping
public Facture AjoutFacture(@RequestBody @Valid Facture facture)
{
return factureServiceImplement.addOneFacture(facture);	
}
@GetMapping
public List<Facture> getAllFacture()
{
return factureServiceImplement.findFactures();	
}
@GetMapping("/{id}")
public Optional<Facture> getMyFacture(@PathVariable String id)
{
	return factureServiceImplement.findOneFacture(id);
}
@DeleteMapping("/{id}")
public void deleteOne(@PathVariable String id)
{
	factureServiceImplement.deleteFacture(id);	

}

}
