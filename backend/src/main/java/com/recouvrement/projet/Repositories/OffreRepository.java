package com.recouvrement.projet.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.recouvrement.projet.Models.Offre;

public interface OffreRepository extends MongoRepository<Offre, String> {

}
