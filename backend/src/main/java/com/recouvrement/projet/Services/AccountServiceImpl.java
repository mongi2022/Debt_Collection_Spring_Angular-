package com.recouvrement.projet.Services;

import com.recouvrement.projet.Models.Role;
import com.recouvrement.projet.Models.User;
import com.recouvrement.projet.Repositories.RoleRepository;
import com.recouvrement.projet.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;
@Service
@Transactional

public class AccountServiceImpl implements AccountService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;
    public AccountServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User addNewUser(User user) {
         String pw= user.getPassword();
         user.setPassword(passwordEncoder.encode(pw));
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
    User user = userRepository.findByUsername(username);
    Role role = roleRepository.findByRoleName(roleName);
    // user.getRoles().add(0,role);
        user.getRoles().add(role);
        userRepository.save(user);
//        if (user.getRoles() == null) {
//
//        } else if (role.getRoleName()!=roleName) {
//
//        } else if (role.getRoleName()==roleName) {
//            System.out.println("Role existe déja");
//        }

    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsersService() {

        return userRepository.findAll();
    }
}
