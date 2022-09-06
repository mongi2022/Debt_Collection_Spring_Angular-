package com.recouvrement.projet.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Payment {
@Id
private String id;
private String date;
private String montant;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getMontant() {
	return montant;
}
public void setMontant(String montant) {
	this.montant = montant;
}
public Payment(String id, String date, String montant) {
	super();
	this.id = id;
	this.date = date;
	this.montant = montant;
}
public Payment() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Payment [id=" + id + ", date=" + date + ", montant=" + montant + "]";
}


}
