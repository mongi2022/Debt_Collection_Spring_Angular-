package com.recouvrement.projet.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recouvrement.projet.Models.Contrat;
import com.recouvrement.projet.Repositories.ContratRepository;

@Service
public class ContratServiceImplement implements ContratInterfaceService {
@Autowired
ContratRepository contratRepository;
	@Override
	public Contrat addOneContrat(Contrat contrat) {
		// TODO Auto-generated method stub
		return contratRepository.save(contrat);
	}

	@Override
	public List<Contrat> findContrats() {
		// TODO Auto-generated method stub
		return contratRepository.findAll();
	}

	@Override
	public Optional<Contrat> findOneContrat(String id) {
		// TODO Auto-generated method stub
		return contratRepository.findById(id);
	}

	@Override
	public void deleteContrat(String id) {
		// TODO Auto-generated method stub
		contratRepository.deleteById(id);
	}

	
}

