package asw.instagnam.ricetteseguite.domain;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RicetteSeguiteEventConsumer {

	@Autowired
	private RicetteSeguiteRepository ricetteSeguiteRepository;

	@Autowired
	private ConnessioniRicetteSeguiteRepository connessioniRicetteSeguiteRepository;

	@Autowired
	private RicetteSeguiteExtraRepository ricetteSeguiteExtraRepository;


	public void onEvent(Object event) {
		if (event.getClass().equals(Ricetta.class)) {
			this.ricetteSeguiteRepository.save((Ricetta)event);
			Ricetta ricetta = (Ricetta)event;
			Collection<Connessione> connessioni = connessioniRicetteSeguiteRepository.findAllByFollowed(ricetta.getAutore());
			for (Connessione connessione : connessioni) {
				Ricetteseguite ricetteSeguite = new Ricetteseguite(connessione.getFollower(),ricetta.getId(),ricetta.getAutore(),ricetta.getTitolo());
				ricetteSeguiteExtraRepository.save(ricetteSeguite);
			}


		}
		if (event.getClass().equals(Connessione.class)) {
			Connessione connessione = (Connessione)event;
			Collection<Connessione> connessioni = connessioniRicetteSeguiteRepository.findAll();
			int test = 0;
			for (Connessione conn : connessioni) {
				if (connessione.getFollower().equals(conn.getFollower()) && connessione.getFollowed().equals(conn.getFollowed())) {
					test = test+1;
				}
			}
			if(test==0) {
				Collection<Ricetta> ricette = ricetteSeguiteRepository.findAllByAutore(connessione.getFollowed());
				for (Ricetta ricetta : ricette) {
					Ricetteseguite ricetteSeguite = new Ricetteseguite(connessione.getFollower(),ricetta.getId(),ricetta.getAutore(),ricetta.getTitolo());
					ricetteSeguiteExtraRepository.save(ricetteSeguite);
				}
				this.connessioniRicetteSeguiteRepository.save((Connessione)event);
			}
		}
	}
}
