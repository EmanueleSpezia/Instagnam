package asw.instagnam.ricetteseguite.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RicetteSeguiteEventConsumer {
	
	@Autowired
	private RicetteSeguiteRepository ricetteSeguiteRepository;
	
	@Autowired
	private ConnessioniRicetteSeguiteRepository connessioniRicetteSeguiteRepository;
	
	
	public void onEvent(Object event) {
		if (event.getClass().equals(Ricetta.class)) {
			this.ricetteSeguiteRepository.save((Ricetta)event);
		}
		if (event.getClass().equals(Connessione.class)) {
			this.connessioniRicetteSeguiteRepository.save((Connessione)event);
		}
	}
}
