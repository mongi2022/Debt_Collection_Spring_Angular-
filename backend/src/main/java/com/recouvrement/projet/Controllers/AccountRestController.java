package com.recouvrement.projet.Controllers;

import com.recouvrement.projet.Futures.RoleUserForm;
import com.recouvrement.projet.Models.Role;
import com.recouvrement.projet.Models.User;
import com.recouvrement.projet.Services.AccountService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")

@RestController

public class AccountRestController {
    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }
   @GetMapping(path = "/users")
   //@PostAuthorize("hasAuthority('USER')")
    public List<User> getAllUsersController(){
        return accountService.getAllUsersService();
    }
    @PostMapping(path = "/users")
  // @PostAuthorize("hasAuthority('ADMIN')")

    public User saveUser(@RequestBody User user){
        return accountService.addNewUser(user);
   }
    @PostMapping(path = "/roles")
    public Role saveRole(@RequestBody Role role){
        return accountService.addNewRole(role);
    }
    @PostMapping(path = "/addRoleToUser")
    public void saveRoleToUser(@RequestBody RoleUserForm roleUserForm){

            accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRoleName());



    }
}
