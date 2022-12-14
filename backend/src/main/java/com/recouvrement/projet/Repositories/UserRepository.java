package com.recouvrement.projet.Repositories;

import com.recouvrement.projet.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")

public interface UserRepository extends MongoRepository<User,Long> {
    User findByUsername(String username);

}
