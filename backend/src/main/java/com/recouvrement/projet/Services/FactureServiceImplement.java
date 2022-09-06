package com.recouvrement.projet.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recouvrement.projet.Models.Facture;
import com.recouvrement.projet.Repositories.FactureRepository;

@Service
public class FactureServiceImplement implements FactureInterfaceService {
@Autowired
FactureRepository factureRepository;
	@Override
	public Facture addOneFacture(Facture facture) {
		// TODO Auto-generated method stub
		return factureRepository.save(facture);
	}

	@Override
	public List<Facture> findFactures() {
		// TODO Auto-generated method stub
		return factureRepository.findAll();
	}

	@Override
	public Optional<Facture> findOneFacture(String id) {
		// TODO Auto-generated method stub
		return factureRepository.findById(id);
	}

	@Override
	public void deleteFacture(String id) {
		// TODO Auto-generated method stub
		factureRepository.deleteById(id);
	}

}
