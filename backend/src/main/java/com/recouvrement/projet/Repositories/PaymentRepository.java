package com.recouvrement.projet.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.recouvrement.projet.Models.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {

}
