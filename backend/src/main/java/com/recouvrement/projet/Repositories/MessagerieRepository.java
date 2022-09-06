package com.recouvrement.projet.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.recouvrement.projet.Models.Messagerie;

public interface MessagerieRepository extends MongoRepository<Messagerie, String> {

}
