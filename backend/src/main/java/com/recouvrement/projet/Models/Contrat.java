package com.recouvrement.projet.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Contrat {
@Id
private String id;
private String codeContrat;
private String typeOffre;
private String numAppel;
private String dateActivation;
private String duree;


}
