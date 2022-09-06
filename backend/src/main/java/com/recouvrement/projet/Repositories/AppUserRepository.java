package com.recouvrement.projet.Repositories;

import com.recouvrement.projet.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppUserRepository extends MongoRepository<User,Long> {
    User findByUsername(String username);

}
