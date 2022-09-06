package com.recouvrement.projet.Repositories;

import com.recouvrement.projet.Models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppRoleRepository extends MongoRepository<Role,String> {
    Role findByRoleName(String roleName);

}
