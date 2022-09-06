package com.recouvrement.projet.Services;

import com.recouvrement.projet.Models.Role;
import com.recouvrement.projet.Models.User;
import com.recouvrement.projet.Repositories.AppRoleRepository;
import com.recouvrement.projet.Repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    private PasswordEncoder passwordEncoder;
    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User addNewUser(User user) {
         String pw= user.getPassword();
         user.setPassword(passwordEncoder.encode(pw));
        return appUserRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {

        return appRoleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
    User user =appUserRepository.findByUsername(username);
    Role role =appRoleRepository.findByRoleName(roleName);
    user.getRoles().add(role);
    }

    @Override
    public User getUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsersService() {

        return appUserRepository.findAll();
    }
}
