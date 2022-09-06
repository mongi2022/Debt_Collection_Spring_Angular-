package com.recouvrement.projet.Services;

import com.recouvrement.projet.Models.Role;
import com.recouvrement.projet.Models.User;

import java.util.List;

public interface AccountService {
    User addNewUser (User user);
    Role addNewRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUserByUsername(String username);
    List<User> getAllUsersService();
}
