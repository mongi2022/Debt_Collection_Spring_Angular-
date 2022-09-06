package com.recouvrement.projet.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
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
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getNumFacture() {
	return numFacture;
}
public void setNumFacture(String numFacture) {
	this.numFacture = numFacture;
}
public String getIdentifiant() {
	return identifiant;
}
public void setIdentifiant(String identifiant) {
	this.identifiant = identifiant;
}
public String getCodeClient() {
	return codeClient;
}
public void setCodeClient(String codeClient) {
	this.codeClient = codeClient;
}
public String getNumTelephone() {
	return numTelephone;
}
public void setNumTelephone(String numTelephone) {
	this.numTelephone = numTelephone;
}
public String getRefFacture() {
	return refFacture;
}
public void setRefFacture(String refFacture) {
	this.refFacture = refFacture;
}
public String getNomClient() {
	return nomClient;
}
public void setNomClient(String nomClient) {
	this.nomClient = nomClient;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getPointVente() {
	return pointVente;
}
public void setPointVente(String pointVente) {
	this.pointVente = pointVente;
}
public String getDPC() {
	return DPC;
}
public void setDPC(String dPC) {
	DPC = dPC;
}
public String getMontantCreance() {
	return montantCreance;
}
public void setMontantCreance(String montantCreance) {
	this.montantCreance = montantCreance;
}
public String getSoldCreance() {
	return soldCreance;
}
public void setSoldCreance(String soldCreance) {
	this.soldCreance = soldCreance;
}
@Override
public String toString() {
	return "Facture [id=" + id + ", numFacture=" + numFacture + ", identifiant=" + identifiant + ", codeClient="
			+ codeClient + ", numTelephone=" + numTelephone + ", refFacture=" + refFacture + ", nomClient=" + nomClient
			+ ", adresse=" + adresse + ", pointVente=" + pointVente + ", DPC=" + DPC + ", montantCreance="
			+ montantCreance + ", soldCreance=" + soldCreance + "]";
}
public Facture(String id, String numFacture, String identifiant, String codeClient, String numTelephone,
		String refFacture, String nomClient, String adresse, String pointVente, String dPC, String montantCreance,
		String soldCreance) {
	super();
	this.id = id;
	this.numFacture = numFacture;
	this.identifiant = identifiant;
	this.codeClient = codeClient;
	this.numTelephone = numTelephone;
	this.refFacture = refFacture;
	this.nomClient = nomClient;
	this.adresse = adresse;
	this.pointVente = pointVente;
	DPC = dPC;
	this.montantCreance = montantCreance;
	this.soldCreance = soldCreance;
}
public Facture() {
	super();
	// TODO Auto-generated constructor stub
}

}
