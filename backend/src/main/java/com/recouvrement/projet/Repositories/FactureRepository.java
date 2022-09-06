package com.recouvrement.projet.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.recouvrement.projet.Models.Facture;

public interface FactureRepository extends MongoRepository<Facture, String> {

}
