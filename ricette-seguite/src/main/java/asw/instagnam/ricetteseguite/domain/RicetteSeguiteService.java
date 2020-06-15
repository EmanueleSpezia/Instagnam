package asw.instagnam.ricetteseguite.domain;

import org.springframework.stereotype.Service;

import asw.instagnam.ricetteseguite.rest.RicetteSeguiteController;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.logging.Logger; 

@Service 
public class RicetteSeguiteService {


	@Autowired
	private RicetteService ricetteService;
	
	@Autowired 
	private ConnessioniService connessioniService;

	/* Trova le ricette (in formato breve) degli utenti seguiti da utente. */ 
	public Collection<Ricetta> getRicetteSeguite(String utente) {
		Collection<Ricetta> ricette = new ArrayList<>(); 
		Collection<Connessione> connessioni = this.connessioniService.getConnessioniByFollower(utente); 
		for (Connessione connessione : connessioni) {
			String followed = connessione.getFollowed();
			Collection<Ricetta> ricetteByFollowed = this.ricetteService.getRicetteByAutore(followed);
			ricette.addAll(ricetteByFollowed);
		}
		return ricette; 
	}
	
}
