package com.recouvrement.projet.Services;

import java.util.List;
import java.util.Optional;

import com.recouvrement.projet.Models.Contrat;

public interface ContratInterfaceService {
	public Contrat addOneContrat(Contrat contrat);
	public List<Contrat> findContrats();
	public Optional<Contrat> findOneContrat(String id);
	public void deleteContrat(String id);

}
