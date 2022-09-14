package com.recouvrement.projet.Controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private static final String TWILIO_ACCOUNT_SID = "ACcac97fa6d1b3d033aba56f7451589291";
    private static final String TWILIO_AUTH_TOKEN = "b2a210d3ac736aef9b12a27aa7ba3edf";
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

    @GetMapping(value = "/sendSMS")
    public ResponseEntity<String> sendSMS() {

        Twilio.init(System.getenv(TWILIO_ACCOUNT_SID), System.getenv(TWILIO_AUTH_TOKEN));

        Message.creator(new PhoneNumber("+21625254561"),
                new PhoneNumber("+21627083675"), "Hello from Twilio 📞").create();

        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }

}
