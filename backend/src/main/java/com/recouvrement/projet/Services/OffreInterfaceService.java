package com.recouvrement.projet.Services;

import java.util.List;
import java.util.Optional;

import com.recouvrement.projet.Models.Offre;

public interface OffreInterfaceService {
	public Offre addOneOffre(Offre offre);
	public List<Offre> findOffres();
	public Optional<Offre> findOneOffre(String id);
	public void deleteOffre(String id);

}
