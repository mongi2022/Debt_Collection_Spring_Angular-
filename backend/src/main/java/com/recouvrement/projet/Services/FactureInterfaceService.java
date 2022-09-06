package com.recouvrement.projet.Services;

import java.util.List;
import java.util.Optional;

import com.recouvrement.projet.Models.Facture;

public interface FactureInterfaceService {
	public Facture addOneFacture(Facture facture);
	public List<Facture> findFactures();
	public Optional<Facture> findOneFacture(String id);
	public void deleteFacture(String id);

}
