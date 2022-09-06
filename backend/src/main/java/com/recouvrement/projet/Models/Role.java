package com.recouvrement.projet.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {
    @Id
    private String id ;
    private String roleName;
}
