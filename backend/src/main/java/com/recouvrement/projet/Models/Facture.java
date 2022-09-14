package com.recouvrement.projet.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facture {
@Id
private String id;
private String numFacture;
private String identifiant;
private String codeClient;
private String numTelephone;
private String refFacture;
private String nomClient;
private String adresse;
private String pointVente;
private String DPC;
private String montantCreance;
private String soldCreance;

}
