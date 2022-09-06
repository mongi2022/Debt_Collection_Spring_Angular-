package com.recouvrement.projet.Services;

import java.util.List;
import java.util.Optional;

import com.recouvrement.projet.Models.Payment;

public interface PaymentInterfaceService {
	public Payment addOnePayment(Payment payment);
	public List<Payment> findPayments();
	public Optional<Payment> findOnePayment(String id);
	public void deletePayment(String id);

}
