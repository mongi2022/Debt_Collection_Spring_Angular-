package com.recouvrement.projet.Services;

import java.util.List;
import java.util.Optional;

import com.recouvrement.projet.Models.Messagerie;

public interface MessagerieInterfaceService {
	public Messagerie addOneMessagerie(Messagerie messagerie);
	public List<Messagerie> findMessageries();
	public Optional<Messagerie> findOneMessagerie(String id);
	public void deleteMessagerie(String id);
}
