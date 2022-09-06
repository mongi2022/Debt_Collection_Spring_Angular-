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

import com.recouvrement.projet.Services.ReclamationServiceImplement;
import com.recouvrement.projet.Models.Reclamation;

@RestController
@RequestMapping("Reclamation")
public class ReclamationController {
@Autowired
ReclamationServiceImplement reclamationServiceImplement;
@PostMapping
public Reclamation AjoutReclamation(@RequestBody @Valid Reclamation reclamation)
{
return reclamationServiceImplement.addOneReclamation(reclamation);	
}
@GetMapping
public List<Reclamation> getAllReclamation()
{
return reclamationServiceImplement.findReclamations();	
}
@GetMapping("/{id}")
public Optional<Reclamation> getMyReclamation(@PathVariable String id)
{
return reclamationServiceImplement.findOneReclamation(id);	
}
@DeleteMapping("/{id}")
public void deleteOne(@PathVariable String id)
{
reclamationServiceImplement.deleteReclamation(id);	

}

}
