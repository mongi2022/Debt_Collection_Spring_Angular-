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

import com.recouvrement.projet.Services.MessagerieServiceImplement;
import com.recouvrement.projet.Models.Messagerie;

@RestController
@RequestMapping("Messagerie")
public class MessagerieController {
@Autowired
MessagerieServiceImplement messagerieServiceImplement;
@PostMapping
public Messagerie AjoutMessagerie(@RequestBody @Valid Messagerie messagerie)
{
return messagerieServiceImplement.addOneMessagerie(messagerie);	
}
@GetMapping
public List<Messagerie> getAllMessagerie()
{
return messagerieServiceImplement.findMessageries();	
}
@GetMapping("/{id}")
public Optional<Messagerie> getMyMessagerie(@PathVariable String id)
{
return messagerieServiceImplement.findOneMessagerie(id);	
}
@DeleteMapping("/{id}")
public void deleteOne(@PathVariable String id)
{
messagerieServiceImplement.deleteMessagerie(id);	

}

}
