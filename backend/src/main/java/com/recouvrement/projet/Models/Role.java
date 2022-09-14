package com.recouvrement.projet.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;



@Document
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Role {
    @Id
    private String id ;
    private String roleName;
}
