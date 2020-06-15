package asw.instagnam.ricette.domain;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asw.instagnam.common.api.event.*; 

@Service
public class RicetteService {

	@Autowired
	private RicettePublisher publisher;
	
	@Autowired
	private RicetteRepository ricetteRepository;

 	public RicettaCompleta createRicetta(String autore, String titolo, String preparazione) {
		RicettaCompleta ricetta = new RicettaCompleta(autore, titolo, preparazione); 
		ricetta = ricetteRepository.save(ricetta);
		DomainEvent event = new DomainRicette(ricetta.getId(),ricetta.getAutore(),ricetta.getTitolo());
		this.publisher.publish(event);
		return ricetta;
	}

 	public RicettaCompleta getRicetta(Long id) {
		RicettaCompleta ricetta = ricetteRepository.findById(id).orElse(null);
		return ricetta;
	}

	public Collection<RicettaCompleta> getRicette() {
		Collection<RicettaCompleta> ricette = ricetteRepository.findAll();
		return ricette;
	}

	public Collection<RicettaCompleta> getRicetteByAutore(String autore) {
		Collection<RicettaCompleta> ricette = ricetteRepository.findAllByAutore(autore);
		return ricette;
	}

}
