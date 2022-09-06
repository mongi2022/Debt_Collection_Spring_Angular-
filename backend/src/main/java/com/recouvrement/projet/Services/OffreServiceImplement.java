package com.recouvrement.projet.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recouvrement.projet.Models.Offre;
import com.recouvrement.projet.Repositories.OffreRepository;

@Service
public class OffreServiceImplement implements OffreInterfaceService {
@Autowired
OffreRepository offreRepository;
	@Override
	public Offre addOneOffre(Offre offre) {
		// TODO Auto-generated method stub
		return offreRepository.save(offre);
	}

	@Override
	public List<Offre> findOffres() {
		// TODO Auto-generated method stub
		return offreRepository.findAll();
	}

	@Override
	public Optional<Offre> findOneOffre(String id) {
		// TODO Auto-generated method stub
		return offreRepository.findById(id);
	}

	@Override
	public void deleteOffre(String id) {
		// TODO Auto-generated method stub
		offreRepository.deleteById(id);
	}

}

