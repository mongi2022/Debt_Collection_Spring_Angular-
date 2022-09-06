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

import com.recouvrement.projet.Services.PaymentServiceImplement;
import com.recouvrement.projet.Models.Payment;

@RestController
@RequestMapping("Payment")
public class PaymentController {
@Autowired
PaymentServiceImplement paymentServiceImplement;
@PostMapping
public Payment AjoutPayment(@RequestBody @Valid Payment payment)
{
return paymentServiceImplement.addOnePayment(payment);	
}
@GetMapping
public List<Payment> getAllPayment()
{
return paymentServiceImplement.findPayments();	
}
@GetMapping("/{id}")
public Optional<Payment> getMyPayment(@PathVariable String id)
{
return paymentServiceImplement.findOnePayment(id);	
}
@DeleteMapping("/{id}")
public void deleteOne(@PathVariable String id)
{
paymentServiceImplement.deletePayment(id);	

}

}
