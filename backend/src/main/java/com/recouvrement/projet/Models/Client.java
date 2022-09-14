package com.recouvrement.projet.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;


@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Client {
@Id
	private String id;
    private String codeClient;
	private String fullName;
	private int    age;
	private String adresse1;
	private String adresse2;
	private String tel1;
	private String tel2;
	private String cin;
	private String profile;
	private String email;
	private String password;
	private String matFiscal;

}
