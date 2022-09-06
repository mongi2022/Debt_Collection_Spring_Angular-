package com.recouvrement.projet;

import com.recouvrement.projet.Models.Client;
import com.recouvrement.projet.Models.Role;
import com.recouvrement.projet.Models.User;
import com.recouvrement.projet.Services.AccountService;
import com.recouvrement.projet.Services.ClientInterfaceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class TTrecouvrementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TTrecouvrementApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner start( ClientInterfaceService clientInterfaceService,
							AccountService accountService){
   return args -> {
	// clientInterfaceService.addOneClient(new Client(null,"code3","ali",28,"adr1","adr2","tel1","tel2","05879445","standard","st@yahoo.fr","12345","matfis5"));
	//   accountService.addNewRole(new Role(null,"CLIENT"));
	//   accountService.addNewRole(new Role(null,"USER"));
//	   accountService.addNewRole(new Role(null,"ADMIN"));
//	   accountService.addNewRole(new Role(null,"CUSTOMER_MANAGER"));
//	   accountService.addNewRole(new Role(null,"PRODUCT_MANAGER"));
//	   accountService.addNewRole(new Role(null,"BILLS_MANAGER"));
	   //**************users
	 //  accountService.addNewUser(new User(null,"ali","1234",new ArrayList<>()));

//	   accountService.addNewUser(new User(null,"user1","1234",new ArrayList<>()));
//	   accountService.addNewUser(new User(null,"admin","1234",new ArrayList<>()));
//	   accountService.addNewUser(new User(null,"user2","1234",new ArrayList<>()));
//	   accountService.addNewUser(new User(null,"user3","1234",new ArrayList<>()));
//	   accountService.addNewUser(new User(null,"user4","1234",new ArrayList<>()));
	   //***roles to users
//	   accountService.addRoleToUser("ali","CLIENT");
//		   accountService.addRoleToUser("user2","CLIENT");

//	   accountService.addRoleToUser("admin","USER");
//	   accountService.addRoleToUser("admin","ADMIN");
//	   accountService.addRoleToUser("user2","USER");
//	   accountService.addRoleToUser("user2","CUSTOMER_MANAGER");
//	   accountService.addRoleToUser("user3","USER");
//	   accountService.addRoleToUser("user3","PRODUCT_MANAGER");
//	   accountService.addRoleToUser("user4","USER");
//	   accountService.addRoleToUser("user4","CUSTOMER_MANAGER");
   };
	}
}
