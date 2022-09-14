package com.recouvrement.projet.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Document
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class User {
    @Id
    private String id;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

   @DBRef(lazy = false)
    private HashSet<Role> roles=new HashSet<>();
//    @ManyToMany(fetch = FetchType.EAGER)
//    private Collection<AppRole>  appRoles=new ArrayList<>();
}
