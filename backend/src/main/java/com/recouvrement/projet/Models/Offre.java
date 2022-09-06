package com.recouvrement.projet.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Offre {
@Id
private String id;
private String titre;
private String description;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Offre(String id, String titre, String description) {
	super();
	this.id = id;
	this.titre = titre;
	this.description = description;
}
public Offre() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Offre [id=" + id + ", titre=" + titre + ", description=" + description + "]";
}


}
