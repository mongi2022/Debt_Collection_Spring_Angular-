package com.recouvrement.projet.Controllers;

import com.recouvrement.projet.Futures.RoleUserForm;
import com.recouvrement.projet.Models.Role;
import com.recouvrement.projet.Models.User;
import com.recouvrement.projet.Services.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class AccountRestController {
    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }
   @GetMapping(path = "/users")
    public List<User> getAllUsersController(){
        return accountService.getAllUsersService();
    }
    @PostMapping(path = "/users")
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
