package asw.instagnam.ricetteseguite.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import asw.instagnam.ricetteseguite.domain.Ricetta;
import asw.instagnam.ricetteseguite.domain.Ricetteseguite;
import asw.instagnam.ricetteseguite.domain.RicetteSeguiteExtraRepository;

@RestController
public class RicetteSeguiteController {

	private final Logger logger = Logger.getLogger(RicetteSeguiteController.class.toString()); 

	@Autowired 
	private RicetteSeguiteExtraRepository ricetteSeguiteExtraRepository;

	/* Trova le ricette (in formato breve) degli utenti seguiti da utente. */ 
	@GetMapping("/ricetteseguite/{utente}") 
	public Collection<Ricetta> getRicetteSeguite(@PathVariable String utente) {
		logger.info("REST CALL: getRicetteSeguite " + utente); 
		Collection<Ricetteseguite> ricetteSeguite = ricetteSeguiteExtraRepository.findAllByUtenteFollower(utente);
		Collection<Ricetta> ricette = new ArrayList<>();
		System.out.println("\nRisultato findAllByUtenteFollower di Ricetteseguite:\n" + ricetteSeguite);
		for (Ricetteseguite ricettaSeguita : ricetteSeguite) {
			System.out.println("\nDentro for ogni ricettaSeguita:\n" + ricettaSeguita);
			Ricetta  ricetta = new Ricetta(ricettaSeguita.getIdRicetta(),ricettaSeguita.getAutoreRicetta(),ricettaSeguita.getTitoloRicetta());
			ricette.add(ricetta);
		}
		logger.info("getRicetteSeguite(): " + ricette);
		return ricette; 
	}

}
