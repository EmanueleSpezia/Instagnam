package asw.instagnam.ricette.domain;

import asw.instagnam.common.api.event.DomainEvent;
import lombok.Data;
import lombok.NoArgsConstructor; 

/* Ricetta, in formato breve. */ 
@Data 
public class Ricetta implements DomainEvent {

	private Long id; 
	private String autore; 
	private String titolo; 
	
	public Ricetta(RicettaCompleta r) {
		this.id = r.getId(); 
		this.autore = r.getAutore(); 
		this.titolo = r.getTitolo(); 
	}
	
}

