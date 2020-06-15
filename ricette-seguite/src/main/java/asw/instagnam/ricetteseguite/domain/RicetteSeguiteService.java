package asw.instagnam.ricetteseguite.domain;

import org.springframework.stereotype.Service;

import asw.instagnam.ricetteseguite.rest.RicetteSeguiteController;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.logging.Logger; 

@Service 
public class RicetteSeguiteService {

	private final Logger logger = Logger.getLogger(RicetteSeguiteController.class.toString()); 
	@Autowired
	private RicetteService ricetteService;
	
	@Autowired 
	private ConnessioniService connessioniService;

	/* Trova le ricette (in formato breve) degli utenti seguiti da utente. */ 
	public Collection<Ricetta> getRicetteSeguite(String utente) {
		Collection<Ricetta> ricette = new ArrayList<>(); 
		Collection<Connessione> connessioni = this.connessioniService.getConnessioniByFollower(utente); 
		for (Connessione connessione : connessioni) {
			logger.info("dentro for stampa connessione:" + connessione);
			String followed = connessione.getFollowed();
			logger.info("dentro for stampa followed:" + followed);
			Collection<Ricetta> ricetteByFollowed = this.ricetteService.getRicetteByAutore(followed);
			logger.info("dentro for stampa ricettebyfollowed:" + ricetteByFollowed);
			ricette.addAll(ricetteByFollowed);
			logger.info("dentro for stampa ricette:" + ricette);
		}
		return ricette; 
	}
	
}
