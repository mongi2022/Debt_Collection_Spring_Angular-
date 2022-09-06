package com.recouvrement.projet.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.recouvrement.projet.Models.Contrat;

public interface ContratRepository extends MongoRepository<Contrat, String> {

}
