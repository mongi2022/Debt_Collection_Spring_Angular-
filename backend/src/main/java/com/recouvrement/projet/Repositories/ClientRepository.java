package com.recouvrement.projet.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.recouvrement.projet.Models.Client;

public interface ClientRepository extends MongoRepository<Client, String> {

}
