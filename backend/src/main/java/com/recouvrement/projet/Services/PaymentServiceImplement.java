package com.recouvrement.projet.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recouvrement.projet.Models.Payment;
import com.recouvrement.projet.Repositories.PaymentRepository;

@Service
public class PaymentServiceImplement implements PaymentInterfaceService {
@Autowired
PaymentRepository paymentRepository;
	@Override
	public Payment addOnePayment(Payment payment) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> findPayments() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

	@Override
	public Optional<Payment> findOnePayment(String id) {
		// TODO Auto-generated method stub
		return paymentRepository.findById(id);
	}

	@Override
	public void deletePayment(String id) {
		// TODO Auto-generated method stub
		paymentRepository.deleteById(id);
	}

}

