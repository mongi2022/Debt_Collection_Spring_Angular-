package com.recouvrement.projet.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.recouvrement.projet.Models.Reclamation;

public interface ReclamationRepository extends MongoRepository<Reclamation, String> {

}
