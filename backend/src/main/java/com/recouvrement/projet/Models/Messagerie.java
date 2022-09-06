package com.recouvrement.projet.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Messagerie {
@Id
private String id;
}
